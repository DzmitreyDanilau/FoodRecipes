package by.dzmitrey.danilau.foodrecipies.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation
import by.dzmitrey.danilau.foodrecipies.R
import timber.log.Timber


class HorizontalDottedProgress : View {
    //actual dot radius
    private val mDotRadius: Float = 5F
    //Bounced Dot Radius
    private val mBounceDotRadius: Float = 8F
    //to get identified in which position dot has to bounce
    private var mDotPosition: Float = 0F
    //specify how many dots you need in a progressbar
    private val mDotAmount: Float = 10F

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    //Method to draw your customized dot on the canvas
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint= Paint()
        //set the color for the dot that you want to draw
        paint.color = resources.getColor(R.color.colorAccent)
        //function to create dot
        createDot(canvas, paint)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        //Animation called when attaching to the window, i.e to your screen
        startAnimation()
    }

    private fun createDot(
        canvas: Canvas,
        paint: Paint
    ) { //here i have setted progress bar with 10 dots,
        // so repeat and wnen i = mDotPosition  then increase the radius of dot i.e mBounceDotRadius
        for (i in 0 until mDotAmount.toInt()) {
            if (i == mDotPosition.toInt()) {
                canvas.drawCircle(
                    (10 + (i * 20)).toFloat(),
                    mBounceDotRadius,
                    mBounceDotRadius,
                    paint
                )
            } else {
                canvas.drawCircle((10 + (i * 20)).toFloat(), mBounceDotRadius, mDotRadius, paint)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width: Int
        //calculate the view width
        val calculatedWidth: Int = (20 * 9)
        width = calculatedWidth
        val height: Int = (mBounceDotRadius.toInt() * 2)
        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }

    private fun startAnimation() {
        val bounceAnimation = BounceAnimation()
        bounceAnimation.duration = 100
        bounceAnimation.repeatCount = Animation.INFINITE
        bounceAnimation.interpolator = LinearInterpolator()
        bounceAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation) {
                mDotPosition++
                //when mDotPosition == mDotAmount ,
                // then start again applying animation from 0th positon , i.e  mDotPosition = 0;
                if (mDotPosition == mDotAmount) {
                    mDotPosition = 0F
                }
                Timber.d("----On Animation Repeat----")
            }
        })
        startAnimation(bounceAnimation)
    }

    private inner class BounceAnimation : Animation() {
        override fun applyTransformation(
            interpolatedTime: Float,
            t: Transformation?
        ) {
            super.applyTransformation(interpolatedTime, t)
            //call invalidate to redraw your view againg.
            invalidate()
        }
    }
}
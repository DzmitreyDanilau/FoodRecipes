package by.dzmitrey.danilau.foodrecipies.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import by.dzmitrey.danilau.foodrecipies.R
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber


private const val SIGNED_IN = 0
private const val STATE_SIGNING_IN = 1
private const val STATE_IN_PROGRESS = 2
private const val RC_SIGN_IN = 0

class LoginActivity : BaseActivity(), GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener {
    private lateinit var googleApiClient: GoogleApiClient
    private var signInProgress = 0
    private lateinit var gso: GoogleSignInOptions
    private lateinit var signInIntent: Intent
    private lateinit var signInButton: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        signInButton = btn_sign_in
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()
        btn_login.setOnClickListener {
            val intent = Intent(this, RecipeListActivity::class.java)
            startActivity(intent)
        }
        signInButton.setOnClickListener {
            signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    override fun onStart() {
        super.onStart()
        googleApiClient.connect()
        val opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient)
        if (opr.isDone) {
            Timber.d("Got cached sign-in")
            val result = opr.get()
            handleSignInResult(result)
        }
    }

    override fun onStop() {
        super.onStop()
        googleApiClient.disconnect()
    }

    override fun onConnected(p0: Bundle?) {
        btn_sign_in.isEnabled = true
//            btn_login.isEnabled = false
        signInProgress = SIGNED_IN

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            handleSignInResult(result)
        }
    }

    private fun handleSignInResult(result: GoogleSignInResult?) {
        Timber.d("$result")
        result?.let {
            if (it.isSuccess) {
                // Signed in successflly, show authenticated UI.
                val googleSignInAcc = result.signInAccount
                val googleSingInId = googleSignInAcc?.id
                Timber.d("Id: $googleSingInId")
                val googleSingInName = googleSignInAcc?.givenName
                Timber.d("Name: $googleSingInName")
                val googleSingInIdToken = googleSignInAcc?.idToken
                Timber.d("Token: $googleSingInIdToken")

                //mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
                //Similarly you can get the email and photourl using acct.getEmail() and  acct.getPhotoUrl()
                if (googleSignInAcc?.photoUrl != null)
                    Timber.d("${googleSignInAcc.photoUrl}")
                Glide.with(iv_logo.context)
                    .load(googleSignInAcc?.photoUrl.toString())
                    .skipMemoryCache(true)
                    .into(iv_logo)
            } else {
                // Signed out, show unauthenticated UI.
            }
        }
    }


    override fun onConnectionSuspended(p0: Int) {
        googleApiClient.connect()
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Timber.d("Connection failed method")
    }
}

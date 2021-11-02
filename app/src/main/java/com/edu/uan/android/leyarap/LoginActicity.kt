package com.edu.uan.android.leyarap

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.autenticacionlayout
import kotlinx.android.synthetic.main.activity_login.editCorreo
import kotlinx.android.synthetic.main.activity_login.editPassword
import android.app.Activity
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

class LoginActicity : AppCompatActivity() {

    //view binding


    var texto_arriba: TextView? = null
    var btnregistrarse: ImageButton? = null
    var btningresar: ImageButton? = null
    var btnfacebook: Button? = null
    var btngoogle: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        texto_arriba = findViewById(R.id.textarriba)
        texto_arriba!!.typeface = Typeface.createFromAsset(assets, "fonts/texto_letras.ttf")


        //botones

        //facebook

        val font = Typeface.createFromAsset(assets, "fonts/texto_letras.ttf")
        btnfacebook?.setTypeface(font)

        //google

        btngoogle?.setTypeface(font)

        //registrarme y acceder
        registroEIngreso()
        sesionActiva()

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        val override = Configuration(newBase.resources.configuration)
        override.fontScale = 1.0f
        applyOverrideConfiguration(override)
    }

//cambio dev
    override fun onStart() {
        super.onStart()
        autenticacionlayout.visibility = View.VISIBLE
    }

    private fun sesionActiva() {
        val pref = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = pref.getString("email", null)
        if (email != null ) {
            autenticacionlayout.visibility = View.INVISIBLE
            mainHome(email)
        }
    }

    private fun registroEIngreso() {
        title = "Autenticacion"
        btn_registrarme.setOnClickListener {
            if (editCorreo.text.isNotEmpty() && editPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    editCorreo.text.toString(),
                    editPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        mainHome(it.result?.user?.email ?: "")
                        val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
                        user?.sendEmailVerification()
                    } else {
                        alertaErrorRegistro()
                    }
                }
            }
        }
        btn_ingresar.setOnClickListener {
            if (editCorreo.text.isNotEmpty() && editPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    editCorreo.text.toString(),
                    editPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        mainHome(it.result?.user?.email ?: "")

                    } else {
                        alertaError()
                    }
                }

            }
        }
        //google en registrar
/*        btn_google.setOnClickListener {
            //configuracion
            val googleConf =
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.txt_bienvenido)).requestEmail()
                    .build()
            val googleClient: GoogleSignInClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()
            //startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
            getGoogleDataBack.launch(googleClient.signInIntent)

        }*/
    }

    private fun alertaError() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setIcon(R.drawable.ic_error)
        builder.setMessage("Se ha producido un error autenticando el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun alertaErrorRegistro() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setIcon(R.drawable.ic_error)
        builder.setMessage("Puede que ya estes registrado con Facebook, Google ó prueba ingresar con tu correo")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun alertaErrorGoogle() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setIcon(R.drawable.ic_error)
        builder.setMessage("Se ha producido un error autenticando el usuario con inicio de sesion Google")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


    private fun mainHome(email: String) {

        val homeActivityIntent = Intent(this, EleccionActivity::class.java).apply {
            putExtra("email", email)
        }
        startActivity(homeActivityIntent)

    }

//google

//////////////
private val getGoogleDataBack=registerForActivityResult(StartActivityForResult()
) {

    if (it.resultCode == Activity.RESULT_OK) {

        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            if (account != null) {
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            mainHome(account.email ?: "")

                        } else {
                            alertaErrorGoogle()
                        }
                    }
            }
        } catch (e: ApiException) {
            alertaErrorGoogle()
        }
    }
}
    ///////////////Facebook


}
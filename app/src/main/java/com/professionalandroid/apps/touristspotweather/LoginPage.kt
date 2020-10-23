package com.professionalandroid.apps.touristspotweather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_login_page.*


class LoginPage:AppCompatActivity() {


    private var mLoginCallback: LoginCallback? = null
    private var mCallbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)


        mCallbackManager = CallbackManager.Factory.create()
        mLoginCallback = LoginCallback()

        btn_custom_login?.setOnClickListener {
            val loginManager = LoginManager.getInstance()
            loginManager.logInWithReadPermissions(
                this@LoginPage,
                listOf("public_profile", "email")
            )
            loginManager.registerCallback(mCallbackManager, mLoginCallback)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        mCallbackManager!!.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }


    inner class LoginCallback : FacebookCallback<LoginResult> {
        // 로그인 성공 시 호출 됩니다. Access Token 발급 성공.
        override fun onSuccess(loginResult: LoginResult) {
            Log.e("Callback :: ", "onSuccess")
            requestMe(loginResult.accessToken)

        }

        // 로그인 창을 닫을 경우, 호출됩니다.
        override fun onCancel() {
            Log.e("Callback :: ", "onCancel")
        }

        // 로그인 실패 시에 호출됩니다.
        override fun onError(error: FacebookException) {
            Log.e("Callback :: ", "onError : " + error.message)
        }

        // 사용자 정보 요청
        fun requestMe(token: AccessToken?) {
            val graphRequest = GraphRequest.newMeRequest(
                token
            ) { `object`, response -> Log.e("result", `object`.toString())
                MainActivity.email = response.jsonObject.getString("email").toString()
                MainActivity.name = response.jsonObject.getString("name").toString()
            }
            val parameters = Bundle()
            parameters.putString("fields", "id,name,email")
            graphRequest.parameters = parameters
            graphRequest.executeAsync()


            Log.e("result", "ddd")

            val intent = Intent(this@LoginPage, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
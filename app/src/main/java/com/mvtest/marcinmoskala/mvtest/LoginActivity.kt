package com.mvtest.marcinmoskala.mvtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val controller by lazy { LoginController(this, emailView, passwordView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        emailSignInButton.setOnClickListener { controller.attemptLogin() }
    }

    override fun onDestroy() {
        super.onDestroy()
        controller.onDestroy()
    }

    fun showProgress(show: Boolean) {
        progressView.visibility = if (show) View.VISIBLE else View.GONE
        loginFormView.visibility = if (show) View.GONE else View.VISIBLE
    }
}


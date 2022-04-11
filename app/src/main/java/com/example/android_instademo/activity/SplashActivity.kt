package com.example.android_instademo.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.android_firebase_demo.managers.AuthManager
import com.example.android_instademo.R

/**
 * In SplashActivity, user can visit SignInActivity or MainActivity
 */
class SplashActivity : BaseActivity() {
    val TAG = SplashActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        initViews()
    }

    private fun initViews() {
        countDownTimer()
    }

    private fun countDownTimer() {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                if (AuthManager.isSignedIn()) {
                    callMainActivity(this@SplashActivity)
                } else {
                    callSignInActivity(this@SplashActivity)
                }
            }
        }.start()
    }
}
package com.example.check

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import com.airbnb.lottie.LottieAnimationView

class ShopType : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shop_type)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(R.id.btnpre2)
        button.setOnClickListener{
            finish()
        }


        val submitButton: Button = findViewById(R.id.submitButton)
        val lottieAnimationView: LottieAnimationView = findViewById(R.id.lottieani)

        submitButton.setOnClickListener {
            lottieAnimationView.visibility = View.VISIBLE
            lottieAnimationView.playAnimation()
            submitButton.visibility = View.GONE

            lottieAnimationView.addAnimatorListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    lottieAnimationView.visibility = View.GONE

                    submitButton.visibility = View.VISIBLE
                }
            })
        }
    }
}
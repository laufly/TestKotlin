package com.wilddog.testkotlin.activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wilddog.testkotlin.R
import kotlinx.android.synthetic.main.activity_animator.*

class AnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)
        startAnimator()
    }

    fun startAnimator(){
        val retation: ObjectAnimator = ObjectAnimator.ofFloat(iv_animator,"rotation",0f,360f)
        val transAnimator : ObjectAnimator = ObjectAnimator.ofFloat(iv_animator,"alpha",1.0f,0.5f,0.8f,1f)
        val set = AnimatorSet()
        set.playTogether(retation,transAnimator)
        set.setDuration(5000)
        set.start()
    }

}

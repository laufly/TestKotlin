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

        var retation: ObjectAnimator = ObjectAnimator.ofFloat(iv_animator,"retation",0f,360f)
        var transAnimator : ObjectAnimator = ObjectAnimator.ofFloat(iv_animator,"alpha",1.0f,0.5f,0.8f,1f)
        var set = AnimatorSet()
        set.playTogether(retation,transAnimator)
        set.setDuration(1000)
        set.start()
    }


}

package com.example.cian.extesions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.cian.utils.GlideApp
import kotlinx.android.synthetic.main.progress_bar.view.*

private const val TAG = "Anim"

fun View.showView(animEnd: () -> Unit) {
    visibility = View.VISIBLE
    animate().alpha(1.0f).setListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator?) {
            super.onAnimationEnd(animation)
            Log.d(TAG, "anim(1) End")
            animEnd()
        }

        override fun onAnimationStart(animation: Animator?) {
            super.onAnimationStart(animation)
            Log.d(TAG, "anim(1) Start")
        }

        override fun onAnimationRepeat(animation: Animator?) {
            super.onAnimationRepeat(animation)
            Log.d(TAG, "anim(1) Repeat")
        }

        override fun onAnimationCancel(animation: Animator?) {
            super.onAnimationCancel(animation)
            Log.d(TAG, "anim(1) Cancel")
        }

        override fun onAnimationPause(animation: Animator?) {
            super.onAnimationPause(animation)
            Log.d(TAG, "anim(1) Pause")
        }

        override fun onAnimationResume(animation: Animator?) {
            super.onAnimationResume(animation)
            Log.d(TAG, "anim(1) Resume")
        }
    })
}

fun View.hideView() {
    animate().alpha(0.0f).setListener(object : AnimatorListenerAdapter() {

        override fun onAnimationStart(animation: Animator?) {
            Log.d(TAG, "anim(2) Start")
        }

        override fun onAnimationEnd(animation: Animator?) {
            progress_bar_fab.alpha = 0.0f
            visibility = View.GONE
            Log.d(TAG, "anim(2) End")
        }

    })

}

fun ImageView.loadImage(image: Any) =
    ifNotDestroyed {
        GlideApp.with(this).load(image).centerCrop().into(this)
    }

private fun View.ifNotDestroyed(block: () -> Unit) {
    if (!(context as Activity).isDestroyed) {
        block()
    }
}
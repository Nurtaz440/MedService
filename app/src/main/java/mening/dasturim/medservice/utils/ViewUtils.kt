package mening.dasturim.medservice.utils

import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator

object ViewUtils {


    fun fadeIn(view: View, duration: Long = 300) {
        if (view.visibility != View.VISIBLE) {
            val fadeIn = AlphaAnimation(0f, 1f)
            fadeIn.interpolator = AccelerateInterpolator()
            fadeIn.duration = duration
            view.animation = fadeIn
        }
        view.visible()
    }


    fun fadeOut(view: View, duration: Long = 300) {
        if (view.visibility == View.VISIBLE) {
            val fadeIn = AlphaAnimation(1f, 0f)
            fadeIn.interpolator = DecelerateInterpolator()
            fadeIn.duration = duration
            view.animation = fadeIn
        }

        view.gone()
    }

}
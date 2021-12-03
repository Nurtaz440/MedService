package mening.dasturim.medservice.ui.base

import android.text.Spanned
import android.view.View
import mening.dasturim.medservice.R

interface BaseMethods {
    fun setStatusBarColor(color: Int = R.attr.colorPrimary)

    fun showDialogNoNetwork()

    fun showDialog(message: String, title: String? = null)

    fun showDialog(message: Int, title: String? = null)

    fun showDialog(message: Spanned?, title: String? = null)

    fun showDialogErrorUnknown()

    fun showBasicDialog(message: String, title: String? = null)

    fun showBasicDialog(message: Spanned?, title: String? = null)

    fun doDataBinding()

    fun hideKeyboard()

    fun showKeyboard(view: View)

    fun setStatusBarBackgroundHeight(statusBarBackground: View)
}
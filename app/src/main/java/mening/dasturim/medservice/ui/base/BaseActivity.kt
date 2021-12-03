package mening.dasturim.medservice.ui.base

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Spanned
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import mening.dasturim.medservice.R


abstract class BaseActivity<T: ViewDataBinding, V: BaseVM> : AppCompatActivity(), BaseMethods {

    companion object{
        const val RC_UPDATE = 1
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun onBound()

    protected abstract val vm: V

    protected lateinit var binding: T
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        doDataBinding()
    }

    override fun doDataBinding(){
        binding.lifecycleOwner = this
        binding.setVariable(1, vm)
        onBound()
    }

    override fun setStatusBarColor(color: Int) {
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            // finally change the color
            window.statusBarColor = ContextCompat.getColor(this, color)
        }
    }

    override fun showDialogNoNetwork() {
        showBasicDialog(getString(R.string.msg_unknown_error))
    }

    override fun showDialog(message: String, title: String?) {
        showBasicDialog(message, title)
    }

    override fun showDialog(message: Int, title: String?) {
        showBasicDialog(getString(message), title)
    }

    override fun showDialog(message: Spanned?, title: String?) {
        showBasicDialog(message, title)
    }

    override fun showDialogErrorUnknown() {
        showBasicDialog(getString(R.string.msg_unknown_error))
    }


    override fun hideKeyboard() {
        // Check if no view has focus:
        this.currentFocus?.let {
            it.clearFocus()
            val imm: InputMethodManager? =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    override fun showKeyboard(view: View) {
        val imm: InputMethodManager? = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.showSoftInput(view, 0)
    }
    override fun showBasicDialog(message: String, title: String?) {
        if (isFinishing.not()) {
            MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(R.string.action_ok) { dialog, which ->

                }
                .show()
        }
    }

    override fun showBasicDialog(message: Spanned?, title: String?) {
        if (isFinishing.not()) {
            MaterialAlertDialogBuilder(this, R.style.ThemeOverlay_App_MaterialAlertDialog)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(R.string.action_ok) { dialog, which ->

                }
                .show()
        }
    }

}
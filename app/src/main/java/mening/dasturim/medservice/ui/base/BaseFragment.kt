package mening.dasturim.medservice.ui.base

import android.os.Bundle
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment <T : ViewDataBinding, V : BaseVM> : Fragment(), BaseMethods {

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun onBound()

    lateinit var binding: T

    abstract val vm: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
      //  prefs = PrefsHelper(gson, PreferenceManager.getDefaultSharedPreferences(requireContext()))


        return DataBindingUtil.inflate<T>(inflater, getLayoutResId(), container, false)
            .apply { binding = this }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doDataBinding()
    }

    override fun doDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(1, vm)
        onBound()
    }

    override fun setStatusBarColor(color: Int) {
        (activity as BaseActivity<*, *>).setStatusBarColor(color)
    }

    override fun showDialogNoNetwork() {
        (activity as BaseActivity<*, *>).showDialogNoNetwork()
    }

    override fun showDialog(message: String, title: String?) {
        (activity as BaseActivity<*, *>).showDialog(message, title)
    }

    override fun showDialog(message: Int, title: String?) {
        (activity as BaseActivity<*, *>).showDialog(message, title)
    }

    override fun showDialog(message: Spanned?, title: String?) {
        (activity as BaseActivity<*, *>).showDialog(message, title)
    }

    override fun showDialogErrorUnknown() {
        (activity as BaseActivity<*, *>).showDialogErrorUnknown()
    }

    override fun showBasicDialog(message: String, title: String?) {
        (activity as BaseActivity<*, *>).showBasicDialog(message, title)

    }

    override fun showBasicDialog(message: Spanned?, title: String?) {
        (activity as BaseActivity<*, *>).showBasicDialog(message, title)
    }

    override fun hideKeyboard() {
        (activity as BaseActivity<*, *>).hideKeyboard()
    }

    override fun showKeyboard(view: View) {
        (activity as BaseActivity<*, *>).showKeyboard(view)
    }
    override fun setStatusBarBackgroundHeight(statusBarBackground: View) {
        (activity as BaseActivity<*, *>).setStatusBarBackgroundHeight(statusBarBackground)
    }
}
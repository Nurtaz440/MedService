package mening.dasturim.medservice.utils

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KClass


fun Context.showToast(text: String){
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun SharedPreferences.put(key: String, value: String?){
    edit().putString(key, value).apply()
}

fun SharedPreferences.put(key: String, value: Int){
    edit().putInt(key, value).apply()
}

fun SharedPreferences.put(key: String, value: Long) {
    edit().putLong(key, value).apply()
}

fun SharedPreferences.put(key: String, value: Boolean) {
    edit().putBoolean(key, value).apply()
}

fun Context.openActivity(
    activityClass: KClass<out AppCompatActivity>,
    action: ((intent: Intent) -> Unit)? = null
) {
    val intent = Intent(this, activityClass.java)
    action?.invoke(intent)
    startActivity(intent)
}

fun AppCompatActivity.openActivityForResult(
    activityClass: KClass<out AppCompatActivity>,
    requestCode: Int,
    action: ((intent: Intent) -> Unit)? = null
) {
    val intent = Intent(this, activityClass.java)
    action?.invoke(intent)
    startActivityForResult(intent, requestCode)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

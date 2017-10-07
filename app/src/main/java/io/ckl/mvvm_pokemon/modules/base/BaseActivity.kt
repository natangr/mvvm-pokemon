package io.ckl.mvvm_pokemon.modules.base

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
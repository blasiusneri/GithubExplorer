package com.x.blas.githubexplorer.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by blasius.n.puspika on 27/09/20.
 */

class UserSharedPreference {

    companion object {
        const val USERNAME = "username"
    }

    private fun getSharedPreference(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setUsername(context: Context, username: String) {
        getSharedPreference(context).edit().also {
            it.putString(USERNAME, username)
            it.apply()
        }
    }

    fun getUsername(context: Context): String {
        return getSharedPreference(context).getString(USERNAME, "").orEmpty()
    }
}
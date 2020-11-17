package com.x.blas.githubexplorer.utils

import android.view.View

/**
 * Created by blasius.n.puspika on 17/11/20.
 */

fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {

    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}
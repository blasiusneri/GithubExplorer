package com.x.blas.githubexplorer.utils

import android.os.SystemClock
import android.view.View

/**
 * Created by blasius.n.puspika on 17/11/20.
 */

class SafeClickListener(
    private var defaultInterval: Int = 1000,
    private val onSafeClick: (View) -> Unit
) : View.OnClickListener {

    private var lastTimeClicked: Long = 0

    override fun onClick(view: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeClick(view)
    }
}
package com.x.blas.githubexplorer.library.imagehelper

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by blasius.n.puspika on 16/11/20.
 */

object ImageLoader {

    fun loadWith(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(
            url
        ).into(imageView)
    }
}
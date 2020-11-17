package com.x.blas.githubexplorer.feature.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.x.blas.githubexplorer.R
import com.x.blas.githubexplorer.feature.search.model.SearchList
import com.x.blas.githubexplorer.library.imagehelper.ImageLoader

/**
 * Created by blasius.n.puspika on 16/11/20.
 */

class SearchUserAdapter(private val dataSet: SearchList) :
    RecyclerView.Adapter<SearchUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchUserAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_search_user, parent, false)
    )

    override fun getItemCount(): Int = dataSet.items.size

    override fun onBindViewHolder(holder: SearchUserAdapter.ViewHolder, position: Int) {
        holder.tvUser.text = dataSet.items[position].login
        holder.tvUrl.text = dataSet.items[position].url
        ImageLoader.loadWith(
            holder.ivAvatar.context,
            dataSet.items[position].avatar_url,
            holder.ivAvatar
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUser: TextView = view.findViewById(R.id.tv_user)
        val tvUrl: TextView = view.findViewById(R.id.tv_urll)
        val ivAvatar: ImageView = view.findViewById(R.id.iv_user)
    }
}
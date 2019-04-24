package com.example.marsrobots.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrobots.ImageListItem
import com.example.marsrobots.R
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)

    fun show(image: ImageListItem) {
        titleTextView.text = image.title
        dateTextView.text = image.date

        Picasso.get()
                .load(image.imageUrl)
                .error(R.drawable.ic_broken_image_black_24dp)
                .placeholder(R.drawable.ic_image_black_24dp)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView)
    }
}
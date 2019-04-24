package com.example.marsrobots.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrobots.ImageListItem
import com.example.marsrobots.R

class ImagesAdapter(private val items: List<ImageListItem>) : RecyclerView.Adapter<ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.show(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
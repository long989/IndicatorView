package com.qkl.viewpager2indicatordemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.qkl.viewpager2indicatordemo.R

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:
 * @author qiukailong
 * @date 2022/9/28 0028
 */
class ImageAdapter(val dataList: MutableList<Int>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
//        val view = View.inflate(parent.context, R.layout.item_layout_image, null)
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_image, parent, false)
        return ImageViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageview.setBackgroundResource(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageview = itemView.findViewById(R.id.img) as ImageView
    }
}


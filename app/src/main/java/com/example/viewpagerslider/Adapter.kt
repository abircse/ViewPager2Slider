package com.example.viewpagerslider

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerslider.Adapter.MyViewHolder
import com.squareup.picasso.Picasso

class Adapter(
    private val context: Context,
    private val list: List<Model>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.custom_image, viewGroup, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, i: Int) {
        val model = list[i]
        Picasso.get().load(model.cityImage).fit().into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(view: View) : ViewHolder(view) {
        var imageView: ImageView

        init {
            imageView = view.findViewById(R.id.imageView)
        }
    }

}
package com.example.viewpagerslider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    lateinit var imagelist : MutableList<Model>
    lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagelist = ArrayList()
        loadImagelist()
        viewPager2 = findViewById(R.id.viewpagerSlider)
        viewPager2.adapter = Adapter(applicationContext, imagelist, viewPager2)
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        viewPager2.setPageTransformer(compositePageTransformer)

    }

    private fun loadImagelist() {
        imagelist.add(Model("https://parsefiles.back4app.com/sxuZjQKyRnJc3O9KytffkfijvmiDGJFFF7pqCKxU/c3a640ab26723f5e21c1642ce64e0b98_mohit-tomar-ll57sYdDnsw-unsplash.jpeg"))
        imagelist.add(Model("https://parsefiles.back4app.com/sxuZjQKyRnJc3O9KytffkfijvmiDGJFFF7pqCKxU/a49b8559239cbf0422061ff17817f9e7_animation-bg.jpeg"))
        imagelist.add(Model("https://parsefiles.back4app.com/sxuZjQKyRnJc3O9KytffkfijvmiDGJFFF7pqCKxU/3f9c17929fc04e1582be2d84734e6551_m-blog-5.jpeg"))
    }
}
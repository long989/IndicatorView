package com.qkl.viewpager2indicatordemo

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.qkl.viewpager2indicatordemo.adapter.ImageAdapter
import com.qkl.viewpager2indicatordemo.databinding.ActivityMainBinding
import com.qkl.viewpager2indicatordemo.indicator.IndicatorView

class MainActivity : AppCompatActivity() {
    private lateinit var mMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mMainBinding.root)
        initView()
    }

    private fun initView() {
        val dataList  = mutableListOf<Int>()
        dataList.add(R.color.purple_200)
        dataList.add(R.color.purple_500)
        dataList.add(R.color.purple_700)
        dataList.add(R.color.teal_200)
        dataList.add(R.color.teal_700)
        val adapter = ImageAdapter(dataList)
        mMainBinding.viewpager2.adapter = adapter
        mMainBinding.indicatorView.initIndicatorCount(adapter.itemCount,0)
        mMainBinding.indicatorView.setIndicatorRatio(1f)
            .setIndicatorRadius(2f)
            .setIndicatorSelectedRatio(10f)
            .setIndicatorSelectedRadius(2f)
            .setIndicatorSpacing(-1f)
            .setIndicatorStyle(IndicatorView.IndicatorStyle.INDICATOR_BIG_CIRCLE)
            .setIndicatorColor(Color.GRAY)
            .setIndicatorSelectorColor(Color.RED)
        mMainBinding.viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                mMainBinding.indicatorView.onPageScrolled(position,positionOffset,positionOffsetPixels)
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                mMainBinding.indicatorView.onPageScrollStateChanged(state)
                super.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                mMainBinding.indicatorView.onPageSelected(position)
                super.onPageSelected(position)
            }
        })
    }
}
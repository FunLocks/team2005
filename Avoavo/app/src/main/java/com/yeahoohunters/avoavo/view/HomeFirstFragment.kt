package com.yeahoohunters.avoavo.view

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.yeahoohunters.avoavo.R
import kotlinx.android.synthetic.main.fragment_home_first. *

class HomeFirstFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val red = resources.getDrawable(R.drawable.congestion_circle, null)
        activity?.applicationContext?.let { ContextCompat.getColor(it, R.color.red) }?.let { red.setTint(it) }
        red.setTintMode(PorterDuff.Mode.SRC_IN)
        val orange = resources.getDrawable(R.drawable.congestion_circle, null)
        activity?.applicationContext?.let { ContextCompat.getColor(it, R.color.orange) }?.let { orange.setTint(it) }
        orange.setTintMode(PorterDuff.Mode.SRC_IN)
        val green = resources.getDrawable(R.drawable.congestion_circle, null)
        activity?.applicationContext?.let { ContextCompat.getColor(it, R.color.green) }?.let { green.setTint(it) }
        green.setTintMode(PorterDuff.Mode.SRC_IN)

        var first: MutableMap<Int, Int> = mutableMapOf()

        for (i in 1..5) {
            arguments?.getInt(i.toString())?.let { first.put(i, it) }
        }
        for (i in 60..62) {
            arguments?.getInt(i.toString())?.let { first.put(i, it) }
        }

        for ((k,v) in first){
            when(k){
                1 -> {
                    when(v){
                        0 -> if (circle_1.visibility == View.VISIBLE) circle_1.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_1.visibility == View.INVISIBLE) circle_1.visibility = View.VISIBLE
                            circle_1.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_1.visibility == View.INVISIBLE) circle_1.visibility = View.VISIBLE
                            circle_1.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_1.visibility == View.INVISIBLE) circle_1.visibility = View.VISIBLE
                            circle_1.setImageDrawable(red)
                        }
                    }
                }
                2 -> {
                    when(v){
                        0 -> if (circle_2.visibility == View.VISIBLE) circle_2.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_2.visibility == View.INVISIBLE) circle_2.visibility = View.VISIBLE
                            circle_2.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_2.visibility == View.INVISIBLE) circle_2.visibility = View.VISIBLE
                            circle_2.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_2.visibility == View.INVISIBLE) circle_2.visibility = View.VISIBLE
                            circle_2.setImageDrawable(red)
                        }
                    }
                }
                3 -> {
                    when(v){
                        0 -> if (circle_3.visibility == View.VISIBLE) circle_3.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_3.visibility == View.INVISIBLE) circle_3.visibility = View.VISIBLE
                            circle_3.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_3.visibility == View.INVISIBLE) circle_3.visibility = View.VISIBLE
                            circle_3.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_3.visibility == View.INVISIBLE) circle_3.visibility = View.VISIBLE
                            circle_3.setImageDrawable(red)
                        }
                    }
                }
                4 -> {
                    when(v){
                        0 -> if (circle_4.visibility == View.VISIBLE) circle_4.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_4.visibility == View.INVISIBLE) circle_4.visibility = View.VISIBLE
                            circle_4.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_4.visibility == View.INVISIBLE) circle_4.visibility = View.VISIBLE
                            circle_4.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_4.visibility == View.INVISIBLE) circle_4.visibility = View.VISIBLE
                            circle_4.setImageDrawable(red)
                        }
                    }
                }
                5 -> {
                    when(v){
                        0 -> if (circle_5.visibility == View.VISIBLE) circle_5.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_5.visibility == View.INVISIBLE) circle_5.visibility = View.VISIBLE
                            circle_5.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_5.visibility == View.INVISIBLE) circle_5.visibility = View.VISIBLE
                            circle_5.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_5.visibility == View.INVISIBLE) circle_5.visibility = View.VISIBLE
                            circle_5.setImageDrawable(red)
                        }
                    }
                }
                60 -> {
                    when(v){
                        0 -> if (circle_60.visibility == View.VISIBLE) circle_60.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_60.visibility == View.INVISIBLE) circle_60.visibility = View.VISIBLE
                            circle_60.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_60.visibility == View.INVISIBLE) circle_60.visibility = View.VISIBLE
                            circle_60.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_60.visibility == View.INVISIBLE) circle_60.visibility = View.VISIBLE
                            circle_60.setImageDrawable(red)
                        }
                    }
                }
                61 -> {
                    when(v){
                        0 -> if (circle_61.visibility == View.VISIBLE) circle_61.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_61.visibility == View.INVISIBLE) circle_61.visibility = View.VISIBLE
                            circle_61.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_61.visibility == View.INVISIBLE) circle_61.visibility = View.VISIBLE
                            circle_61.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_61.visibility == View.INVISIBLE) circle_61.visibility = View.VISIBLE
                            circle_61.setImageDrawable(red)
                        }
                    }
                }
                62 -> {
                    when(v){
                        0 -> if (circle_62.visibility == View.VISIBLE) circle_62.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_62.visibility == View.INVISIBLE) circle_62.visibility = View.VISIBLE
                            circle_62.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_62.visibility == View.INVISIBLE) circle_62.visibility = View.VISIBLE
                            circle_62.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_62.visibility == View.INVISIBLE) circle_62.visibility = View.VISIBLE
                            circle_62.setImageDrawable(red)
                        }
                    }
                }
            }
        }
    }
}
package com.yeahoohunters.avoavo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeahoohunters.avoavo.R
import android.graphics.PorterDuff
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_home_fourth. *

class HomeFourthFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_fourth, container, false)
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

        var fourth: MutableMap<Int, Int> = mutableMapOf()

        for (i in 25..36) {
            arguments?.getInt(i.toString())?.let { fourth.put(i, it) }
        }
        for (i in 71..74) {
            arguments?.getInt(i.toString())?.let { fourth.put(i, it) }
        }

        for ((k,v) in fourth){
            when(k){
                25 -> {
                    when(v){
                        0 -> if (circle_25.visibility == View.VISIBLE) circle_25.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_25.visibility == View.INVISIBLE) circle_25.visibility = View.VISIBLE
                            circle_25.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_25.visibility == View.INVISIBLE) circle_25.visibility = View.VISIBLE
                            circle_25.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_25.visibility == View.INVISIBLE) circle_25.visibility = View.VISIBLE
                            circle_25.setImageDrawable(red)
                        }
                    }
                }
                26 -> {
                    when(v){
                        0 -> if (circle_26.visibility == View.VISIBLE) circle_26.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_26.visibility == View.INVISIBLE) circle_26.visibility = View.VISIBLE
                            circle_26.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_26.visibility == View.INVISIBLE) circle_26.visibility = View.VISIBLE
                            circle_26.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_26.visibility == View.INVISIBLE) circle_26.visibility = View.VISIBLE
                            circle_26.setImageDrawable(red)
                        }
                    }
                }
                27 -> {
                    when(v){
                        0 -> if (circle_27.visibility == View.VISIBLE) circle_27.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_27.visibility == View.INVISIBLE) circle_27.visibility = View.VISIBLE
                            circle_27.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_27.visibility == View.INVISIBLE) circle_27.visibility = View.VISIBLE
                            circle_27.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_27.visibility == View.INVISIBLE) circle_27.visibility = View.VISIBLE
                            circle_27.setImageDrawable(red)
                        }
                    }
                }
                28 -> {
                    when(v){
                        0 -> if (circle_28.visibility == View.VISIBLE) circle_28.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_28.visibility == View.INVISIBLE) circle_28.visibility = View.VISIBLE
                            circle_28.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_28.visibility == View.INVISIBLE) circle_28.visibility = View.VISIBLE
                            circle_28.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_28.visibility == View.INVISIBLE) circle_28.visibility = View.VISIBLE
                            circle_28.setImageDrawable(red)
                        }
                    }
                }
                29 -> {
                    when(v){
                        0 -> if (circle_29.visibility == View.VISIBLE) circle_29.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_29.visibility == View.INVISIBLE) circle_29.visibility = View.VISIBLE
                            circle_29.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_29.visibility == View.INVISIBLE) circle_29.visibility = View.VISIBLE
                            circle_29.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_29.visibility == View.INVISIBLE) circle_29.visibility = View.VISIBLE
                            circle_29.setImageDrawable(red)
                        }
                    }
                }
                30 -> {
                    when(v){
                        0 -> if (circle_30.visibility == View.VISIBLE) circle_30.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_30.visibility == View.INVISIBLE) circle_30.visibility = View.VISIBLE
                            circle_30.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_30.visibility == View.INVISIBLE) circle_30.visibility = View.VISIBLE
                            circle_30.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_30.visibility == View.INVISIBLE) circle_30.visibility = View.VISIBLE
                            circle_30.setImageDrawable(red)
                        }
                    }
                }
                31 -> {
                    when(v){
                        0 -> if (circle_31.visibility == View.VISIBLE) circle_31.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_31.visibility == View.INVISIBLE) circle_31.visibility = View.VISIBLE
                            circle_31.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_31.visibility == View.INVISIBLE) circle_31.visibility = View.VISIBLE
                            circle_31.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_31.visibility == View.INVISIBLE) circle_31.visibility = View.VISIBLE
                            circle_31.setImageDrawable(red)
                        }
                    }
                }
                32 -> {
                    when(v){
                        0 -> if (circle_32.visibility == View.VISIBLE) circle_32.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_32.visibility == View.INVISIBLE) circle_32.visibility = View.VISIBLE
                            circle_32.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_32.visibility == View.INVISIBLE) circle_32.visibility = View.VISIBLE
                            circle_32.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_32.visibility == View.INVISIBLE) circle_32.visibility = View.VISIBLE
                            circle_32.setImageDrawable(red)
                        }
                    }
                }
                33 -> {
                    when(v){
                        0 -> if (circle_33.visibility == View.VISIBLE) circle_33.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_33.visibility == View.INVISIBLE) circle_33.visibility = View.VISIBLE
                            circle_33.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_33.visibility == View.INVISIBLE) circle_33.visibility = View.VISIBLE
                            circle_33.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_33.visibility == View.INVISIBLE) circle_33.visibility = View.VISIBLE
                            circle_33.setImageDrawable(red)
                        }
                    }
                }
                34 -> {
                    when(v){
                        0 -> if (circle_34.visibility == View.VISIBLE) circle_34.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_34.visibility == View.INVISIBLE) circle_34.visibility = View.VISIBLE
                            circle_34.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_34.visibility == View.INVISIBLE) circle_34.visibility = View.VISIBLE
                            circle_34.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_34.visibility == View.INVISIBLE) circle_34.visibility = View.VISIBLE
                            circle_34.setImageDrawable(red)
                        }
                    }
                }
                35 -> {
                    when(v){
                        0 -> if (circle_35.visibility == View.VISIBLE) circle_35.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_35.visibility == View.INVISIBLE) circle_35.visibility = View.VISIBLE
                            circle_35.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_35.visibility == View.INVISIBLE) circle_35.visibility = View.VISIBLE
                            circle_35.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_35.visibility == View.INVISIBLE) circle_35.visibility = View.VISIBLE
                            circle_35.setImageDrawable(red)
                        }
                    }
                }
                36 -> {
                    when(v){
                        0 -> if (circle_36.visibility == View.VISIBLE) circle_36.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_36.visibility == View.INVISIBLE) circle_36.visibility = View.VISIBLE
                            circle_36.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_36.visibility == View.INVISIBLE) circle_36.visibility = View.VISIBLE
                            circle_36.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_36.visibility == View.INVISIBLE) circle_36.visibility = View.VISIBLE
                            circle_36.setImageDrawable(red)
                        }
                    }
                }
                71 -> {
                    when(v){
                        0 -> if (circle_71.visibility == View.VISIBLE) circle_71.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_71.visibility == View.INVISIBLE) circle_71.visibility = View.VISIBLE
                            circle_71.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_71.visibility == View.INVISIBLE) circle_71.visibility = View.VISIBLE
                            circle_71.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_71.visibility == View.INVISIBLE) circle_71.visibility = View.VISIBLE
                            circle_71.setImageDrawable(red)
                        }
                    }
                }
                72 -> {
                    when(v){
                        0 -> if (circle_72.visibility == View.VISIBLE) circle_72.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_72.visibility == View.INVISIBLE) circle_72.visibility = View.VISIBLE
                            circle_72.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_72.visibility == View.INVISIBLE) circle_72.visibility = View.VISIBLE
                            circle_72.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_72.visibility == View.INVISIBLE) circle_72.visibility = View.VISIBLE
                            circle_72.setImageDrawable(red)
                        }
                    }
                }
                73 -> {
                    when(v){
                        0 -> if (circle_73.visibility == View.VISIBLE) circle_73.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_73.visibility == View.INVISIBLE) circle_73.visibility = View.VISIBLE
                            circle_73.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_73.visibility == View.INVISIBLE) circle_73.visibility = View.VISIBLE
                            circle_73.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_73.visibility == View.INVISIBLE) circle_73.visibility = View.VISIBLE
                            circle_73.setImageDrawable(red)
                        }
                    }
                }
                74 -> {
                    when(v){
                        0 -> if (circle_74.visibility == View.VISIBLE) circle_74.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_74.visibility == View.INVISIBLE) circle_74.visibility = View.VISIBLE
                            circle_74.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_74.visibility == View.INVISIBLE) circle_74.visibility = View.VISIBLE
                            circle_74.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_74.visibility == View.INVISIBLE) circle_74.visibility = View.VISIBLE
                            circle_74.setImageDrawable(red)
                        }
                    }
                }
            }
        }
    }
}
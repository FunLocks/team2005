package com.yeahoohunters.avoavo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeahoohunters.avoavo.R
import android.graphics.PorterDuff
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_home_third. *

class HomeThirdFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_third, container, false)
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

        var third: MutableMap<Int, Int> = mutableMapOf()

        for (i in 11..24) {
            arguments?.getInt(i.toString())?.let { third.put(i, it) }
        }
        for (i in 66..70) {
            arguments?.getInt(i.toString())?.let { third.put(i, it) }
        }

        for ((k,v) in third){
            when(k){
                11 -> {
                    when(v){
                        0 -> if (circle_11.visibility == View.VISIBLE) circle_11.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_11.visibility == View.INVISIBLE) circle_11.visibility = View.VISIBLE
                            circle_11.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_11.visibility == View.INVISIBLE) circle_11.visibility = View.VISIBLE
                            circle_11.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_11.visibility == View.INVISIBLE) circle_11.visibility = View.VISIBLE
                            circle_11.setImageDrawable(red)
                        }
                    }
                }
                12 -> {
                    when(v){
                        0 -> if (circle_12.visibility == View.VISIBLE) circle_12.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_12.visibility == View.INVISIBLE) circle_12.visibility = View.VISIBLE
                            circle_12.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_12.visibility == View.INVISIBLE) circle_12.visibility = View.VISIBLE
                            circle_12.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_12.visibility == View.INVISIBLE) circle_12.visibility = View.VISIBLE
                            circle_12.setImageDrawable(red)
                        }
                    }
                }
                13 -> {
                    when(v){
                        0 -> if (circle_13.visibility == View.VISIBLE) circle_13.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_13.visibility == View.INVISIBLE) circle_13.visibility = View.VISIBLE
                            circle_13.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_13.visibility == View.INVISIBLE) circle_13.visibility = View.VISIBLE
                            circle_13.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_13.visibility == View.INVISIBLE) circle_13.visibility = View.VISIBLE
                            circle_13.setImageDrawable(red)
                        }
                    }
                }
                14 -> {
                    when(v){
                        0 -> if (circle_14.visibility == View.VISIBLE) circle_14.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_14.visibility == View.INVISIBLE) circle_14.visibility = View.VISIBLE
                            circle_14.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_14.visibility == View.INVISIBLE) circle_14.visibility = View.VISIBLE
                            circle_14.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_14.visibility == View.INVISIBLE) circle_14.visibility = View.VISIBLE
                            circle_14.setImageDrawable(red)
                        }
                    }
                }
                15 -> {
                    when(v){
                        0 -> if (circle_15.visibility == View.VISIBLE) circle_15.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_15.visibility == View.INVISIBLE) circle_15.visibility = View.VISIBLE
                            circle_15.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_15.visibility == View.INVISIBLE) circle_15.visibility = View.VISIBLE
                            circle_15.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_15.visibility == View.INVISIBLE) circle_15.visibility = View.VISIBLE
                            circle_15.setImageDrawable(red)
                        }
                    }
                }
                16 -> {
                    when(v){
                        0 -> if (circle_16.visibility == View.VISIBLE) circle_16.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_16.visibility == View.INVISIBLE) circle_16.visibility = View.VISIBLE
                            circle_16.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_16.visibility == View.INVISIBLE) circle_16.visibility = View.VISIBLE
                            circle_16.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_16.visibility == View.INVISIBLE) circle_16.visibility = View.VISIBLE
                            circle_16.setImageDrawable(red)
                        }
                    }
                }
                17 -> {
                    when(v){
                        0 -> if (circle_17.visibility == View.VISIBLE) circle_17.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_17.visibility == View.INVISIBLE) circle_17.visibility = View.VISIBLE
                            circle_17.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_17.visibility == View.INVISIBLE) circle_17.visibility = View.VISIBLE
                            circle_17.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_17.visibility == View.INVISIBLE) circle_17.visibility = View.VISIBLE
                            circle_17.setImageDrawable(red)
                        }
                    }
                }
                18 -> {
                    when(v){
                        0 -> if (circle_18.visibility == View.VISIBLE) circle_18.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_18.visibility == View.INVISIBLE) circle_18.visibility = View.VISIBLE
                            circle_18.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_18.visibility == View.INVISIBLE) circle_18.visibility = View.VISIBLE
                            circle_18.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_18.visibility == View.INVISIBLE) circle_18.visibility = View.VISIBLE
                            circle_18.setImageDrawable(red)
                        }
                    }
                }
                19 -> {
                    when(v){
                        0 -> if (circle_19.visibility == View.VISIBLE) circle_19.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_19.visibility == View.INVISIBLE) circle_19.visibility = View.VISIBLE
                            circle_19.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_19.visibility == View.INVISIBLE) circle_19.visibility = View.VISIBLE
                            circle_19.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_19.visibility == View.INVISIBLE) circle_19.visibility = View.VISIBLE
                            circle_19.setImageDrawable(red)
                        }
                    }
                }
                20 -> {
                    when(v){
                        0 -> if (circle_20.visibility == View.VISIBLE) circle_20.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_20.visibility == View.INVISIBLE) circle_20.visibility = View.VISIBLE
                            circle_20.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_20.visibility == View.INVISIBLE) circle_20.visibility = View.VISIBLE
                            circle_20.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_20.visibility == View.INVISIBLE) circle_20.visibility = View.VISIBLE
                            circle_20.setImageDrawable(red)
                        }
                    }
                }
                21 -> {
                    when(v){
                        0 -> if (circle_21.visibility == View.VISIBLE) circle_21.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_21.visibility == View.INVISIBLE) circle_21.visibility = View.VISIBLE
                            circle_21.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_21.visibility == View.INVISIBLE) circle_21.visibility = View.VISIBLE
                            circle_21.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_21.visibility == View.INVISIBLE) circle_21.visibility = View.VISIBLE
                            circle_21.setImageDrawable(red)
                        }
                    }
                }
                22 -> {
                    when(v){
                        0 -> if (circle_22.visibility == View.VISIBLE) circle_22.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_22.visibility == View.INVISIBLE) circle_22.visibility = View.VISIBLE
                            circle_22.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_22.visibility == View.INVISIBLE) circle_22.visibility = View.VISIBLE
                            circle_22.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_22.visibility == View.INVISIBLE) circle_22.visibility = View.VISIBLE
                            circle_22.setImageDrawable(red)
                        }
                    }
                }
                23 -> {
                    when(v){
                        0 -> if (circle_23.visibility == View.VISIBLE) circle_23.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_23.visibility == View.INVISIBLE) circle_23.visibility = View.VISIBLE
                            circle_23.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_23.visibility == View.INVISIBLE) circle_23.visibility = View.VISIBLE
                            circle_23.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_23.visibility == View.INVISIBLE) circle_23.visibility = View.VISIBLE
                            circle_23.setImageDrawable(red)
                        }
                    }
                }
                24 -> {
                    when(v){
                        0 -> if (circle_24.visibility == View.VISIBLE) circle_24.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_24.visibility == View.INVISIBLE) circle_24.visibility = View.VISIBLE
                            circle_24.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_24.visibility == View.INVISIBLE) circle_24.visibility = View.VISIBLE
                            circle_24.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_24.visibility == View.INVISIBLE) circle_24.visibility = View.VISIBLE
                            circle_24.setImageDrawable(red)
                        }
                    }
                }
                66 -> {
                    when(v){
                        0 -> if (circle_66.visibility == View.VISIBLE) circle_66.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_66.visibility == View.INVISIBLE) circle_66.visibility = View.VISIBLE
                            circle_66.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_66.visibility == View.INVISIBLE) circle_66.visibility = View.VISIBLE
                            circle_66.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_66.visibility == View.INVISIBLE) circle_66.visibility = View.VISIBLE
                            circle_66.setImageDrawable(red)
                        }
                    }
                }
                67 -> {
                    when(v){
                        0 -> if (circle_67.visibility == View.VISIBLE) circle_67.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_67.visibility == View.INVISIBLE) circle_67.visibility = View.VISIBLE
                            circle_67.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_67.visibility == View.INVISIBLE) circle_67.visibility = View.VISIBLE
                            circle_67.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_67.visibility == View.INVISIBLE) circle_67.visibility = View.VISIBLE
                            circle_67.setImageDrawable(red)
                        }
                    }
                }
                68 -> {
                    when(v){
                        0 -> if (circle_68.visibility == View.VISIBLE) circle_68.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_68.visibility == View.INVISIBLE) circle_68.visibility = View.VISIBLE
                            circle_68.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_68.visibility == View.INVISIBLE) circle_68.visibility = View.VISIBLE
                            circle_68.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_68.visibility == View.INVISIBLE) circle_68.visibility = View.VISIBLE
                            circle_68.setImageDrawable(red)
                        }
                    }
                }
                69 -> {
                    when(v){
                        0 -> if (circle_69.visibility == View.VISIBLE) circle_69.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_69.visibility == View.INVISIBLE) circle_69.visibility = View.VISIBLE
                            circle_69.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_69.visibility == View.INVISIBLE) circle_69.visibility = View.VISIBLE
                            circle_69.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_69.visibility == View.INVISIBLE) circle_69.visibility = View.VISIBLE
                            circle_69.setImageDrawable(red)
                        }
                    }
                }
                70 -> {
                    when(v){
                        0 -> if (circle_70.visibility == View.VISIBLE) circle_70.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_70.visibility == View.INVISIBLE) circle_70.visibility = View.VISIBLE
                            circle_70.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_70.visibility == View.INVISIBLE) circle_70.visibility = View.VISIBLE
                            circle_70.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_70.visibility == View.INVISIBLE) circle_70.visibility = View.VISIBLE
                            circle_70.setImageDrawable(red)
                        }
                    }
                }
            }
        }
    }
}
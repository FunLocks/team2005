package com.yeahoohunters.avoavo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeahoohunters.avoavo.R
import android.graphics.PorterDuff
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_home_second.*

class HomeSecondFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_second, container, false)
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

        var second: MutableMap<Int, Int> = mutableMapOf()

        for (i in 6..10) {
            arguments?.getInt(i.toString())?.let { second.put(i, it) }
        }
        for (i in 63..65) {
            arguments?.getInt(i.toString())?.let { second.put(i, it) }
        }

        for ((k,v) in second){
            when(k){
                6 -> {
                    when(v){
                        0 -> if (circle_6.visibility == View.VISIBLE) circle_6.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_6.visibility == View.INVISIBLE) circle_6.visibility = View.VISIBLE
                            circle_6.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_6.visibility == View.INVISIBLE) circle_6.visibility = View.VISIBLE
                            circle_6.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_6.visibility == View.INVISIBLE) circle_6.visibility = View.VISIBLE
                            circle_6.setImageDrawable(red)
                        }
                    }
                }
                7 -> {
                    when(v){
                        0 -> if (circle_7.visibility == View.VISIBLE) circle_7.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_7.visibility == View.INVISIBLE) circle_7.visibility = View.VISIBLE
                            circle_7.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_7.visibility == View.INVISIBLE) circle_7.visibility = View.VISIBLE
                            circle_7.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_7.visibility == View.INVISIBLE) circle_7.visibility = View.VISIBLE
                            circle_7.setImageDrawable(red)
                        }
                    }
                }
                8 -> {
                    when(v){
                        0 -> if (circle_8.visibility == View.VISIBLE) circle_8.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_8.visibility == View.INVISIBLE) circle_8.visibility = View.VISIBLE
                            circle_8.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_8.visibility == View.INVISIBLE) circle_8.visibility = View.VISIBLE
                            circle_8.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_8.visibility == View.INVISIBLE) circle_8.visibility = View.VISIBLE
                            circle_8.setImageDrawable(red)
                        }
                    }
                }
                9 -> {
                    when(v){
                        0 -> if (circle_9.visibility == View.VISIBLE) circle_9.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_9.visibility == View.INVISIBLE) circle_9.visibility = View.VISIBLE
                            circle_9.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_9.visibility == View.INVISIBLE) circle_9.visibility = View.VISIBLE
                            circle_9.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_9.visibility == View.INVISIBLE) circle_9.visibility = View.VISIBLE
                            circle_9.setImageDrawable(red)
                        }
                    }
                }
                10 -> {
                    when(v){
                        0 -> if (circle_10.visibility == View.VISIBLE) circle_10.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_10.visibility == View.INVISIBLE) circle_10.visibility = View.VISIBLE
                            circle_10.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_10.visibility == View.INVISIBLE) circle_10.visibility = View.VISIBLE
                            circle_10.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_10.visibility == View.INVISIBLE) circle_10.visibility = View.VISIBLE
                            circle_10.setImageDrawable(red)
                        }
                    }
                }
                63 -> {
                    when(v){
                        0 -> if (circle_63.visibility == View.VISIBLE) circle_63.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_63.visibility == View.INVISIBLE) circle_63.visibility = View.VISIBLE
                            circle_63.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_63.visibility == View.INVISIBLE) circle_63.visibility = View.VISIBLE
                            circle_63.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_63.visibility == View.INVISIBLE) circle_63.visibility = View.VISIBLE
                            circle_63.setImageDrawable(red)
                        }
                    }
                }
                64 -> {
                    when(v){
                        0 -> if (circle_64.visibility == View.VISIBLE) circle_64.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_64.visibility == View.INVISIBLE) circle_64.visibility = View.VISIBLE
                            circle_64.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_64.visibility == View.INVISIBLE) circle_64.visibility = View.VISIBLE
                            circle_64.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_64.visibility == View.INVISIBLE) circle_64.visibility = View.VISIBLE
                            circle_64.setImageDrawable(red)
                        }
                    }
                }
                65 -> {
                    when(v){
                        0 -> if (circle_65.visibility == View.VISIBLE) circle_65.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_65.visibility == View.INVISIBLE) circle_65.visibility = View.VISIBLE
                            circle_65.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_65.visibility == View.INVISIBLE) circle_65.visibility = View.VISIBLE
                            circle_65.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_65.visibility == View.INVISIBLE) circle_65.visibility = View.VISIBLE
                            circle_65.setImageDrawable(red)
                        }
                    }
                }
            }
        }
    }
}
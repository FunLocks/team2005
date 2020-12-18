package com.yeahoohunters.avoavo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yeahoohunters.avoavo.R
import android.graphics.PorterDuff
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_home_fifth. *
import kotlinx.android.synthetic.main.fragment_home_fourth.*

class HomeFifthFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_fifth, container, false)
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

        var fifth: MutableMap<Int, Int> = mutableMapOf()

        for (i in 37..59) {
            arguments?.getInt(i.toString())?.let { fifth.put(i, it) }
        }
        for (i in 75..77) {
            arguments?.getInt(i.toString())?.let { fifth.put(i, it) }
        }

        for ((k,v) in fifth){
            when(k){
                37 -> {
                    when(v){
                        0 -> if (circle_37.visibility == View.VISIBLE) circle_37.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_37.visibility == View.INVISIBLE) circle_37.visibility = View.VISIBLE
                            circle_37.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_37.visibility == View.INVISIBLE) circle_37.visibility = View.VISIBLE
                            circle_37.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_37.visibility == View.INVISIBLE) circle_37.visibility = View.VISIBLE
                            circle_37.setImageDrawable(red)
                        }
                    }
                }
                38 -> {
                    when(v){
                        0 -> if (circle_38.visibility == View.VISIBLE) circle_38.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_38.visibility == View.INVISIBLE) circle_38.visibility = View.VISIBLE
                            circle_38.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_38.visibility == View.INVISIBLE) circle_38.visibility = View.VISIBLE
                            circle_38.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_38.visibility == View.INVISIBLE) circle_38.visibility = View.VISIBLE
                            circle_38.setImageDrawable(red)
                        }
                    }
                }
                39 -> {
                    when(v){
                        0 -> if (circle_39.visibility == View.VISIBLE) circle_39.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_39.visibility == View.INVISIBLE) circle_39.visibility = View.VISIBLE
                            circle_39.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_39.visibility == View.INVISIBLE) circle_39.visibility = View.VISIBLE
                            circle_39.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_39.visibility == View.INVISIBLE) circle_39.visibility = View.VISIBLE
                            circle_39.setImageDrawable(red)
                        }
                    }
                }
                40 -> {
                    when(v){
                        0 -> if (circle_40.visibility == View.VISIBLE) circle_40.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_40.visibility == View.INVISIBLE) circle_40.visibility = View.VISIBLE
                            circle_40.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_40.visibility == View.INVISIBLE) circle_40.visibility = View.VISIBLE
                            circle_40.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_40.visibility == View.INVISIBLE) circle_40.visibility = View.VISIBLE
                            circle_40.setImageDrawable(red)
                        }
                    }
                }
                41 -> {
                    when(v){
                        0 -> if (circle_41.visibility == View.VISIBLE) circle_41.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_41.visibility == View.INVISIBLE) circle_41.visibility = View.VISIBLE
                            circle_41.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_41.visibility == View.INVISIBLE) circle_41.visibility = View.VISIBLE
                            circle_41.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_41.visibility == View.INVISIBLE) circle_41.visibility = View.VISIBLE
                            circle_41.setImageDrawable(red)
                        }
                    }
                }
                42 -> {
                    when(v){
                        0 -> if (circle_42.visibility == View.VISIBLE) circle_42.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_42.visibility == View.INVISIBLE) circle_42.visibility = View.VISIBLE
                            circle_42.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_42.visibility == View.INVISIBLE) circle_42.visibility = View.VISIBLE
                            circle_42.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_42.visibility == View.INVISIBLE) circle_42.visibility = View.VISIBLE
                            circle_42.setImageDrawable(red)
                        }
                    }
                }
                43 -> {
                    when(v){
                        0 -> if (circle_43.visibility == View.VISIBLE) circle_43.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_43.visibility == View.INVISIBLE) circle_43.visibility = View.VISIBLE
                            circle_43.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_43.visibility == View.INVISIBLE) circle_43.visibility = View.VISIBLE
                            circle_43.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_43.visibility == View.INVISIBLE) circle_43.visibility = View.VISIBLE
                            circle_43.setImageDrawable(red)
                        }
                    }
                }
                44 -> {
                    when(v){
                        0 -> if (circle_44.visibility == View.VISIBLE) circle_44.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_44.visibility == View.INVISIBLE) circle_44.visibility = View.VISIBLE
                            circle_44.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_44.visibility == View.INVISIBLE) circle_44.visibility = View.VISIBLE
                            circle_44.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_44.visibility == View.INVISIBLE) circle_44.visibility = View.VISIBLE
                            circle_44.setImageDrawable(red)
                        }
                    }
                }
                45 -> {
                    when(v){
                        0 -> if (circle_45.visibility == View.VISIBLE) circle_45.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_45.visibility == View.INVISIBLE) circle_45.visibility = View.VISIBLE
                            circle_45.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_45.visibility == View.INVISIBLE) circle_45.visibility = View.VISIBLE
                            circle_45.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_45.visibility == View.INVISIBLE) circle_45.visibility = View.VISIBLE
                            circle_45.setImageDrawable(red)
                        }
                    }
                }
                46 -> {
                    when(v){
                        0 -> if (circle_46.visibility == View.VISIBLE) circle_46.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_46.visibility == View.INVISIBLE) circle_46.visibility = View.VISIBLE
                            circle_46.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_46.visibility == View.INVISIBLE) circle_46.visibility = View.VISIBLE
                            circle_46.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_46.visibility == View.INVISIBLE) circle_46.visibility = View.VISIBLE
                            circle_46.setImageDrawable(red)
                        }
                    }
                }
                47 -> {
                    when(v){
                        0 -> if (circle_47.visibility == View.VISIBLE) circle_47.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_47.visibility == View.INVISIBLE) circle_47.visibility = View.VISIBLE
                            circle_47.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_47.visibility == View.INVISIBLE) circle_47.visibility = View.VISIBLE
                            circle_47.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_47.visibility == View.INVISIBLE) circle_47.visibility = View.VISIBLE
                            circle_47.setImageDrawable(red)
                        }
                    }
                }
                48 -> {
                    when(v){
                        0 -> if (circle_48.visibility == View.VISIBLE) circle_48.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_48.visibility == View.INVISIBLE) circle_48.visibility = View.VISIBLE
                            circle_48.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_48.visibility == View.INVISIBLE) circle_48.visibility = View.VISIBLE
                            circle_48.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_48.visibility == View.INVISIBLE) circle_48.visibility = View.VISIBLE
                            circle_48.setImageDrawable(red)
                        }
                    }
                }
                49 -> {
                    when(v){
                        0 -> if (circle_49.visibility == View.VISIBLE) circle_49.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_49.visibility == View.INVISIBLE) circle_49.visibility = View.VISIBLE
                            circle_49.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_49.visibility == View.INVISIBLE) circle_49.visibility = View.VISIBLE
                            circle_49.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_49.visibility == View.INVISIBLE) circle_49.visibility = View.VISIBLE
                            circle_49.setImageDrawable(red)
                        }
                    }
                }
                50 -> {
                    when(v){
                        0 -> if (circle_50.visibility == View.VISIBLE) circle_50.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_50.visibility == View.INVISIBLE) circle_50.visibility = View.VISIBLE
                            circle_50.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_50.visibility == View.INVISIBLE) circle_50.visibility = View.VISIBLE
                            circle_50.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_50.visibility == View.INVISIBLE) circle_50.visibility = View.VISIBLE
                            circle_50.setImageDrawable(red)
                        }
                    }
                }
                51 -> {
                    when(v){
                        0 -> if (circle_51.visibility == View.VISIBLE) circle_51.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_51.visibility == View.INVISIBLE) circle_51.visibility = View.VISIBLE
                            circle_51.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_51.visibility == View.INVISIBLE) circle_51.visibility = View.VISIBLE
                            circle_51.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_51.visibility == View.INVISIBLE) circle_51.visibility = View.VISIBLE
                            circle_51.setImageDrawable(red)
                        }
                    }
                }
                52 -> {
                    when(v){
                        0 -> if (circle_52.visibility == View.VISIBLE) circle_52.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_52.visibility == View.INVISIBLE) circle_52.visibility = View.VISIBLE
                            circle_52.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_52.visibility == View.INVISIBLE) circle_52.visibility = View.VISIBLE
                            circle_52.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_52.visibility == View.INVISIBLE) circle_52.visibility = View.VISIBLE
                            circle_52.setImageDrawable(red)
                        }
                    }
                }
                53 -> {
                    when(v){
                        0 -> if (circle_53.visibility == View.VISIBLE) circle_53.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_53.visibility == View.INVISIBLE) circle_53.visibility = View.VISIBLE
                            circle_53.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_53.visibility == View.INVISIBLE) circle_53.visibility = View.VISIBLE
                            circle_53.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_53.visibility == View.INVISIBLE) circle_53.visibility = View.VISIBLE
                            circle_53.setImageDrawable(red)
                        }
                    }
                }
                54 -> {
                    when(v){
                        0 -> if (circle_54.visibility == View.VISIBLE) circle_54.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_54.visibility == View.INVISIBLE) circle_54.visibility = View.VISIBLE
                            circle_54.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_54.visibility == View.INVISIBLE) circle_54.visibility = View.VISIBLE
                            circle_54.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_54.visibility == View.INVISIBLE) circle_54.visibility = View.VISIBLE
                            circle_54.setImageDrawable(red)
                        }
                    }
                }
                55 -> {
                    when(v){
                        0 -> if (circle_55.visibility == View.VISIBLE) circle_55.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_55.visibility == View.INVISIBLE) circle_55.visibility = View.VISIBLE
                            circle_55.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_55.visibility == View.INVISIBLE) circle_55.visibility = View.VISIBLE
                            circle_55.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_55.visibility == View.INVISIBLE) circle_55.visibility = View.VISIBLE
                            circle_55.setImageDrawable(red)
                        }
                    }
                }
                56 -> {
                    when(v){
                        0 -> if (circle_56.visibility == View.VISIBLE) circle_56.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_56.visibility == View.INVISIBLE) circle_56.visibility = View.VISIBLE
                            circle_56.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_56.visibility == View.INVISIBLE) circle_56.visibility = View.VISIBLE
                            circle_56.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_56.visibility == View.INVISIBLE) circle_56.visibility = View.VISIBLE
                            circle_56.setImageDrawable(red)
                        }
                    }
                }
                57 -> {
                    when(v){
                        0 -> if (circle_57.visibility == View.VISIBLE) circle_57.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_57.visibility == View.INVISIBLE) circle_57.visibility = View.VISIBLE
                            circle_57.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_57.visibility == View.INVISIBLE) circle_57.visibility = View.VISIBLE
                            circle_57.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_57.visibility == View.INVISIBLE) circle_57.visibility = View.VISIBLE
                            circle_57.setImageDrawable(red)
                        }
                    }
                }
                58 -> {
                    when(v){
                        0 -> if (circle_58.visibility == View.VISIBLE) circle_58.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_58.visibility == View.INVISIBLE) circle_58.visibility = View.VISIBLE
                            circle_58.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_58.visibility == View.INVISIBLE) circle_58.visibility = View.VISIBLE
                            circle_58.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_58.visibility == View.INVISIBLE) circle_58.visibility = View.VISIBLE
                            circle_58.setImageDrawable(red)
                        }
                    }
                }
                59 -> {
                    when(v){
                        0 -> if (circle_59.visibility == View.VISIBLE) circle_59.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_59.visibility == View.INVISIBLE) circle_59.visibility = View.VISIBLE
                            circle_59.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_59.visibility == View.INVISIBLE) circle_59.visibility = View.VISIBLE
                            circle_59.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_59.visibility == View.INVISIBLE) circle_59.visibility = View.VISIBLE
                            circle_59.setImageDrawable(red)
                        }
                    }
                }
                75 -> {
                    when(v){
                        0 -> if (circle_75.visibility == View.VISIBLE) circle_75.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_75.visibility == View.INVISIBLE) circle_75.visibility = View.VISIBLE
                            circle_75.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_75.visibility == View.INVISIBLE) circle_75.visibility = View.VISIBLE
                            circle_75.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_75.visibility == View.INVISIBLE) circle_75.visibility = View.VISIBLE
                            circle_75.setImageDrawable(red)
                        }
                    }
                }
                76 -> {
                    when(v){
                        0 -> if (circle_76.visibility == View.VISIBLE) circle_76.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_76.visibility == View.INVISIBLE) circle_76.visibility = View.VISIBLE
                            circle_76.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_76.visibility == View.INVISIBLE) circle_76.visibility = View.VISIBLE
                            circle_76.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_76.visibility == View.INVISIBLE) circle_76.visibility = View.VISIBLE
                            circle_76.setImageDrawable(red)
                        }
                    }
                }
                77 -> {
                    when(v){
                        0 -> if (circle_77.visibility == View.VISIBLE) circle_77.visibility = View.INVISIBLE
                        in 1..5 -> {
                            if (circle_77.visibility == View.INVISIBLE) circle_77.visibility = View.VISIBLE
                            circle_77.setImageDrawable(green)
                        }
                        in 6..10 -> {
                            if (circle_77.visibility == View.INVISIBLE) circle_77.visibility = View.VISIBLE
                            circle_77.setImageDrawable(orange)
                        }
                        in 11..15 -> {
                            if (circle_77.visibility == View.INVISIBLE) circle_77.visibility = View.VISIBLE
                            circle_77.setImageDrawable(red)
                        }
                    }
                }
            }
        }
    }
}
package com.yeahoohunters.avoavo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.yeahoohunters.avoavo.R

class MyplaceFragment : Fragment() {
    lateinit var scrollView: LinearLayout
    val bundle = Bundle()
    val locationList: HashMap<Int, String> = hashMapOf(
        Pair(5, "食堂"),
        Pair(10, "売店"),
        Pair(17, "大講義室"),
        Pair(19, "364教室"),
        Pair(24, "図書館"),
        Pair(36, "講堂"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_myplace, container, false)

        scrollView = view.findViewById(R.id.myplaceList)


        for (item in locationList) {
            var textView = Button(context)
            textView.text = item.value
            textView.setOnClickListener {
                bundle.putInt("key", item.key)
                val fragment = MyplaceDetailFragment()
                fragment.arguments = bundle
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit()
            }
            scrollView.addView(textView)
        }

        return view
    }
}
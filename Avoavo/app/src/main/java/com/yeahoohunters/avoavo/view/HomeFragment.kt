package com.yeahoohunters.avoavo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yeahoohunters.avoavo.R

class HomeFragment : Fragment() {
    var onClose: Boolean = true

    lateinit var background: View

    lateinit var fabMain: FloatingActionButton
    lateinit var fabFirst: FloatingActionButton
    lateinit var fabSecond: FloatingActionButton
    lateinit var fabThird: FloatingActionButton
    lateinit var fabFourth: FloatingActionButton
    lateinit var fabFifth: FloatingActionButton

    lateinit var rotateBackward: Animation
    lateinit var rotateForward: Animation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)

        background = view.findViewById(R.id.fab_background) as View

        rotateBackward = AnimationUtils.loadAnimation(view.context, R.anim.fab_rotate_backward_animation)
        rotateForward = AnimationUtils.loadAnimation(view.context, R.anim.fab_rotate_forward_animation)

        fabMain = view.findViewById(R.id.fab_floor_main) as FloatingActionButton
        fabFirst = view.findViewById(R.id.fab_floor_first) as FloatingActionButton
        fabSecond = view.findViewById(R.id.fab_floor_second) as FloatingActionButton
        fabThird = view.findViewById(R.id.fab_floor_third) as FloatingActionButton
        fabFourth = view.findViewById(R.id.fab_floor_fourth) as FloatingActionButton
        fabFifth = view.findViewById(R.id.fab_floor_fifth) as FloatingActionButton

        fabMain.setOnClickListener { view ->
            if (onClose) {
                openFab()
            } else {
                closeFab()
            }
        }

        fabFirst.setOnClickListener{view ->
            parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrameLayout, HomeFirstFragment())
                    .commit()
        }

        fabSecond.setOnClickListener{ view ->
            parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrameLayout, HomeSecondFragment())
                    .commit()
        }

        fabThird.setOnClickListener { view ->
            parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrameLayout, HomeThirdFragment())
                    .commit()
        }

        fabFourth.setOnClickListener{ view ->
            parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrameLayout, HomeFourthFragment())
                    .commit()
        }

        fabFifth.setOnClickListener { view ->
            parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrameLayout, HomeFifthFragment())
                    .commit()
        }

        firstCloseFab()

        parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentFrameLayout, HomeThirdFragment())
                .commit()

        // Inflate the layout for this fragment
        return view
    }

    private fun openFab() {
        background.visibility = View.VISIBLE
        fabFirst.show()
        fabSecond.show()
        fabThird.show()
        fabFourth.show()
        fabFifth.show()
        fabMain.startAnimation(rotateForward)
        onClose = false
    }

    private fun closeFab() {
        background.visibility = View.INVISIBLE
        fabFirst.hide()
        fabSecond.hide()
        fabThird.hide()
        fabFourth.hide()
        fabFifth.hide()
        fabMain.startAnimation(rotateBackward)
        onClose = true
    }

    private fun firstCloseFab(){
        background.visibility = View.INVISIBLE
        fabFirst.hide()
        fabSecond.hide()
        fabThird.hide()
        fabFourth.hide()
        fabFifth.hide()
        onClose = true
    }
}
package com.yeahoohunters.avoavo.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yeahoohunters.avoavo.R
import com.yeahoohunters.avoavo.model.api.responce.NowSituation.Congection
import com.yeahoohunters.avoavo.model.room.NowSituationDatabase
import com.yeahoohunters.avoavo.repository.NowSituationRepository
import kotlinx.coroutines.*

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

    lateinit var localNowSituationList: List<Congection>
    val bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nowSituationDao = activity?.application?.let { NowSituationDatabase.getDatabase(it).nowSituationDao() }
        val nowSituationRepository = nowSituationDao?.let{ NowSituationRepository(it) }
        val scope = CoroutineScope(Job() + Dispatchers.Main)

        if(nowSituationRepository != null) scope.launch (Dispatchers.Main){
            async(Dispatchers.IO){
                nowSituationRepository.getRemoteNowSituationList()
            }.await()
                .let {
                    Log.d("ApiResult", it.toString())

                    if (it.isNotEmpty()) {
                        nowSituationRepository.deleteLocalNowSituationList()
                        for (remoteNowSituation in it) {
                            nowSituationRepository.insertLocalNowSituationItem(remoteNowSituation)
                            Log.d("InsertItem", remoteNowSituation.toString())
                        }
                    }

                    localNowSituationList = withContext(Dispatchers.IO) { nowSituationRepository.getLocalNowSituationList() }
                    for (item in localNowSituationList){
                        Log.d("listItem", item.toString())

                        bundle.putInt(item.location_id.toString(), item.value)
                    }
                }
        }
    }

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

        fabMain.setOnClickListener {
            if (onClose) {
                openFab()
            } else {
                closeFab()
            }
        }

        fabFirst.setOnClickListener{
            closeFab()
            val fragment = HomeFirstFragment()
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrameLayout, fragment)
                    .commit()
        }

        fabSecond.setOnClickListener{
            closeFab()
            val fragment = HomeSecondFragment()
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentFrameLayout, fragment)
                .commit()
        }

        fabThird.setOnClickListener {
            closeFab()
            val fragment = HomeThirdFragment()
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentFrameLayout, fragment)
                .commit()
        }

        fabFourth.setOnClickListener{
            closeFab()
            val fragment = HomeFourthFragment()
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentFrameLayout, fragment)
                .commit()
        }

        fabFifth.setOnClickListener {
            closeFab()
            val fragment = HomeFifthFragment()
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentFrameLayout, fragment)
                .commit()
        }

        firstCloseFab()

        val fragment = HomeThirdFragment()
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentFrameLayout, fragment)
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
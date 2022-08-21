package com.example.lab_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [YourLibraryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class YourLibraryFragment : Fragment(R.layout.fragment_your_library) {
    // TODO: Rename and change types of parameters
    private lateinit var buttonCount: ImageButton
    private lateinit var counting: TextView
    private var count: Int=0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view,savedInstanceState)
        buttonCount = view.findViewById(R.id.imgBtn_fragment_yourLibrary_AddIcon)
        counting = view.findViewById(R.id.txtView_fragment_YourLibrary_amountSongs)
        setListeners()
    }

    override fun onResume() {
        super.onResume()
        counting.text = count.toString()
    }
    private fun setListeners(){
        buttonCount.setOnClickListener{
            count++
            counting.text = count.toString()
        }
    }
}
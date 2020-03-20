package edu.miu.cs473mobiledeviceprogramming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import edu.miu.cs473mobiledeviceprogramming.databinding.FragmentLectureBinding

/**
 * A simple [Fragment] subclass.
 */
class Lecture : Fragment() {


    lateinit var binding: FragmentLectureBinding
    var pdfFile = arrayOf("simple", "book2", "book3", "book4", "book5")




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_lecture, container, false)

        binding.lect
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        }

}

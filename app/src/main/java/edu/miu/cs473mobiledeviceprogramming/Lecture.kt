package edu.miu.cs473mobiledeviceprogramming

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.miu.cs473mobiledeviceprogramming.Models.PdfLecture
import edu.miu.cs473mobiledeviceprogramming.MyAdapters.MyPdfRecyclerAdapter
import edu.miu.cs473mobiledeviceprogramming.MyAdapters.OnPdfCategoryClick
import edu.miu.cs473mobiledeviceprogramming.databinding.FragmentLectureBinding

/**
 * A simple [Fragment] subclass.
 */
class Lecture : Fragment(),OnPdfCategoryClick {


    lateinit var binding: FragmentLectureBinding
    var pdfFile = listOf<PdfLecture>(
        PdfLecture(R.drawable.pdf,"Lesson-1.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-2.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-3.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-4.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-5.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-6.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-7.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-8.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-9.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-10.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-11.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-12.pdf"),
        PdfLecture(R.drawable.pdf,"Lesson-13.pdf")


    )




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_lecture, container, false)
        var pdfRecyclerId = root.findViewById<RecyclerView>(R.id.pdfRecyclerId)
        pdfRecyclerId.adapter = MyPdfRecyclerAdapter(pdfFile,this)
        pdfRecyclerId.layoutManager = LinearLayoutManager(activity)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        }

    override fun onPdfSelected(pdf: PdfLecture) {
        val intent = Intent(activity,PDFviwer::class.java)
        intent.putExtra("pdfLecture",pdf)
        startActivity(intent)
    }

}

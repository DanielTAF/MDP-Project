package edu.miu.cs473mobiledeviceprogramming

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.miu.cs473mobiledeviceprogramming.Models.PdfLecture
import edu.miu.cs473mobiledeviceprogramming.MyAdapters.MyPdfRecyclerAdapter
import edu.miu.cs473mobiledeviceprogramming.MyAdapters.OnPdfCategoryClick

/**
 * A simple [Fragment] subclass.
 */
class Assignment : Fragment(), OnPdfCategoryClick {

    var pdfFile = listOf<PdfLecture>(

        PdfLecture(R.drawable.pdf,"assignment-1.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-2.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-3.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-4.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-5.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-6.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-7.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-8.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-9.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-10.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-11.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-12.pdf"),
        PdfLecture(R.drawable.pdf,"assignment-13.pdf")




    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_assignment, container, false)
        var assignRecyclerId = root.findViewById<RecyclerView>(R.id.assignRecyclerId)
        assignRecyclerId.adapter = MyPdfRecyclerAdapter(pdfFile,this)
        assignRecyclerId.layoutManager = LinearLayoutManager(activity)
        return root
    }

    override fun onPdfSelected(pdf: PdfLecture) {
        val intent = Intent(activity,PDFviwer::class.java)
        intent.putExtra("pdfLecture",pdf)
        startActivity(intent)
    }

}

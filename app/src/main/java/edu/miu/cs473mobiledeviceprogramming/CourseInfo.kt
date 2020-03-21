package edu.miu.cs473mobiledeviceprogramming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.barteksc.pdfviewer.PDFView

/**
 * A simple [Fragment] subclass.
 */
class CourseInfo : Fragment() {
    var myPDFViwer: PDFView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_lecture2, container, false)
        myPDFViwer = root.findViewById<View>(R.id.pdfViwer) as PDFView
        myPDFViwer!!.fromAsset("course.pdf").load()
        return root
    }

}

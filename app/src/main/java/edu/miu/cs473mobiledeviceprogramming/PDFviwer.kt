package edu.miu.cs473mobiledeviceprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView
import edu.miu.cs473mobiledeviceprogramming.Models.PdfLecture

class PDFviwer : AppCompatActivity() {
    var myPDFViwer: PDFView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_lecture2)
        val pdfLecture = intent.getSerializableExtra("pdfLecture") as PdfLecture
        myPDFViwer = findViewById<View>(R.id.pdfViwer) as PDFView
        myPDFViwer!!.fromAsset(pdfLecture.name).load()

    }
}

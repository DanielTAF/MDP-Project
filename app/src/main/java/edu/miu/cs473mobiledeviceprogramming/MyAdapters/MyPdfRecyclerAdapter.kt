package edu.miu.cs473mobiledeviceprogramming.MyAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.miu.cs473mobiledeviceprogramming.Models.PdfLecture
import edu.miu.cs473mobiledeviceprogramming.R
import kotlinx.android.synthetic.main.custom_pdf_lecture_layout.view.*

class MyPdfRecyclerAdapter(val mlist:List<PdfLecture>,val clickListner:OnPdfCategoryClick) : RecyclerView.Adapter<MyPdfRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.custom_pdf_lecture_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return mlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadView(mlist[position],clickListner)
    }

    class ViewHolder(var view: View): RecyclerView.ViewHolder(view){
      val pdfImage = view.imagePdfId
        val pdfName = view.pdfNameId

        fun loadView(pdf:PdfLecture,action:OnPdfCategoryClick){
            pdfImage.setImageResource(pdf.logo)
            pdfName.text = pdf.name
            view.setOnClickListener {
                action.onPdfSelected(pdf)
            }
        }
    }
}

interface OnPdfCategoryClick{
    fun onPdfSelected(pdf:PdfLecture)
}


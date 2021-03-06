package com.example.hyperdealsbusiness.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyperdealsbusiness.Model.SubcategoryParse
import com.example.hyperdealsbusiness.R
import kotlinx.android.synthetic.main.model_subcategory_businessman.view.*
import java.util.*
val TAG = "Subcateg"
class SubcategoryAdapterBusiness (var context: Context, var subcategoryList : ArrayList<SubcategoryParse>, var myPosition:Int) : RecyclerView.Adapter<SubcategoryAdapterBusiness.ViewHolder>(){


    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        //   val btn_subcat = view.btn_subcategory!!

        val btn_subcat =view.btn_subcategory!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.model_subcategory_businessman,parent,false))

    override fun getItemCount(): Int = subcategoryList.size


    override fun onBindViewHolder(holder: SubcategoryAdapterBusiness.ViewHolder, position: Int) {
        val mysubCategory = subcategoryList[position]


        try {
            holder.btn_subcat.text = mysubCategory.SubcategoryName
        }
        catch(e:Exception){

Log.e(TAG,e.toString())
        }


        if(mysubCategory.Selected)
        {
            holder.btn_subcat.setBackgroundResource(R.drawable.subcategory_shape_selected)
            holder.btn_subcat.setTextColor(context.resources.getColor(R.color.white))

        }

        holder.btn_subcat.setOnClickListener {
            if(mysubCategory.Selected){
                subcategoryList[position].Selected = false
                CategoryAdapterBusiness.globalCategoryList[myPosition].Subcategories[position].Selected = false
                holder.btn_subcat.setBackgroundResource(R.drawable.subcategory_shape)
                holder.btn_subcat.setTextColor(context.resources.getColor(R.color.colorPrimaryDark))


            }
            else{
                subcategoryList[position].Selected = true
                CategoryAdapterBusiness.globalCategoryList[myPosition].Subcategories[position].Selected = true
                holder.btn_subcat.setBackgroundResource(R.drawable.subcategory_shape_selected)
                holder.btn_subcat.setTextColor(context.resources.getColor(R.color.white))

            }


        }


    }





}
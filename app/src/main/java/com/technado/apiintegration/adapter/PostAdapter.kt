package com.technado.apiintegration.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.technado.apiintegration.R
import com.technado.apiintegration.model.MyDataItem

class PostAdapter : RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    var context: Context? = null
    var myDataItem: List<MyDataItem>? = null

    constructor(context: Context?, myDataItem: List<MyDataItem>?) : super() {
        this.context = context
        this.myDataItem = myDataItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.tvTitle.setText(myDataItem?.get(position)?.title)
        holder.tvTitle.text = myDataItem!![position].title
        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "" + position, Toast.LENGTH_SHORT)
        })
    }

    override fun getItemCount(): Int {
        return myDataItem?.size!!
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView

        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
        }
    }
}
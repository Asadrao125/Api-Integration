package com.technado.apiintegration.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.technado.apiintegration.R
import com.technado.apiintegration.model.MyDataItem
import com.technado.apiintegration.model.PhotosModel

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.MyViewHolder> {
    var context: Context? = null
    var photosModel: List<PhotosModel>? = null

    constructor(context: Context?, myDataItem: List<PhotosModel>?) : super() {
        this.context = context
        photosModel = myDataItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_photos, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTitle.text = photosModel!![position].title
        Picasso.get().load(photosModel!![position].thumbnailUrl).placeholder(R.mipmap.ic_launcher)
            .into(holder.image)
        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "" + position, Toast.LENGTH_SHORT)
        })
    }

    override fun getItemCount(): Int {
        return photosModel?.size!!
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var image: ImageView

        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            image = itemView.findViewById(R.id.image)
        }
    }
}
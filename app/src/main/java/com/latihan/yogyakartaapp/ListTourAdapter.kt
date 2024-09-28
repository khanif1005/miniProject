package com.latihan.yogyakartaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListTourAdapter(private val listTour: ArrayList<Wisata>) : RecyclerView.Adapter<ListTourAdapter.listViewHolder>(){
    private lateinit var onItemClikCallback: OnItemClickCallback

    fun setOnItemCallback(onitemCallback: OnItemClickCallback){
        this.onItemClikCallback = onitemCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): listViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tour, parent, false)
        return listViewHolder(view)
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val (name, description, photo) = listTour[position]
        //Glide
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
        }
    }

    override fun getItemCount(): Int = listTour.size

    class listViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Wisata)
    }
}
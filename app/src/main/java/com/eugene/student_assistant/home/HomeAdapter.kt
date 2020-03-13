package com.eugene.student_assistant.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eugene.student_assistant.R
import de.hdodenhof.circleimageview.CircleImageView


class HomeAdapter( var data: ArrayList<HomeItemClass>, var clickListener: OnItemClickListener, var context: Context) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        lateinit var mItemViewHolder : ViewHolder
        val layout = LayoutInflater.from(context).inflate(R.layout.custom_home_item, parent, false)

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        val current: HomeItemClass = data[position]
//        holder.title.text = data[position].title
//        holder.image.setImageResource(data[position].image)

        holder.initialize(data.get(position), clickListener)

    }

    override fun getItemCount(): Int {
        return data.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView
        var image: CircleImageView

        init {
            title = itemView.findViewById(R.id.homer_title_txt)
            image = itemView.findViewById(R.id.homer_circle_image)
        }

        fun initialize(item: HomeItemClass, action: OnItemClickListener){
            title.text = item.title
            image.setImageResource(item.image)

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick (item: HomeItemClass, position: Int)
    }
}
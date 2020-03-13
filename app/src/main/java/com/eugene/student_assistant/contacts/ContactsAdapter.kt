package com.eugene.student_assistant.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eugene.student_assistant.R
import de.hdodenhof.circleimageview.CircleImageView

class ContactsAdapter(var data: ArrayList<ContactsItemClass>, var clickListener: OnItemClickListener, var context: Context) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title: TextView
        var image: CircleImageView

        init {
            title = itemView.findViewById(R.id.contact_title_txt)
            image = itemView.findViewById(R .id.contact_circle_image)
        }
        fun initialize(item: ContactsItemClass, action: OnItemClickListener){
            title.text = item.title
            image.setImageResource(item.image)

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var layout = LayoutInflater.from(context).inflate(R.layout.custom_contacts_item,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initialize(data.get(position), clickListener)
    }
    interface OnItemClickListener{
        fun onItemClick(item: ContactsItemClass, position: Int)
    }
}
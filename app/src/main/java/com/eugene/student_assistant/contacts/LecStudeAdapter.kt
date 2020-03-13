package com.eugene.student_assistant.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eugene.student_assistant.R
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class LecStudeAdapter(var data: ArrayList<LecStudeItem>, var clickListener: OnItemClickListener,var context: Context) : RecyclerView.Adapter<LecStudeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.lec_stude_contact_item, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initialize(data.get(position), clickListener)
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var Name: TextView
        var PhoneBoth: TextView
        var image: CircleImageView

        init {
            Name = itemView.findViewById(R.id.lec_stude_name_cont)
            PhoneBoth = itemView.findViewById(R.id.lec_stude_phoneNumber)
            image = itemView.findViewById(R.id.lec_stude_cont_image)

        }
        fun initialize(item: LecStudeItem, action: OnItemClickListener){
            Name.text = item.Name
            PhoneBoth.text = item.PhoneBoth
            image.setImageResource(item.image)


            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(item: LecStudeItem, position: Int)
    }
}
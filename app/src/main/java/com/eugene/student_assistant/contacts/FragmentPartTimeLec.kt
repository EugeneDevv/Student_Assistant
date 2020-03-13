package com.eugene.student_assistant.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eugene.student_assistant.R

class FragmentPartTimeLec : Fragment(), LecStudeAdapter.OnItemClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.part_time_lec_fragment, container, false)

        val items = ArrayList<LecStudeItem>()

        items.add(LecStudeItem("PROF. J.K BITOK", "0722668933/0727830204", "0722668933", "", R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. VICTOR K. KIMELI", "0727830204", "0727830204", "", R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. BETTY KORIR", "0727830204/0727830204", "0727830204", "0727830204",R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. ARGWINGS OTIENO", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. JULIUS SHICHIKHA", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. ERICK ROTICH", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("DR. DENNIS KINGANGI", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("MR. JOHN ROTICH", "0727830204", "0727830204", "",R.drawable.contact_icon_one))
        items.add(LecStudeItem("MR. CHARLES SAMBULI", "0739440628/0727830204", "0739440628", "0727830204",R.drawable.contact_icon_one))

        val recycler = layout.findViewById<RecyclerView>(R.id.part_time_recyclerview)

        val adapter = LecStudeAdapter(items, this, context!!)

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
        return layout
    }

    override fun onItemClick(item: LecStudeItem, position: Int) {

    }
}
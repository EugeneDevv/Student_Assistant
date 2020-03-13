package com.eugene.student_assistant.home


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eugene.student_assistant.FAQS.FAQSActivity
import com.eugene.student_assistant.R
import com.eugene.student_assistant.announcements.AnnouncementsActivity
import com.eugene.student_assistant.contacts.ContactsActivity
import com.eugene.student_assistant.curriculum.CurriculumActivity
import com.eugene.student_assistant.lost_and_found.LostFoundActivity
import com.eugene.student_assistant.my_profile.ProfileActivity
import com.eugene.student_assistant.web.PortalWebActivity
import com.eugene.student_assistant.web.SchoolWebActivity


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.fragment_home, container, false)


        val items = ArrayList<HomeItemClass>()

        items.add(HomeItemClass("Contacts", R.drawable.contact_book))
        items.add(HomeItemClass("Announcements", R.drawable.announcements2))
        items.add(HomeItemClass("Lost & Found", R.drawable.lost_and_found1))
        items.add(HomeItemClass("Curriculum", R.drawable.curriculum2))
        items.add(HomeItemClass("Portal", R.drawable.portal))
        items.add(HomeItemClass("School Website", R.drawable.website))
        items.add(HomeItemClass("My Profile", R.drawable.profile))
        items.add(HomeItemClass("FAQS", R.drawable.faqs))

        val recycler = layout.findViewById<RecyclerView>(R.id.home_recycle_list)

        val adapter = HomeAdapter(items,this, context!!)

        recycler.layoutManager = GridLayoutManager(activity!!.applicationContext,2)
        recycler.adapter = adapter

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.actionBar?.title = "HOME"

    }
    override fun onItemClick(item: HomeItemClass, position: Int) {

//        Toast.makeText(context,"cluick",Toast.LENGTH_SHORT).show()
        if(position==0){
        val intent = Intent(context, ContactsActivity::class.java)
        startActivity(intent)
        }else if (position == 1){
            val intent = Intent(context, AnnouncementsActivity::class.java)
            startActivity(intent)
        }else if (position == 2){
            val intent = Intent(context, LostFoundActivity::class.java)
            startActivity(intent)
        }else if (position == 3){
            val intent = Intent(context, CurriculumActivity::class.java)
            startActivity(intent)
        }else if (position == 4){
            val intent = Intent(context, PortalWebActivity::class.java)
            startActivity(intent)
        }
        else if (position == 5){
            val intent = Intent(context, SchoolWebActivity::class.java)
            startActivity(intent)
        }
        else if (position == 6){
            val intent = Intent(context, ProfileActivity::class.java)
            startActivity(intent)
        }else {
            val intent = Intent(context, FAQSActivity::class.java)
            startActivity(intent)
        }

        }

        }


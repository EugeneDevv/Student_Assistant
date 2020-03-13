package com.eugene.student_assistant.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eugene.student_assistant.R

class ContactsActivity : AppCompatActivity(), ContactsAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val items = ArrayList<ContactsItemClass>()

        items.add(ContactsItemClass("EMERGENCY", R.drawable.emergency))
        items.add(ContactsItemClass("LECTURERS", R.drawable.lecturer))
        items.add(ContactsItemClass("STUDENT LEADERS", R.drawable.studentleader))

        val recycler = findViewById<RecyclerView>(R.id.contactsm_recycler_view)
        val adapter = ContactsAdapter(items, this, applicationContext)

        recycler.layoutManager = LinearLayoutManager(applicationContext)
        recycler.adapter = adapter
    }

    override fun onItemClick(item: ContactsItemClass, position: Int) {
        if (position == 0) {
            val intent = Intent(this, EmergencyContactsActivity::class.java)
            startActivity(intent)
        } else if (position == 1) {
            val intent = Intent(this, LecturersContActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, StudentsLeadersActivity::class.java)
            startActivity(intent)
        }
    }
}
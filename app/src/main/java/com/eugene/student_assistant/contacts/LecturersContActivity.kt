package com.eugene.student_assistant.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.eugene.student_assistant.R
import kotlinx.android.synthetic.main.activity_lecturers_cont.*

class LecturersContActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecturers_cont)

        var faculties = arrayOf("School of Science", "School of Engineering", "School of Education", "School of Business", "School of Agriculture")
        spinner_faculty.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,faculties)
        spinner_faculty.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

        }

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentFullTimeLec(), "FULL-TIME")
        adapter.addFragment(FragmentPartTimeLec(), "PART-TIME")
        adapter.addFragment(FragmentFavLec(), "")
        lecturers_viewPager.adapter = adapter
        lecturers_tabLayout.setupWithViewPager(lecturers_viewPager)
        lecturers_tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_fav)
    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}

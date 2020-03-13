package com.eugene.student_assistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.eugene.student_assistant.announcements.AnnouncementsActivity
import com.eugene.student_assistant.contacts.ContactsActivity
import com.eugene.student_assistant.curriculum.CurriculumActivity
import com.eugene.student_assistant.home.HomeFragment
import com.eugene.student_assistant.lost_and_found.LostFoundActivity
import com.eugene.student_assistant.my_profile.EditProfileActivity
import com.eugene.student_assistant.web.PortalWebActivity
import com.eugene.student_assistant.web.SchoolWebActivity
import com.eugene.student_assistant.welcome.LogInActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_nav.*
import kotlinx.android.synthetic.main.app_bar_main.*

class NavActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var homeFragment: HomeFragment
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav)

        mAuth = FirebaseAuth.getInstance()

        setSupportActionBar(toolBar)
        val actionBar = supportActionBar
        actionBar?.title = "UOE STUDENT ASSISTANT"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            (R.string.open),
            (R.string.close)){

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId){
            R.id.home -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.contacts -> {
                this.startActivity(Intent(this, ContactsActivity::class.java))
                return true
//                contactsFragment =
//                    ContactsFragment()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frame_layout, contactsFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    .commit()
            }
            R.id.announcements -> {
                this.startActivity(Intent(this, AnnouncementsActivity::class.java))
                return true
            }
            R.id.lost_found -> {
                this.startActivity(Intent(this, LostFoundActivity::class.java))
                return true
            }
            R.id.curriculum -> {
                this.startActivity(Intent(this, CurriculumActivity::class.java))
                return true
            }
            R.id.my_profile -> {
                this.startActivity(Intent(this, EditProfileActivity::class.java))
                return true
            }
            R.id.portal -> {
                this.startActivity(Intent(this, PortalWebActivity::class.java))
                return true
            }
            R.id.website -> {
                this.startActivity(Intent(this, SchoolWebActivity::class.java))
                return true

            }
            R.id.disclaimer -> {

            }
            R.id.developer -> {

            }
            R.id.log_out -> {
                mAuth.signOut()
                this.startActivity(Intent(this, LogInActivity::class.java))
                finish()
                return true
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{super.onBackPressed()}
    }
}

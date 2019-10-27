package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.Adapter.ContactsAdapter
import com.example.contacts.Model.Contacts
import com.example.contacts.Repository.ContactsRepository
import com.example.contacts.ViewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit  var mContactsViewModel:MainActivityViewModel

    private val adapter:ContactsAdapter= ContactsAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  mContactsViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)



        mContactsViewModel.Repo(ContactsRepository())
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
//        floating_button_add.setOnClickListener {
//            startActivity(Intent(applicationContext,placementActivity::class.java))
//        }
        mContactsViewModel.getContact().observe(this, Observer<List<Contacts>>{
            adapter.setData(it)
            adapter.notifyDataSetChanged()
        })

    }
}

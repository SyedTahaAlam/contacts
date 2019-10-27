package com.example.contacts

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.Adapter.ContactsAdapter
import com.example.contacts.Model.Contacts
import com.example.contacts.ViewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mContactsViewModel: MainActivityViewModel

    private val adapter: ContactsAdapter = ContactsAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dialogInterface = ProgressDialog.show(this@MainActivity, "Loading", "Please Wait")

        mContactsViewModel =
            ViewModelProviders.of(this@MainActivity).get(MainActivityViewModel::class.java)


//        mContactsViewModel.Repo(ContactsRepository(context = applicationContext))
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        floating_button_add.setOnClickListener {
            mContactsViewModel.addContact();
            mContactsViewModel.isUploading.value = true
        }

//        if(mContactsViewModel.contacts!=null)
        //to observe the change in the data of the appliaction
        mContactsViewModel.getContact()!!.observe(this, Observer<List<Contacts>> {
            adapter.setData(it)
            adapter.notifyDataSetChanged()
            mContactsViewModel.isUploading.value = false
        })


        //to observe the changes of the loading state of the application
        mContactsViewModel.isUploading!!.observe(this, Observer<Boolean> {

            if (it) {
                dialogInterface.show()
            } else {
                dialogInterface.dismiss()
            }
        })


    }


    fun click(position: Int) {
        mContactsViewModel.isUploading.value = true
        mContactsViewModel.Delete(position)
    }
}

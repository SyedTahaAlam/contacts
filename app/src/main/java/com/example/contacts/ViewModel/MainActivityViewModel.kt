package com.example.contacts.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contacts.Model.Contacts
import com.example.contacts.Repository.ContactsRepository

/**
 * view model to house the bussiness logic inherits from the andorid view model because of the need of context
 */
class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    var contacts: LiveData<List<Contacts>>? = null
    var repo: ContactsRepository? = null
    var isUploading = MutableLiveData<Boolean>(true) // to show the progress dialog box to make interection with the user

    //initializer block to initialize the data that is needed the most
    init {
        repo = ContactsRepository(application)
        contacts = repo!!.getContacts()
    }


    fun getContact(): LiveData<List<Contacts>>? {
        return contacts
    }

    fun addContact() {

        repo!!.addContact()
    }


    fun Delete(id: Int) {
        repo!!.delete(id)
    }


}
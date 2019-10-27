package com.example.contacts.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.contacts.Model.Contacts
import com.example.contacts.Repository.ContactsRepository

class MainActivityViewModel (application:Application):AndroidViewModel(application){
     var contacts:LiveData<List<Contacts>>?=null
    lateinit var  repo:ContactsRepository


    fun Repo( contactRepository:ContactsRepository){
        repo=contactRepository
    }
    fun getContact():LiveData<List<Contacts>>{
       return repo.getContacts()
    }





}
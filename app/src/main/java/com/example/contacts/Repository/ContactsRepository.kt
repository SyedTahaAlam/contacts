package com.example.contacts.Repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contacts.Model.Contacts
import com.example.contacts.retrofit.Endpoints
import com.example.contacts.retrofit.retrofit
import retrofit2.*

class ContactsRepository{
    var ContactsEndPoint :Endpoints=retrofit.getInstance().create(Endpoints::class.java)


    fun getContacts():LiveData<List<Contacts>>{

        val contacts=MutableLiveData<List<Contacts>>()



        ContactsEndPoint.getContacts().enqueue(object : Callback<List<Contacts>>{
            override fun onFailure(call: Call<List<Contacts>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Contacts>>,   response: Response<List<Contacts>>
            ) {

                if(response.isSuccessful)
                contacts.value=response.body()
            }
        })


        return contacts;
    }
}
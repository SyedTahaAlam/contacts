package com.example.contacts.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contacts.Model.Contacts
import com.example.contacts.retrofit.Endpoints
import com.example.contacts.retrofit.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * the repository to fetch the data
 */
class ContactsRepository(context: Context) {
    //to have the endpoint of the retrofit
    var ContactsEndPoint: Endpoints = retrofit.getInstance()!!.create(Endpoints::class.java)
    var con: Context = context

    //to make the data lifecycle aware
    val contact = MutableLiveData<List<Contacts>>()


    /**
     * to have the data from the end point from the retrofit from the mockapi
     *
     */
    fun getContacts(): MutableLiveData<List<Contacts>> {


        ContactsEndPoint.getContacts().enqueue(object : Callback<List<Contacts>> {
            override fun onFailure(call: Call<List<Contacts>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<Contacts>>, response: Response<List<Contacts>>
            ) {

                if (response.isSuccessful)
                    contact.value = response.body()
            }
        })


        return contact
    }


    /**
     * to add the data to the mock api end point
     *
     */
    fun addContact(): LiveData<Boolean> {
        val data = MutableLiveData<Boolean>()
        data.value = false

//        var progressDialog:ProgressDialog= ProgressDialog.show(con,"sending Data","sending")
            ContactsEndPoint.putContact().enqueue(object : Callback<Contacts> {
                override fun onFailure(call: Call<Contacts>, t: Throwable) {

                }

                override fun onResponse(call: Call<Contacts>, response: Response<Contacts>) {
                    if (response.isSuccessful) {


                        getContacts()

                    }

                }
            })
        return data
    }


    /**
     * to delete the data from the data base
     */
    fun delete(id: Int) {
        ContactsEndPoint.deleteContact(id).enqueue(object : Callback<Contacts> {
            override fun onFailure(call: Call<Contacts>, t: Throwable) {

            }

            override fun onResponse(call: Call<Contacts>, response: Response<Contacts>) {
                if (response.isSuccessful) {


                    getContacts()

                }

            }
        })


    }


}
package com.example.contacts.retrofit

import com.example.contacts.Model.Contacts
import retrofit2.Call
import retrofit2.http.*


interface Endpoints {

    @GET("api/contact/addcontact")
    fun getContacts(
    ): Call<List<Contacts>>



    @POST("api/contact/addcontact")
    fun putContact(

    ): Call<Contacts>


    @DELETE("api/contact/addcontact/{id}")
    fun deleteContact(@Path("id") id:Int):Call<Contacts>
}

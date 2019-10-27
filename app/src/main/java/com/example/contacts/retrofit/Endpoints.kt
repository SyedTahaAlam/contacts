package com.example.contacts.retrofit

import com.example.contacts.Model.Contacts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Endpoints {

    @GET("api/contact/addcontact")
    fun getContacts(
        @Query("sources") newsSource: String,
        @Query("apiKey") apiKey: String
    ): Call<List<Contacts>>
}
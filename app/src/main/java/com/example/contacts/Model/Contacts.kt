package com.example.contacts.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * this is to get the data from the api
 */
data class Contacts(
    @Expose
    @SerializedName("id")
    var contactId: kotlin.Int,
    @Expose
    @SerializedName("name")
    var name: String,
    @Expose
    @SerializedName("number")
    val number: Int
)
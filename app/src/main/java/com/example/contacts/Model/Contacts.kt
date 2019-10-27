package com.example.contacts.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Contacts(
    @Expose
    @SerializedName("id")
    var contactId: kotlin.Int,
    @Expose
    @SerializedName("name")
    var name: Int,
    @Expose
    @SerializedName("number")
    val number: Int
)
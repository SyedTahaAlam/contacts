package com.example.contacts.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofit{
    companion object{
         var endpoint: Retrofit?=null


       fun  getInstance():Retrofit?{
           if(endpoint==null){
              endpoint= Retrofit.Builder()
                   .baseUrl("http://5db576ae4e41670014ef2963.mockapi.io/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build()
           }
           return endpoint
       }
    }
}

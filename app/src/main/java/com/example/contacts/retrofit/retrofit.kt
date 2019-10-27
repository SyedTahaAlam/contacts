package com.example.contacts.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofit{
    companion object{
        lateinit var retrofit: Retrofit


       fun  getInstance():Retrofit{
           if(retrofit==null){
              retrofit= Retrofit.Builder()
                   .baseUrl("http://5db576ae4e41670014ef2963.mockapi.io/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build()
           }
           return retrofit
       }
    }
}

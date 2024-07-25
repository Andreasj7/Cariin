package com.example.cariin.models

class Panorama (val name: String, val listTipeRekreasi: List<String>){
    fun getTipeRekreasi(): List<String>{
        return listTipeRekreasi
    }

    fun getNama(): String{
        return name
    }
}
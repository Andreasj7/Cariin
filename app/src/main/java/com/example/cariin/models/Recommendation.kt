package com.example.cariin.models

class Recommendation (name: String, alamat:String) {
    private val name: String = name
    private val alamat: String = alamat

    fun getName(): String {
        return name
    }

    fun getAlamat(): String {
        return alamat
    }
}
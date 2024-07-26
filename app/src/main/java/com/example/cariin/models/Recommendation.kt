package com.example.cariin.models

class Recommendation(
    private val name: String,
    private val alamat: String,
    private val imageResId: Int // Tambahkan properti ini
) {
    fun getName(): String {
        return name
    }

    fun getAlamat(): String {
        return alamat
    }

    fun getImageResId(): Int {
        return imageResId
    }
}

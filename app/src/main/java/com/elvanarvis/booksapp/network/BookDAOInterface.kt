package com.elvanarvis.booksapp.network

import com.elvanarvis.booksapp.response.BooksResponse
import retrofit2.Call
import retrofit2.http.GET

interface BookDAOInterface {    //Database Access Object
    //retrofit http serverı ile interface sayesinde iletişim kuruyor

    //veri çekerken get kullanılır
    @GET("all_books.php")
    fun getBooks() : Call<BooksResponse>  //ne tarz bir cevap istediğimizi gösteriyoruz

}
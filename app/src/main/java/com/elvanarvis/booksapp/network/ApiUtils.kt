package com.elvanarvis.booksapp.network

class ApiUtils {

    companion object {

        private const val BASE_URL = "http://books.canerture.com/"

        fun getBooksDAOInterface() : BookDAOInterface{

            return RetrofitClient.getClient(BASE_URL).create(BookDAOInterface::class.java)
        }

    }

}
package com.elvanarvis.booksapp.response

import com.elvanarvis.booksapp.model.Book
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BooksResponse(@SerializedName("books") @Expose var books: List<Book>,
                        @SerializedName("success") @Expose var success: Int
)

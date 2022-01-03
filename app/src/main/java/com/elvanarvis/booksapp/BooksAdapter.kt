package com.elvanarvis.booksapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elvanarvis.booksapp.databinding.BookCardBinding
import com.elvanarvis.booksapp.model.Book
import com.squareup.picasso.Picasso

class BooksAdapter(private  var booksList : ArrayList<Book>)
    :RecyclerView.Adapter<BooksAdapter.BooksCardDesign>() {

        class BooksCardDesign(val bookCardBinding: BookCardBinding)
            :RecyclerView.ViewHolder(bookCardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bookCardBinding = BookCardBinding.inflate(layoutInflater,parent,false)
        return BooksCardDesign(bookCardBinding)
    }

    override fun onBindViewHolder(holder: BooksCardDesign, position: Int) {
        val book = booksList[position]

        holder.bookCardBinding.apply {

            bookText.text = book.book_name
            Picasso.get().load(book.book_image_url).into(bookImage)

        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }
}

























package com.elvanarvis.booksapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.elvanarvis.booksapp.databinding.ActivityMainBinding
import com.elvanarvis.booksapp.databinding.FragmentAnasayfaBinding
import com.elvanarvis.booksapp.model.Book
import com.elvanarvis.booksapp.network.ApiUtils
import com.elvanarvis.booksapp.response.BooksResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    var booksList: ArrayList<Book> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnasayfaBinding.inflate(layoutInflater)

        getBooks()
        return binding.root
    }

    private fun getBooks(){

        ApiUtils.getBooksDAOInterface().getBooks().enqueue(
            object : Callback<BooksResponse>{
                override fun onResponse(
                    call: Call<BooksResponse>,
                    response: Response<BooksResponse>
                ) {
                    val tempList = response.body()?.books

                    tempList?.let {
                        booksList = it as ArrayList<Book>
                    }
                    val booksAdapter = BooksAdapter(booksList)
                    binding.bookRecyclerView.adapter = booksAdapter
                    binding.bookRecyclerView.layoutManager = GridLayoutManager(context,2)
                    binding.bookRecyclerView.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
                    //burası hata olduğunda ekrana yazdırmak için
                }

            }
        )
    }

}























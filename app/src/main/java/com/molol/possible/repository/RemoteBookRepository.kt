package com.molol.possible.repository

import com.molol.possible.model.Book
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.net.URL

const val URL_BOOKS : String = "http://de-coding-test.s3.amazonaws.com/books.json"

class RemoteBookRepository : BookRepository {


    override fun getBooks() : List<Book> {
        val json = URL(URL_BOOKS).readText()
        return convertJson(json)
    }

    fun convertJson(json: String) : List<Book> {
        val books = mutableListOf<Book>()
        try {
            val jsonArray = JSONArray(json)
            for(i in 0..jsonArray.length()-1) {
                val jsonBook = jsonArray[i] as JSONObject
                with(jsonBook) {
                    val book = Book( this.getString("title"), this.getString("imageURL"))
                    books.add(book)
                }

            }
        } catch( e: Exception) {

        }
        return books
    }
}
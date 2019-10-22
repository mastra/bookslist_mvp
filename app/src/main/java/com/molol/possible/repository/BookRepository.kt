package com.molol.possible.repository
// daniel mastracchio mastra@gmail.com
//
import com.molol.possible.model.Book

interface BookRepository {
    fun getBooks() : List<Book>
}
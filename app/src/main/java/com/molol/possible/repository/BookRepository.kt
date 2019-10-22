package com.molol.possible.repository

import com.molol.possible.model.Book

interface BookRepository {
    fun getBooks() : List<Book>
}
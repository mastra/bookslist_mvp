package com.molol.possible.presenter

import com.molol.possible.model.Book

interface BookView {
    fun showBooks(books: List<Book>)
}
package com.molol.possible.presenter

import com.molol.possible.model.Book
import com.molol.possible.repository.BookRepository


class BookPresenter(private  val repository: BookRepository) {

    var view : BookView? = null

    fun attach(v: BookView) {
        this.view = v
    }

    fun detach() {
        this.view = null
    }

    fun getBooks(){
        val books = repository.getBooks()
        view?.showBooks(books)
    }

}
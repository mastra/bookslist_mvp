package com.molol.possible.presenter
// daniel mastracchio mastra@gmail.com
//

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
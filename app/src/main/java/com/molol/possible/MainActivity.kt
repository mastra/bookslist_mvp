package com.molol.possible

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.molol.possible.model.Book
import com.molol.possible.repository.BookRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import androidx.recyclerview.widget.DividerItemDecoration
import com.molol.possible.presenter.BookPresenter
import com.molol.possible.presenter.BookView
import com.molol.possible.repository.RemoteBookRepository

class MainActivity : AppCompatActivity(), BookView {


    private val presenter = BookPresenter( RemoteBookRepository() )

    private lateinit var linearLayoutManager: LinearLayoutManager
    private var adapter = BookRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)

        linearLayoutManager = LinearLayoutManager(this)
        adapter = BookRecyclerAdapter()
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration( recyclerView.context, linearLayoutManager.getOrientation()
        )
        recyclerView.addItemDecoration(dividerItemDecoration)


        doAsync {

            presenter.getBooks()

        }
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()

    }

    override fun showBooks(books: List<Book>) {
        runOnUiThread {
            adapter.books = books
        }
    }

}

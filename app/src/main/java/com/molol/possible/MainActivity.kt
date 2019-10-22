package com.molol.possible

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.molol.possible.model.Book
import com.molol.possible.repository.BookRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import androidx.recyclerview.widget.DividerItemDecoration

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private var adapter = BookRecyclerAdapter()
    lateinit var books : List<Book>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        adapter = BookRecyclerAdapter()
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration( recyclerView.context, linearLayoutManager.getOrientation()
        )
        recyclerView.addItemDecoration(dividerItemDecoration)

        doAsync {
            val repo = BookRepository()
            books = repo.getBooks()
            runOnUiThread {
                adapter.books = books
            }
        }
    }
}

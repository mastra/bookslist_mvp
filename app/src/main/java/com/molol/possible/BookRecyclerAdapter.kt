package com.molol.possible

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.molol.possible.model.Book
import kotlinx.android.synthetic.main.book_row.view.*

class BookRecyclerAdapter() : RecyclerView.Adapter<BookRecyclerAdapter.BookViewHolder>() {

    var books = listOf<Book>()
        set(value)  {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.book_row, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val aBook = books[position]
        holder.title.text = aBook.title
        holder.loadImage(aBook.imageURL)
     }

    class BookViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title = view.textViewTitle
        val image = view.imageViewBook

        fun loadImage(url:String) {
            Glide.with(view)
                .load(url)
                .centerInside()
                .into(image);
        }
    }

}
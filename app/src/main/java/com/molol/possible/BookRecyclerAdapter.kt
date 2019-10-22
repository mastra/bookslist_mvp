package com.molol.possible

import android.app.Activity
import android.graphics.BitmapFactory
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.molol.possible.model.Book
import kotlinx.android.synthetic.main.book_row.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.runOnUiThread
import java.net.URL

class BookRecyclerAdapter : RecyclerView.Adapter<BookRecyclerAdapter.BookViewHolder>() {

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
             doAsync {
                val bin = URL(url).readBytes()
                val bm = BitmapFactory.decodeByteArray(bin, 0, bin.size)
                view.context.runOnUiThread {
                    image.setImageBitmap(bm)
                }
            }
        }
    }

}
package com.example.flixster
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixster.R.id





class CurrentMoviesRecyclerViewAdapter (
    private val currentMovies: List<CurrentMovie>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<CurrentMoviesRecyclerViewAdapter.CurrentMovieViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentMovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_current_movie, parent, false)
            return CurrentMovieViewHolder(view)
        }



        inner class CurrentMovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: CurrentMovie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(id.title) as TextView
            val mOverview: TextView = mView.findViewById<View>(id.overview) as TextView
           // val mRanking: TextView = mView.findViewById<View>(id.ranking) as TextView
            val mMoviePoster: ImageView = mView.findViewById<View>(id.movie_poster) as ImageView
         //   val mBookDescription: TextView = mView.findViewById<View>(id.book_description) as TextView
          //  val mBuyButton: Button = mView.findViewById<Button>(id.buy_button) as Button



          //  override fun toString(): String {
         //       return mBookTitle.toString() + " '" + mBookAuthor.text + "'"
         //   }
        }


        override fun onBindViewHolder(holder: CurrentMovieViewHolder, position: Int) {
            val currentMovie = currentMovies[position]

            holder.mItem = currentMovie
            holder.mMovieTitle.text = currentMovie.title
           // holder.mBookAuthor.text = book.author
           // holder.mRanking.text=book.rank.toString()
            //holder.mBookImage
            holder.mOverview.text= currentMovie.overview
            Glide.with(holder.mView)
                .load("https://image.tmdb.org/t/p/w500"+currentMovie.posterPath).placeholder(R.drawable.loading)
            .error(R.drawable.not_found)
                .centerInside()
                .into(holder.mMoviePoster)



        }


        override fun getItemCount(): Int {
           // TODO("Not yet implemented")
            return currentMovies.size
        }


}
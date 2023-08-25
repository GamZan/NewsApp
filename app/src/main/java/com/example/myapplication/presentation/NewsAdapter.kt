package com.example.myapplication.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.api.Results
import com.example.myapplication.databinding.CardViewBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var listNews: List<Results>? = null


    fun setListNews(listNews: List<Results>?) {
        this.listNews = listNews
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = CardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (listNews?.size == null) 1 else listNews?.size!!
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listNews?.get(position))
    }

    class NewsViewHolder(binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        private val text = binding.text
        private val title = binding.title
        private val photo = binding.photo

        fun bind(news: Results?) {
            title.text = news?.title
            text.text = news?.abstract
            Glide.with(photo).load(news?.multimedia?.get(0)?.photoUrl).into(photo)
        }
    }
}




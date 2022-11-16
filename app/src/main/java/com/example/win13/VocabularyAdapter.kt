package com.example.win13

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win13.model.Vocabulary

class VocabularyAdapter(val list: List<Vocabulary>) :
    RecyclerView.Adapter<VocabularyAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.text_view_name_vocab)
        val tvDesc = itemView.findViewById<TextView>(R.id.text_view_description_vocab)

        fun binding(title: String, description: String) {
            tvTitle.text = title
            tvDesc.text = description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.vocabulary_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding(list[position].title, list[position].description)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
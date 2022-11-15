package com.example.win13

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.win13.model.Rankingmenteam

class TeamAdapter(val list: List<Rankingmenteam>): RecyclerView.Adapter<TeamAdapter.Holder>() {

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.imageView_team)
        val textViewName = itemView.findViewById<TextView>(R.id.text_view_name_team)
        val textViewScore = itemView.findViewById<TextView>(R.id.text_view_score_team)
        fun bind(imageUrl: String, name: String, score: String){
            Glide.with(itemView.context)
                .load(imageUrl)
                .into(imageView)
            textViewName.text = "Country: $name"
            textViewScore.text = "Score: $score"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.team_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position].image, list[position].national_team, list[position].wr_score)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
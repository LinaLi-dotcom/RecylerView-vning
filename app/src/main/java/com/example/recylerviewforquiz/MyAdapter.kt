package com.example.recylerviewforquiz

import android.annotation.SuppressLint
import android.graphics.Color
import android.opengl.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MyAdapter() : RecyclerView.Adapter<myViewHolder> () {

    var bestFilmList2020 = mutableListOf<String>("Parasite", "Soul", "Clemency", "Collective", "Portrait of a Lady on Fire", "Rocks", "Saint Maud", "The Assistant", "Mank", "Never Rarely Sometimes Always" )
    var giveStarOrNot = mutableListOf<Boolean>(true, false, true, false, true, false, true, false, true, false)
    var toSaveorNot = mutableListOf<Boolean>(false, true, false, true,  false, true, false, true, false, true)

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val vh = myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.my_layout_item, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return bestFilmList2020.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.nameTextView.text = (position+1).toString()+". "+bestFilmList2020[position]
        
        if (position % 2 ==0)
        {
           holder.theRow.setBackgroundColor(Color.parseColor("#81b842"))
        }else
        {
          holder.theRow.setBackgroundColor(Color.parseColor("#bdd2a9"))
        }

        if (giveStarOrNot[position] == true)
        {
          holder.starImageView.visibility = View.VISIBLE
          //holder.starGrayImageView.visibility = View.GONE
        }else
        {
          holder.starImageView.visibility = View.INVISIBLE
          //holder.starGrayImageView.visibility = View.VISIBLE
        }

        if(toSaveorNot[position] == true)
        {
            holder.plusImageView.visibility = View.VISIBLE
            //holder.deleteImageView.visibility = View.GONE
        }else
        {
            holder.plusImageView.visibility = View.INVISIBLE 
            //holder.deleteImageView.visibility = View.VISIBLE
        }
    }

    

}

class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    //var myImageView = view.findViewById<ImageView>(R.id.theImageView)
    var nameTextView = view.findViewById<TextView>(R.id.nameTextView)
    var starImageView = view.findViewById<ImageView>(R.id.star)
    var plusImageView = view.findViewById<ImageView>(R.id.plus)
    var theRow = view.findViewById<ConstraintLayout>(R.id.row)


}
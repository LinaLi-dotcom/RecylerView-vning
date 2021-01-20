package com.example.recylerviewforquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var theAdapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var theRecyclerView = findViewById<RecyclerView>(R.id.theRecyclerView)

        theRecyclerView.layoutManager = GridLayoutManager(this, 5, GridLayoutManager.HORIZONTAL,false)
        theRecyclerView.adapter = theAdapter

        var addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            var editText= findViewById<EditText>(R.id.editText)
            var newFilm = editText.text.toString()

            editText.setText("")

            theAdapter.bestFilmList2020.add(newFilm)
            theAdapter.giveStarOrNot.add(true)
            theAdapter.toSaveorNot.add(false)

            theAdapter.notifyDataSetChanged()


        }


    }
}
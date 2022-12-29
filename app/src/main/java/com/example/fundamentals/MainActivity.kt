package com.example.fundamentals

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var myList = mutableListOf(
            Todo("", false)

        )
        var adapter = todoAdapter(myList)
        val myrecylerView = findViewById<RecyclerView>(R.id.rvTodo)
        myrecylerView.adapter = adapter
        myrecylerView.layoutManager = LinearLayoutManager(this)

        val myEditText = findViewById<EditText>(R.id.editText)
        val myButton = findViewById<Button>(R.id.myAddButton)
       // val myCheckBox = findViewById<CheckBox>(R.id.checkBox)
        myButton.setOnClickListener {
            val newTitle = myEditText.text.toString()
            val toDO = Todo(newTitle,false)
            if ( newTitle.isEmpty()){
                Toast.makeText(this, "please add something", Toast.LENGTH_SHORT).show()
            }
            myList.add(toDO)
            adapter.notifyItemChanged(myList.size-1)
            myEditText.text.clear()
        }



    }


}

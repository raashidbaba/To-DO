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
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var myList = mutableListOf(
            Todo("feed the cat", true),
            Todo("join the meeting", false),
            Todo("complete assignments", false)
        )
        var adapter = todoAdapter(myList)
        val myrecylerView = findViewById<RecyclerView>(R.id.rvTodo)
        myrecylerView.adapter = adapter
        myrecylerView.layoutManager = LinearLayoutManager(this)

        val myEditText = findViewById<EditText>(R.id.editText)
        val myButton = findViewById<Button>(R.id.myAddButton)
        val myDeleteBtn = findViewById<Button>(R.id.myDeleteBtn)

        myButton.setOnClickListener {
            val newTitle = myEditText.text.toString()
            val toDO = Todo(newTitle, false)
            val checkboxText = findViewById<CheckBox>(R.id.checkBox)
           // val constraint = findViewById(R.id.myConstraint) as ConstraintLayout
             //   val checkBoo = false
            if (newTitle.isEmpty() && !checkboxText.isChecked) {
                  //checkboxText.visibility =View.INVISIBLE
               // constraint.visibility = View.INVISIBLE
                Toast.makeText(this, "please add a TO-DO", Toast.LENGTH_SHORT).show()
            }
            myList.add(toDO)
            adapter.notifyItemChanged(myList.size - 1)
            myEditText.text.clear()
        }
        myDeleteBtn.setOnClickListener {
Toast.makeText(this,"git check",Toast.LENGTH_SHORT).show()
        }


    }


}

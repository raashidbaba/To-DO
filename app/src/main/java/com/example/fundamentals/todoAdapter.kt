package com.example.fundamentals

import android.content.Intent
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class todoAdapter(var todo: MutableList<Todo>) : RecyclerView.Adapter<todoAdapter.todoHolder>() {


    inner class todoHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return todoHolder(view)
    }
    fun deleteTodo(){
        todo.removeAll() { todo ->
            todo.isCheckedBox
        }
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: todoHolder, position: Int) {
        val curTodo = todo[position]
        holder.itemView.apply {
            val titleText = findViewById<TextView>(R.id.tvTitle)
            val checkboxText = findViewById<CheckBox>(R.id.checkBox)
            titleText.text = todo[position].title
           if (titleText.text.isNullOrEmpty()){
               checkboxText.visibility = View.INVISIBLE
           }
            checkboxText.isChecked = todo[position].isCheckedBox
            toggleThrough(titleText, checkboxText.isChecked)
            checkboxText.setOnCheckedChangeListener { _, isCheckedcv ->
                toggleThrough(titleText,isCheckedcv)
                curTodo.isCheckedBox = !curTodo.isCheckedBox

            }


        }
    }

    override fun getItemCount(): Int {
        return todo.size


    }

    private fun toggleThrough(titleText: TextView, isCheckedStatus: Boolean) {
        if (isCheckedStatus) {
            titleText.paintFlags = titleText.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            titleText.paintFlags = titleText.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }


}



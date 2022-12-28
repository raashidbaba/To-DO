package com.example.fundamentals

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class todoAdapter(var todo: List<Todo>) : RecyclerView.Adapter<todoAdapter.todoHolder>() {
    interface OnCheckboxChangedListener {
        fun onCheckboxChanged(position: Int, isChecked: Boolean)
    }
    
    inner class todoHolder(itemView: View) : RecyclerView.ViewHolder(itemView)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return todoHolder(view)
    }

    override fun onBindViewHolder(holder: todoHolder, position: Int) {
        holder.itemView.apply {
            val titleText = findViewById<TextView>(R.id.tvTitle)
            val checkboxText = findViewById<CheckBox>(R.id.checkBox)
            titleText.text = todo[position].title
            checkboxText.isChecked = todo[position].isChecked

        }
    }

    override fun getItemCount(): Int {
        return todo.size


    }

}



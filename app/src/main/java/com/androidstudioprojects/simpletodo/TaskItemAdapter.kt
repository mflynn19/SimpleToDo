package com.androidstudioprojects.simpletodo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskItemAdapter(val listofItems: List<String>, val longClickListener: onLongClickListener) : RecyclerView.Adapter<TaskItemAdapter.ViewHolder>(){
    interface onLongClickListener{
        fun onItemLongClick(position: Int)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView
        init{
            textView = itemView.findViewById(android.R.id.text1)
            itemView.setOnLongClickListener {
                longClickListener.onItemLongClick(adapterPosition)
                true
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listofItems.get(position)
        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return listofItems.count()
    }
}
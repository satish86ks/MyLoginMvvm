package com.example.myloginmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myloginmvvm.R
import com.example.myloginmvvm.data.Data

class ListViewAdapter(private val mList:List<Data>): RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = mList[position]
        holder.textView.text=items.name

        holder.itemView.setOnClickListener {
            navigateToDetailScreen(it)
        }

    }

    override fun getItemCount(): Int {
      return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    private fun navigateToDetailScreen(view: View){
        view.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}
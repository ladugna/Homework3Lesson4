package com.example.homework3lesson4

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.homework3lesson4.R

import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    var context: Context,
    var text1: Array<String>,
    var text2: Array<String>,
    var img: IntArray,
    var text3: Array<String>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Values assigned to the respective View components in the card_layout.xml
        holder.txt1.text = text1[position]
        holder.txt2.text = text2[position]
       holder.img.setImageResource(img[position])
        // Implement the click Listener in the using the layout.
        holder.rlayout.setOnClickListener {
            // User clicks the list Item to open the DetailActivity
            val intent = Intent(context, DetailActivity::class.java)
            var res = text1[position]
            Toast.makeText(context, "$res clicked", Toast.LENGTH_LONG).show()
            // Pass data to the Detail Activity
            intent.putExtra("image", img[position])
            intent.putExtra("name", text1[position])
            intent.putExtra("detail", text3[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return text1.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rlayout: RelativeLayout = itemView.findViewById(R.id.playout)
        var txt1: TextView = itemView.findViewById(R.id.tv1)
        var txt2: TextView = itemView.findViewById(R.id.tv2)
        var img: ImageView = itemView.findViewById(R.id.imageView)

    }
}
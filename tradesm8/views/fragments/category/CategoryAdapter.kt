package com.app.tradesm8.views.fragments.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.tradesm8.R
import com.app.tradesm8.models.category.Category
import com.app.tradesm8.utilities.common.customToast
import com.bumptech.glide.Glide

class CategoryAdapter(category: List<Category>, activity: FragmentActivity?) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val myList : List<Category> = category
    private val context : Context = activity!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_home_cat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.text = myList.get(position).catName

        Glide.with(context).load(myList.get(position).catImage)
            .into(holder.productImage)

        holder.productClick.setOnClickListener {

            if (myList.get(position).status != 2){

            }
            else {
                context.customToast("Category/Products Not Available")
            }

        }

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    class ViewHolder(ItemView: View)  : RecyclerView.ViewHolder(ItemView) {

        val productName : TextView = ItemView.findViewById(R.id.textProductName)
        val productImage : ImageView = ItemView.findViewById(R.id.productImgView)
        val productClick : CardView = ItemView.findViewById(R.id.cardView)

    }
}
package jmc.rs.kimtinviinthoicabn

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import jmc.rs.kimtinviinthoicabn.databinding.RecyclertwoBinding

class Adapter(var mainlist: Array<String>, var desc: Array<String>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    var currentposition = 0

    class ViewHolder(binding: RecyclertwoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var bindings: RecyclertwoBinding = binding
        fun bindIdea(dataPor: String , desc : String) {
            itemView.apply {
                bindings.title.text = dataPor
                bindings.title2.text = desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclertwo, parent, false
            )
        )

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mainlist[position]
        val desc = desc[position]

        holder.bindIdea(data, desc)

        holder.bindings.title2.visibility = View.GONE

        if (currentposition == position) {
            holder.bindings.title2.visibility = View.VISIBLE
        }

        holder.bindings.linear.setOnClickListener()
        {
            currentposition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return mainlist.size
    }
}

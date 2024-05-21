package com.example.enfecassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enfecassignment.R
import com.example.enfecassignment.model.MergedData

class MergedDataAdapter : RecyclerView.Adapter<MergedDataAdapter.MergedDataViewHolder>() {

    private var mergedDataList: List<MergedData> = emptyList()

    fun setMergedData(data: List<MergedData>) {
        this.mergedDataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MergedDataViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_merged_data, parent, false)
        return MergedDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: MergedDataViewHolder, position: Int) {
        holder.bind(mergedDataList[position])
    }

    override fun getItemCount(): Int {
        return mergedDataList.size
    }

    class MergedDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.post_title)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val email: TextView = itemView.findViewById(R.id.email)
        private val lat: TextView = itemView.findViewById(R.id.lat)
        private val lng: TextView = itemView.findViewById(R.id.lng)
        private val companyName: TextView = itemView.findViewById(R.id.company)

        fun bind(data: MergedData) {
            title.text = data.title
            name.text = data.name
            email.text = data.email
            lat.text = data.lat
            lng.text = data.lng
            companyName.text = data.companyName
        }
    }
}
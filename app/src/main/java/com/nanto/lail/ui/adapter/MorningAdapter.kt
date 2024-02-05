package com.nanto.lail.ui.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanto.lail.data.response.DataItem
import com.r10.lail.databinding.ItemDzikirBinding

class MorningAdapter(val listM: ArrayList<DataItem>): RecyclerView.Adapter<MorningAdapter.ListViewHolder>() {
    
    class ListViewHolder(binding: ItemDzikirBinding): RecyclerView.ViewHolder(binding.root){

        private var notes = binding.tvNotes
        private var title = binding.tvTitle
        private var fawaid = binding.tvFawaid
        private var source = binding.tvSource
        private var arabic = binding.tvArabic

        fun setData(listDzikir: DataItem) {
            notes.text = listDzikir.notes
            title.text = listDzikir.title
            fawaid.text = listDzikir.fawaid
            source.text = listDzikir.source
            arabic.text = listDzikir.arabic

        }
    }

    // untuk memmbuta lifesycle onCreate pada activiti
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemDzikirBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }
    
    // untuk menampilkan jumlah data yg akan ditampilkan
    override fun getItemCount(): Int {
        return listM.size
    }

    // untuk menetukan posisi data
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listM[position]
        holder.setData(data)
    }
}
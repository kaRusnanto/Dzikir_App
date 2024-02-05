package com.nanto.lail.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanto.lail.MainViewModel
import com.nanto.lail.ui.adapter.MorningAdapter
import com.nanto.lail.data.response.DataItem
import com.r10.lail.databinding.ActivityMorningBinding

class MorningActivity : AppCompatActivity() {

    private lateinit var morningBinding: ActivityMorningBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        morningBinding = ActivityMorningBinding.inflate(layoutInflater)
        setContentView(morningBinding.root)

        mainViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)

        mainViewModel.getDzikirPagi()
        mainViewModel.getDzikirPetang()


        showAdapter()
        
    }
    private fun showAdapter(){
        val lm = LinearLayoutManager(this)
        morningBinding.rvItemMorning.layoutManager = lm 

        val mode = intent.getStringExtra(MODE)

        if (mode == "evening"){
            mainViewModel.listDzikirPetang.observe(this) { result ->
                setData(result)
            }

        }
        else {
            mainViewModel.listDzikirPagi.observe(this) { result ->
                setData(result)
            }
        }
    }

    private fun setData(result: ArrayList<DataItem>) {
        val adapter = MorningAdapter(result)
        morningBinding.rvItemMorning.adapter = adapter
    }

    fun cekData() {
        mainViewModel.listDzikirPagi.observe(this) {
            Log.d("Cek data", it.toString())
        }
    }

    companion object {
        public val MODE = String()
    }
}
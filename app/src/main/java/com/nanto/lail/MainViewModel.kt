package com.nanto.lail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.nanto.lail.data.network.ApiConfig
import com.nanto.lail.data.response.DataItem
import com.nanto.lail.data.response.ResponseDzikir
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel: ViewModel() {
    private val _listDzikirPagi = MutableLiveData<ArrayList<DataItem>>();
    val listDzikirPagi: LiveData<ArrayList<DataItem>> = _listDzikirPagi


    private val _listDzikirPetang = MutableLiveData<ArrayList<DataItem>>();
    val listDzikirPetang: LiveData<ArrayList<DataItem>> = _listDzikirPetang;

    fun getDzikirPagi() {
        val client = ApiConfig.getApiService().getDzikirPagi()
        client.enqueue(object : Callback<ResponseDzikir>{
            override fun onResponse(
                call: Call<ResponseDzikir>,
                response: Response<ResponseDzikir>
            ) {
                val  data = response.body()
                if (data != null) {
                    _listDzikirPagi.value = ArrayList(data.data)
                }
            }

            override fun onFailure(call: Call<ResponseDzikir>, t: Throwable) {
                Log.d("Eror",t.message.toString())
            }
        })
    }

    fun getDzikirPetang() {
        val client = ApiConfig.getApiService().getDzikirPetang()
        client.enqueue(object : Callback<ResponseDzikir>{
            override fun onResponse(
                call: Call<ResponseDzikir>,
                response: Response<ResponseDzikir>
            ) {
                val  data = response.body()
                if (data != null) {
                    _listDzikirPetang.value = ArrayList(data.data)
                }
            }

            override fun onFailure(call: Call<ResponseDzikir>, t: Throwable) {
                Log.d("Eror",t.message.toString())
            }
        })
    }

}
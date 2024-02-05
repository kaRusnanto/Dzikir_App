package com.nanto.lail.data.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ResponseDzikir(

    @field:SerializedName("data")
    val data: List<DataItem>? = null,

    @field:SerializedName("message")
    val message: String? = null
) : Parcelable

@Parcelize
data class DataItem(

    @field:SerializedName("notes")
    val notes: String? = null,

    @field:SerializedName("arabic")
    val arabic: String? = null,

    @field:SerializedName("translation")
    val translation: String? = null,

    @field:SerializedName("latin")
    val latin: String? = null,

    @field:SerializedName("source")
    val source: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("fawaid")
    val fawaid: String? = null
) : Parcelable
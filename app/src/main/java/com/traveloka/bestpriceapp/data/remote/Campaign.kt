package com.traveloka.bestpriceapp.data.remote

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Campaign(
    val img: Int,
    val name: String
) : Parcelable

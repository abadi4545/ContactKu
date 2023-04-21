package com.arkam.contactku.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class People(
    val id : String,
    val firstName : String,
    val lastName: String,
    val email: String,
    val dob: String
) : Parcelable

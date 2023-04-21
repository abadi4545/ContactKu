package com.arkam.contactku.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DetailPeople(
    val id : String,
    val firstName : String,
    val lastName: String,
    val email: String,
    val dob: String
) :Parcelable
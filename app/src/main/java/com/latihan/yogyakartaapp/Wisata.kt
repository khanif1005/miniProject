package com.latihan.yogyakartaapp

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.Photo
import android.util.EventLogTags.Description
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val name: String,
    val description: String,
    val photo: List<String>
) : Parcelable

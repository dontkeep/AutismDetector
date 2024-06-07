package com.nicelydone.autismdetector.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items(
   val title: String,
   val content: String
): Parcelable

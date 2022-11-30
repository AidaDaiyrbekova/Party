package com.example.auto

import com.google.gson.annotations.SerializedName

data class Guest(
   @SerializedName("name") val name: String,
   @SerializedName ("photoGuest")val photoGuest: String
)
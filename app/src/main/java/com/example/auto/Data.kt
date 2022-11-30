package com.example.auto

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("guest") val guest: List<Guest>,
    @SerializedName ("nameInviting") val nameInviting: String,
    @SerializedName ("nameParty")val nameParty: String,
    @SerializedName ("photoInviting") val photoInviting: String,
    @SerializedName ("photoParty") val photoParty: String
)
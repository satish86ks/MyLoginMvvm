package com.example.myloginmvvm.data

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.parcelize.Parcelize

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class UserResponse(
    @JsonProperty("httpCode")
    val httpCode: Int = 0,
    @JsonProperty("message")
    val message: String = "",
): Parcelable
package com.example.myloginmvvm.data

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.parcelize.Parcelize

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class Data(
    @JsonProperty("id")
    val id: Int=0,
    @JsonProperty("name")
    val name: String="",
    @JsonProperty("year")
    val year: Int=0,
    @JsonProperty("color")
    val color: String="",
    @JsonProperty("pantone_value")
    val pantone_value: String=""
) : Parcelable
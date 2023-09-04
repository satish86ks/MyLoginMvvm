package com.example.myloginmvvm.data

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.parcelize.Parcelize


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class UserListResponse(
    @JsonProperty("data")
    val data: List<Data>,
    @JsonProperty("page")
    val page: Int=0,
    @JsonProperty("per_page")
    val per_page: Int=0,
    @JsonProperty("support")
    val support: Support,
    @JsonProperty("total")
    val total: Int=0,
    @JsonProperty("total_pages")
    val total_pages: Int=0
) : Parcelable
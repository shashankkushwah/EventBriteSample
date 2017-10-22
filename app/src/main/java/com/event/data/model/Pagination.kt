package com.event.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Shashank on 22/10/2017.
 */
class Pagination(@SerializedName("object_count") val objectCount: Int, @SerializedName("page_number") val pageNumber:
Int, @SerializedName("page_size") val pageSize: Int, @SerializedName("page_count") val pageCount: Int,
                 @SerializedName("has_more_items") val hasMoreItems: Boolean)
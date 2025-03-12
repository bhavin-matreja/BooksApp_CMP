package com.bvn.bookcmp.book.data.dto

import androidx.compose.ui.graphics.drawscope.Stroke
import kotlinx.serialization.Serializable

@Serializable(with = BookWorkDtoSerializer::class)
data class BookWorkDto(
    val description: String? = null
)
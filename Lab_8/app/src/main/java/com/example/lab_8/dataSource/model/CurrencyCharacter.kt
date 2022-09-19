package com.example.lab_8.dataSource.model

import java.io.Serializable

/**
 * Data of each character
 */
data class CurrencyCharacter(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
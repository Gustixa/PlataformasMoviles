package com.example.lab_8.dataSource.model

import java.io.Serializable

/**
 * Data of each character
 */
data class CurrencyCharacter(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val origin: Origin,
    val episode: List<String>
)
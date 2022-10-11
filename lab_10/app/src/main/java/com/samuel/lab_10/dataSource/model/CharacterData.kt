package com.samuel.lab_10.dataSource.model

import com.samuel.lab_10.dataSource.local.model.Character


data class CharacterData(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val origin: Origin,
    val episode: List<String>
)

fun CharacterData.mapToModel(): Character = Character(
    id = id.toInt(),
    name = name,
    status = status,
    species = species,
    gender = gender,
    image = image,
    origin = origin.name,
    episodes = episode.size
)
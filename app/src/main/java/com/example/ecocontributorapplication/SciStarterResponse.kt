package com.example.ecocontributorapplication

data class SciStarterResponse(
    val projects: List<Project>
)

data class Project(
    val id: Int,
    val name: String,
    val description: String,
    val location: String
)

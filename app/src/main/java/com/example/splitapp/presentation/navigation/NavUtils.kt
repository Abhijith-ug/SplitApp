package com.example.splitapp.presentation.navigation

fun navQuery(key: String): String = "$key={$key}"
fun String.toNavQueryValue(argKey: String): String = "$argKey=${this.ifEmpty { null }}"

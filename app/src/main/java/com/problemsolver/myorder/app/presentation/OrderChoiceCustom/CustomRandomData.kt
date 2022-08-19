package com.problemsolver.myorder.app.presentation.OrderChoiceCustom

fun RandomData():Data{
    val items = listOf(
        "x",
        "x "
    ).random()

    return Data(items)
}
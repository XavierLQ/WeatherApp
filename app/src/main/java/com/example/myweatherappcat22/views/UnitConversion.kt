package com.example.myweatherappcat22.views

fun convertKtoC(tempInK: Double): Float {
    return (tempInK - 273.15).toFloat()
}

fun convertKtoF(tempInK: Double): Float {
    return (((tempInK - 273.15) * (9 / 5)) + 32).toFloat()
}

// this is an extension function, use them instead of a normal functions
// they are lighter to run and can be used on any double value
fun Double.convertPaToPSI(): Int =
    ((this / 10) * 0.145038).toInt()


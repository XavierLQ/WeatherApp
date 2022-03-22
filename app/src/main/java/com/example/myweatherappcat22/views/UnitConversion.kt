package com.example.myweatherappcat22.views

fun convertKtoC(tempInK: Double): Float {
    return (tempInK - 273.15).toFloat()
}

fun convertKtoF(tempInK: Double): Float {
    return (((tempInK - 273.15) * (9 / 5)) + 32).toFloat()
}

fun convertPaToPSI(pressureInPa: Double): Int {
    return ((pressureInPa / 10) * 0.145038).toInt()
}


package com.xavizard.registros

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Persona(val name: String, val charge: String, val description: String, val rate: Float) :
    Parcelable {
    
}
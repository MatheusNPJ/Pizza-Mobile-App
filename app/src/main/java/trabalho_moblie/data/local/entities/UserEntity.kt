package com.example.trabalho_moblie.data.local.entities
import androidx.room.Entity
import androidx.room.PrimaryKey


//Essa estrutura de dado está pronta para receber os usuário e poder levalos de forma correta até o BD
@Entity(tableName = "users")
data class UserEntity (

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name : String = "",
    val senha : String = "",
    val email : String = ""

)
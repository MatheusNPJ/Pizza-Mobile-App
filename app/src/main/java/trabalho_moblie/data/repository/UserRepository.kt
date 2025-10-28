package com.example.trabalho_moblie.data.repository

import UserDao
import com.example.trabalho_moblie.data.local.entities.UserEntity

class UserRepository (private val dao : UserDao) {

    suspend fun insertUser(user: UserEntity) {
        dao.insertUser(user)
    }

    suspend fun getUser(user: UserEntity): UserEntity? {
        return dao.getUser(user.name, user.senha)
    }

}
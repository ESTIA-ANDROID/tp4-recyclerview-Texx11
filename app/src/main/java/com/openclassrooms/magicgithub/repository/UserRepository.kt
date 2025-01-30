package com.openclassrooms.magicgithub.repository

import com.openclassrooms.magicgithub.api.ApiService
import com.openclassrooms.magicgithub.model.User

class UserRepository(
    private val apiService: ApiService
) {
    fun getUsers(): List<User> {
        return apiService.getUsers()
    }

    fun addRandomUser() {
        apiService.addRandomUser()
    }

    fun deleteUser(user: User) {
        apiService.deleteUser(user)
    }

    fun setActiveInactive(user: User) {
        apiService.setActiveInactive(user)
    }

    fun swapUsers(from: Int, to: Int) {
        apiService.swapUsers(from, to)
    }
}
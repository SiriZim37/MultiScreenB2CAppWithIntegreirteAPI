package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siri.multiscreenb2cappwithintegreirteapi.room.dao.UserDao
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.UserEntity
import com.siri.multiscreenb2cappwithintegreirteapi.utils.AppUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {

    fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        phone: String,
        address: String?,
        profileImageUri: String?,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            val existing = userDao.getUserByEmail(email)
            if (existing != null) {
                onError("Email already registered")
                return@launch
            }

            val user = UserEntity(
                firstName = firstName,
                lastName = lastName,
                email = email,
                phone = phone,
                address = address,
                profileImageUri = profileImageUri,
                registeredAt = System.currentTimeMillis(),
                passwordHash = AppUtils.hashPassword(password)
            )

            userDao.insertUser(user)
            onSuccess()
        }
    }
}

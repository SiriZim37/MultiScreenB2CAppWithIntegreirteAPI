package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.UserEntity
import com.siri.multiscreenb2cappwithintegreirteapi.room.repo.ProductRepository
import com.siri.multiscreenb2cappwithintegreirteapi.room.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    application: Application,
    private val repository: UserRepository
) : AndroidViewModel(application) {

    // ใช้ LiveData หรือ StateFlow เพื่อเก็บข้อมูล user
    private val _user = MutableStateFlow<UserEntity?>(null)
    val user: StateFlow<UserEntity?> = _user.asStateFlow()

    init {
        loadUser()
    }

    private fun loadUser() {
        viewModelScope.launch {
            val userFromDb = repository.getFirstUser()
            _user.value = userFromDb
        }
    }

}
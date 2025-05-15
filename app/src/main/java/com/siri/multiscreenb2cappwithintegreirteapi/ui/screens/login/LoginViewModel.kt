package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siri.multiscreenb2cappwithintegreirteapi.room.repo.UserRepository
import com.siri.multiscreenb2cappwithintegreirteapi.utils.AppUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.security.MessageDigest
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean?> = _isLoading

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoading.value = true
            delay(1000) // แค่จำลองโหลด

            val user = userRepository.getUserByEmail(email)
            if (user == null || !AppUtils.verify(password, user.passwordHash)) {
                _error.value = "Invalid email or password"
                _loginSuccess.value = false
            } else {
                _loginSuccess.value = true
            }

            _isLoading.value = false
        }
    }

    fun setError(message: String) {
        _error.value = message
    }

    private fun hashPassword(password: String): String {
        return MessageDigest.getInstance("SHA-256")
            .digest(password.toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}

package jorge.andaur.rios.mvvm14mayo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jorge.andaur.rios.mvvm14mayo.model.User

class UserViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val _greeting = MutableLiveData<String>()
    val greeting: LiveData<String> get() = _greeting


    fun setUser(name: String) {
        _user.value = User(name)
    }

    fun generateGreeting() {
        val userName = _user.value?.name ?: ""
        val greeting = "Hola, $userName!"
        _greeting.value = greeting
    }
}
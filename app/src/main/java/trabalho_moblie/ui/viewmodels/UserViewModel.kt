package com.example.trabalho_moblie.ui.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trabalho_moblie.data.local.entities.UserEntity
import com.example.trabalho_moblie.data.model.User
import com.example.trabalho_moblie.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow


data class UserUiState(
    val listaDeUsuarios: List<User> = emptyList(),
    val name: String = "",
    val email: String = "",
    val senha: String = "",
    val message : String = ""

) {
    val textoBotao: String
        get() = "Add"
}

class UserViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(UserUiState())
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()


    private val _message = MutableSharedFlow<String>()
    val message = _message.asSharedFlow()

    // Atualiza o nome do usuário
    fun onNomeChange(novoNome: String) {
        _uiState.update { it.copy(name = novoNome,) }
    }

    // Atualiza o email do usuário
    fun onEmailChange(novoEmail: String) {
        _uiState.update { it.copy(email = novoEmail,) }
    }

    // Atualiza a senha do usuário
    fun onSenhaChange(novaSenha: String) {
        _uiState.update { it.copy(senha = novaSenha,) }
    }

    fun clear_uiState() {
        _uiState.value = UserUiState()
    }

    fun Login(){

        val user = UserEntity(
            name = _uiState.value.name,
            senha = _uiState.value.senha
        )


        if(user.name.isBlank() || user.senha.isBlank()){
            _uiState.value = _uiState.value.copy(message = "Preencha todos os campos!")
        } else {
            viewModelScope.launch {
                val result = repository.getUser(user)
                if (result != null) {
                    _uiState.update { it.copy(message = "Login realizado com sucesso!") }
                } else {
                    _uiState.update { it.copy(message = "Usuário não encontrado!") }
                }
            }
        }
    }

    fun onCadastrar() {

        val user = UserEntity(
            name = _uiState.value.name,
            email = _uiState.value.email,
            senha = _uiState.value.senha
        )


        if(user.name.isBlank() || user.email.isBlank() || user.senha.isBlank()){
            _uiState.value = _uiState.value.copy(message = "Preencha todos os campos!")
        } else {
            viewModelScope.launch {
                repository.insertUser(user)
                _uiState.value = _uiState.value.copy(
                    message = "Usuário cadastrado com sucesso!"
                )
                delay(3000)
                clear_uiState()

            }
        }
    }

}


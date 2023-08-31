package stan_atilovich.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import stan_atilovich.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import stan_atilovich.harry_potter_and_retrofit.domain.model.model2.CharacterModel
import stan_atilovich.harry_potter_and_retrofit.domain.model.usecase.GetCharacterListUseCase
import stan_atilovich.harry_potter_and_retrofit.domain.model.usecase.GetCharacterUseCase

class MainViewModel : ViewModel() {
    private val repository = CharacterRepositoryImpl()

    private val getCharacterListUseCase = GetCharacterListUseCase(repository)
    private val getCharacterUseCase = GetCharacterUseCase(repository)

    private var _character: MutableStateFlow<CharacterModel> =
        MutableStateFlow<CharacterModel>(CharacterModel())
    var character = _character.asStateFlow()

    init {
        viewModelScope.launch {
            _character.value = getCharacterUseCase.getCharacter(1)
        }
    }
}
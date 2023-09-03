package stan_atilovich.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import stan_atilovich.harry_potter_and_retrofit.data.CharacterRepositoryImpl
import stan_atilovich.harry_potter_and_retrofit.domain.model.usecase.GetCharacterListUseCase
import stan_atilovich.harry_potter_and_retrofit.domain.model.usecase.GetCharacterUseCase

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
           val repo = CharacterRepositoryImpl()
                 val useCase = GetCharacterUseCase(repo)
                     val useCase2 = GetCharacterListUseCase(repo)
            return MainViewModel(repo,useCase2,useCase) as T
        }
        throw IllegalArgumentException("неизвестное имя классса")
    }
}
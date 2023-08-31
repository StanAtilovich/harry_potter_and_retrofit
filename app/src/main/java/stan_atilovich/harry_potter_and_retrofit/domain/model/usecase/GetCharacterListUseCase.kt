package stan_atilovich.harry_potter_and_retrofit.domain.model.usecase

import stan_atilovich.harry_potter_and_retrofit.domain.model.model2.CharacterModel
import stan_atilovich.harry_potter_and_retrofit.domain.model.repository.CharacterRepository

class GetCharacterListUseCase(
    private val repo: CharacterRepository
) {
    suspend fun getCharacterList(): List<CharacterModel> {
        return repo.getCharacters()
    }
}
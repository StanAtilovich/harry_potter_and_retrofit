package stan_atilovich.harry_potter_and_retrofit.data

import stan_atilovich.harry_potter_and_retrofit.data.dto.CharacterDto
import stan_atilovich.harry_potter_and_retrofit.data.mapper.CharacterMapper
import stan_atilovich.harry_potter_and_retrofit.domain.model.model2.CharacterModel
import stan_atilovich.harry_potter_and_retrofit.domain.model.repository.CharacterRepository


class CharacterRepositoryImpl : CharacterRepository {
    private val mapper = CharacterMapper()

    override suspend fun getCharacters(): List<CharacterModel> {
        return mapper.mapListDtoToListModel(RetrofitInstance.searchCharacterApi.getCharacters())
    }

    override suspend fun getCharacterById(id: Int): CharacterModel {
        return mapper.mapDtoToModel(
            RetrofitInstance.searchCharacterApi.getCharactersById(id)
        )
    }
}
package stan_atilovich.harry_potter_and_retrofit.domain.model.repository

import stan_atilovich.harry_potter_and_retrofit.domain.model.model2.CharacterModel

interface CharacterRepository {

   suspend fun getCharacters(): List<CharacterModel>
   suspend fun getCharacterById(id: Int): CharacterModel
}
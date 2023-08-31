package stan_atilovich.harry_potter_and_retrofit.data.mapper

import stan_atilovich.harry_potter_and_retrofit.data.dto.CharacterDto
import stan_atilovich.harry_potter_and_retrofit.domain.model.model2.CharacterModel

class CharacterMapper {
    fun mapDtoToModel(characterDto: CharacterDto)= CharacterModel(
        id = characterDto.id,
        name = characterDto.name,
        hogwartsHouse = characterDto.hogwartsHouse,
        imageUrl = characterDto.imageUrl
    )

    fun mapListDtoToListModel(dtoList:List<CharacterDto>): List<CharacterModel>{
        var resList = mutableListOf<CharacterModel>()
        dtoList.forEach { resList.add(mapDtoToModel(it)) }
        return resList
    }
}
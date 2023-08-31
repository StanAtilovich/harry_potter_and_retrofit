package stan_atilovich.harry_potter_and_retrofit.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import stan_atilovich.harry_potter_and_retrofit.data.dto.CharacterDto


const val BASE_URL = "https://harry-potter-api-en.onrender.com/characters"

interface SearchCharactersApi {
    @GET
   suspend fun getCharacters(): List<CharacterDto>

    @GET
   suspend fun getCharactersById(@Query("id") id: Int = 1): CharacterDto

    //  @GET("/{id}")
    //  fun getCharactersByIdPath(@Path("id") id: Int = 1)
}


object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    val searchCharacterApi: SearchCharactersApi =
        retrofit.create(SearchCharactersApi::class.java)
}
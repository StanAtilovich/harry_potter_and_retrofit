package stan_atilovich.harry_potter_and_retrofit.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import stan_atilovich.harry_potter_and_retrofit.data.dto.CharacterDto
import java.util.concurrent.TimeUnit


const val BASE_URL = "https://harry-potter-api-en.onrender.com"

interface SearchCharactersApi {
    @GET("/characters")
    suspend fun getCharacters(): List<CharacterDto>

    @GET("/characters/{id}")
    suspend fun getCharactersById(@Path("id") id: Int = 1): CharacterDto

}


object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchCharacterApi: SearchCharactersApi =
        retrofit.create(SearchCharactersApi::class.java)
}
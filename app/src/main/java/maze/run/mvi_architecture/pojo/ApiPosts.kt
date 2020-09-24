package maze.run.mvi_architecture.pojo

import retrofit2.http.GET
import javax.inject.Inject

interface ApiPosts {

    @GET("posts")
    suspend fun getposts():List<Posts>

}
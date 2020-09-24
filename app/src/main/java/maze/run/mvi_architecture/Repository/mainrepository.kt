package maze.run.mvi_architecture.Repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import maze.run.mvi_architecture.pojo.ApiPosts
import maze.run.mvi_architecture.pojo.Posts
import maze.run.mvi_architecture.util.DataState
import java.lang.Exception

class mainrepository
constructor(
    private val apiPosts: ApiPosts
) {
    suspend fun getBlogs(): Flow<DataState<List<Posts>>> = flow {
        emit(DataState.Loading)
        delay(1000)
            val networkBlogs = apiPosts.getposts()
            emit(DataState.Success(networkBlogs))


    }
}

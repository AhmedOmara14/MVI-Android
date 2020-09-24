package maze.run.mvi_architecture.util

import maze.run.mvi_architecture.pojo.Posts


sealed class DataState<out R> {

    data class Success<out T>(val list: List<Posts>) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}

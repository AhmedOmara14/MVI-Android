package maze.run.mvi_architecture.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import maze.run.mvi_architecture.Repository.mainrepository
import maze.run.mvi_architecture.pojo.Posts
import maze.run.mvi_architecture.util.DataState


@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject
constructor(
    private val mainrepository: mainrepository
) : ViewModel() {

    private val mutableLiveData: MutableLiveData<DataState<List<Posts>>> = MutableLiveData()


    suspend fun getPosts(): MutableLiveData<DataState<List<Posts>>> {
        viewModelScope.launch {
                    mainrepository.getBlogs()
                        .onEach {dataState ->
                            mutableLiveData.value = dataState
                        }
                        .launchIn(viewModelScope)

        }
        return  mutableLiveData

    }

}














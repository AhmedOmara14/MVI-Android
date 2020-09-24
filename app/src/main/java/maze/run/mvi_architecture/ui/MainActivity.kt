package maze.run.mvi_architecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import maze.run.mvi_architecture.R
import maze.run.mvi_architecture.pojo.Posts
import maze.run.mvi_architecture.util.DataState
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch(Dispatchers.Main) {
            mainViewModel.getPosts().observe(
                this@MainActivity,
                androidx.lifecycle.Observer { dataState ->
                    when (dataState) {
                        is DataState.Success<List<Posts>> -> {
                            Log.d(TAG, "onCreate: "+dataState.list.get(1).body)
                        }
                        is DataState.Error -> {
                            Log.d(TAG, "onViewCreated: ")
                        }
                        is DataState.Loading -> {
                        }
                    }
                })

        }

    }

    companion object {
        private const val TAG = "MainActivity"
    }

}
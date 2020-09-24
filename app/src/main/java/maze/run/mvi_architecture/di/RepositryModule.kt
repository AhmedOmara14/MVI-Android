package maze.run.mvi_architecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import maze.run.mvi_architecture.Repository.mainrepository
import maze.run.mvi_architecture.pojo.ApiPosts

import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)

@Module
object RepositryModule {

    @Singleton
    @Provides
   fun provideRepositry(apiPosts: ApiPosts): mainrepository {
        return mainrepository(apiPosts)
    }


}
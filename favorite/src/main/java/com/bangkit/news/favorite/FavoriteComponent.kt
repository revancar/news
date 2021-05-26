package com.bangkit.news.favorite

import android.content.Context
import com.bangkit.news.di.FavoriteModuleDepedencies
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Singleton


@Component(dependencies = [FavoriteModuleDepedencies::class])
interface FavoriteComponent {

    fun inject(activity: FavoriteActivity)

    @Component.Builder
    interface Builder{
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDepedencies: FavoriteModuleDepedencies): Builder
        fun build(): FavoriteComponent
    }

}
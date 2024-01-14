package com.landmuc.tracked.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.landmuc.core.data.preferences.DefaultPreferences
import com.landmuc.core.domain.preferences.Preferences
import com.landmuc.core.domain.use_case.FilterOutDigits
import com.landmuc.core.domain.use_case.FilterOutDigitsAndDots
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits {
        return FilterOutDigits()
    }

    @Provides
    @Singleton
    fun provideFilterOutDigitsAndDots(): FilterOutDigitsAndDots {
        return FilterOutDigitsAndDots()
    }
}
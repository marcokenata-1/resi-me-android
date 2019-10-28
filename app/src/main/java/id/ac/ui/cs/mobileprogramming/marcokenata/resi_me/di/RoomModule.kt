package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.RecipeDao
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.RecipeDatabase
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) : RecipeDatabase {
        return Room.databaseBuilder(
            application,
            RecipeDatabase::class.java,"recipes.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideRecipeDao(appDatabase: RecipeDatabase): RecipeDao {
        return appDatabase.recipeDao()
    }


}
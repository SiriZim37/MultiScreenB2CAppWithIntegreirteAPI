package com.siri.multiscreenb2cappwithintegreirteapi.room.module

import android.content.Context
import androidx.room.Room
import com.siri.multiscreenb2cappwithintegreirteapi.room.dao.ProductDao
import com.siri.multiscreenb2cappwithintegreirteapi.room.dao.UserDao
import com.siri.multiscreenb2cappwithintegreirteapi.room.db.AppDatabase
import com.siri.multiscreenb2cappwithintegreirteapi.room.repo.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()


    @Provides
    fun provideProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao()
    }

//    @Provides
//    fun provideProductRepository(productDao: ProductDao): ProductRepository {
//        return ProductRepository(productDao)
//    }
}

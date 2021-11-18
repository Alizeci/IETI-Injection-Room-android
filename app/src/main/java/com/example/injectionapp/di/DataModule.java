package com.example.injectionapp.di;

import android.content.Context;

import androidx.room.Room;

import com.example.injectionapp.analytics.AnalyticsAdapter;
import com.example.injectionapp.analytics.GoogleAnalytics;
import com.example.injectionapp.data.AppDatabase;
import com.example.injectionapp.data.dao.UserDao;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn( SingletonComponent.class )
public class DataModule
{

    @Provides
    @Singleton
    public AnalyticsAdapter provideAnalyticsAdapter()
    {
        return new GoogleAnalytics();
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context,
                AppDatabase.class, "database-name").build(); //To create an instance of the database
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(AppDatabase appDatabase){
        return appDatabase.userDao();
    }

    @Provides
    @Singleton
    public Executor provideExecutor(){
        return Executors.newFixedThreadPool(1);
    }
}
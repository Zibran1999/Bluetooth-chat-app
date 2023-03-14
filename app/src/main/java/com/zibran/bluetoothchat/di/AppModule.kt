package com.zibran.bluetoothchat.di

import android.content.Context
import com.zibran.bluetoothchat.data.chat.AndroidBluetoothController
import com.zibran.bluetoothchat.domain.chat.BluetoothDeviceController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideBluetoothController(@ApplicationContext context:Context): BluetoothDeviceController{
        return AndroidBluetoothController(context)
    }
}

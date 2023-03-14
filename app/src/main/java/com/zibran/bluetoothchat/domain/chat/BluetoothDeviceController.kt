package com.zibran.bluetoothchat.domain.chat

import kotlinx.coroutines.flow.StateFlow

interface BluetoothDeviceController {
    val scannedDevices: StateFlow<List<BluetoothDevice>>
    val pairedDevices: StateFlow<List<BluetoothDevice>>


    fun startDiscovery()
    fun stopDiscovery()
    fun release()
}
package com.zibran.bluetoothchat.presentation

import com.zibran.bluetoothchat.domain.chat.BluetoothDevice


data class BluetoothUiState(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List<BluetoothDevice> = emptyList(),
)

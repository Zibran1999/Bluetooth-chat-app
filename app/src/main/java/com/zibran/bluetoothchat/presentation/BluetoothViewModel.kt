package com.zibran.bluetoothchat.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zibran.bluetoothchat.domain.chat.BluetoothDeviceController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BluetoothViewModel @Inject constructor(
    private val bluetoothController: BluetoothDeviceController,
) : ViewModel() {
    private val _state = MutableStateFlow(BluetoothUiState())
    val state = combine(
        bluetoothController.scannedDevices,
        bluetoothController.pairedDevices,
        _state
    ) { scannedDevices, pairedDevices, state ->
        state.copy(scannedDevices = scannedDevices,pairedDevices= pairedDevices)

    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),_state.value)

    fun statScan(){
        bluetoothController.startDiscovery()
    }
    fun stopScan(){
        bluetoothController.stopDiscovery()
    }

}
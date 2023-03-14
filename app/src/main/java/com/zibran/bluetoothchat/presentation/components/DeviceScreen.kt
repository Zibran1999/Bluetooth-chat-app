package com.zibran.bluetoothchat.presentation.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zibran.bluetoothchat.domain.chat.BluetoothDevice
import com.zibran.bluetoothchat.presentation.BluetoothUiState

@Composable
fun DeviceScreen(
    state: BluetoothUiState,
    onStartScan: () -> Unit,
    onStopScan: () -> Unit,
) {


    Column(modifier = Modifier.fillMaxSize()) {
        BluetoothDeviceList(
            scannedDevices = state.scannedDevices,
            pairedDevices = state.pairedDevices,
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { onStartScan() }) {
                Text(text = "Start Scan")
            }
            Button(onClick = { onStopScan() }) {
                Text(text = "Stop Scan")
            }
        }

    }

}

@Composable
fun BluetoothDeviceList(
    scannedDevices: List<BluetoothDevice>,
    pairedDevices: List<BluetoothDevice>,
    onClick: (BluetoothDevice) -> Unit,
    modifier: Modifier = Modifier,
) {

//    Log.d("ScannedDevice", scannedDevices[0].name.toString())
//    Log.d("PairedDevice", pairedDevices[0].name.toString())

    LazyColumn(modifier = modifier) {
        item {
            Text(
                text = "Paired Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(pairedDevices) { pairedDevice ->
            Text(
                text = pairedDevice.name ?: "(No name)",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable { onClick(pairedDevice) }
            )
        }

        item {
            Text(
                text = "Scanned Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(scannedDevices) { scannedDevice ->
            Text(
                text = scannedDevice.name ?: "(No name)",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable { onClick(scannedDevice) }
            )
        }
    }

}
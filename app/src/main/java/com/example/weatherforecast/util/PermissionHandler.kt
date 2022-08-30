package com.example.weatherforecast.util

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.permissionHandler(
    permission: Array<String>,
    granted: () -> Unit,
    notGranted: () -> Unit
) {
    val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        for (i in it) {
            if (!i.value) notGranted()
        }
        granted()
    }
    activityResultLauncher.launch(
        permission
    )
}
package com.problemsolver.myorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.problemsolver.MyOrderApp
import com.problemsolver.myorder.app.presentation.CustomerOrderCheckDetail.CustomerOCDScreen
import com.problemsolver.myorder.app.presentation.StoreDetail.StoreDetailScreen
import com.problemsolver.myorder.ui.theme.MyOrderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyOrderApp() }
    }
}
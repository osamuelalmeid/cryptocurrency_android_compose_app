package com.samuelalmeida.cryptocurrencyandroidcompose.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.samuelalmeida.cryptocurrencyandroidcompose.presentation.theme.CryptocurrencyComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyComposeTheme() {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}
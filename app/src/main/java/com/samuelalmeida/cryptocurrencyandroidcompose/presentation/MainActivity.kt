package com.samuelalmeida.cryptocurrencyandroidcompose.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samuelalmeida.cryptocurrencyandroidcompose.presentation.coin_detail.CoinDetailScreen
import com.samuelalmeida.cryptocurrencyandroidcompose.presentation.coin_list.CoinListScreen
import com.samuelalmeida.cryptocurrencyandroidcompose.presentation.theme.CryptocurrencyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyComposeTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coindId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
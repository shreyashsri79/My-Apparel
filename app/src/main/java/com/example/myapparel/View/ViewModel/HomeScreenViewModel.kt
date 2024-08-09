package com.example.myapparel.View.ViewModel

import androidx.lifecycle.ViewModel
import com.example.myapparel.View.UiState.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeScreenViewModel : ViewModel() {

    private val _homeScreenUiState = MutableStateFlow(HomeScreenUiState())
    val homeScreenUiState: StateFlow<HomeScreenUiState> = _homeScreenUiState.asStateFlow()

    fun openBrowserCard(){
        _homeScreenUiState.update { currentState->
            currentState.copy(isBrowseCardOpen = true)
        }
    }

    fun closeBrowserCard(){
        _homeScreenUiState.update { currentState->
            currentState.copy(isBrowseCardOpen = false)
        }
    }


}
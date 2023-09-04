package com.example.myloginmvvm.remote.repository

import androidx.navigation.NavDirections

/**
 * State object used by view model to notify view.
 */
sealed class NavState {
    object Loading : NavState()
    class Success(val direction: NavDirections? = null) : NavState()
    class Failed(val error: Error? = null, val message: String? = null) : NavState()
}

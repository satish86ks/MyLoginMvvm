package com.example.myloginmvvm.extension

import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.ViewModel
import com.example.myloginmvvm.R


/**
 * Hilt extension helper for creating view models.
 */
inline fun <reified T : ViewModel> Fragment.hiltMainNavGraphViewModels() =
    hiltNavGraphViewModels<T>(R.id.nav_graph)

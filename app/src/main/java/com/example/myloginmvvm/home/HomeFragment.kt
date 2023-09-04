package com.example.myloginmvvm.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myloginmvvm.adapter.ListViewAdapter
import com.example.myloginmvvm.databinding.FragmentFirstBinding
import com.example.myloginmvvm.extension.hiltMainNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by hiltMainNavGraphViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        viewModel.getLoginUserDetails()

        viewModel.user.observe(viewLifecycleOwner){

            var listItem=it.data
            val recyclerview= binding.recyclerview
            recyclerview.layoutManager = LinearLayoutManager(context)
            val adapter = ListViewAdapter(listItem)
            recyclerview.adapter = adapter

        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
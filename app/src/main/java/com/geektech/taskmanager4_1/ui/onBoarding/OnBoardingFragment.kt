package com.geektech.taskmanager4_1.ui.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.taskmanager4_1.data.local.infor
import com.geektech.taskmanager4_1.databinding.FragmentOnBoardingBinding
import com.geektech.taskmanager4_1.ui.onBoarding.adapter.OnBoardingAdapter


class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var infor: infor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        infor = infor (requireContext())

        val onBoardAdapter = OnBoardingAdapter{
            infor.saveShowBoarding(true)
            findNavController().navigateUp()
        }

        binding.viewPager.adapter = onBoardAdapter

        binding.indicator.setViewPager(binding.viewPager)

    }

}
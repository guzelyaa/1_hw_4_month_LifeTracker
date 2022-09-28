package com.example.a1hw4monthlifetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a1hw4monthlifetracker.databinding.FragmentBoardBinding

class BoardFragment : Fragment(), ItemOnClickListener {

    private lateinit var binding: FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).hideToolBar()
        val list= ArrayList<BoardModel>()
        list.add(BoardModel(R.drawable.board_first, "Экономь время", "Дальше"))
        list.add(BoardModel(R.drawable.board_second, "Достигай целей", "Дальше"))
        list.add(BoardModel(R.drawable.board_third, "Развивайся", "Начинаем"))
        val boardAdapter = BoardAdapter(list, this)
        binding.viewPager.adapter = boardAdapter
        binding.dotsIndicator.attachTo(binding.viewPager)
    }

    override fun itemClick() {
        findNavController().navigate(R.id.action_boardFragment_to_homeFragment2)
    }

    override fun btnClick1page() {
        binding.viewPager.setCurrentItem(1)
    }

    override fun btnClick2page() {
        binding.viewPager.setCurrentItem(2)
    }
}
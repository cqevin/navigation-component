package com.chriskevin.learnnavcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.chriskevin.learnnavcomponent.databinding.FragmentEndBinding

/**
 * A simple [Fragment] subclass.
 */
class EndFragment : Fragment() {

    val args by navArgs<EndFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentEndBinding.inflate(inflater, container, false)
        binding.learn = this
        return binding.root
    }

    fun navigate() {
        findNavController().navigate(EndFragmentDirections.actionEndFragmentToStartFragment())
    }
}

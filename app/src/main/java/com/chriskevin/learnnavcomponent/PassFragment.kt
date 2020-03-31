package com.chriskevin.learnnavcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.chriskevin.learnnavcomponent.databinding.FragmentPassBinding

/**
 * A simple [Fragment] subclass.
 */
class PassFragment : Fragment() {
    private var _binding: FragmentPassBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pass.setOnClickListener { v ->
            val data = binding.data.text.toString()
            v.findNavController().navigate(PassFragmentDirections.actionPassFragmentToEndFragment(data))
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}
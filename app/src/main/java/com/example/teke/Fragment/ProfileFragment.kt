package com.example.teke.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teke.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    lateinit var sp: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    val PREF_DATA = "user_room"

    @SuppressLint("CommitPrefEdits")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        sp = this.requireActivity()
            .getSharedPreferences(PREF_DATA, Context.MODE_PRIVATE)
        editor = sp.edit()

        sp = requireActivity().getPreferences(0)
        sp.getString("name", binding.profileName.toString())!!
        sp.getString("email", binding.profileEmail.toString())!!
        sp.getString("address", binding.profileAddress.toString())!!

//        binding.profileName.text = name
//        binding.profileEmail.text = email
//        binding.profileAddress.text = address

        return binding.root

    }
}
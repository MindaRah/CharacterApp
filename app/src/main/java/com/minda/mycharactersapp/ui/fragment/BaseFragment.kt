package com.minda.mycharactersapp.ui.fragment

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.minda.mycharactersapp.ui.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment: Fragment() {
    protected val characterViewModel by lazy {
        ViewModelProvider(requireActivity())[CharacterViewModel::class.java]
    }
    protected fun showError(message:String,action:()->Unit){
        AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage(message)
            .setNegativeButton("Dismiss"){dialog, _->dialog.dismiss()}
            .setPositiveButton("Retry"){_,_-> action.invoke()}
    }
}
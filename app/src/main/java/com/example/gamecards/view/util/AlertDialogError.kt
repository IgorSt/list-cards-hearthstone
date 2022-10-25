package com.example.gamecards.view.util

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.gamecards.R

/**
 * Igor Santos
 * 25/10/2022
 */

class AlertDialogError : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val build = AlertDialog.Builder(requireContext())
            build.setMessage(R.string.error_network)
                .setPositiveButton(R.string.back, DialogInterface.OnClickListener { _, _ ->
                    requireActivity().onBackPressed()
                }).show()
            build.create()
        } ?: throw IllegalStateException("Activity cannot br null")
    }
}
package com.github.frosthard.beforenightfalls


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.frosthard.beforenightfalls.databinding.FragmentEndingDisplayBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class EndingDisplay : Fragment() {

    val currentEnding: MyApplication.Scene = MyApplication.currentDisplayedEnding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Timber.d(MyApplication.ON_ATTACH_CALLED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d(MyApplication.ON_CREATE_CALLED)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingDisplayBinding>(inflater,
            R.layout.fragment_ending_display, container, false)

        binding.endingDisplay = this

        Timber.d(MyApplication.ON_CREATE_VIEW_CALLED)

        return binding.root
    }
}

package com.github.frosthard.beforenightfalls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.frosthard.beforenightfalls.databinding.FragmentGameBinding
import com.github.frosthard.beforenightfalls.MyApplication.Scene
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    // Variables
    private val scenes = MyApplication.scenes
    lateinit var currentScene: Scene
    private var selectedActionId: Int = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false
        )

        // This is IMPORTANT! without this, "@{}" things in [fragment_game.sml] won't work.
        currentScene = scenes[0]

        // Bind this fragment class to the layout
        binding.viewModel = this

        // Listener for action button
        binding.actionButton.setOnClickListener {

            if (binding.actions.checkedRadioButtonId != -1) {

                when (binding.actions.checkedRadioButtonId) {
                    binding.actionOne.id -> selectedActionId = 0
                    binding.actionTwo.id -> selectedActionId = 1

                }

                when (currentScene) {
                    scenes[0] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[1]
                            1 -> currentScene = scenes[14]
                        }
                    }
                    scenes[1] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[2]
                            1 -> currentScene = scenes[13]
                        }
                    }
                    scenes[2] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[3]
                            1 -> currentScene = scenes[12]
                        }
                    }
                    scenes[3] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[4]
                            1 -> currentScene = scenes[9]
                        }
                    }
                    scenes[4] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[5]
                            1 -> currentScene = scenes[6]
                        }
                    }
                    scenes[5] -> {
                        MyApplication.badEnding1 = true
                        ending()
                    }
                    scenes[6] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[7]
                            1 -> currentScene = scenes [8]
                        }
                    }
                    scenes[7] -> {
                        MyApplication.badEnding2 = true
                        ending()
                    }
                    scenes[8] -> {
                        MyApplication.normalEnding = true
                        ending()
                    }

                    scenes[9] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[10]
                            1 -> currentScene = scenes [11]
                        }
                    }

                    scenes[10] -> {
                        MyApplication.badEnding3 = true
                        ending()
                    }

                    scenes[11] -> {
                        MyApplication.goodEnding = true
                        ending()
                    }

                    scenes[12] -> {
                        MyApplication.badEnding4 = true
                        ending()
                    }

                    scenes[13] -> {
                        MyApplication.badEnding5 = true
                        ending()
                    }
                }

                // Disabling options if choice == "" and enabling them if not
                if (currentScene.actions[0] == "") binding.actionOne.isEnabled = false else binding.actionOne.isEnabled = true
                if (currentScene.actions[1] == "") binding.actionTwo.isEnabled = false else binding.actionTwo.isEnabled = true


                binding.actions.clearCheck()
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.invalidateAll()
            } else {
                Toast.makeText(this.activity, "Select one of the actions to continue!", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private fun ending() {

        when(selectedActionId) {
            0 -> this.activity!!.onBackPressed()
            1 -> currentScene = scenes[0]
        }
    }

}
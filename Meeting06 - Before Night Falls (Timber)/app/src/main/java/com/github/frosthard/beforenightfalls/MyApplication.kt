package com.github.frosthard.beforenightfalls

import android.app.Application
import timber.log.Timber

class MyApplication: Application() {

    data class Scene(
        val body: String,
        val actions: List<String>
    )

    companion object {
        // Constants
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"


        // Scenes
        val scenes: List<Scene> = listOf (
            // 0
            Scene (
                "You woke up in a Minecraft world! You have nothing in your inventory. You can choose to start gathering resources, " +
                        "or maybe you could test your luck and find a village to jumpstart your survival?",
                listOf("Start gathering wood", "Wander off and find a village")),

            // 1
            Scene (
                "You got several wood! You craft a Wooden Sword, a Wooden Axe, and a Wooden Pickaxe. " +
                        "Ready to find some cobblestones! But there's no stone in sight. " +
                        "You see a beach nearby, or you could just dig straight down to get them! What do you do?",
                actions = listOf("Go to the beach" ,"Dig straight down")),
            // 2
            Scene (
                "You went to the beach! But it seems pretty long. You could dig through to the left, " +
                        "or through to the right",
                actions = listOf("Dig through to the left" ,"Dig through to the right")),

            // 3
            Scene (
                "You dug through the left. You found some cobblestone. And even some iron on the way. You start making a furnace, " +
                        "smelt the iron, and make an Iron Pickaxe. You ran back to the surface, and the sun is still shining bright. " +
                        "You feel that you have more time to ready things. You walk around for a while, and you found a cave. " +
                        "This could be an opportunity to get more ores! Or die. Nearby is a birch forest, perhaps you could find a sheep to make bed." +
                        "But if you don't find anything you're going to waste so much time exploring." +
                        "What do you do?",
                actions = listOf ("Delve into the cave", "Explore the forest")),

            // 4
            Scene (
                "The cave was enormous. You found a fork in the road. Do you go left, or right?",
                actions = listOf ("Go left", "Go right")),

            // 5 BAD ENDING Rushed
            Scene (
                "You went left, but you found 2 creepers on surprise, and a skeleton started shooting you." +
                        "Without adequate equipment, you couldn't survive the mobs, and you died." +
                        "BAD Ending: Chose the wrong path",
                actions = listOf(TRY_AGAIN, MAIN_MENU)),

            // 6
            Scene (
                "You went right, and found enough iron to make an Iron Sword and a Chestplate. " +
                        "You feel now you're strong enough fight the night. You can delve deeper, " +
                        "or start making a house up in the surface.",
                actions = listOf("You go deeper", "You refuse to go deeper and play it safe.")),

            // 7
            Scene (
                "You went deeper, and even found some Diamonds! But underneath the stone your" +
                        "standing on is lava, and you fell into it. You got up but you still died with your body" +
                        "burned to crisp." +
                        "BAD Ending: Diamonds on Fire",
                actions = listOf(TRY_AGAIN, MAIN_MENU)),

            // 8
            Scene (
                "You didn't go deeper. You went back and you see the night has fell. " +
                        "You couldn't find a bed yet, but you're well equipped so you survived the night later." +
                        "NORMAL Ending: Take Back the Night",
                actions = listOf(TRY_AGAIN, MAIN_MENU)),

            // 9
            Scene (
                "You explored the forest. For minutes you couldn't find any sheep, and you know night is falling soon. You could probably go back to the cave, or just keep finding a sheep.",
                actions = listOf ("Back to the cave", "Keep finding the sheep")),

            // 10
            Scene (
                "You almost reached the cave, but night fell too soon and you found too many " +
                        "mobs without having any equipment. You died without preparations." +
                        "BAD Ending: Back and forth",
                actions = listOf (TRY_AGAIN, MAIN_MENU)),

            // 11 Good end
            Scene (
                "You persevere in finding a sheep, and you are rewarded for your patience! You found several and you quickly get their wool." +
                        "You crafted a bed, and you found the one object in the game that literally skips over the whole night. Game is over, you won." +
                        "GOOD Ending: Found a time-travel device",
                actions = listOf (TRY_AGAIN, MAIN_MENU)),

            // 12
            Scene (
                "You dig through the right, and you found a treasure chest! It got some Iron Ingots, and a Heart of the Sea. Not " +
                        "sure what you could do with it yet though." +
                        "But you turn around and total shock fills your body, as a creeper exploded in your face and you died." +
                        "BAD Ending: Creeper? Aww man.",
                actions = listOf (TRY_AGAIN, MAIN_MENU)),

            // 13
            Scene (
                "You just dig straight down! Not long after though, you fell into a pool of lava. " +
                        "You broke the number one rule in Minecraft; never dig straight down." +
                        "BAD Ending: Under the floor, is lava",
                actions = listOf(TRY_AGAIN, MAIN_MENU)),

            // 14
            Scene (
                "You went to find a village because mining is for noobs. You found a Pillager's Fort instead, and you got slayed by hundreds of crossbow bolts." +
                        "BAD Ending: Bad Omen",
                actions = listOf(TRY_AGAIN, MAIN_MENU))
            )

        // Ending flags
        var badEnding1 = false
        var badEnding2 = false
        var badEnding3 = false
        var badEnding4 = false
        var badEnding5 = false
        var badEnding6 = false
        var normalEnding = false
        var goodEnding = false

        // Utils
        lateinit var currentDisplayedEnding: Scene
    }

        var LOG_PREFIX = "[TIMBER LOGGING] -------------> "


        var ON_CREATE_CALLED = LOG_PREFIX + "onCreate() Called!"
        var ON_START_CALLED = LOG_PREFIX + "onStart() Called!"
        var ON_RESUME_CALLED = LOG_PREFIX + "onResume() Called!"
        var ON_PAUSE_CALLED = LOG_PREFIX + "onPause() Called!"
        var ON_STOP_CALLED = LOG_PREFIX + "onStop() Called!"
        var ON_DESTROY_CALLED = LOG_PREFIX + "onDestroy() Called!"
        var ON_RESTART_CALLED = LOG_PREFIX + "onRestart() Called!"
        var ON_ATTACH_CALLED = LOG_PREFIX + "onAttach() Called!"
        var ON_DETACH_CALLED = LOG_PREFIX + "onDetach() Called!"
        var ON_CREATE_VIEW_CALLED = LOG_PREFIX + "onCreateView() Called!"
        var ON_DESTROY_VIEW_CALLED = LOG_PREFIX + "onDestroyView() Called!"
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
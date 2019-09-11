package com.github.frosthard

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.github.frosthard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private val loremIpsum: MyData = MyData(
        "Lorem Ipsum",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis auctor elit sed vulputate mi sit. Leo urna molestie at elementum eu facilisis sed. Natoque penatibus et magnis dis parturient montes nascetur ridiculus mus. Vitae elementum curabitur vitae nunc sed velit. Egestas diam in arcu cursus euismod quis viverra nibh cras. Morbi tristique senectus et netus et malesuada. Diam maecenas ultricies mi eget mauris pharetra et ultrices. Mus mauris vitae ultricies leo integer malesuada nunc vel. Mattis nunc sed blandit libero volutpat. Lobortis feugiat vivamus at augue eget. Lacinia at quis risus sed vulputate odio. Bibendum est ultricies integer quis auctor elit. Molestie nunc non blandit massa enim nec dui.\n" +
                "Amet consectetur adipiscing elit duis tristique sollicitudin nibh. Lorem sed risus ultricies tristique nulla aliquet enim. Faucibus pulvinar elementum integer enim neque. Nullam non nisi est sit amet facilisis magna etiam tempor. Eget mauris pharetra et ultrices neque ornare. Gravida neque convallis a cras semper. Commodo elit at imperdiet dui accumsan sit. Scelerisque fermentum dui faucibus in ornare quam viverra. Sed turpis tincidunt id aliquet risus feugiat in ante. Vulputate sapien nec sagittis aliquam malesuada bibendum. Aenean sed adipiscing diam donec adipiscing tristique risus. Rhoncus urna neque viverra justo nec ultrices dui sapien. Elementum eu facilisis sed odio morbi quis commodo. Odio tempor orci dapibus ultrices in iaculis nunc sed. Lacus vestibulum sed arcu non odio euismod lacinia at quis. Sed turpis tincidunt id aliquet risus feugiat in. Amet nisl purus in mollis nunc sed id semper. Morbi blandit cursus risus at ultrices mi tempus imperdiet. Eu augue ut lectus arcu bibendum at varius vel pharetra."
    )

    private val spaceIpsum: MyData = MyData(
        "Space Ipsum",
        "For those who have seen the Earth from space, and for the hundreds and perhaps thousands more who will, the experience most certainly changes your perspective. The things that we share in our world are far more valuable than those which divide us.\n" +
                "It suddenly struck me that that tiny pea, pretty and blue, was the Earth. I put up my thumb and shut one eye, and my thumb blotted out the planet Earth. I didn’t feel like a giant. I felt very, very small.\n" +
                "Science has not yet mastered prophecy. We predict too much for the next year and yet far too little for the next 10.\n" + "" +
                "We choose to go to the moon in this decade and do the other things, not because they are easy, but because they are hard, because that goal will serve to organize and measure the best of our energies and skills, because that challenge is one that we are willing to accept, one we are unwilling to postpone, and one which we intend to win.\n" +
                "There can be no thought of finishing for ‘aiming for the stars.’ Both figuratively and literally, it is a task to occupy the generations. And no matter how much progress one makes, there is always the thrill of just beginning."
    )

    private val corporateIpsum: MyData = MyData(
        "Corporate Ipsum",
        "Leverage agile frameworks to provide a robust synopsis for high level overviews. Iterative approaches to corporate strategy foster collaborative thinking to further the overall value proposition. Organically grow the holistic world view of disruptive innovation via workplace diversity and empowerment.\n" +
                "Bring to the table win-win survival strategies to ensure proactive domination. At the end of the day, going forward, a new normal that has evolved from generation X is on the runway heading towards a streamlined cloud solution. User generated content in real-time will have multiple touchpoints for offshoring.\n" + "" +
                "Capitalize on low hanging fruit to identify a ballpark value added activity to beta test. Override the digital divide with additional clickthroughs from DevOps. Nanotechnology immersion along the information highway will close the loop on focusing solely on the bottom line."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loremIpsum = loremIpsum
        binding.spaceIpsum = spaceIpsum
        binding.corporateIpsum = corporateIpsum

        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.listOfLorems,
            android.R.layout.simple_spinner_dropdown_item
        )
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.loremSpinner.adapter = adapter1
        binding.loremSpinner.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val currentType: String = binding.loremSpinner.getItemAtPosition(position).toString()
        when (currentType) {
            "Lorem Ipsum" -> {
                binding.creatorText.text = binding.loremIpsum?.type
                binding.loremText.text = binding.loremIpsum?.ipsum
            }
            "Space Ipsum" -> {
                binding.creatorText.text = binding.spaceIpsum?.type
                binding.loremText.text = binding.spaceIpsum?.ipsum
            }
            "Corporate Ipsum" -> {
                binding.creatorText.text = binding.corporateIpsum?.type
                binding.loremText.text = binding.corporateIpsum?.ipsum
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}
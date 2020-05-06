package com.salvarez.companiessurveys.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.salvarez.companiessurveys.R
import kotlinx.android.synthetic.main.fragment_screen_slide_page.*

private const val ARG_COUNT = "argcount"

class ScreenSlidePagerFragment : Fragment() {

    private var position: Int = 0
    private var imagesArray = arrayOf(
        R.drawable.slide2,
        R.drawable.slide1
    )


    companion object{

        fun newInstance(position: Int): ScreenSlidePagerFragment {
            var screenSlideFragment =
                ScreenSlidePagerFragment()
            var arguments: Bundle = Bundle()
            arguments.putInt(ARG_COUNT, position)
            screenSlideFragment.arguments = arguments
            return  screenSlideFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        position = arguments?.getInt(ARG_COUNT)!!

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewSlides.setImageResource(imagesArray[position])
    }
}
package com.bignerdranch.android.criminalintent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

class zoominfragment: DialogFragment(){
    companion object {
        const val TAG = "zoominfragment"
        private const val ARG_IMAGE_RESOURCE = "imageResource"

        fun newInstance(imageResource: Int): zoominfragment {
            val fragment = zoominfragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_RESOURCE, imageResource)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_zoomed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val imageResource = it.getInt(ARG_IMAGE_RESOURCE)
            view.findViewById<ImageView>(R.id.imageViewZoomedIn).setImageResource(imageResource)
        }
    }
}
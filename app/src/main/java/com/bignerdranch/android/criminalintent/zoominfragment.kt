package com.bignerdranch.android.criminalintent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

class ImageFragment : DialogFragment() {



    companion object {
        const val TAG = "ImageDialogFragment"
        fun newInstance(photoFileName: String?): ImageFragment {
            val frag = ImageFragment()
            val args = Bundle()
            args.putSerializable("IMAGE_PATH", photoFileName)
            frag.arguments = args
            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_zoomed, container, false)
        val image = view.findViewById(R.id.imageViewZoomedIn) as ImageView
        val fileName = arguments?.getSerializable("IMAGE_PATH") as String

        image.setImageBitmap(BitmapFactory.decodeFile(requireContext().filesDir.path + "/" + fileName))

        return view


    }
}
package com.geektech.taskmanager4_1.ui.profile

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.geektech.taskmanager4_1.data.local.infor
import com.geektech.taskmanager4_1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var infor: infor

    private val getContent: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.GetContent()) { imageUri: Uri? ->
//            binding.ivPicture.setImageURI(imageUri)

            Glide.with(this).load(imageUri.toString()).into(binding.ivPicture)
            infor.saveImage(imageUri.toString())
        }

    companion object {
        private const val CONTENT_TYPE = "image/*"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        infor = infor(requireContext())

        checkChanges()
        saveChanges()

        binding.ivPicture.setOnClickListener {
            getContent.launch(CONTENT_TYPE)
        }
    }

    private fun checkChanges() {
        if (infor.getTitle() != ""){
            binding.etTitleHint.hint = infor.getTitle()
        }

        if (infor.getDescription() != ""){
            binding.etDescriptionHint.hint = infor.getDescription()
        }

        if (infor.getAge() != ""){
            binding.etAgeHint.hint = infor.getAge()
        }

        if (infor.getImage() != ""){
            Glide.with(this).load(infor.getImage()).into(binding.ivPicture)
        }
    }

    private fun saveChanges() {
        binding.etTitle.addTextChangedListener{
            infor.saveTitle(binding.etTitle.text.toString())
        }

        binding.etDescription.addTextChangedListener{
            infor.saveDescription(binding.etDescription.text.toString())
        }

        binding.etAge.addTextChangedListener{
            infor.saveAge(binding.etAge.text.toString())
        }
    }
}
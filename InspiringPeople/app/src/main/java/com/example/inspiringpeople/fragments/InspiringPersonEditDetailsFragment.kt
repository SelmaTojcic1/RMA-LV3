package com.example.inspiringpeople.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.inspiringpeople.database.InspiringPeopleDatabaseBuilder
import com.example.inspiringpeople.database.InspiringPeopleRepository
import com.example.inspiringpeople.database.InspiringPersonDao
import com.example.inspiringpeople.databinding.FragmentInspiringPersonEditDetailsBinding
import com.example.inspiringpeople.model.InspiringPerson

class InspiringPersonEditDetailsFragment : Fragment() {

    lateinit var inspiringPersonEditDetailsBinding: FragmentInspiringPersonEditDetailsBinding
    private val inspiringPeopleRepository: InspiringPersonDao by lazy {
        InspiringPeopleDatabaseBuilder.getInstance().inspiringPersonDao()
    }

    companion object{
        const val TAG = "EditDetails"
        private const val KEY = "InspiringPerson"

        fun create(inspiringPerson: InspiringPerson): InspiringPersonEditDetailsFragment {
            val args = Bundle()
            args.putSerializable(KEY, inspiringPerson)
            val fragment = InspiringPersonEditDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        inspiringPersonEditDetailsBinding = FragmentInspiringPersonEditDetailsBinding.inflate(
                inflater,
                container,
                false
        )

        inspiringPersonEditDetailsBinding.btnSaveChanges.setOnClickListener { saveChanges() }

        return inspiringPersonEditDetailsBinding.root
    }

    private fun saveChanges() {
        arguments?.let {
            val inspiringPerson = it.getSerializable(KEY) as InspiringPerson

            val name = inspiringPersonEditDetailsBinding
                    .etEditInspiringPersonNameInput.text.toString()
            val date = inspiringPersonEditDetailsBinding
                    .etEditInspiringPersonDateInput.text.toString()
            val details = inspiringPersonEditDetailsBinding
                    .etEditInspiringPersonDetailsInput.text.toString()
            val imageUrl = inspiringPersonEditDetailsBinding
                    .etEditInspiringPersonUrlInput.text.toString()
            val firstQuote = inspiringPersonEditDetailsBinding
                    .etEditInspiringPersonFirstQuoteInput.text.toString()
            val secondQuote = inspiringPersonEditDetailsBinding
                    .etEditInspiringPersonSecondQuoteInput.text.toString()

            if (name != "") inspiringPeopleRepository.changeName(inspiringPerson, name)
            if (date != "") inspiringPeopleRepository.changeDate(inspiringPerson, date)
            if (details != "") inspiringPeopleRepository.changeDetails(inspiringPerson, details)
            if (imageUrl != "") inspiringPeopleRepository.changeImageUrl(inspiringPerson, imageUrl)
            if (firstQuote != "") {
                inspiringPerson.quotesList.add(firstQuote)
            }
            if (secondQuote != "") {
                inspiringPerson.quotesList.add(secondQuote)
            }
        }
        fragmentManager?.popBackStack()
    }
}


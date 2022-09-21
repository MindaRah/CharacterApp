package com.minda.mycharactersapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minda.mycharactersapp.R
import com.minda.mycharactersapp.databinding.CharacterRowViewBinding
import com.minda.mycharactersapp.model.Result
import com.squareup.picasso.Picasso


    class CharacterAdapter(private val characterList: MutableList<Result> = mutableListOf()): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setCharacter(character: MutableList<Result>){
        characterList.clear()
        characterList.addAll(character)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            CharacterRowViewBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
       return characterList.size
    }

    class CharacterViewHolder(private val bindings: CharacterRowViewBinding): RecyclerView.ViewHolder(bindings.root){
        fun bind(characters: Result){
            bindings.nametxt.text = characters.name
            bindings.gendertxt.text = characters.gender
            bindings.speciestxt.text = characters.species
            bindings.statustxt.text = characters.status
            Picasso.get()
                .load(characters.image)
                .placeholder(R.mipmap.ic_launcher)
                .into(bindings.albumimage)
        }
    }
}

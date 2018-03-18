package com.rifqimfahmi.livedataexample.ui.home.adapter

import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rifqimfahmi.livedataexample.R
import com.rifqimfahmi.livedataexample.ui.home.ActionListenerList
import com.rifqimfahmi.livedataexample.ui.home.model.Dog
import io.realm.RealmChangeListener
import io.realm.RealmResults
import kotlinx.android.synthetic.main.dog_layout.view.*

/*
 * Created by Rifqi Mulya Fahmi on 16/03/18.
 */

class DogAdapter(listener: ActionListenerList) : RecyclerView.Adapter<DogVH>() {

    val mListener = listener

    var mDogs: RealmResults<Dog>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DogVH {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.dog_layout, parent, false)
        return DogVH(view)
    }

    override fun getItemCount(): Int {
        return mDogs?.size ?: 0
    }

    override fun onBindViewHolder(holder: DogVH?, position: Int) {
        holder?.let {
            holder.bind(mDogs?.get(position), mListener)
        } ?: run {

        }
    }

    fun initListener() {
        mDogs?.addChangeListener(RealmChangeListener {
            Log.d("DELETED", "DATA DELETED")
            notifyDataSetChanged()
        })
    }
}

class DogVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(dog: Dog?, mListener: ActionListenerList) {
        itemView.apply {
            tv_name.text = dog?.name ?: "Unknown"
            tv_breed.text = dog?.breed ?: "Unknown"
            tv_gender.text = dog?.gender.toString()
        }

        itemView.setOnLongClickListener {
            val dialogConfirmation = AlertDialog.Builder(it.context)
            dialogConfirmation.setMessage("Are u sure want to delete this item.. (${dog?.name}, ${dog?.breed}, ${dog?.gender})")
            dialogConfirmation.setPositiveButton("YES", { dialogInterface: DialogInterface, i: Int ->
                mListener.deleteDog(dog!!)
            })
            dialogConfirmation.setCancelable(true)
            dialogConfirmation.show()
            true
        }
    }
}
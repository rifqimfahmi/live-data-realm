package com.rifqimfahmi.livedataexample.ui.home.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rifqimfahmi.livedataexample.R
import com.rifqimfahmi.livedataexample.ui.home.ActionListenerList
import com.rifqimfahmi.livedataexample.ui.home.adapter.DogAdapter
import com.rifqimfahmi.livedataexample.ui.home.model.Dog
import io.realm.Realm
import kotlinx.android.synthetic.main.rv_fragment.*

/*
 * Created by Rifqi Mulya Fahmi on 16/03/18.
 */

class NewDog : Fragment(), ActionListenerList {


    override fun deleteDog(dog: Dog) {
        var realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            dog.deleteFromRealm()
        }
        Toast.makeText(context, "${mDogAdapter.mDogs?.size} ", Toast.LENGTH_LONG).show()
    }

    val mDogAdapter = DogAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.rv_fragment, container, false)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_live_data.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = mDogAdapter
        }

        var realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            var datas= it.where(Dog::class.java).findAll()
            mDogAdapter.mDogs = datas
        }
        mDogAdapter.initListener()
    }
}
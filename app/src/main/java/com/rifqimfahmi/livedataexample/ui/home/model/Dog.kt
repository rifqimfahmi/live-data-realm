package com.rifqimfahmi.livedataexample.ui.home.model

import io.realm.RealmObject

/*
 * Created by Rifqi Mulya Fahmi on 16/03/18.
 */

open class Dog(
        var name: String = "",
        var gender: Int = 2,
        var breed : String? = null
) : RealmObject() {
}
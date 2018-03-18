package com.rifqimfahmi.livedataexample.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.rifqimfahmi.livedataexample.R
import com.rifqimfahmi.livedataexample.ui.home.fragments.NewDog
import com.rifqimfahmi.livedataexample.ui.home.fragments.PopularDog
import com.rifqimfahmi.livedataexample.ui.home.model.Dog
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var mDogs: ArrayList<Dog> = arrayListOf(
            Dog("Tino", 1, "Husky"),
            Dog("Tina", 0, "Akita"),
            Dog("Lele", 0, "Affenspincher"),
            Dog("Polito", 1, "Pollar")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        vp_home.adapter = PagerAdapter(supportFragmentManager)
        tl_pager.setupWithViewPager(vp_home)

        initDummyRealmData()
    }

    private fun initDummyRealmData() {
        var mrealm = Realm.getDefaultInstance()
        mrealm.executeTransaction {
            it.deleteAll()
            mrealm.insertOrUpdate(mDogs)
        }
        mrealm.close()
    }
}

interface ActionListenerList {
    fun deleteDog(dog: Dog)
}

class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return PopularDog()
            }
            1 -> {
                return NewDog()
            }
        }

        throw IndexOutOfBoundsException("Fragment cannot be more than 2")
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "popular"
            }
            1 -> {
                return "new"
            }
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

}

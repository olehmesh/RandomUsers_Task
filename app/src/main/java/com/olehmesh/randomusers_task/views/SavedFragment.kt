package com.olehmesh.randomusers_task.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.adapters.SavedAdapter
import com.olehmesh.randomusers_task.database.DatabaseManager
import com.olehmesh.randomusers_task.database.entity.UserInfo
import kotlinx.android.synthetic.main.fragment_saved.*

class SavedFragment : Fragment(), SavedAdapter.OnDeleteListener {

    private var databaseManager: DatabaseManager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        databaseManager = DatabaseManager.getDatabase(context)

        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerViewSaved.layoutManager = LinearLayoutManager(context)

    }

    override fun onResume() {
        super.onResume()

        // val entityLiveData: LiveData<MutableList<EntityData>> = databaseManager?.daoMethods()!!.all
//entityLiveData.observeForever(Observer {  })

        /*    val res = databaseManager?.daoMethods()?.all
             ?.subscribeOn(Schedulers.io())
             ?.observeOn(AndroidSchedulers.mainThread())
             ?.subscribe {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }


         val recyclerAdapter = SavedAdapter(res)*/

        val recyclerAdapter =
            SavedAdapter(databaseManager?.daoUserInfo()?.all as MutableList<UserInfo>)
        recyclerAdapter.setOnDeleteListener(this)
        recyclerViewSaved.adapter = recyclerAdapter

    }

    override fun onDelete(entityDatabase: UserInfo) {
        databaseManager?.daoUserInfo()?.delete(entityDatabase)
    }

}
package com.openclassrooms.magicgithub.ui.user_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ActivityListUserBinding
import com.openclassrooms.magicgithub.di.Injection.getRepository
import com.openclassrooms.magicgithub.model.User

class ListUserActivity : AppCompatActivity(), UserListAdapter.Listener {
    // FOR DESIGN --- Replaced by ViewBinding
    /*
    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton
    */
    private lateinit var binding:ActivityListUserBinding
    // FOR DATA ---
    private lateinit var adapter: UserListAdapter

    // OVERRIDE ---
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_list_user)
        binding= ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureFab()
        configureRecyclerView()
        setupItemTouchHelper()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    // CONFIGURATION ---
    private fun configureRecyclerView() {
        //recyclerView = findViewById(R.id.activity_list_user_rv)
        adapter = UserListAdapter(this)
        binding.activityListUserRv.adapter = adapter

    }

    private fun configureFab() {
        //fab = findViewById(R.id.activity_list_user_fab)
        binding.activityListUserFab.setOnClickListener(View.OnClickListener { view: View? ->
            getRepository().addRandomUser()
            loadData()
        })
    }

    private fun loadData() {
        val updateUsers = getRepository().getUsers()
        adapter.updateList(updateUsers)
    }

    // ACTIONS ---
    override fun onClickDelete(user: User) {
        Log.d(ListUserActivity::class.java.name, "User tries to delete a item.")
        getRepository().deleteUser(user)
        loadData()
    }

    private fun setupItemTouchHelper() {
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.DOWN or ItemTouchHelper.UP,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val startPosition = viewHolder.bindingAdapterPosition
                val endPosition = target.bindingAdapterPosition
                // Swap items in adapter
                getRepository().swapUsers(startPosition, endPosition)
                loadData()
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // Simply refresh item to reset its position (no action)
                val position = viewHolder.bindingAdapterPosition
                val user = adapter.getItem(position)

                getRepository().setActiveInactive(user)
                loadData()
                //adapter.notifyItemChanged(viewHolder.bindingAdapterPosition)
            }

            //Threshold for swipe
            override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
                return 0.4f
            }
        })
        itemTouchHelper.attachToRecyclerView(binding.activityListUserRv)
    }
}
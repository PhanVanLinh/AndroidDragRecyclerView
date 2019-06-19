package vn.linhpv.androiddragrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_users.layoutManager = LinearLayoutManager(this)
        recycler_users.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val userAdapter = UserAdapter()
        recycler_users.adapter = userAdapter
        val users = arrayListOf<User>()
        for (i in 0..20) {
            users.add(User("$i"))
        }
        userAdapter.data = users

        val itemTouchHelper =
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    Collections.swap(userAdapter.data, viewHolder.adapterPosition, target.adapterPosition)
                    userAdapter.notifyItemMoved(viewHolder.adapterPosition, target.adapterPosition)
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                }
            })
        itemTouchHelper.attachToRecyclerView(recycler_users)
    }
}

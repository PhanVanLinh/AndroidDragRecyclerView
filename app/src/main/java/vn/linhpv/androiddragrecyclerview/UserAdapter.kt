package vn.linhpv.androiddragrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var data: List<User> = arrayListOf()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.text_name.text = user.name
        }

        companion object {
            fun create(parentView: ViewGroup): UserViewHolder {
                val view = LayoutInflater.from(parentView.context).inflate(R.layout.item_user, parentView, false)
                return UserViewHolder(view)
            }
        }
    }
}
package animation.constrainlayout.sample.com.sharedviewtransition.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import animation.constrainlayout.sample.com.sharedviewtransition.R
import animation.constrainlayout.sample.com.sharedviewtransition.domain.model.Monkey
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_monkey.view.*

class MonkeyAdapter(private val monkeys: List<Monkey>,
                    private val itemClick: (Monkey, ImageView) -> Unit) :
        RecyclerView.Adapter<MonkeyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_monkey, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(monkeys[position])
    }

    override fun getItemCount() = monkeys.size

    class ViewHolder(private val containerView: View, private val itemClick: (Monkey, ImageView) -> Unit)
        : RecyclerView.ViewHolder(containerView) {

        fun bind(monkey: Monkey) {
            with(monkey) {
                Picasso.get()
                        .load(monkey.thumbnailUrl)
                        .placeholder(R.drawable.placeholder)
                        .into(containerView.imageView)
                containerView.textView_name.text = name
                containerView.setOnClickListener { itemClick(this, containerView.imageView) }
                containerView.imageView.transitionName = name
            }
        }
    }
}
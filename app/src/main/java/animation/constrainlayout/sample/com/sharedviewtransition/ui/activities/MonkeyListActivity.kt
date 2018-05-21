package animation.constrainlayout.sample.com.sharedviewtransition.ui.activities

import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.ImageView
import animation.constrainlayout.sample.com.sharedviewtransition.R
import animation.constrainlayout.sample.com.sharedviewtransition.domain.datasource.MonkeyProvider
import animation.constrainlayout.sample.com.sharedviewtransition.domain.model.Monkey
import animation.constrainlayout.sample.com.sharedviewtransition.ui.adapters.MonkeyAdapter
import kotlinx.android.synthetic.main.activity_monkey_list.*


class MonkeyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monkey_list)

        monkeyList.layoutManager = GridLayoutManager(this, 2)
        monkeyList.adapter = MonkeyAdapter(MonkeyProvider().getAll()) { monkey: Monkey, imageView: ImageView ->
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, monkey.name)
            startActivity(MonkeyDetailActivity.newIntent(this, monkey), options.toBundle())
        }
    }
}

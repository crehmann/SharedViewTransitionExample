package animation.constrainlayout.sample.com.sharedviewtransition.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import animation.constrainlayout.sample.com.sharedviewtransition.R
import animation.constrainlayout.sample.com.sharedviewtransition.domain.datasource.MonkeyProvider
import animation.constrainlayout.sample.com.sharedviewtransition.domain.model.Monkey
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_monkey_detail.*

class MonkeyDetailActivity : AppCompatActivity() {

    companion object {
        const val ID = "DetailActivity:position"

        fun newIntent(context: Context, monkey: Monkey): Intent {
            val intent = Intent(context, MonkeyDetailActivity::class.java)
            intent.putExtra(ID, monkey.id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monkey_detail)
        bindMonkey(MonkeyProvider().findById(intent.getIntExtra(ID, -1)))
    }

    private fun bindMonkey(monkey: Monkey?) {
        if (monkey == null) return
        Picasso.get().load(monkey.imageUrl).into(imageView)
        textView_title.text = monkey.name
        textView_subtitle.text = monkey.location
        textView_description.text = monkey.details
        imageView.transitionName = monkey.name
    }
}
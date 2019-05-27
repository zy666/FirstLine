package github.com.zy666

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import github.com.zy666.second.SecondPartActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_second -> startActivity(SecondPartActivity.createIntent(this))
        }
    }
}

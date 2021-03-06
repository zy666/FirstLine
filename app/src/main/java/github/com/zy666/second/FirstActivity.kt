package github.com.zy666.second

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import github.com.zy666.R

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, FirstActivity::class.java)
        }
    }

}

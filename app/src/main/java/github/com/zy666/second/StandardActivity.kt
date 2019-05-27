package github.com.zy666.second

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import github.com.zy666.R
import kotlinx.android.synthetic.main.activity_standard.*

class StandardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standard)
        //打印信息，打印当前活动的实例
        Log.e("onCreate", this.toString())
        btn_standard.setOnClickListener {
            startActivity(StandardActivity.createIntent(this))
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, StandardActivity::class.java)
        }
    }

}

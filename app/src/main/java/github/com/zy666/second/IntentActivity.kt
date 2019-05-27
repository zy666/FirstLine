package github.com.zy666.second

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import github.com.zy666.R
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity() {
    var title = ""
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        title = intent.getStringExtra("title")
        name = intent.getStringExtra("name")
        setData(name, title)
    }

    private fun setData(name: String, title: String) {
        tv_title.text = title
        tv_name.text = name
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            setResult(Activity.RESULT_OK)
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }

    companion object {
        fun createIntent(context: Context, name: String, title: String): Intent {
            var intent = Intent(context, IntentActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("title", title)
            return intent
        }
    }
}

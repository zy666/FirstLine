package github.com.zy666.second

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import github.com.zy666.R

class LifeActivity : AppCompatActivity(), View.OnClickListener {
    var tag = "life-activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life)
        Log.e(tag, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(tag, "onRestart")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_normal -> startActivity(
                NormalActivity.createIntent(
                    this
                )
            )
            R.id.btn_dialog -> startActivity(
                DialogActivity.createIntent(
                    this
                )
            )
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, LifeActivity::class.java)
        }
    }
}

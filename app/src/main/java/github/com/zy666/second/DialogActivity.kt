package github.com.zy666.second

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import github.com.zy666.R

class DialogActivity : AppCompatActivity() {
    var tag = "Dialog--->>>>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
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

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, DialogActivity::class.java)
        }
    }
}

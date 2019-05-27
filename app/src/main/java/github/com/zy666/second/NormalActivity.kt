package github.com.zy666.second

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import github.com.zy666.R

class NormalActivity : AppCompatActivity() {
    var tag = "Normal"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        Log.e(tag, "onCreate")
        var tempData = savedInstanceState?.getString("data_key")
        Log.e("tempData", tempData)
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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        var tempData = "123"
        outState?.putString("data_key", tempData)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, NormalActivity::class.java)
        }
    }
}

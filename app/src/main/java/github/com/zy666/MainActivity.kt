package github.com.zy666

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var begin: String = "Toast"
    var start: String = "FirstActivity"
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_begin -> Toast.makeText(this, btn_begin.text, Toast.LENGTH_LONG).show()
            R.id.btn_first -> startActivity(FirstActivity.createIntent(this))
            R.id.btn_finish -> finish()
//            R.id.btn_two -> startActivity(TwoActivity.createIntent(this))
            R.id.btn_two -> {
                var intent = Intent("TwoActivity")
                intent.addCategory("myDefineAction")
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeBtnText(begin, start)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.add_item -> Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            R.id.refresh_item -> Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun changeBtnText(text: String, desc: String) {
        btn_begin.text = text
        btn_first.text = desc
    }
}

package github.com.zy666

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var begin: String = "Toast"
    var start: String = "FirstActivity"
    val RequestCode = 1;
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_begin -> Toast.makeText(this, btn_begin.text, Toast.LENGTH_LONG).show()
            R.id.btn_first -> startActivity(FirstActivity.createIntent(this))
            //关闭页面
            R.id.btn_finish -> finish()
            //intent隐式启动，页面
            R.id.btn_two -> {
                var intent = Intent("TwoActivity")
                intent.addCategory("myDefineAction")
                startActivity(intent)
                //startActivity(TwoActivity.createIntent(this))//intent显示启动
            }
            //intent隐式调用浏览器
            R.id.btn_webview -> {
                var intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.baidu.com")
                startActivity(intent)
            }
            //intent隐式调用，拨打电话
            R.id.btn_tel -> {
                var permission =
                    ContextCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.CALL_PHONE)
                if (permission == PackageManager.PERMISSION_GRANTED) {
                    callPhone()
                } else {
                    ActivityCompat.requestPermissions(
                        this@MainActivity, arrayOf(android.Manifest.permission.CALL_PHONE), RequestCode
                    )
                }

            }
            //intent数据传递
            R.id.btn_pass_data -> {
                startActivityForResult(IntentActivity.createIntent(this, "标题", "内容"), 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        if (requestCode == 1) {
            btn_pass_data.text = "intent刷新数据啦"
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == RequestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                && permissions[0] == android.Manifest.permission.CALL_PHONE
            ) {
                callPhone()
            } else {
                Toast.makeText(this@MainActivity, "permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //拨打电话
    private fun callPhone() {
        try {
            var intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
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

    private fun changeBtnText(text: String, desc: String) {
        btn_begin.text = text
        btn_first.text = desc
    }
}

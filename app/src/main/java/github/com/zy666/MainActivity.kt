package github.com.zy666

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("NewApi")
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_begin -> Toast.makeText(this, btn_begin.text, Toast.LENGTH_LONG).show();
            R.id.btn_start -> Toast.makeText(this, btn_start.text, Toast.LENGTH_LONG).show();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_begin.text = "开始使用kotlin"
        btn_begin.setOnClickListener(this)
        btn_start.setOnClickListener(this)
//        btn_begin.setOnClickListener {
//            Toast.makeText(this, btn_begin.text, Toast.LENGTH_LONG).show();
//        }
    }
}

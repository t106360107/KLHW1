package com.example.hwk1

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Button
import com.example.hwk1.R

class MainActivity : AppCompatActivity() {
    private var ed_name: EditText? = null
    private var tv_text: TextView? = null
    private var tv_name: TextView? = null
    private var tv_winner: TextView? = null
    private var tv_mmora: TextView? = null
    private var tv_cmora: TextView? = null
    private var btn_scissor: RadioButton? = null
    private var btn_stone: RadioButton? = null
    private var btn_paper: RadioButton? = null
    private var btn_mora: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ed_name = findViewById(R.id.ed_name)
        tv_text = findViewById(R.id.tv_text)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)
        btn_scissor = findViewById(R.id.btn_scissor)
        btn_stone = findViewById(R.id.btn_stone)
        btn_paper = findViewById(R.id.btn_paper)
        btn_mora = findViewById(R.id.btn_mora)

        btn_mora!!.setOnClickListener {
            if (ed_name!!.length() < 1)
                tv_text!!.text = "請輸入玩家姓名"
            else {
                tv_name!!.text = String.format("名字\n%s", ed_name!!.text.toString())
                if (btn_scissor!!.isChecked)
                    tv_mmora!!.text = "我方出拳\n剪刀"
                else if (btn_stone!!.isChecked)
                    tv_mmora!!.text = "我方出拳\n石頭"
                else
                    tv_mmora!!.text = "我方出拳\n布"
                val computer = (Math.random() * 3).toInt()
                if (computer == 0)
                    tv_cmora!!.text = "電腦出拳\n剪刀"
                else if (computer == 1)
                    tv_cmora!!.text = "電腦出拳\n石頭"
                else
                    tv_cmora!!.text = "電腦出拳\n布"
                if (btn_scissor!!.isChecked && computer == 2 ||
                    btn_stone!!.isChecked && computer == 0 ||
                    btn_paper!!.isChecked && computer == 1
                ) {
                    tv_winner!!.text = "勝利者\n" + ed_name!!.text.toString()
                    tv_text!!.text = "恭喜你獲勝了！！！"
                } else if (btn_scissor!!.isChecked && computer == 1 ||
                    btn_stone!!.isChecked && computer == 2 ||
                    btn_paper!!.isChecked && computer == 0
                ) {
                    tv_winner!!.text = "勝利者\n電腦"
                    tv_text!!.text = "可惜，電腦獲勝了！"
                } else {
                    tv_winner!!.text = "勝利者\n平手"
                    tv_text!!.text = "平局，請再試一次！"
                }
            }
        }
    }
}

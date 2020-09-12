package com.example.l4s_tangotyo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruit: Array<Word> = arrayOf(Word(R.drawable.apple, "りんご", "Apple"),
                Word(R.drawable.banana,"ばなな","Banana"),
                Word(R.drawable.orange,"みかん","Orange"),
                Word(R.drawable.strawberry,"イチゴ","Strawberry")
        )

        for(i in 0 .. 3) {
            addWord(fruit[i])
        }
    }

    private fun addWord (word: Word){
        //今までxmlで付けてたtextViewをこっちで作っちゃうよ
        //Contextとはアプリケーション全体の情報を保持するActivityのスーパークラス
        val nameTextView = TextView(this) // val nameTextView = TextView(applicationContext)と同じ意味
        nameTextView.text = word.name
        val englishNameTextView = TextView(this)
        englishNameTextView.text = word.englishName
        //containerというLinearLayoutの中にtextViewを入れるよ
        // container.addView(nameTextView)
        val layout = LinearLayout(this.applicationContext)
        layout.orientation = LinearLayout.HORIZONTAL
        val imageView = ImageView(this)//applicationContext
        imageView.setImageResource(word.resId)

        layout.addView(imageView)
        layout.addView(nameTextView)
        layout.addView(englishNameTextView)

        container.addView(layout)
    }
}

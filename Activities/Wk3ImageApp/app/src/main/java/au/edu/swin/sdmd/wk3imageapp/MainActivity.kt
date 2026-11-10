package au.edu.swin.sdmd.wk3imageapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageList = listOf(
            R.drawable.visibility_24dp_e3e3e3,
            R.drawable.thumb_down_24dp_e3e3e3,
            R.drawable.check_circle_outline_24dp_e3e3e3
        )
        val image = findViewById<ImageView>(R.id.ChangeImage)
        var counter = 0
        image.setOnClickListener {
            counter = (counter + 1) % imageList.size
            image.setImageResource(imageList[counter])
            }

        val colorList = listOf(
            R.color.white,
            R.color.black ,
            R.color.red
        )
        var colorCounter = 0
        image.setOnLongClickListener {
            colorCounter = (colorCounter + 1) % colorList.size
            image.setColorFilter(getColor((colorList[colorCounter])))
            true
            }
        }
    }

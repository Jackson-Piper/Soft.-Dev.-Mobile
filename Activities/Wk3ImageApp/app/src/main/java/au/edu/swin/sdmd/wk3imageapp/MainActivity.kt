package au.edu.swin.sdmd.wk3imageapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedState
import kotlin.rem

class ImageViewModel : ViewModel(){
    var counter =0
    var colorCounter = 0

    val imageList = listOf(
        R.drawable.visibility_24dp_e3e3e3,
        R.drawable.thumb_down_24dp_e3e3e3,
        R.drawable.check_circle_outline_24dp_e3e3e3
    )
    val colorList = listOf(
        R.color.white,
        R.color.black ,
        R.color.red
    )

    fun nextImage(): Int {
        counter = (counter + 1) % imageList.size
        return imageList[counter]
    }
    fun nextColor(): Int {
        colorCounter = (colorCounter + 1) % colorList.size
        return colorList[colorCounter]
    }

    fun currentImage(): Int {
        return imageList[counter]
    }

    fun currentColor(): Int{
        return colorList[colorCounter]
    }
}

class MainActivity : AppCompatActivity() {
    val vm: ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.ChangeImage)
            image.setImageResource(vm.currentImage())
            image.setColorFilter(getColor(vm.currentColor()))


        image.setOnClickListener {
            image.setImageResource(vm.nextImage())
            }
        image.setOnLongClickListener {
            image.setColorFilter(getColor(vm.nextColor()))
            true
            }
        }
    }

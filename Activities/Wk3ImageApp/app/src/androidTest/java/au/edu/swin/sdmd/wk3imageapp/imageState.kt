package au.edu.swin.sdmd.wk3imageapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class imageState(
    val color: Int = 0,
    val currImage: Int =0
    ) {


    class ImageViewModel : ViewModel() {

        val imageList = listOf(
            R.drawable.visibility_24dp_e3e3e3,
            R.drawable.thumb_down_24dp_e3e3e3,
            R.drawable.check_circle_outline_24dp_e3e3e3
        )
        val colorList = listOf(
            R.color.white,
            R.color.black,
            R.color.red
        )
        private val _uiState = MutableStateFlow(imageState())
        val uiState: StateFlow<imageState> = _uiState.asStateFlow()

        fun nextImage() {
            _uiState.update { currentState ->

                currentState.copy(
                    currImage = (currImage + 1) % imageList.size
                            image . setImageResource (imageList[counter])

                )
            }
        }
    }
}

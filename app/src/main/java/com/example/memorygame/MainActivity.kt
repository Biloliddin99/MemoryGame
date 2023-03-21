package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.view.allViews
import kotlinx.android.synthetic.main.activity_hard.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.image_1
import kotlinx.android.synthetic.main.activity_main.image_2
import kotlinx.android.synthetic.main.activity_main.image_3
import kotlinx.android.synthetic.main.activity_main.image_4
import kotlinx.android.synthetic.main.activity_main.image_5
import kotlinx.android.synthetic.main.activity_main.image_6
import kotlinx.android.synthetic.main.activity_main.image_7
import kotlinx.android.synthetic.main.activity_main.image_8
import java.util.Random

class MainActivity : AppCompatActivity() {

    private val listImageOpenClose = arrayOf(false, false, false, false, false, false,false,false)
    private val imageIndex = arrayOfNulls<Int>(2)
    private val photoId = arrayOfNulls<Int>(2)
    var openPhoto = 0
    var doAnimation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomImage()
    }

    private fun imageClick(imageView: ImageView, photo: Int, index: Int) {
        if (!doAnimation) {
            if (!listImageOpenClose[index]) {
                openAnimation(imageView, photo, index)
            } else {
                closeAnimation(imageView, photo, index)
            }
        }
    }

    private fun openAnimation(imageView: ImageView, photo: Int, index: Int) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                doAnimation = true
            }

            override fun onAnimationEnd(p0: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(photo)
                animation2.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        listImageOpenClose[index] = true
                        imageIndex[openPhoto] = index
                        photoId[openPhoto] = photo
                        openPhoto++

                        if (openPhoto == 2) {
                            if (photoId[0] == photoId[1]) {
                                findImageView(imageIndex[0]).visibility = View.INVISIBLE
                                openPhoto--
                                findImageView(imageIndex[1]).visibility = View.INVISIBLE
                                openPhoto--
                            } else {
                                closeAnimation(findImageView(imageIndex[0]), -1, imageIndex[0])
                                closeAnimation(findImageView(imageIndex[1]), -1, imageIndex[1])
                            }

                        }
                        doAnimation = false
                    }

                    override fun onAnimationRepeat(p0: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })

    }

    private fun closeAnimation(imageView: ImageView, photo: Int, index: Int?) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                doAnimation = true
            }

            override fun onAnimationEnd(p0: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.mind2)
                animation2.setAnimationListener(object :Animation.AnimationListener{
                    override fun onAnimationStart(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        doAnimation = false
                    }

                    override fun onAnimationRepeat(p0: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })
        listImageOpenClose[index!!] = false
        openPhoto--
    }

    private fun findImageView(index: Int?): ImageView {
        var imageView: ImageView? = null
        when (index) {
            0 -> imageView = image_1
            1 -> imageView = image_2
            2 -> imageView = image_3
            3 -> imageView = image_4
            4 -> imageView = image_5
            5 -> imageView = image_6
            6 -> imageView = image_7
            7 -> imageView = image_8
        }
        return imageView!!
    }

    private fun randomImage(){
        when(Random().nextInt(4)){
            0->case1()
            1->case2()
            2->case3()
            3->case4()
        }

    }

    private fun case1(){
        image_1.setOnClickListener {
            imageClick(image_1,R.drawable.lion,0)
        }
        image_2.setOnClickListener {
            imageClick(image_2,R.drawable.koala,1)
        }
        image_3.setOnClickListener {
            imageClick(image_3,R.drawable.tiger,2)
        }
        image_4.setOnClickListener {
            imageClick(image_4,R.drawable.monkey,3)
        }
        image_5.setOnClickListener {
            imageClick(image_5,R.drawable.lion,4)
        }
        image_6.setOnClickListener {
            imageClick(image_6,R.drawable.monkey,5)
        }
        image_7.setOnClickListener {
            imageClick(image_7,R.drawable.lion,6)
        }
        image_8.setOnClickListener {
            imageClick(image_8,R.drawable.tiger,7)
        }
    }

    private fun case2(){
        image_1.setOnClickListener {
            imageClick(image_1,R.drawable.monkey,0)
        }
        image_2.setOnClickListener {
            imageClick(image_2,R.drawable.zebra,1)
        }
        image_3.setOnClickListener {
            imageClick(image_3,R.drawable.elephant,2)
        }
        image_4.setOnClickListener {
            imageClick(image_4,R.drawable.monkey,3)
        }
        image_5.setOnClickListener {
            imageClick(image_5,R.drawable.rabbit,4)
        }
        image_6.setOnClickListener {
            imageClick(image_6,R.drawable.zebra,5)
        }
        image_7.setOnClickListener {
            imageClick(image_7,R.drawable.rabbit,6)
        }
        image_8.setOnClickListener {
            imageClick(image_8,R.drawable.elephant,7)
        }
    }

    private fun case3(){
        image_1.setOnClickListener {
            imageClick(image_1,R.drawable.elephant,0)
        }
        image_2.setOnClickListener {
            imageClick(image_2,R.drawable.fox,1)
        }
        image_3.setOnClickListener {
            imageClick(image_3,R.drawable.elephant,2)
        }
        image_4.setOnClickListener {
            imageClick(image_4,R.drawable.monkey,3)
        }
        image_5.setOnClickListener {
            imageClick(image_5,R.drawable.lion,4)
        }
        image_6.setOnClickListener {
            imageClick(image_6,R.drawable.fox,5)
        }
        image_7.setOnClickListener {
            imageClick(image_7,R.drawable.lion,6)
        }
        image_8.setOnClickListener {
            imageClick(image_8,R.drawable.monkey,7)
        }
    }

    private fun case4(){
        image_1.setOnClickListener {
            imageClick(image_1,R.drawable.zebra,0)
        }
        image_2.setOnClickListener {
            imageClick(image_2,R.drawable.horse,1)
        }
        image_3.setOnClickListener {
            imageClick(image_3,R.drawable.monkey,2)
        }
        image_4.setOnClickListener {
            imageClick(image_4,R.drawable.monkey,3)
        }
        image_5.setOnClickListener {
            imageClick(image_5,R.drawable.lion,4)
        }
        image_6.setOnClickListener {
            imageClick(image_6,R.drawable.horse,5)
        }
        image_7.setOnClickListener {
            imageClick(image_7,R.drawable.lion,6)
        }
        image_8.setOnClickListener {
            imageClick(image_8,R.drawable.zebra,7)
        }
    }

//    fun restart(){
//        for (i in listImageOpenClose.indices){
//            listImageOpenClose[i] = false
//        }
//        doAnimation = false
//        closeAnimation(image_1,)
//    }

    fun restart(){
        for (i in listImageOpenClose.indices){
            listImageOpenClose[i]=false
        }
        doAnimation=false
        closeAnimation(image_1,R.drawable.elephant, 0)
        closeAnimation(image_2,R.drawable.lion,0)
        closeAnimation(image_3,R.drawable.fox,0)
        closeAnimation(image_4,R.drawable.rabbit,0)
        closeAnimation(image_5,R.drawable.elephant,0)
        closeAnimation(image_6,R.drawable.lion, 0)
        closeAnimation(image_7,R.drawable.rabbit, 0)
        closeAnimation(image_8,R.drawable.fox, 0)

        openPhoto=0
        image_1.visibility = View.VISIBLE
        image_2.visibility = View.VISIBLE
        image_3.visibility = View.VISIBLE
        image_4.visibility = View.VISIBLE
        image_5.visibility = View.VISIBLE
        image_6.visibility = View.VISIBLE


    }

}
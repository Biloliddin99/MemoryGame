package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.memorygame.databinding.ActivityMediumBinding
import kotlinx.android.synthetic.main.activity_main.*

class Medium : AppCompatActivity() {

    private val listImageOpenClose =
        arrayOf(false, false, false, false, false, false, false, false, false, false, false, false)
    private val imageIndex = arrayOfNulls<Int>(2)
    private val photoId = arrayOfNulls<Int>(2)
    var openPhoto = 0
    var doAnimation = false

    private lateinit var binding: ActivityMediumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image1.setOnClickListener {
            imageClick(binding.image1, R.drawable.horse, 0)
        }
        binding.image2.setOnClickListener {
            imageClick(binding.image2, R.drawable.lion, 1)
        }
        binding.image3.setOnClickListener {
            imageClick(binding.image3, R.drawable.deer, 2)
        }
        binding.image4.setOnClickListener {
            imageClick(binding.image4, R.drawable.tiger, 3)
        }
        binding.image5.setOnClickListener {
            imageClick(binding.image5, R.drawable.horse, 4)
        }
        binding.image6.setOnClickListener {
            imageClick(binding.image6, R.drawable.elephant, 5)
        }
        binding.image7.setOnClickListener {
            imageClick(binding.image7, R.drawable.lion, 6)
        }
        binding.image8.setOnClickListener {
            imageClick(binding.image8, R.drawable.tiger, 7)
        }
        binding.image9.setOnClickListener {
            imageClick(binding.image9, R.drawable.rabbit, 8)
        }
        binding.image10.setOnClickListener {
            imageClick(binding.image10, R.drawable.elephant, 9)
        }
        binding.image11.setOnClickListener {
            imageClick(binding.image11, R.drawable.deer, 10)
        }
        binding.image12.setOnClickListener {
            imageClick(binding.image12, R.drawable.rabbit, 11)
        }
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
                val animation2 = AnimationUtils.loadAnimation(this@Medium, R.anim.anim2)
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
                val animation2 = AnimationUtils.loadAnimation(this@Medium, R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.mind2)
                animation2.setAnimationListener(object : Animation.AnimationListener {
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
            0 -> imageView = binding.image1
            1 -> imageView = binding.image2
            2 -> imageView = binding.image3
            3 -> imageView = binding.image4
            4 -> imageView = binding.image5
            5 -> imageView = binding.image6
            6 -> imageView = binding.image7
            7 -> imageView = binding.image8
            8 -> imageView = binding.image9
            9 -> imageView = binding.image10
            10 -> imageView = binding.image11
            11 -> imageView = binding.image12
        }
        return imageView!!
    }
}
package com.example.bottomnavigationexample.util

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.example.bottomnavigationexample.R


class AspectLockedImageView : androidx.appcompat.widget.AppCompatImageView {

    private var aspectRatio = 0f
    private var aspectRatioSource: AspectRatioSource? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.AspectLockedImageView
        )
        aspectRatio = a.getFloat(R.styleable.AspectLockedImageView_imageAspectRatio, 0f)
        a.recycle()
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        var localRatio = aspectRatio

        if (localRatio.toDouble() == 0.0 && aspectRatioSource != null
            && aspectRatioSource!!.height > 0
        ) {
            localRatio = aspectRatioSource!!.width.toFloat() / aspectRatioSource!!.height.toFloat()
        }

        if (localRatio.toDouble() == 0.0) {
            super.onMeasure(widthSpec, heightSpec)
        } else {
            var lockedWidth = MeasureSpec.getSize(widthSpec)
            var lockedHeight = MeasureSpec.getSize(heightSpec)

            if (lockedWidth == 0 && lockedHeight == 0) {
                throw IllegalArgumentException(
                    "Both width and height cannot be zero -- watch out for scrollable containers"
                )
            }

            // Get the padding of the border background.
            val hPadding = paddingLeft + paddingRight
            val vPadding = paddingTop + paddingBottom

            // Resize the preview frame with correct aspect ratio.
            lockedWidth -= hPadding
            lockedHeight -= vPadding

            if (lockedHeight > 0 && lockedWidth > lockedHeight * localRatio) {
                lockedWidth = (lockedHeight * localRatio + .5).toInt()
            } else {
                lockedHeight = (lockedWidth / localRatio + .5).toInt()
            }

            // Add the padding of the border.
            lockedWidth += hPadding
            lockedHeight += vPadding

            // Ask children to follow the new preview dimension.
            super.onMeasure(
                View.MeasureSpec.makeMeasureSpec(lockedWidth, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(lockedHeight, View.MeasureSpec.EXACTLY)
            )
        }
    }

    fun setAspectRatioSource(v: View) {
        this.aspectRatioSource =
            ViewAspectRatioSource(v)
    }

    fun setAspectRatioSource(aspectRatioSource: AspectRatioSource) {
        this.aspectRatioSource = aspectRatioSource
    }

    // from com.android.camera.PreviewFrameLayout, with slight
    // modifications

    fun setAspectRatio(aspectRatio: Float) {
        if (aspectRatio <= 0.0) {
            throw IllegalArgumentException(
                "aspect ratio must be positive"
            )
        }

        if (this.aspectRatio != aspectRatio) {
            this.aspectRatio = aspectRatio
            requestLayout()
        }
    }

    interface AspectRatioSource {
        val width: Int

        val height: Int
    }

    private class ViewAspectRatioSource internal constructor(v: View) :
        AspectRatioSource {
        private var v: View? = null

        override val width: Int
            get() = v!!.width

        override val height: Int
            get() = v!!.height

        init {
            this.v = v
        }
    }

}
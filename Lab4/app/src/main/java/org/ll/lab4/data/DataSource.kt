package org.ll.lab4.data

import android.content.ClipData

object DataSource {
    fun loadData(): List<ClipData.Item> {
        return listOf(
            ClipData.Item(
                title = R.string.name,//load the text defined in strings . xml
                image = R.drawable.name // load the image defined in drawables
            )
        )
        //Item (
        //title =  R.string.  load the text defined in strings.xml
        // image = R.drawable.name load the image defined in drawables
        //),


        //retrofit used in real life to load images
    }
}
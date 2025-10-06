package org.ll.lab4.data

import org.ll.lab4.R
import org.ll.lab4.model.MyItem


object DataSource {
    // Datasource is an object and loadData is a simple function (Not composable) that returns
    //my hardcoded data
    fun loadData(): List<MyItem> {
        return listOf(

            MyItem(
                title = R.string.miu_prefessionals,//load the text defined in strings . xml
                image = R.drawable.compro_professionals // load the image defined in drawables
            ),

            MyItem(
                title = R.string.miu_admission,//load the text defined in strings . xml
                image = R.drawable.compro_admission_team // load the image defined in drawables
            ),
            MyItem(
                title = R.string.miu_renuka,//load the text defined in strings . xml
                image = R.drawable.faculty_student // load the image defined in drawables
            ),
            MyItem(
                title = R.string.miu_friends,//load the text defined in strings . xml
                image = R.drawable.friends // load the image defined in drawables
            ),
            MyItem(
                title = R.string.miu_graduation,//load the text defined in strings . xml
                image = R.drawable.graduation // load the image defined in drawables
            ),
            MyItem(
                title = R.string.miu_campus,//load the text defined in strings . xml
                image = R.drawable.miu_campus // load the image defined in drawables
            ),
            MyItem(
                title = R.string.miu_rainbow,//load the text defined in strings . xml
                image = R.drawable.rainbow // load the image defined in drawables
            ),
            MyItem(
                title = R.string.miu_sustainable,//load the text defined in strings . xml
                image = R.drawable.sustainable_living_center // load the image defined in drawables
            ),
        )

        //retrofit used in real life to load images
    }
}
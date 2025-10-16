package org.ll.lab9.core.database

import android.content.Context
import androidx.room.Database
import org.ll.lab9.core.database.dao.ItemDao
import org.ll.lab9.core.database.entity.Item
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Item::class],
    version = 1,
    exportSchema = false
)
abstract class InventoryDatabase() : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        private var INSTANCE: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = InventoryDatabase::class.java,
                    name = "item_database"
                ).build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}

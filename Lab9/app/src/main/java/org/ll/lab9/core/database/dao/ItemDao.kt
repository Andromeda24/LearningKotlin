package org.ll.lab9.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.ll.lab9.core.database.entity.Item

@Dao
// DAO is an interface because is the connection between logic and database
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("SELECT * FROM items where id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<Item>>


}
package org.ll.lab9.feature.item.data

import kotlinx.coroutines.flow.Flow
import org.ll.lab9.core.database.dao.ItemDao
import org.ll.lab9.core.database.entity.Item
import org.ll.lab9.feature.item.domain.ItemRepository

class ItemRepositoryImpl(
    private var itemDao: ItemDao
): ItemRepository {
    override fun getAllItems(): Flow<List<Item>> {
        return  itemDao.getAllItems()
    }
    override suspend fun insertItem(item: Item) {
        return itemDao.insertItem(item)
    }
}
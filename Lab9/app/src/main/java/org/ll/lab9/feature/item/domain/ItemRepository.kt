package org.ll.lab9.feature.item.domain

import kotlinx.coroutines.flow.Flow
import org.ll.lab9.core.database.entity.Item

interface ItemRepository {
    suspend fun insertItem(item: Item)
    fun getAllItems(): Flow<List<Item>>
}
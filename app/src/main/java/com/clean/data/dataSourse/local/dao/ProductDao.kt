package com.clean.data.dataSourse.local.dao

import androidx.room.*
import com.clean.data.models.ProductEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: List<ProductEntity>)



    @Query("SELECT * FROM ${ProductEntity.TABLE_NAME}")
    fun getAllPosts(): Flow<List<ProductEntity>>


}
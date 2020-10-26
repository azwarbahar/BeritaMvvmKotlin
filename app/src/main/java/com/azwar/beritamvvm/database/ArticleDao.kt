package com.azwar.beritamvvm.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.azwar.beritamvvm.model.Article
import kotlinx.coroutines.selects.select

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("select * from articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}
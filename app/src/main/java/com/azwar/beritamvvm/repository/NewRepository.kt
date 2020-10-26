package com.azwar.beritamvvm.repository

import com.azwar.beritamvvm.database.ArticleDatabase
import com.azwar.beritamvvm.model.Article
import com.azwar.beritamvvm.network.RetrofitInstance

class NewRepository(val db : ArticleDatabase) {

    //get
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    //membuat databse
    suspend fun upset(article: Article) = db.getArticleDao().upsert(article)

    // save
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    // hapus
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}
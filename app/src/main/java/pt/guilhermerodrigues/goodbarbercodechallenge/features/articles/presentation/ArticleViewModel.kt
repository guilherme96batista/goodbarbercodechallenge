package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.usecases.GetArticle
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.domain.usecases.GetArticles
import pt.guilhermerodrigues.goodbarbercodechallenge.core.common.UseCaseParams
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val getArticles: GetArticles,
    private val getArticle: GetArticle
): ViewModel() {

    private val _articlesListLiveData = MutableLiveData<Result<List<Article>>>()
    val articlesListLiveData: LiveData<Result<List<Article>>> = _articlesListLiveData
    private val _articleLiveData = MutableLiveData<Result<Article>>()
    val articleLiveData: LiveData<Result<Article>> = _articleLiveData

    fun loadArticles() {
        viewModelScope.launch {
            val result = getArticles()
            _articlesListLiveData.value = result
        }
    }

    fun loadArticle(id: Int) {
        viewModelScope.launch {
            val result = getArticle(UseCaseParams.ArticleParams(id))
            _articleLiveData.value = result
        }
    }
}
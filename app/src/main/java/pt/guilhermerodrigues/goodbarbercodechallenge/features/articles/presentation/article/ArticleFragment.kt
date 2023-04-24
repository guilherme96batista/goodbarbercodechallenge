package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.presentation.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.presentation.ArticleViewModel
import pt.guilhermerodrigues.goodbarbercodechallenge.databinding.ArticleDetailWebViewBinding

@AndroidEntryPoint
class ArticleFragment : Fragment() {
    private val viewModel: ArticleViewModel by viewModels()
    private lateinit var binding: ArticleDetailWebViewBinding
    private lateinit var article: Article

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArticleDetailWebViewBinding.inflate(inflater)
        val bundle = arguments
        if (bundle != null) {
            val articleString = bundle.getSerializable("article")
            val gson = Gson()
            article = gson.fromJson(articleString as String, Article::class.java)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadArticle(article.id)

        viewModel.articleLiveData.observe(viewLifecycleOwner) { result ->
            result.fold(
                onSuccess = {
                    binding.titleTextView.text = it.title
                    binding.contentWebView.loadData(it.content, "text/html", "UTF-8")
                },
                onFailure = {
                    val myErrorMessage = it.message + "\n Failed to retrieve info, using cached one"
                    binding.titleTextView.text = myErrorMessage
                    binding.contentWebView.loadData(article.content, "text/html", "UTF-8")
                }
            )
        }
    }

}
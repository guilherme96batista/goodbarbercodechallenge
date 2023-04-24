package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.presentation.articleslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import pt.guilhermerodrigues.goodbarbercodechallenge.R
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.presentation.ArticleViewModel
import pt.guilhermerodrigues.goodbarbercodechallenge.databinding.ArticlesRecyclerListFragmentBinding

@AndroidEntryPoint
class ArticlesListFragment: Fragment() {
    private val viewModel: ArticleViewModel by viewModels()
    private lateinit var binding: ArticlesRecyclerListFragmentBinding
    private lateinit var articlesAdapter: ArticlesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArticlesRecyclerListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadArticles()
        initViews()

        viewModel.articlesListLiveData.observe(viewLifecycleOwner) { result ->
            result.fold(
                onSuccess = {
                    articlesAdapter.setItemList(it)
                },
                onFailure = {
                    binding.textViewHello.text = it.message!!
                }
            )
        }
    }

    private fun initViews() {
        articlesAdapter = ArticlesAdapter(emptyList(), ::onHolderClick)

        binding.articleRecyclerView.apply{
            adapter = articlesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onHolderClick(article: Article) {
        val gson = Gson()
        val articleJson = gson.toJson(article)

        val bundle = Bundle()
        bundle.putSerializable("article", articleJson)

        activity?.let { Navigation.findNavController(it, R.id.nav_host_fragment) }
            ?.navigate(R.id.articleFragment, bundle)
    }
}


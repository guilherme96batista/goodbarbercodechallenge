package pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.presentation.articleslist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import pt.guilhermerodrigues.goodbarbercodechallenge.features.articles.data.models.Article
import pt.guilhermerodrigues.goodbarbercodechallenge.databinding.ArticleViewHolderBinding


/*TODO build this adapter with pagination*/
class ArticlesAdapter (
    private var itemList: List<Article>,
    private val onHolderClick: (article: Article) -> Unit
) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ArticleViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArticleViewHolder(binding, onHolderClick)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = itemList[position]
        holder.bind(article)
    }

    override fun getItemViewType(position: Int): Int {
        return position % 10
    }

    override fun getItemCount(): Int = this.itemList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItemList(itemList: List<Article>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    class ArticleViewHolder(
        private val binding: ArticleViewHolderBinding,
        private val onHolderClick: (article: Article) -> Unit
    ) : RecyclerView.ViewHolder(binding.root),  View.OnClickListener {
        private lateinit var _article: Article
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(
            article: Article,
        ) {
            Picasso.get()
                .load(article.images[0].url)
                .into(binding.articleImageView)

            binding.articleTitleTextView.text = article.title
            _article = article
        }


        override fun onClick(view: View?) {
            onHolderClick(_article)
        }
    }
}






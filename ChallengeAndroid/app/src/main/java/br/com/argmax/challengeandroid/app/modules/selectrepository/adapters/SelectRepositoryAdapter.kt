package br.com.argmax.challengeandroid.app.modules.selectrepository.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.argmax.challengeandroid.R
import br.com.argmax.challengeandroid.app.components.repositorycard.dto.RepositoryCardDto
import br.com.argmax.challengeandroid.databinding.RepositoryCardViewHolderBinding
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.repository_card_view_holder.*

class SelectRepositoryAdapter : Adapter<SelectRepositoryAdapter.RepositoryCardViewHolder>() {

    private var data: List<RepositoryCardDto> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryCardViewHolder {
        val repositoryCardViewHolderItemBinding: RepositoryCardViewHolderBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.repository_card_view_holder,
                parent,
                false
            )

        return RepositoryCardViewHolder(repositoryCardViewHolderItemBinding.root)
    }

    override fun onBindViewHolder(holder: RepositoryCardViewHolder, position: Int) {
        holder.updateData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun replaceData(list: List<RepositoryCardDto>) {
        list.let {
            data = it
            notifyDataSetChanged()
        }
    }

    inner class RepositoryCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun updateData(repositoryCardDto: RepositoryCardDto) {
            repositoryCard.setRepositoryCardDto(repositoryCardDto)
        }

    }


}

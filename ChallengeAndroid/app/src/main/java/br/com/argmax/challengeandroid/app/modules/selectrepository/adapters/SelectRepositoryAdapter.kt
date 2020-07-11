package br.com.argmax.challengeandroid.app.modules.selectrepository.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.argmax.challengeandroid.R
import br.com.argmax.challengeandroid.app.components.repositorycard.dto.RepositoryCardDto
import br.com.argmax.challengeandroid.databinding.RepositoryCardViewHolderItemBinding
import kotlinx.android.extensions.LayoutContainer

class SelectRepositoryAdapter : Adapter<SelectRepositoryAdapter.RepositoryCardViewHolderItem>() {

    private var data: List<RepositoryCardDto> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryCardViewHolderItem {
        val repositoryCardViewHolderItemBinding: RepositoryCardViewHolderItemBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.repository_card_view_holder_item,
                parent,
                false
            )

        return RepositoryCardViewHolderItem(repositoryCardViewHolderItemBinding.root)
    }

    override fun onBindViewHolder(holder: RepositoryCardViewHolderItem, position: Int) {
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

    inner class RepositoryCardViewHolderItem(itemView: View) : RecyclerView.ViewHolder(itemView),
        LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun updateData(repositoryCardDto: RepositoryCardDto) {

        }

    }


}

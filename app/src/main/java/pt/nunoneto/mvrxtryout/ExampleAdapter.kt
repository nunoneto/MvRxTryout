package pt.nunoneto.mvrxtryout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.example_list_item.view.*

class ExampleAdapter(val onHeroPressed: (model: ExampleEntity) -> Unit) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    var animateLikes = arrayListOf<Int>()
    var listItems = emptyList<ExampleEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ExampleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.example_list_item, parent, false))

    override fun getItemCount() = listItems.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val itemView = holder.itemView
        listItems.elementAtOrNull(position)?.let { model ->
            Glide.with(itemView.context)
                .load(model.imageUrl)
                .transform(CircleCrop())
                .into(itemView.image)

            itemView.tv_name.text = model.name
            itemView.tv_creators.text = model.creators
            itemView.setOnClickListener { onHeroPressed(model) }


            val tintColor = ContextCompat.getColor(itemView.context, R.color.red)
            val resource = if (model.liked) {
                R.drawable.ic_favorite_checked
            } else {
                R.drawable.ic_favorite_unchecked
            }

            itemView.iv_like.background =
                ContextCompat.getDrawable(itemView.context, resource)?.also { DrawableCompat.setTint(it, tintColor) }

            if (animateLikes.remove(model.id)) {
                val anim = AnimationUtils.loadAnimation(itemView.context, R.anim.scale_anim)
                itemView.iv_like.startAnimation(anim)
            }
        }

    }

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}


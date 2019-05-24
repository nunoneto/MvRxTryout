package pt.nunoneto.mvrxtryout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.*
import kotlinx.android.synthetic.main.example_fragment.*

class ExampleFragment : BaseMvRxFragment() {

    private val viewModel: ExampleViewModel by fragmentViewModel()
    private val adapter = ExampleAdapter(::onHeroPressed)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.example_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_data.adapter = adapter
        rv_data.layoutManager = LinearLayoutManager(context)
    }

    override fun invalidate() = withState(viewModel) { exampleState ->
        when (exampleState.list) {
            is Fail -> {
                loading.visibility = View.GONE
            }
            is Loading -> {
                loading.visibility = View.VISIBLE
            }
            is Success -> {
                val newList = exampleState.list.invoke()
                newList.forEach { new ->
                    if (adapter.listItems.find { old -> old.id == new.id }?.liked == false && new.liked) {
                        adapter.animateLikes.add(new.id)
                    }
                }

                adapter.listItems = newList
                adapter.notifyDataSetChanged()

                loading.visibility = View.GONE
            }
        }
    }

    private fun onHeroPressed(exampleEntity: ExampleEntity) =
        viewModel.setHeroLikedState(exampleEntity)

    companion object {
        fun newInstance() = ExampleFragment()
    }
}

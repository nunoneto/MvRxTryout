package pt.nunoneto.mvrxtryout

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.Success

class ExampleViewModel(initialState: ExampleState) :
    BaseMvRxViewModel<ExampleState>(initialState, debugMode = BuildConfig.DEBUG) {

    init {
        logStateChanges()
        getExampleList()
    }

//    // RxJava style
//      private fun getExampleList() =
//        getExampleEntities()
//            .observeOn(Schedulers.io())
//            .subscribeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                // success code
//            }, {
//                // handle error
//            })

    // MvRx Style
    private fun getExampleList() =
        getExampleEntities()
            .execute { exampleState ->
                copy(list = exampleState)
            }

    fun setHeroLikedState(model: ExampleEntity) {
        setState {
            val list = this.list.invoke()
                .orEmpty()
                .map {
                    if (it.id == model.id) {
                        it.copy(liked = it.liked.not())
                    } else {
                        it
                    }
                }

            copy(list = Success(list))
        }
    }
}
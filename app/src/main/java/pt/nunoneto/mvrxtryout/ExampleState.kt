package pt.nunoneto.mvrxtryout

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class ExampleState(val list: Async<List<ExampleEntity>> = Uninitialized) : MvRxState

package pt.nunoneto.mvrxtryout

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity

class MainActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, ExampleFragment.newInstance()).commit()
        }
    }
}

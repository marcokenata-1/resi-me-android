package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.SavedMenu

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

class SavedMenuViewModel : ViewModel(), CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }
}

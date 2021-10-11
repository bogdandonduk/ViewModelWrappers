package bogdandonduk.viewmodelwrapperslib.automatic

import android.app.Activity
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import bogdandonduk.viewmodelwrapperslib.core.GenericViewModelFactory

interface SingleAutomaticInitializationWithInitializationViewModelHandlerActivity<T : ViewModel> {
    var viewModelInitialization: (activity: Activity) -> T

    fun getInitializedViewModel(activity: ComponentActivity) : T {
        val viewModel = viewModelInitialization.invoke(activity)

        return ViewModelProvider(activity, GenericViewModelFactory(viewModel)).get(viewModel::class.java)
    }

    fun getInitializedViewModel(activity: Activity, viewModelStore: ViewModelStore) : T {
        val viewModel = viewModelInitialization.invoke(activity)

        return ViewModelProvider(viewModelStore, GenericViewModelFactory(viewModel)).get(viewModel::class.java)
    }

    fun getInitializedViewModel(activity: Activity, viewModelStoreOwner: ViewModelStoreOwner) : T {
        val viewModel = viewModelInitialization.invoke(activity)

        return ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(viewModel)).get(viewModel::class.java)
    }
}
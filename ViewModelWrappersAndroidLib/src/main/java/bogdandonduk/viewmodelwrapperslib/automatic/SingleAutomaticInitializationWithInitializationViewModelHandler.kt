package bogdandonduk.viewmodelwrapperslib.automatic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import bogdandonduk.viewmodelwrapperslib.core.GenericViewModelFactory

interface SingleAutomaticInitializationWithInitializationViewModelHandler<T : ViewModel> {
    var viewModelInitialization: () -> T

    fun getInitializedViewModel(viewModelStoreOwner: ViewModelStoreOwner) : T {
        val viewModel = viewModelInitialization.invoke()

        return ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(viewModel)).get(viewModel::class.java)
    }

    fun getInitializedViewModel(viewModelStore: ViewModelStore) : T {
        val viewModel = viewModelInitialization.invoke()

        return ViewModelProvider(viewModelStore, GenericViewModelFactory(viewModel)).get(viewModel::class.java)
    }
}
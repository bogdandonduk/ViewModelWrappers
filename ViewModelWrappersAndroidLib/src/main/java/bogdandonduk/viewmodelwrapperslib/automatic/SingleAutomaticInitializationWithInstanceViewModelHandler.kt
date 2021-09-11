package bogdandonduk.viewmodelwrapperslib.automatic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import bogdandonduk.viewmodelwrapperslib.core.GenericViewModelFactory

interface SingleAutomaticInitializationWithInstanceViewModelHandler<T : ViewModel> {
    var viewModelNewInstance: T

    fun getInitializedViewModel(viewModelStoreOwner: ViewModelStoreOwner) = ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(viewModelNewInstance)).get(viewModelNewInstance::class.java)

    fun getInitializedViewModel(viewModelStore: ViewModelStore) = ViewModelProvider(viewModelStore, GenericViewModelFactory(viewModelNewInstance)).get(viewModelNewInstance::class.java)
}
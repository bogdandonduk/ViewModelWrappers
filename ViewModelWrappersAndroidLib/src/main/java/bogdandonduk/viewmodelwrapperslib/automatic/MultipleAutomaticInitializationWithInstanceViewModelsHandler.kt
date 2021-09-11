package bogdandonduk.viewmodelwrapperslib.automatic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import bogdandonduk.viewmodelwrapperslib.core.ERROR_MESSAGE_INITIALIZED_MAP_CONTAINS_NO_VIEWMODEL_WITH_THIS_KEY
import bogdandonduk.viewmodelwrapperslib.core.GenericViewModelFactory

interface MultipleAutomaticInitializationWithInstanceViewModelsHandler {
    var viewModels: MutableMap<String, ViewModel>

    fun getInitializedViewModelByKey(viewModelStoreOwner: ViewModelStoreOwner, savedKey: String) : ViewModel {
        val viewModel = viewModels[savedKey] ?: throw NullPointerException(ERROR_MESSAGE_INITIALIZED_MAP_CONTAINS_NO_VIEWMODEL_WITH_THIS_KEY)

        return ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(viewModel)).get(viewModel::class.java)
    }
}
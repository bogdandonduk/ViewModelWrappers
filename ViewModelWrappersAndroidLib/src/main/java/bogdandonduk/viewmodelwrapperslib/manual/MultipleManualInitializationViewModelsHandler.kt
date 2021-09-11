package bogdandonduk.viewmodelwrapperslib.manual

import androidx.lifecycle.ViewModel

interface MultipleManualInitializationViewModelsHandler {
    /**
     * Mark the 'viewModels' property of as 'lateinit'
     */
    var viewModels: MutableMap<String, ViewModel>

    fun getViewModelByKey(savedKey: String) = viewModels[savedKey]
}
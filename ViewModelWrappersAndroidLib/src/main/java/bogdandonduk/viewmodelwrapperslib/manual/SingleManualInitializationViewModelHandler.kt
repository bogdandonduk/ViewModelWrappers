package bogdandonduk.viewmodelwrapperslib.manual

import androidx.lifecycle.ViewModel

interface SingleManualInitializationViewModelHandler<T : ViewModel> {
    /**
        * Mark the 'viewModel' property of as 'lateinit'
    */
    var viewModel: T
}
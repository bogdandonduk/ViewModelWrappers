package bogdandonduk.viewmodelwrapperslib.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import bogdandonduk.viewmodelwrapperslib.manual.MultipleManualInitializationViewModelsHandler
import bogdandonduk.viewmodelwrapperslib.manual.SingleManualInitializationViewModelHandler

object ManualViewModelInitializer {
    /**
        * Following init...() and get...() methods should be called not earlier than in onCreate() of the owner activity or fragment.
        * For this, mark the 'viewModel(s)' property of ...ViewModelHandler interfaces as 'lateinit'
    */

    fun <T : ViewModel> initSingle(viewModelStoreOwner: ViewModelStoreOwner, manualInitializationViewModelHandler: SingleManualInitializationViewModelHandler<T>, newInstance : T) : T {
        manualInitializationViewModelHandler.viewModel = ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(newInstance)).get(newInstance::class.java)

        return manualInitializationViewModelHandler.viewModel
    }

    fun <T : ViewModel> initSingle(viewModelStore: ViewModelStore, manualInitializationViewModelHandler: SingleManualInitializationViewModelHandler<T>, newInstance : T) : T {
        manualInitializationViewModelHandler.viewModel = ViewModelProvider(viewModelStore, GenericViewModelFactory(newInstance)).get(newInstance::class.java)

        return manualInitializationViewModelHandler.viewModel
    }

    inline fun <T : ViewModel> initSingle(viewModelStoreOwner: ViewModelStoreOwner, manualInitializationViewModelHandler: SingleManualInitializationViewModelHandler<T>, initialization: () -> T) : T {
        val viewModel = initialization.invoke()

        manualInitializationViewModelHandler.viewModel = ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(viewModel)).get(viewModel::class.java)

        return manualInitializationViewModelHandler.viewModel
    }

    inline fun <T : ViewModel> initSingle(viewModelStore: ViewModelStore, manualInitializationViewModelHandler: SingleManualInitializationViewModelHandler<T>, initialization: () -> T) : T {
        val viewModel = initialization.invoke()

        manualInitializationViewModelHandler.viewModel = ViewModelProvider(viewModelStore, GenericViewModelFactory(viewModel)).get(viewModel::class.java)

        return manualInitializationViewModelHandler.viewModel
    }

    fun <T : ViewModel> getSingle(viewModelStoreOwner: ViewModelStoreOwner, newInstance: T) =
        ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(newInstance)).get(newInstance::class.java)

    fun <T : ViewModel> getSingle(viewModelStore: ViewModelStore, newInstance: T) =
        ViewModelProvider(viewModelStore, GenericViewModelFactory(newInstance)).get(newInstance::class.java)

    inline fun <T : ViewModel> getSingle(viewModelStoreOwner: ViewModelStoreOwner, initialization: () -> T) : T {
        val viewModel = initialization.invoke()

        return ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(viewModel)).get(viewModel::class.java)
    }

    inline fun <T : ViewModel> getSingle(viewModelStore: ViewModelStore, initialization: () -> T) : T {
        val viewModel = initialization.invoke()

        return ViewModelProvider(viewModelStore, GenericViewModelFactory(viewModel)).get(viewModel::class.java)
    }

    fun initMultiple(viewModelStoreOwner: ViewModelStoreOwner, manualInitializationViewModelHandler: MultipleManualInitializationViewModelsHandler, vararg newInstancesWithKeys: Pair<String, ViewModel>) : MutableMap<String, ViewModel> {
        val viewModels = mutableMapOf<String, ViewModel>()

        newInstancesWithKeys.forEach { (key, value) ->
            viewModels[key] = ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(value)).get(value::class.java)
        }

        manualInitializationViewModelHandler.viewModels = viewModels

        return manualInitializationViewModelHandler.viewModels
    }

    fun initMultiple(viewModelStore: ViewModelStore, manualInitializationViewModelHandler: MultipleManualInitializationViewModelsHandler, vararg newInstancesWithKeys: Pair<String, ViewModel>) : MutableMap<String, ViewModel> {
        val viewModels = mutableMapOf<String, ViewModel>()

        newInstancesWithKeys.forEach { (key, value) ->
            viewModels[key] =  ViewModelProvider(viewModelStore, GenericViewModelFactory(value)).get(value::class.java)
        }

        manualInitializationViewModelHandler.viewModels = viewModels

        return manualInitializationViewModelHandler.viewModels
    }

    fun initMultiple(viewModelStoreOwner: ViewModelStoreOwner, manualInitializationViewModelHandler: MultipleManualInitializationViewModelsHandler, vararg initializations: () -> Pair<String, ViewModel>) : MutableMap<String, ViewModel> {
        val viewModels = mutableMapOf<String, ViewModel>()

        initializations.forEach {
            val pair = it.invoke()

            viewModels[pair.first] = ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(pair.second)).get(pair.second::class.java)
        }

        manualInitializationViewModelHandler.viewModels = viewModels

        return manualInitializationViewModelHandler.viewModels
    }

    fun initMultiple(viewModelStore: ViewModelStore, manualInitializationViewModelHandler: MultipleManualInitializationViewModelsHandler, vararg initializations: () -> Pair<String, ViewModel>) : MutableMap<String, ViewModel> {
        val viewModels = mutableMapOf<String, ViewModel>()

        initializations.forEach {
            val pair = it.invoke()

            viewModels[pair.first] = ViewModelProvider(viewModelStore, GenericViewModelFactory(pair.second)).get(pair.second::class.java)
        }

        manualInitializationViewModelHandler.viewModels = viewModels

        return manualInitializationViewModelHandler.viewModels
    }

    fun getMultiple(viewModelStoreOwner: ViewModelStoreOwner, vararg newInstancesWithKeys: Pair<String, ViewModel>) : MutableMap<String, ViewModel> {
        val viewModels = mutableMapOf<String, ViewModel>()

        newInstancesWithKeys.forEach { (key, value) ->
            viewModels[key] = ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(value)).get(value::class.java)
        }

        return viewModels
    }

    fun getMultiple(viewModelStore: ViewModelStore, vararg newInstancesWithKeys: Pair<String, ViewModel>) : MutableMap<String, ViewModel> {
        val viewModels = mutableMapOf<String, ViewModel>()

        newInstancesWithKeys.forEach { (key, value) ->
            viewModels[key] =  ViewModelProvider(viewModelStore, GenericViewModelFactory(value)).get(value::class.java)
        }

        return viewModels
    }

    fun getMultiple(viewModelStoreOwner: ViewModelStoreOwner, vararg initializations: () -> Pair<String, ViewModel>) : MutableMap<String, ViewModel> {
        val viewModels = mutableMapOf<String, ViewModel>()

        initializations.forEach {
            val pair = it.invoke()

            viewModels[pair.first] = ViewModelProvider(viewModelStoreOwner, GenericViewModelFactory(pair.second)).get(pair.second::class.java)
        }

        return viewModels
    }

    fun getMultiple(viewModelStore: ViewModelStore, vararg initializations: () -> Pair<String, ViewModel>) : MutableMap<String, ViewModel> {
        val viewModels = mutableMapOf<String, ViewModel>()

        initializations.forEach {
            val pair = it.invoke()

            viewModels[pair.first] = ViewModelProvider(viewModelStore, GenericViewModelFactory(pair.second)).get(pair.second::class.java)
        }

        return viewModels
    }
}
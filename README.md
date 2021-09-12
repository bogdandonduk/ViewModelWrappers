
# ViewModelWrappers

  Collection of wrapper interfaces to simplify your ViewModel initialization with single and multiple ViewModels support.
  
## Include in your project  
**Gradle dependency**  
  
Add this in your **app**-level **build.gradle** file:  
```groovy
dependencies {  
	...  
  
	def latest_version_tag = 2.1.2
	implementation "com.github.bogdandonduk:ViewModelWrappers:$latest_version_tag"  
  
	...  
}  
```  
You can always find the **latest_version_tag** [here](https://github.com/bogdandonduk/ViewModelWrappers/releases).  
  
Also make sure you have this repository in your **project**-level **build.gradle** file:  
```groovy  
allprojects {  
	repositories {  
		...  
  
		maven { url 'https://jitpack.io' }  
	}  
}  
```  

# Examples of usage
```kotlin 
  // implement one of the interfaces depending on which type of initialization you want
  
  class MainActivity : AppCompatActivity, SingleAutomaticInitializationWithInitializationViewModelHandlerActivity {
    override var viewModelInitialization = { intent: Intent ->
      MainActivityViewModel(repository = HomeRepositoty.getInstance(cacheFilePath = intent.dataString))
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
      ...
      
      // and get initialized ViewModel through the corresponding method without having to initialize it manually, e.g. via NewInstanceFactory.
      getInitializedViewModel(activity = this, viewModelStore = viewModelStore)
      
    }
    
  }

```


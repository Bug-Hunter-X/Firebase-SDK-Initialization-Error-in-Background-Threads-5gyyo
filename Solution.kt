To avoid this error, ensure that the Firebase app is initialized properly before calling any Firebase services, particularly when working in background threads.  Consider using a mechanism like coroutines and ensuring that Firebase initialization completes before other operations.  The following snippet shows a correct usage in a coroutine scope:

```kotlin
import kotlinx.coroutines.*

GlobalScope.launch { 
    // Initialize Firebase in the coroutine's scope
    Firebase.initializeApp(context) // replace context with your valid context
    withContext(Dispatchers.IO){ 
        //perform Firebase operations here 
    }
}
```
Proper context initialization ensures the SDK operates with the right environment and resources, thus preventing errors.
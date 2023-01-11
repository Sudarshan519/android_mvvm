import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer: DefaultLifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun  onCreate(){}
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun  onPause(){}
}

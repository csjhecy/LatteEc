package www.csj.festec;
import activitys.ProxyActivity;
import delegates.LatteDeletate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDeletate setRootDelegate() {
        return ExampleDelegate.newInstance();
    }
}

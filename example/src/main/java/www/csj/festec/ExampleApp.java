package www.csj.festec;

import android.app.Application;

import app.Latte;


public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("xxx")
                .config();
    }
}

package manhnv.test;

import android.app.Application;

/**
 * Created by root on 3/31/17.
 */

public class App extends Application {
    private static App _self;

    public static App self() {
        return _self;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _self = this;
    }
}

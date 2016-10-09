package learn.sdu.pcz.test_pull_to_refresh.app;

import android.app.Application;

import in.srain.cube.Cube;

/**
 * Created by newbee on 2016/10/8.
 */
public class CubeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // other code
        // ..

        Cube.onCreate(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        // other code
        // ...

    }
}

package learn.sdu.pcz.test_pull_to_refresh.base;

import android.os.Bundle;
import in.srain.cube.mints.base.MintsBaseActivity;
import learn.sdu.pcz.test_pull_to_refresh.PtrDemoHomeFragment;
import learn.sdu.pcz.test_pull_to_refresh.R;

public class MainActivity extends MintsBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pushFragmentToBackStack(PtrDemoHomeFragment.class, null);
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.id_fragment;
    }
}

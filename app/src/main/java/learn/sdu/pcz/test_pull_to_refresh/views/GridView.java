package learn.sdu.pcz.test_pull_to_refresh.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.srain.cube.mints.base.TitleBaseActivity;
import in.srain.cube.mints.base.TitleBaseFragment;
import learn.sdu.pcz.test_pull_to_refresh.R;

/**
 * Created by hp on 2016/10/7.
 */

public class GridView extends TitleBaseFragment {

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHeaderTitle("Grid Title");
        final View contentView = inflater.inflate(R.layout.gridview_layout, null);
//        final View gridView =  contentView.findViewById(R.id.gridview_gridview);

        return contentView;
    }
}

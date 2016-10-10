package learn.sdu.pcz.test_pull_to_refresh.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import in.srain.cube.image.CubeImageView;
import in.srain.cube.image.ImageLoader;
import in.srain.cube.image.ImageLoaderFactory;
import in.srain.cube.mints.base.TitleBaseActivity;
import in.srain.cube.mints.base.TitleBaseFragment;
import in.srain.cube.request.JsonData;
import in.srain.cube.request.RequestFinishHandler;
import in.srain.cube.util.LocalDisplay;
import in.srain.cube.views.list.ListViewDataAdapter;
import in.srain.cube.views.list.ViewHolderBase;
import in.srain.cube.views.list.ViewHolderCreator;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import learn.sdu.pcz.test_pull_to_refresh.R;
import learn.sdu.pcz.test_pull_to_refresh.data.DemoRequestData;

/**
 * Created by hp on 2016/10/7.
 */

public class Cube_GridView extends TitleBaseFragment {

    private PtrClassicFrameLayout ptrClassicFrameLayout;
    private ListViewDataAdapter<JsonData> adapter;
    private ImageLoader imageLoader;
    private static final int IMAGESIZE = (LocalDisplay.SCREEN_WIDTH_PIXELS - LocalDisplay.dp2px(12 + 12 + 10)) / 2;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHeaderTitle("Grid Title");
        final View contentView = inflater.inflate(R.layout.gridview_layout, null);
        final GridView gridView = (GridView) contentView.findViewById(R.id.gridview_gridview);
        imageLoader = ImageLoaderFactory.create(getContext());
        ptrClassicFrameLayout = (PtrClassicFrameLayout) contentView.findViewById(R.id.giridview_ptr);

        adapter = new ListViewDataAdapter<JsonData>(new ViewHolderCreator<JsonData>() {
            @Override
            public ViewHolderBase<JsonData> createViewHolder() {
                return new ViewHolder();
            }
        });
//        gridView.setAdapter(adapter);

        ptrClassicFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                updata();
            }
        });

        return contentView;

    }
    private void updata(){
        DemoRequestData.getImageList(new RequestFinishHandler<JsonData>() {
            @Override
            public void onRequestFinish(final JsonData data) {
                ptrClassicFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.getDataList().clear();
                        adapter.getDataList().addAll(data.optJson("data").optJson("list").toArrayList());
                        ptrClassicFrameLayout.refreshComplete();
                        adapter.notifyDataSetChanged();
                    }
                }, 0);
            }
        });
    }


private class ViewHolder extends ViewHolderBase<JsonData>{

    private CubeImageView img;

    @Override
    public View createView(LayoutInflater layoutInflater) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.gridview_layout_in_iamge,null);
        img = (CubeImageView) view.findViewById(R.id.gridviewlayout_gridview_adapter_img);
        LinearLayout.LayoutParams lyp = new LinearLayout.LayoutParams(IMAGESIZE, IMAGESIZE);
        img.setLayoutParams(lyp);
        return view;
    }

    @Override
    public void showData(int position, JsonData itemData) {
            String url = itemData.optString("pic");
            img.loadImage(imageLoader, url);
        }
    }
}
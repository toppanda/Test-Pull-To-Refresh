package learn.sdu.pcz.test_pull_to_refresh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.srain.cube.mints.base.BlockMenuFragment;
import in.srain.cube.util.LocalDisplay;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import learn.sdu.pcz.test_pull_to_refresh.views.Cube_WebView;
import learn.sdu.pcz.test_pull_to_refresh.views.Cube_GridView;

public class PtrDemoHomeFragment extends BlockMenuFragment {

    @Override
    protected void addItemInfo(ArrayList<MenuItemInfo> itemInfos) {

        // Cube_GridView
        itemInfos.add(newItemInfo("Grid view", R.color.cube_mints_4d90fe, new OnClickListener() {

            @Override
            public void onClick(View v) {
                getContext().pushFragmentToBackStack(Cube_GridView.class, null);
            }
        }));

        itemInfos.add(newItemInfo("知乎（With a web view）",R.color.cube_holo_blue_light, new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().pushFragmentToBackStack(Cube_WebView.class, null);
            }
        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_frame_layout, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(WithTextViewInFrameLayoutFragment.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_only_text_view, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(EvenOnlyATextView.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_list_view, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(WithListView.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_web_view, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(WithWebView.class, null);
//            }
//        }));
//
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_with_list_view_and_empty_view, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(WithListViewAndEmptyView.class, null);
//            }
//        }));
//
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_scroll_view, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(WithScrollView.class, null);
//            }
//        }));
//        itemInfos.add(null);
//        itemInfos.add(null);
//
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_keep_header, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(KeepHeader.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_hide_header, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(HideHeader.class, null);
//            }
//        }));
//
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_release_to_refresh, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(ReleaseToRefresh.class, null);
//            }
//        }));
//
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_pull_to_refresh, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(PullToRefresh.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_auto_fresh, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(AutoRefresh.class, null);
//            }
//        }));
//        itemInfos.add(null);
//
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_storehouse_header_using_string_array, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(StoreHouseUsingStringArray.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_storehouse_header_using_string, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(StoreHouseUsingString.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_storehouse_header_using_point_list, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(StoreHouseUsingPointList.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_material_style, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(MaterialStyleFragment.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_material_style_pin_content, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(MaterialStylePinContentFragment.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_with_long_press, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(WithLongPressFragment.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_block_with_view_pager, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(getContext(), ViewPagerActivity.class);
//                startActivity(intent);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_rentals_style, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(RentalsStyleFragment.class, null);
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_enable_next_ptr_at_once, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                getContext().pushFragmentToBackStack(EnableNextPTRAtOnce.class, null);
//            }
//        }));
//
//        itemInfos.add(newItemInfo(R.string.ptr_demo_placeholder, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_placeholder, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//            }
//        }));
//        itemInfos.add(newItemInfo(R.string.ptr_demo_placeholder, R.color.cube_mints_4d90fe, new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//            }
//        }));
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.createView(inflater, container, savedInstanceState);
        view.setBackgroundColor(getResources().getColor(R.color.cube_mints_333333));

        final PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.fragment_ptr_home_ptr_frame);
        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.setPadding(0, LocalDisplay.dp2px(20), 0, LocalDisplay.dp2px(20));
        header.initWithString("loading...");

        ptrFrameLayout.setDurationToCloseHeader(1500);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ptrFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrameLayout.refreshComplete();
                    }
                }, 1500);
            }
        });
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ptr_home;
    }

    @Override
    protected void setupViews(View view) {
        super.setupViews(view);
        setHeaderTitle("PTR TEST");
    }
}

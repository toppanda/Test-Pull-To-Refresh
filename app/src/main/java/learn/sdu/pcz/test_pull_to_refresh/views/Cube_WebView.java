package learn.sdu.pcz.test_pull_to_refresh.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import in.srain.cube.mints.base.TitleBaseActivity;
import in.srain.cube.mints.base.TitleBaseFragment;
import in.srain.cube.views.block.BlockListView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import learn.sdu.pcz.test_pull_to_refresh.R;

/**
 * Created by newbee on 2016/10/9.
 */
public class Cube_WebView extends TitleBaseFragment{
    private PtrClassicFrameLayout mPtrFrame;
    private WebView mWebView;
    private final String HomeUrl = "https://www.zhihu.com/topic/19556498/hot";
    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View containView = inflater.inflate(R.layout.webview_layout, null);
        mWebView = (WebView) containView.findViewById(R.id.webviewlayout_webview);
        mWebView.loadUrl(HomeUrl);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                mPtrFrame.refreshComplete();
            }
        });
        mPtrFrame = (PtrClassicFrameLayout) containView.findViewById(R.id.webview_ptrframe);
        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mWebView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                update();
            }
        });
        //
        mPtrFrame.setResistance(1.7f);
        mPtrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        mPtrFrame.setDurationToClose(200);
        mPtrFrame.setDurationToCloseHeader(1000);
        mPtrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);
        return containView;
    }

    private void update(){
        if (mWebView.getUrl() != HomeUrl){
            mWebView.loadUrl(mWebView.getUrl());
        }

    }
}




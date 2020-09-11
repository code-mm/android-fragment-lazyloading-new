package com.ms.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class HomeFragment extends BaseFragment {


    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initData() {
        super.initData();

        showProgressDialog();


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            hideProgressDialog();
                            Toast.makeText(getContext(), "加载完成", Toast.LENGTH_SHORT).show();

                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

}

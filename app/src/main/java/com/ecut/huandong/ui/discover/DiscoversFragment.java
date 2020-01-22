package com.ecut.huandong.ui.discover;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.ecut.huandong.R;
import com.ecut.huandong.adapters.IndicatorAdapter;
import com.ecut.huandong.adapters.MainContentAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

/**
 * @author Cora
 */
public class DiscoversFragment extends Fragment {
    IndicatorAdapter mIndicatorAdapter;
    private ViewPager contentPager;

    private DiscoversViewModel discoversViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        discoversViewModel = ViewModelProviders.of(this).get(DiscoversViewModel.class);
        View root = inflater.inflate(R.layout.fragment_discovers, container, false);

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MagicIndicator magicIndicator = (MagicIndicator) getActivity().findViewById(R.id.main_indicator);
        magicIndicator.setBackgroundColor(Color.parseColor("#455a64"));
        contentPager = getActivity().findViewById(R.id.content_pager);
//        initView();
//        initEvent();

    }

    private void initEvent() {
        mIndicatorAdapter.setOnIndicatorTapClickListener(new IndicatorAdapter.OnIndicatorTapClickListener() {
            @Override
            public void onTabClick(int index) {
                if (contentPager!=null){
                    contentPager.setCurrentItem(index);
                }
            }
        });

    }

    private void initView() {
        MagicIndicator magicIndicator = (MagicIndicator) getActivity().findViewById(R.id.main_indicator);
        magicIndicator.setBackgroundColor(Color.parseColor("#455a64"));
        // 创建indicator 适配器
        mIndicatorAdapter = new IndicatorAdapter(getActivity());
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(mIndicatorAdapter);
        // View Pager
        contentPager = getActivity().findViewById(R.id.content_pager);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        MainContentAdapter mainContentAdapter = new MainContentAdapter(fm);
        contentPager.setAdapter(mainContentAdapter);
//         将 view pager和indicator绑定到一起
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, contentPager);


    }
}
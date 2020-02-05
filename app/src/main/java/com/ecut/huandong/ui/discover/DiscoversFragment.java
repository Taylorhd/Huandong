package com.ecut.huandong.ui.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
    private IndicatorAdapter mIndicatorAdapter;
    private ViewPager contentPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_discovers, container, false);

        initView(root);
        initEvent();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initEvent() {
        mIndicatorAdapter.setOnIndicatorTapClickListener(new IndicatorAdapter.OnIndicatorTapClickListener() {
            @Override
            public void onTabClick(int index) {
                if (contentPager != null) {
                    contentPager.setCurrentItem(index);
                }
            }
        });

    }

    private void initView(View view) {
        MagicIndicator magicIndicator = view.findViewById(R.id.main_indicator);
        magicIndicator.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.indicator_color));
        // 创建indicator 适配器
        mIndicatorAdapter = new IndicatorAdapter(requireActivity());
        CommonNavigator commonNavigator = new CommonNavigator(requireActivity());
        commonNavigator.setAdapter(mIndicatorAdapter);
        // View Pager
        contentPager = view.findViewById(R.id.content_pager);
        FragmentManager fm = requireActivity().getSupportFragmentManager();
        MainContentAdapter mainContentAdapter = new MainContentAdapter(fm);
        contentPager.setAdapter(mainContentAdapter);
//         将 view pager和indicator绑定到一起
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, contentPager);

    }
}
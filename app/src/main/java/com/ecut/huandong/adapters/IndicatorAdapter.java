package com.ecut.huandong.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.ecut.huandong.R;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class IndicatorAdapter extends CommonNavigatorAdapter {
    private OnIndicatorTapClickListener mOnTapClickListener;
    private final String[] mTitles ;
    public IndicatorAdapter(Context context) {
            mTitles = context.getResources().getStringArray(R.array.indicator_title);
    }

    @Override
    public int getCount() {
        if (mTitles != null){
            return mTitles.length;
        }
        return 0;
    }
    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
        simplePagerTitleView.setNormalColor(Color.rgb(220,220,220));
        simplePagerTitleView.setSelectedColor(Color.WHITE);
        simplePagerTitleView.setTextSize(18);
        simplePagerTitleView.setText(mTitles[index]);
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                mViewPager.setCurrentItem(index);
  
                if (mOnTapClickListener != null) {
                    mOnTapClickListener.onTabClick(index);
                }
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
        linePagerIndicator.setColors(Color.WHITE);
        return linePagerIndicator;
    }
    public void setOnIndicatorTapClickListener(OnIndicatorTapClickListener listener){
        this.mOnTapClickListener = listener;
    }
    public interface OnIndicatorTapClickListener{
        void onTabClick(int index);
    }
}

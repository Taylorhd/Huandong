package com.ecut.huandong.ui.community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.ecut.huandong.R;
import com.ecut.huandong.base.BaseFragment;
import com.ecut.huandong.fragments.CommunityCityFragment;
import com.ecut.huandong.fragments.CommunityHomeFragment;
import com.ecut.huandong.fragments.CommunityLiveFragment;
import com.ecut.huandong.fragments.CommunitySubscribeFragment;
import com.ecut.huandong.fragments.CommunityVideoFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cora
 */
public class CommunityFragment extends Fragment {
    TabLayout  communityTablayout;
    ViewPager2 communityViewPager2;
    private static Map<Integer, Fragment> communityFragmnetCache = new HashMap<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CommunityViewModel communityViewModel = ViewModelProviders.of(this).get(CommunityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_community, container, false);
        communityTablayout = root.findViewById(R.id.community_tablayout);
        communityViewPager2 = root.findViewById(R.id.community_viewpager2);
        communityViewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Fragment fragment = communityFragmnetCache.get(position);
                if (fragment != null){
                    return  fragment;
                }
     switch (position){
         case 0: fragment =  new CommunityHomeFragment();break;
         case 1:fragment =  new CommunityVideoFragment();break;
         case 2:fragment =  new CommunityLiveFragment();break;
         case 3:fragment =  new CommunitySubscribeFragment();break;
         case 4:fragment =  new CommunityCityFragment();break;

         default: fragment =  null;
         break;
     }
                return fragment;
//
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });

        new TabLayoutMediator(communityTablayout, communityViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0 : tab.setText("首页");
                    break;
                    case 1: tab.setText("视频");
                    break;
                    case 2: tab.setText("直播");
                    break;
                    case 3: tab.setText("关注");
                    break;
                    case 4: tab.setText("同城");
                    break;
                }
            }
        }).attach();


        return root;
    }




}
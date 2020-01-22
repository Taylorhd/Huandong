package com.ecut.huandong.utils;

import com.ecut.huandong.base.BaseFragment;
import com.ecut.huandong.fragments.ArticleFragment;
import com.ecut.huandong.fragments.ConsultFragment;
import com.ecut.huandong.fragments.FollowingFragment;
import com.ecut.huandong.fragments.NewestArticleFragment;
import com.ecut.huandong.fragments.SportMallFragment;

import java.util.HashMap;
import java.util.Map;

public class FragmentCreator {
    public final static int INDEX_FOLLOWING = 0;
    public final static int INDEX_ARTICLE = 1;
    public final static int INDEX_CONSULT = 2;
    public final static int INDEX_NEWEST_ARTICLE = 3;
    public final static int INDEX_SPORT_MALL = 4;
    public final static int PAGE_COUNT = 5;
    private static final String TAG = "FragmentCreator" ;
    private static Map<Integer, BaseFragment> sCache = new HashMap<>();
    public static BaseFragment getFragment(int index){
        BaseFragment baseFragment = sCache.get(index);

        if (baseFragment != null){
            return  baseFragment;
        }
        switch ( index){
            case INDEX_FOLLOWING:
                baseFragment = new FollowingFragment();
                break;
            case INDEX_ARTICLE:
                baseFragment = new ArticleFragment();
                break;
            case INDEX_CONSULT:
                baseFragment = new ConsultFragment();
                break;
            case INDEX_NEWEST_ARTICLE:
                baseFragment = new NewestArticleFragment();
                break;
            case INDEX_SPORT_MALL:
                baseFragment = new SportMallFragment();
                break;
                default:
                    break;

        }
        sCache.put(index,baseFragment);
        return  baseFragment;
    }
}

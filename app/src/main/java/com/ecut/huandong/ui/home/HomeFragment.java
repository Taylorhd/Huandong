package com.ecut.huandong.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ecut.huandong.R;
import com.ecut.huandong.ShoppingItem;
import com.ecut.huandong.adapters.ShoppingItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cora
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private HomeViewModel homeViewModel;
    private List<ShoppingItem> shoppingItems = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CardView cardView = (CardView)getView().findViewById(R.id.cardViewInfo);
        TextView tv = (TextView)getView().findViewById(R.id.text_follow);

        //  实现recycle view ，
        initShopItem();
        RecyclerView  recyclerView = (RecyclerView) getView().findViewById(R.id.recycle_view);
        recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ShoppingItemAdapter adapter = new ShoppingItemAdapter(shoppingItems);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);        // 私信menu
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        return root;
    }

    // 实现 响应点击菜单事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_message:
                Toast.makeText(this.getActivity(),"message test",Toast.LENGTH_SHORT).show();
                return true;
                default:
                return super.onOptionsItemSelected(item);
        }

    }

    // 实现私信menu
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_home_message,menu);

    }

    private void initShopItem() {
        ShoppingItem itemList = new ShoppingItem(R.string.shopping_list,R.drawable.ic_featured_play_list_black_24dp);
        shoppingItems.add(itemList);
        ShoppingItem itemcCar = new ShoppingItem(R.string.shopping_car,R.drawable.ic_shopping_cart_black_24dp);
        shoppingItems.add(itemcCar);
        ShoppingItem itemTicket = new ShoppingItem(R.string.shopping_ticket,R.drawable.ic_coupon__black_24dp);
        shoppingItems.add(itemTicket);
        ShoppingItem itemAddress = new ShoppingItem(R.string.shopping_address,R.drawable.ic_home_black_24dp);
        shoppingItems.add(itemAddress);
        ShoppingItem itemWallet = new ShoppingItem(R.string.shopping_wallet,R.drawable.ic_account_balance_wallet_black_24dp);
        shoppingItems.add(itemWallet);
        ShoppingItem itemAccount = new ShoppingItem(R.string.shopping_account,R.drawable.ic_account_box_black_24dp);
        shoppingItems.add(itemAccount);
        ShoppingItem itemServer = new ShoppingItem(R.string.shopping_server,R.drawable.ic_person_black_24dp);
        shoppingItems.add(itemServer);
        ShoppingItem itemSetting = new ShoppingItem(R.string.shopping_setting,R.drawable.ic_settings_black_24dp);
        shoppingItems.add(itemSetting);
    }
}
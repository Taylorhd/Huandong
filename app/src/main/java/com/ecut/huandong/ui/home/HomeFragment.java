package com.ecut.huandong.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ecut.huandong.MainActivity;
import com.ecut.huandong.R;
import com.ecut.huandong.ShoppingItem;
import com.ecut.huandong.ShoppingItemAdapter;
import com.ecut.huandong.TestActivity;

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
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        CardView cardView = (CardView)root.findViewById(R.id.cardViewInfo);
        TextView tv = (TextView)root.findViewById(R.id.text_follow);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TestActivity.class);
                startActivity(intent);

            }
        });
        initShopItem();
        RecyclerView  recyclerView = (RecyclerView) root.findViewById(R.id.recycle_view);
        recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ShoppingItemAdapter adapter = new ShoppingItemAdapter(shoppingItems);
        recyclerView.setAdapter(adapter);

        return root;
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
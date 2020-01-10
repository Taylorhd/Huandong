package com.ecut.huandong;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingItemAdapter extends RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>{
    private List<ShoppingItem> mShoppingItemList;

//    static class ViewHolder extends RecyclerView.ViewHolder{
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView shoppingItemImage;
        TextView shoppingItemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shoppingItemImage = (ImageView) itemView.findViewById(R.id.shop_item_image);
            shoppingItemName = (TextView) itemView.findViewById(R.id.shop_item_text);

        }

    }
    public ShoppingItemAdapter(List<ShoppingItem> mShoppingItemList) {
        this.mShoppingItemList = mShoppingItemList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShoppingItem shoppingItem = mShoppingItemList.get(position);
        holder.shoppingItemName.setText(shoppingItem.getItemName());
        holder.shoppingItemImage.setImageResource(shoppingItem.getItemImage());

    }



    @Override
    public int getItemCount() {
        return mShoppingItemList.size();
    }
}

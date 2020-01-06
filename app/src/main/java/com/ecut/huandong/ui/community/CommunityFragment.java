package com.ecut.huandong.ui.community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ecut.huandong.R;

/**
 * @author Cora
 */
public class CommunityFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CommunityViewModel communityViewModel = ViewModelProviders.of(this).get(CommunityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_community, container, false);
        final TextView textView = root.findViewById(R.id.text_community);
        communityViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
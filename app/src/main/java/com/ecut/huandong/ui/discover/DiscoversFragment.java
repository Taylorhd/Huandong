package com.ecut.huandong.ui.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ecut.huandong.R;

/**
 * @author Cora
 */
public class DiscoversFragment extends Fragment {

    private DiscoversViewModel discoversViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        discoversViewModel =
                ViewModelProviders.of(this).get(DiscoversViewModel.class);
        View root = inflater.inflate(R.layout.fragment_discovers, container, false);
        final TextView textView = root.findViewById(R.id.text_discover);
        discoversViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
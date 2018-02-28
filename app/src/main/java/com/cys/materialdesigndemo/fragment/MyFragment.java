package com.cys.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * MyFragment
 */
public class MyFragment extends Fragment {
    public static final String TAB = "TAB";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String text = getArguments().getString(TAB);
        TextView textView = new TextView(getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        return textView;
    }
}

package com.magic.wdl.dialogdemo;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wangdongliang on 16/9/20.
 */
public class MyDialogFragment2 extends DialogFragment {
    private CommunicateInterface communicateInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(STYLE_NO_TITLE, 0);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        communicateInterface = (CommunicateInterface) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.custom_view_2, container, false);
        TextView cancel = (TextView) view.findViewById(R.id.cancel_action);
        TextView confirm = (TextView) view.findViewById(R.id.confirm_action);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicateInterface.negativeClicked();

                dismiss();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicateInterface.positiveClicked();

                dismiss();
            }
        });

        return view;
    }
}

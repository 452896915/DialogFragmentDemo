package com.magic.wdl.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by wangdongliang on 16/9/20.
 */
public class MyDialogFragment extends DialogFragment {
    CommunicateInterface communicateInterface = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        communicateInterface = (CommunicateInterface) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 设置Dialog样式和theme
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), 0);
        builder.setTitle("提示")
                //             .setMessage("确定继续？")
                .setView(getActivity().getLayoutInflater().inflate(R.layout.custom_view, null))
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        communicateInterface.positiveClicked();

                        dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        communicateInterface.negativeClicked();

                        dismiss();
                    }
                });

        Dialog dialog = builder.create();

        /* 错误的用法
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getActivity(), "Cancel now", Toast.LENGTH_SHORT).show();

                dismiss();
            }
        });

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Toast.makeText(getActivity(), "Dismiss now", Toast.LENGTH_SHORT).show();

                dismiss();
            }
        });
        */

        return dialog;
    }

    /*
    * 正确的用法
    *
    * */
    @Override
    public void onCancel(DialogInterface dialog) {
        Toast.makeText(getActivity(), "Cancel now", Toast.LENGTH_SHORT).show();

        super.onCancel(dialog);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        Toast.makeText(getActivity(), "Dismiss now", Toast.LENGTH_SHORT).show();

        super.onDismiss(dialog);
    }
}

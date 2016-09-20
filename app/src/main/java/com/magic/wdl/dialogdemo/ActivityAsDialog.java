package com.magic.wdl.dialogdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wangdongliang on 16/9/20.
 */
public class ActivityAsDialog extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_view_2);

        TextView cancel = (TextView) findViewById(R.id.cancel_action);
        TextView confirm = (TextView) findViewById(R.id.confirm_action);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityAsDialog.this, "继续下一关", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityAsDialog.this, "取消", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}

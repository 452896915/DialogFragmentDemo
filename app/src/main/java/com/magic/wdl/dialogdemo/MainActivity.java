package com.magic.wdl.dialogdemo;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CommunicateInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.setview_tv)
    public void onSetViewTVClicked(View v) {
        DialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getFragmentManager(), "dialog1");
    }

    @OnClick(R.id.oncreateview_tv)
    public void onCreateViewTVClicked(View v) {
        DialogFragment dialogFragment = new MyDialogFragment2();
        dialogFragment.show(getFragmentManager(), "dialog2");
    }

    @OnClick(R.id.show_as_dialog_tv)
    public void onShowAsDialogTVClicked(View v) {
        DialogFragment dialogFragment = new MyDialogFragment2();
        dialogFragment.show(getFragmentManager(), "dialog3");
    }

    @OnClick(R.id.show_as_fragment_tv)
    public void onShowAsFragmentTVClicked(View v) {
        DialogFragment dialogFragment = new MyDialogFragment2();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(dialogFragment, "diglog4")
                .addToBackStack(null)
                .commit();
    }

    @OnClick(R.id.activity_as_dialog_tv)
    public void onActivityAsDialogClicked(View v) {
        Intent intent = new Intent(this, ActivityAsDialog.class);
        startActivity(intent);
    }

    @Override
    public void positiveClicked() {
        Toast.makeText(this, "继续下一关", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void negativeClicked() {
        Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show();
    }
}

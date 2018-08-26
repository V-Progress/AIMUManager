package com.aimu.inventorymanage.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aimu.inventorymanage.R;
import com.aimu.inventorymanage.activity.base.BaseActivity;
import com.aimu.inventorymanage.utils.LogUtil;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.mylhyl.zxing.scanner.OnScannerCompletionListener;
import com.mylhyl.zxing.scanner.ScannerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EntryInventoryActivity extends BaseActivity {

    @BindView(R.id.scanner_view)
    ScannerView mScannerView;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void setActTitle() {
        setTitleBar(R.string.inven_lentry_title);
    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_entry_inventory);
    }

    @Override
    protected void initView() {

        //打开扫描界面扫描条形码或二维码
//        startActivity(new Intent(this, CaptureActivity.class));
        mScannerView.setOnScannerCompletionListener(new OnScannerCompletionListener() {
            @Override
            public void onScannerCompletion(Result result, ParsedResult parsedResult, Bitmap bitmap) {
                LogUtil.e("123", "扫描到了内容======" + result.getText().toString() + "===");
                tv.setText(result.getText().toString());
                mScannerView.setVisibility(View.GONE);

            }
        });
    }

    @Override
    protected void onResume() {
        mScannerView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mScannerView.onPause();
        super.onPause();
    }
}

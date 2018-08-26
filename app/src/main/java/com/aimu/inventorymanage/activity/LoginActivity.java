package com.aimu.inventorymanage.activity;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;

import com.aimu.inventorymanage.Const.Const;
import com.aimu.inventorymanage.R;
import com.aimu.inventorymanage.activity.base.BaseActivity;
import com.aimu.inventorymanage.db.DBController;
import com.aimu.inventorymanage.model.User;
import com.aimu.inventorymanage.utils.DialogUtil;
import com.aimu.inventorymanage.utils.LogUtil;
import com.aimu.inventorymanage.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.edt_phonenum_login)
    EditText edtPhonenumLogin;
    @BindView(R.id.edt_password_login)
    EditText edtPasswordLogin;
    @BindView(R.id.cb_auto_login)
    CheckBox cbAutoLogin;
    private String phoneNum;
    private String password;

    @Override
    protected void setActTitle() {
        setTitleBar(R.string.login_title);
    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.btn_singnup_login)
    public void onViewClicked() {
        phoneNum = edtPhonenumLogin.getText().toString();
        password = edtPasswordLogin.getText().toString();

        if(TextUtils.isEmpty(phoneNum)){
            DialogUtil.show1Btn(this,"手机号码不能为空");
            return;
        }

        if(!(phoneNum.length() == 11)){
            DialogUtil.show1Btn(this,"手机号码位数不正确");
            return;
        }

        if(TextUtils.isEmpty(password)){
            DialogUtil.show1Btn(this,"密码不能为空");
            return;
        }

        if(password.length() < 6 || password.length() > 11){
            DialogUtil.show1Btn(this,"密码位数不正确");
            return;
        }

        mDBController.singIn(phoneNum,password);
    }

    @Override
    public void onDBGetData(List list,boolean isSucc) {
        if(isSucc){
            DialogUtil.show1Btn(this,"登陆成功");
            jumpActivity(EntryInventoryActivity.class);
        }else{
            DialogUtil.show1Btn(this,"密码错误");
        }
    }

    @Override
    public void onDBError(Exception e) {
        DialogUtil.show1Btn(this,e.getMessage());
    }

    @Override
    public void onDBFinish() {
        super.onDBFinish();
        LogUtil.e("12131313131212121");
    }
}

package com.aimu.inventorymanage.activity;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;

import com.aimu.inventorymanage.Const.Const;
import com.aimu.inventorymanage.R;
import com.aimu.inventorymanage.activity.base.BaseActivity;
import com.aimu.inventorymanage.model.User;
import com.aimu.inventorymanage.utils.DialogUtil;
import com.aimu.inventorymanage.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

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

        BmobQuery<User> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo(Const.DB_KEY.KEY_DB_WHERE,phoneNum);
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if(list == null || list.size()<=0){
                    ToastUtil.showShort(LoginActivity.this,"未注册");
                    return;
                }

                User user = list.get(0);
                if(!TextUtils.equals(password,user.getUser_password())){
                    ToastUtil.showShort(LoginActivity.this,"密码错误");
                    return;
                }
                ToastUtil.showShort(LoginActivity.this,"登陆成功");
                jumpActivity(MainActivity.class);
            }
        });
    }
}

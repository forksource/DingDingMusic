package com.dingmouren.dingdingmusic.ui.personal;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;

import com.dingmouren.dingdingmusic.Constant;
import com.dingmouren.dingdingmusic.R;
import com.dingmouren.dingdingmusic.base.BaseActivity;
import com.dingmouren.dingdingmusic.utils.SPUtil;

import butterknife.BindView;

/**
 * Created by dingmouren on 2017/2/12.
 */

public class EditActivity extends BaseActivity {
    @BindView(R.id.edit_name) EditText mEdit;
    @BindView(R.id.btn_confim)Button mBtnConfirm;
    @Override
    public int setLayoutResourceID() {
        return R.layout.activity_edit;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTransition();
    }

    private void setTransition() {
        Slide slide1 = new Slide();
        slide1.setSlideEdge(Gravity.TOP);
        getWindow().setExitTransition(slide1);

        Slide slide2 = new Slide();
        slide2.setSlideEdge(Gravity.BOTTOM);
        getWindow().setEnterTransition(slide2);
    }

    @Override
    public void initView() {
        mBtnConfirm.setOnClickListener(view -> changeName());
    }


    @Override
    public void initData() {

    }


    private void changeName() {
        String newName = mEdit.getText().toString().trim();
        if (!TextUtils.isEmpty(newName)){
            SPUtil.put(this, Constant.USER_NAME,newName);
            Snackbar.make(mEdit,"昵称修改成功",Snackbar.LENGTH_SHORT).show();
            finish();
        }else {
            Snackbar.make(mEdit,"昵称不能为空",Snackbar.LENGTH_SHORT).show();
        }
    }
}

package cn.bpzzr.change.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bpzzr.change.R;
import cn.bpzzr.change.bean.GankTest;
import cn.bpzzr.change.bean.UserBean;
import cn.bpzzr.change.databinding.ActivityDemonstrationBinding;
import cn.bpzzr.change.interf.ServerHost;
import cn.bpzzr.change.mvp.MVP;
import cn.bpzzr.change.net.RetrofitTools;
import cn.bpzzr.change.ui.view.CustomEditText;
import cn.bpzzr.change.util.KeyBoardAdaptUtil;
import cn.bpzzr.change.util.LogUtil;

public class DemonstrationActivity extends AppCompatActivity implements MVP.Presenter,
        MVP.View, View.OnClickListener {
    ActivityDemonstrationBinding binding;
    //@BindView(R.id.ce_test)
    CustomEditText customEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_demonstration);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demonstration);
        binding.setClickListener(this);
        KeyBoardAdaptUtil.assistActivity(this);
        initialRequest();
        //initView();
    }

    private void initView() {
        //customEt = findViewById(R.id.ce_test);
        customEt.getCustomEt().setInputType(InputType.TYPE_CLASS_PHONE);
        customEt.getCustomEt().setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        customEt.clearContent(customEt.getCustomEtIvRightF());
        customEt.visualTransform(customEt.getCustomEtIvRightS());
    }

    RetrofitTools instance;

    @Override
    public void initialRequest() {
        instance = RetrofitTools.getInstance(ServerHost.BASE_URL);
        //instance.getTest(this);
        //instance.getTest2(this);
        instance.getTest3(this);
    }

    @Override
    public void onRequestStart(String tag) {
        firstSet();

    }

    private void firstSet() {
        // 初始化数据
        UserBean user = new UserBean();
        user.firstName = "Victor";
        user.lastName = "Fang";
        // 绑定数据
        binding.setUser(user);
    }

    @Override
    public void onError(String tag, String msg) {
        LogUtil.e("" + msg);
    }

    @Override
    public void onSuccess(String tag, String result, Object data) {
        if ("getTest3".equals(tag)) {
            GankTest gankTest = (GankTest) data;
            if (gankTest != null) {
                List<GankTest.ResultsBean> results = gankTest.getResults();
                if (results != null) {
                    for (int i = 0; i < results.size(); i++) {
                        if (i == 0) {
                            GankTest.ResultsBean resultsBean = results.get(i);
                            LogUtil.e("resultsBean......" + resultsBean);
                            UserBean user = new UserBean();
                            user.firstName = resultsBean.getDesc();
                            user.lastName = resultsBean.getCreatedAt();
                            // 绑定数据
                            binding.setUser(user);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onEmpty(String tag) {

    }

    @Override
    public void onClick(View v) {
        LogUtil.e("click....." + v);
    }
}

package cn.bpzzr.change.ui.fragment;

import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import cn.bpzzr.change.R;
import cn.bpzzr.change.adapter.Adapter2FilterSelectMore;
import cn.bpzzr.change.adapter.MyFilterBarAdapter;
import cn.bpzzr.change.bean.FilterBarData;
import cn.bpzzr.change.bean.FilterRadioData;
import cn.bpzzr.change.bean.RecommendCondition;
import cn.bpzzr.change.bean.SkillWordBean;
import cn.bpzzr.change.bean.SubTagBean;
import cn.bpzzr.change.ui.fragment.base.BaseFragment;
import cn.bpzzr.change.ui.page.FilterSelectMorePage;
import cn.bpzzr.change.ui.page.FilterSelectOnePage;
import cn.bpzzr.change.ui.view.DropDownView;
import cn.bpzzr.change.ui.view.LinearContainer;
import cn.bpzzr.change.util.LogUtil;

/**
 * Created by Administrator on 2018/2/1.
 * 我的
 */

public class MineFragment extends BaseFragment implements MyFilterBarAdapter.OnTabClickListener {
    @BindView(R.id.btn_setting)
    AppCompatButton btnSetting;
    Unbinder unbinder;
    @BindView(R.id.lc_con)
    LinearContainer lcCon;
    private static final String[] FILTER_CONDITION_BAR = new String[]{
            "活跃", "推荐", "技能", "地区", "阶段", "行业"
    };

    @Override
    public boolean isNeedLazy() {
        return false;
    }

    @Override
    public int getRootViewLayoutId() {
        return R.layout.fragment_mine;
    }

    List<FilterRadioData> recommendConditions;

    @Override
    public void viewHasBind() {
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到下载管理页

            }
        });
        List<FilterBarData> filterBarDataList = new ArrayList<>();
        //1.无下拉菜单
        filterBarDataList.add(new FilterBarData<>(FILTER_CONDITION_BAR[0], "活跃", FilterBarData.NONE));
        //2.单选下拉菜单
        recommendConditions = new ArrayList<>();
        recommendConditions.add(new FilterRadioData<>(
                new RecommendCondition("0", "推荐"), true));
        recommendConditions.add(new FilterRadioData<>(
                new RecommendCondition("1", "最新"), false));
        filterBarDataList.add(new FilterBarData<>(FILTER_CONDITION_BAR[1], recommendConditions,
                FilterBarData.SELECT_ONE));

        List<SkillWordBean> skillWordBeans = new ArrayList<>();
        List<SubTagBean> subTagBeans = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            subTagBeans.add(new SubTagBean("技能" + i, i, Adapter2FilterSelectMore.ITEM_TYPE_TITLE));
            for (int j = 0; j < 2 * i + 5; j++) {
                subTagBeans.add(new SubTagBean("标签" + j, j, Adapter2FilterSelectMore.ITEM_TYPE_TAG));
            }
        }
        //3.标签式多选
        filterBarDataList.add(new FilterBarData<>(FILTER_CONDITION_BAR[2], subTagBeans,
                FilterBarData.SELECT_MORE));
        //4.级联式多选

        //filterBarDataList.add(new FilterBarData<>(FILTER_CONDITION_BAR[1],""));

        /*for (int i = 0; i < FILTER_CONDITION_BAR.length; i++) {
            filterBarDataList.add(new FilterBarData<>(FILTER_CONDITION_BAR[i], "数据" + i, 0));
        }*/
        lcCon.setAdapter(new MyFilterBarAdapter(filterBarDataList, mActivity, this));

    }

    @Override
    public void clickTab(View itemView, ViewGroup parent, int position,
                         boolean showPage, DropDownView dropDownView, FilterBarData filterBarData) {
        if (dropDownView == null) {
            LogUtil.e(mFragmentTag + getTag(), "dropDownView is null !");
            return;
        }
        switch (position) {
            case 0:
                LogUtil.e(mFragmentTag + getTag(), "直接筛选");
                break;
            case 1:
                if (showPage) {
                    dropDownView.initPop(parent,
                            new FilterSelectOnePage(mActivity,
                                    (List<FilterRadioData>) filterBarData.getExtraData()));
                }
                break;
            case 2:
                if (showPage) {
                    dropDownView.initPop(parent,
                            new FilterSelectMorePage(mActivity,
                                    (List<SubTagBean>) filterBarData.getExtraData()));
                }
                break;
        }
    }

    @Override
    public void initialRequest() {

    }

}

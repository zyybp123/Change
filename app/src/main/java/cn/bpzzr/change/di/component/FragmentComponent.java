package cn.bpzzr.change.di.component;

import cn.bpzzr.change.di.module.FragmentModule;
import cn.bpzzr.change.ui.fragment.base.BaseFragment;
import dagger.Component;

/**
 * Created by Administrator on 2018/3/2.
 */

@Component(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(BaseFragment baseFragment);
}

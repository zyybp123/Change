/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package cn.bpzzr.change.di.module;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import cn.bpzzr.change.di.scope.ContextLife;
import cn.bpzzr.change.di.scope.PerFragment;
import dagger.Module;
import dagger.Provides;

/**
 * module 类
 * 作用是提供对象
 * 被@Provides注解所标记的方法会被查询到（查询是按返回值类型查询）
 * 查询规则：
 * 步骤1：查找Module中是否存在创建该类的方法。
 * 步骤2：若存在创建类方法，查看该方法是否存在参数
 * 步骤2.1：若存在参数，则按从步骤1开始依次初始化每个参数
 * 步骤2.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
 * 步骤3：若不存在创建类方法，则查找Inject注解的构造函数，看构造函数是否存在参数
 * 步骤3.1：若存在参数，则从步骤1开始依次初始化每个参数
 * 步骤3.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
 */
@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    public Activity provideActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    public Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    public Fragment getMFragment() {
        return mFragment;
    }
}

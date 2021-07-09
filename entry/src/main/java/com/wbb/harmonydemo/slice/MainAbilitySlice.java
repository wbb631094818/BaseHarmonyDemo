package com.wbb.harmonydemo.slice;

import com.wbb.harmonydemo.ResourceTable;
import com.wbb.harmonydemo.SecondAbility;
import com.wbb.harmonydemo.utils.Utils;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

/**
 *  AbilitySlice  相当于前端的vue各个路由，Android的fragment。
 *
 *  在前端vue来说，页面一个Ability多个路由AbilitySlice。单页面结构
 *  多个Ability就是多页面结构
 *
 *  Ability相对Android来说就是activity
 */
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button bt = (Button) findComponentById(ResourceTable.Id_bt);
        bt.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                // 点击事件，点击后去第二个页面
                Utils.openNewPage(MainAbilitySlice.this, SecondAbility.class);
            }
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}

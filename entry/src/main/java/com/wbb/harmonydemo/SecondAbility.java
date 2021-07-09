package com.wbb.harmonydemo;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

/**
 * 第二个测试页面
 *
 */
public class SecondAbility extends Ability {

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_second);

    }
}

package com.wbb.harmonydemo;

import com.wbb.harmonydemo.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

/**
 * 对应activity
 */
public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
//        super.setUIContent(ResourceTable.Layout_ability_main);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}

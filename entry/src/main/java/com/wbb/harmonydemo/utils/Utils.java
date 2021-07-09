package com.wbb.harmonydemo.utils;

import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.app.Context;

/**
 *  工具类
 */
public class Utils {

    /**
     *  跳转到一个新的页面
     * @param context
     * @param cls
     */
    public static void openNewPage(Context context,Class<?> cls){
        // 跳转
        Intent intent = new Intent();
        Operation operation = new Intent.OperationBuilder()
                .withAction(Intent.ACTION_QUERY_WEATHER)
                .withDeviceId("")
                .withBundleName(context.getBundleName())
                .withAbilityName(cls)
                .build();
        intent.setOperation(operation);
        context.startAbility(intent,200);
    }
}

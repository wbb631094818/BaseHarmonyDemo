package com.wbb.harmonydemo.component;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.render.Canvas;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.multimodalinput.event.TouchEvent;

/**
 * 自定义组件   自定义view
 * https://developer.harmonyos.com/cn/docs/documentation/doc-guides/ui-java-custom-components-0000001139369661
 */
public class CustomComponent extends Component implements Component.DrawTask, Component.EstimateSizeListener , Component.TouchEventListener{
    public CustomComponent(Context context) {
        super(context);
        init();
    }

    public CustomComponent(Context context, AttrSet attrSet) {
        super(context, attrSet);
        init();
    }

    public CustomComponent(Context context, AttrSet attrSet, String styleName) {
        super(context, attrSet, styleName);
        init();
    }

    public CustomComponent(Context context, AttrSet attrSet, int resId) {
        super(context, attrSet, resId);
        init();
    }

    private final HiLogLabel LABLE = new HiLogLabel(HiLog.DEBUG,0x00201,"wbb");

    // 圆环宽度
    private static final float CIRCLE_STROKE_WIDTH = 100f;
    // 绘制圆环的画笔
    private Paint circlePaint;
    private int width = 500,height=500;

    private void init() {
        // 初始化画笔
        initPaint();
        // 设置测量组件的侦听器
        setEstimateSizeListener(this);
        // 添加绘制任务
        addDrawTask(this);
        // 设置TouchEvent响应事件
        setTouchEventListener(this);
    }

    private void initPaint() {
        circlePaint = new Paint();
        circlePaint.setColor(Color.BLUE);
        circlePaint.setStrokeWidth(CIRCLE_STROKE_WIDTH);
        circlePaint.setStyle(Paint.Style.STROKE_STYLE);
    }

    // 对组件进行测量监听
    // 自定义组件测量出的大小需通过setEstimatedSize设置给组件，并且必须返回true使测量值生效。
    @Override
    public boolean onEstimateSize(int widthEstimateConfig, int heightEstimateConfig) {
         width = Component.EstimateSpec.getSize(widthEstimateConfig);
         height = Component.EstimateSpec.getSize(heightEstimateConfig);

        // 将测量的宽高
        setEstimatedSize(
                Component.EstimateSpec.getChildSizeWithMode(width, width, Component.EstimateSpec.NOT_EXCEED),
                Component.EstimateSpec.getChildSizeWithMode(height, height, Component.EstimateSpec.NOT_EXCEED));
        return true;
    }

    @Override
    public void onDraw(Component component, Canvas canvas) {
        // 在界面中绘制一个圆心坐标为(500,500),半径为400的圆
        canvas.drawCircle(width/2, height/2, 400, circlePaint);
    }

    // 事件监听
    @Override
    public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
        HiLog.error(LABLE, "touchEvent.getAction(): "+touchEvent.getAction());
        switch (touchEvent.getAction()) {
            case TouchEvent.PRIMARY_POINT_DOWN:
                if (circlePaint.getColor() == Color.GREEN){
                    circlePaint.setColor(Color.YELLOW);
                }else{
                    circlePaint.setColor(Color.GREEN);
                }
                HiLog.error(LABLE, "PRIMARY_POINT_DOWN");
                // 刷新UI
                invalidate();
                break;
            case TouchEvent.PRIMARY_POINT_UP:

                HiLog.error(LABLE, "PRIMARY_POINT_UP");
                circlePaint.setColor(Color.YELLOW);
                invalidate();
                break;
        }
        return false;
    }
}

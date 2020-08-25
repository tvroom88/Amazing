package com.example.myapplication.utils;

import android.view.animation.*;

/**
 * Created with IntelliJ IDEA.
 * User: LeeJaeHoon
 * Date: 13. 11. 6
 * Time: 오후 2:38
 * To change this template use File | Settings | File Templates.
 */
public class AnimationUtil {

    public static TranslateAnimation getTranslateAnimation(float old_x, float new_x, float old_y, float new_y, int duration)
    {
        TranslateAnimation transition = new TranslateAnimation(old_x, new_x, old_y, new_y);
        transition.setDuration(duration);
        return transition;
    }

    public static ScaleAnimation getScaleAnimation(float old_ratio_x, float new_ratio_x, float old_ratio_y, float new_ratio_y, int duration)
    {
        ScaleAnimation scale = new ScaleAnimation(old_ratio_x, new_ratio_x
                , old_ratio_y, new_ratio_y
                , Animation.RELATIVE_TO_SELF, 0.5f
                , Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(duration);
        return scale;
    }

    public static AlphaAnimation getAlphaAnimation(float old_alpha, float new_alpha, int duration)
    {
        AlphaAnimation alpha = new AlphaAnimation(old_alpha, new_alpha);
        alpha.setDuration(duration);
        return alpha;
    }

    public static RotateAnimation getRotationAnimation(float old_angle, float new_angle, int duration)
    {
        RotateAnimation rotation = new RotateAnimation(old_angle, new_angle
                , Animation.RELATIVE_TO_SELF, 0.5f
                , Animation.RELATIVE_TO_SELF, 0.5f);
        rotation.setDuration(duration);
        return rotation;
    }
}

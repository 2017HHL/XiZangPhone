package com.mingnong.xizangphone.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.view.datapicker.LoopListener;
import com.mingnong.xizangphone.view.datapicker.LoopView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by wyw on 2016/11/2.
 */

public class PickerDateDialog extends Dialog {
    private static final int MIN_YEAR = 2010;
    private Params params;

    public PickerDateDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    private void setParams(PickerDateDialog.Params params) {
        this.params = params;
    }

    public interface OnDateSelectedListener {
        void onDateSelected(int[] dates);
    }

    private static final class Params {
        private boolean shadow = true;
        private boolean canCancel = true;
        private LoopView loopYear, loopMonth, loopDay;
        private OnDateSelectedListener callback;
    }

    public static class Builder {
        private final Context context;
        private final PickerDateDialog.Params params;

        public Builder(Context context) {
            this.context = context;
            params = new PickerDateDialog.Params();
        }

        /**
         * 获取当前选择的日期
         *
         * @return int[]数组形式返回。例[1990,6,15]
         */
        private final int[] getCurrDateValues() {
            int currYear = Integer.parseInt(params.loopYear.getCurrentItemValue());
            int currMonth = Integer.parseInt(params.loopMonth.getCurrentItemValue());
            int currDay = Integer.parseInt(params.loopDay.getCurrentItemValue());
            return new int[]{currYear, currMonth, currDay};
        }

        public Builder setOnDateSelectedListener(OnDateSelectedListener onDateSelectedListener) {
            params.callback = onDateSelectedListener;
            return this;
        }


        public PickerDateDialog create() {
            final PickerDateDialog dialog = new PickerDateDialog(context, params.shadow ? R.style.Theme_Light_NoTitle_Dialog : R.style.Theme_Light_NoTitle_NoShadow_Dialog);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_picker_three, null);
            Calendar c = Calendar.getInstance();
            final LoopView loopDay = (LoopView) view.findViewById(R.id.loop3);
//            c.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH),1);
//            c.roll(Calendar.DATE, false);
            loopDay.setArrayList(d(1, getMaxDay()));
            loopDay.setCurrentItem(c.get(Calendar.DAY_OF_MONTH)-1);
            loopDay.setNotLoop();

            int year = c.get(Calendar.YEAR);
            final LoopView loopYear = (LoopView) view.findViewById(R.id.loop1);
            loopYear.setArrayList(d(MIN_YEAR, year - MIN_YEAR + 10));
            loopYear.setCurrentItem(c.get(Calendar.YEAR) - MIN_YEAR);
            loopYear.setNotLoop();

            final LoopView loopMonth = (LoopView) view.findViewById(R.id.loop2);
            loopMonth.setArrayList(d(1, 12));
            loopMonth.setCurrentItem(c.get(Calendar.MONTH));
            loopMonth.setNotLoop();

            final LoopListener maxDaySyncListener = new LoopListener() {
                @Override
                public void onItemSelect(int item) {
                    Calendar c = Calendar.getInstance();
                    c.set(Integer.parseInt(loopYear.getCurrentItemValue()), Integer.parseInt(loopMonth.getCurrentItemValue()) - 1, 1);
                    c.roll(Calendar.DATE, false);
                    int maxDayOfMonth = c.get(Calendar.DATE);
                    int fixedCurr = loopDay.getCurrentItem();
                    loopDay.setArrayList(d(1, maxDayOfMonth));
                    // 修正被选中的日期最大值
                    if (fixedCurr > maxDayOfMonth) fixedCurr = maxDayOfMonth - 1;
                    loopDay.setCurrentItem(fixedCurr);
                }
            };
            loopYear.setListener(maxDaySyncListener);
            loopMonth.setListener(maxDaySyncListener);

            view.findViewById(R.id.tv_finish).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    params.callback.onDateSelected(getCurrDateValues());
                }
            });

            Window win = dialog.getWindow();
            win.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams lp = win.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            win.setAttributes(lp);
            win.setGravity(Gravity.BOTTOM);
            win.setWindowAnimations(R.style.Animation_Bottom_Rising);

            dialog.setContentView(view);
            dialog.setCanceledOnTouchOutside(params.canCancel);
            dialog.setCancelable(params.canCancel);

            params.loopYear = loopYear;
            params.loopMonth = loopMonth;
            params.loopDay = loopDay;
            dialog.setParams(params);
            return dialog;
        }

        /**
         * 将数字传化为集合，并且补充0
         *
         * @param startNum 数字起点
         * @param count    数字个数
         * @return
         */
        private static List<String> d(int startNum, int count) {
            String[] values = new String[count];
            for (int i = startNum; i < startNum + count; i++) {
                String tempValue = (i < 10 ? "0" : "") + i;
                values[i - startNum] = tempValue;
            }
            return Arrays.asList(values);
        }

        /**
         * 获取当前月份的最大天数
         * @return
         */
        private int getMaxDay() {
            Calendar c = Calendar.getInstance();
            c.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH),1);
            c.roll(Calendar.DATE, false);
            return c.get(Calendar.DATE);
        }
    }
}

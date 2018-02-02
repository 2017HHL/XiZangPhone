package com.mingnong.xizangphone.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.CodeAnimal;
import com.mingnong.xizangphone.dao.external.DBExternalController;
import com.mingnong.xizangphone.dao.external.CodeAnimalDao;
import com.mingnong.xizangphone.dao.external.CoderDao;
import com.mingnong.xizangphone.view.datapicker.LoopListener;
import com.mingnong.xizangphone.view.datapicker.LoopView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wyw on 2016/11/4.
 * 两级联动对话框->种类
 */

public class PickerAnimKindDialog extends Dialog {
    private Params params;

    public PickerAnimKindDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    private void setParams(PickerAnimKindDialog.Params params) {
        this.params = params;
    }


    public interface OnRegionSelectedListener {
        void onSelected(String[] select);
    }


    private static final class Params {
        private boolean shadow = true;
        private boolean canCancel = true;
        private LoopView loop1;
        private LoopView loop2;
        private int initSelection;
        private OnRegionSelectedListener callback;
        private List<CodeAnimal> first;
        private Map<String,List<CodeAnimal>> second;

    }

    public static class Builder {
        private final Context context;
        private final PickerAnimKindDialog.Params params;

        public Builder(Context context) {
            this.context = context;
            params = new PickerAnimKindDialog.Params();
        }

        /**
         *
         * return string[0] 一级种类
         * string[1] 二级种类 没有2级种类传""
         * string[2] 单位
         */
        private final String[] getValue() {
            String fdw;
            CoderDao coderDao = DBExternalController.getDaoSession().getCoderDao();
            CodeAnimal firstAnim = params.first.get(params.loop1.getCurrentItem());
            if (params.loop2.getCurrentItemValue().equals("无")) {
                fdw = firstAnim.getFDw();
            } else {
                fdw = params.second.get(firstAnim.getTId()).get(params.loop2.getCurrentItem()).getFDw();
            }
            //单位
            String unit = coderDao.queryBuilder().where(CoderDao.Properties.CId.eq(fdw)).build().list().get(0).getCName();
            return new String[]{params.loop1.getCurrentItemValue(),
                    params.loop2.getCurrentItemValue().equals("无")?"":params.loop2.getCurrentItemValue(),unit};
        }

        public Builder setSelection(int initSelection) {
            params.initSelection = initSelection;
            return this;
        }

        public Builder setOnRegionSelectedListener(OnRegionSelectedListener onRegionSelectedListener) {
            params.callback = onRegionSelectedListener;
            return this;
        }

        public Builder buildData() {
            params.first = buildFirst();
            params.second = buildSecond(params.first);
            return this;
        }

        /**
         * 猪牛羊
         * @return
         */
        private List<CodeAnimal> buildFirst() {
            //获取数据库,读取数据
            CodeAnimalDao animalDao = DBExternalController.getDaoSession().getCodeAnimalDao();
            return animalDao.queryBuilder().where(CodeAnimalDao.Properties.CParent.eq("1000")).build().list();
        }

        /**
         * 第二层
         * @param firstList
         * @return
         */
        private Map<String, List<CodeAnimal>> buildSecond(List<CodeAnimal> firstList) {
            HashMap<String, List<CodeAnimal>> map = new HashMap<>();
            CodeAnimalDao codeAnimalDao = DBExternalController.getDaoSession().getCodeAnimalDao();
            for (CodeAnimal anim : firstList) {
                List<CodeAnimal> list = codeAnimalDao.queryBuilder().where(CodeAnimalDao.Properties.CParent.eq(anim.getTId())).build().list();
                if (list == null ||list.size() ==0) {
                    list = new ArrayList<>();
                    CodeAnimal entity = new CodeAnimal();
                    entity.setCName("无");
                    entity.setFDw("17");
                    list.add(entity);
                }
                map.put(anim.getTId(),list);
            }
            return map;
        }

        public PickerAnimKindDialog create() {
            final PickerAnimKindDialog dialog = new PickerAnimKindDialog(context, params.shadow ? R.style.Theme_Light_NoTitle_Dialog : R.style.Theme_Light_NoTitle_NoShadow_Dialog);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_picker_second, null);

            view.findViewById(R.id.tv_finish).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    params.callback.onSelected(getValue());
                }
            });

            final LoopView loop1 = (LoopView) view.findViewById(R.id.loop1);
            loop1.setArrayList(getList(params.first));
            loop1.setNotLoop();
            loop1.setCurrentItem(0);
//            if (params.first.size() > 0) loop1.setCurrentItem(params.initSelection);

            final LoopView loop2 = (LoopView) view.findViewById(R.id.loop2);
            String select = params.first.get(1).getTId();
            loop2.setArrayList(getList(params.second.get(select)));
            loop2.setNotLoop();
            loop2.setCurrentItem(0);

            loop1.setListener(new LoopListener() {
                @Override
                public void onItemSelect(int item) {
                    List<CodeAnimal> codeAnimals = params.second.get(params.first.get(item).getTId());
                    loop2.setArrayList(getList(codeAnimals));
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

            params.loop1 = loop1;
            params.loop2 = loop2;
            dialog.setParams(params);

            return dialog;
        }
        private List<String> getList(List<CodeAnimal> source) {
            if (source == null) return new ArrayList<>();
            List<String> result = new ArrayList<>();
            for (CodeAnimal unit : source) {
                result.add(unit.getCName());
            }
            return result;
        }
    }
}

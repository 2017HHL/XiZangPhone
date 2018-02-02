package com.mingnong.xizangphone.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.CodeProduct;
import com.mingnong.xizangphone.dao.external.CodeProductDao;
import com.mingnong.xizangphone.dao.external.CoderDao;
import com.mingnong.xizangphone.dao.external.DBExternalController;
import com.mingnong.xizangphone.view.datapicker.LoopListener;
import com.mingnong.xizangphone.view.datapicker.LoopView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wyw on 2016/11/2.
 * 产品种类 三级对跨框
 */

public class PickerProductKindDialog extends Dialog {
    private Params params;

    public PickerProductKindDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    private void setParams(PickerProductKindDialog.Params params) {
        this.params = params;
    }

    public interface OnDateSelectedListener {
        void onDateSelected(String[] dates);
    }

    private static final class Params {
        private boolean shadow = true;
        private boolean canCancel = true;
        private String title = "请选择种类";
        private LoopView loop1, loop2, loop3;
        private List<CodeProduct> firstData;
        private HashMap<String, List<CodeProduct>> secondData, thirdData;
        private OnDateSelectedListener callback;
    }

    public static class Builder {
        private final Context context;
        private final PickerProductKindDialog.Params params;

        public Builder(Context context) {
            this.context = context;
            params = new PickerProductKindDialog.Params();
        }

        public Builder setTitle(String title) {
            params.title = title;
            return this;
        }

        private final String[] getCurrDateValues() {
            String fdw = params.secondData.get(params.firstData.get(params.loop1.getCurrentItem())
                    .getTId()).get(params.loop2.getCurrentItem()).getFDw();
//            if (params.loop3.getCurrentItemValue().equals("")) {
//                //获取第二列的单位
//                fdw = params.secondData.get(params.loop2.getCurrentItemValue()).
//                         get(params.loop2.getCurrentItem()).getFDw();
//            } else {
//                //获取第三列的单位
//                fdw = params.thirdData.get(params.loop3.getCurrentItemValue()).
//                        get(params.loop3.getCurrentItem()).getFDw();
//            }
            //单位
            String unit = DBExternalController.getDaoSession().getCoderDao().
                    queryBuilder().where(CoderDao.Properties.CId.eq(fdw)).build().list().get(0).getCName();
            return new String[]{params.loop1.getCurrentItemValue(),
                    params.loop2.getCurrentItemValue(),
                    params.loop3.getCurrentItemValue().equals("")?"":params.loop3.getCurrentItemValue()
                    ,unit};
        }

        public Builder setOnDateSelectedListener(OnDateSelectedListener onDateSelectedListener) {
            params.callback = onDateSelectedListener;
            return this;
        }


        public Builder buildData() {
            params.firstData = buildFirstData();
            new Thread(){
                @Override
                public void run() {
                    params.secondData = buildSecondData(params.firstData);
                    params.thirdData = buildThirdData(params.secondData);
                }
            }.start();
            return this;
        }

        private List<CodeProduct> buildFirstData() {
            //获取数据库,读取数据
            CodeProductDao codeProductDao = DBExternalController.getDaoSession().getCodeProductDao();
            //获取第一列的数据
            return codeProductDao.queryBuilder().where(CodeProductDao.Properties.CParent.eq("200")).build().list();
        }

        private HashMap<String, List<CodeProduct>> buildSecondData(List<CodeProduct> province) {
            HashMap<String, List<CodeProduct>> cityData = new HashMap<>();
            CodeProductDao codeProductDao = DBExternalController.getDaoSession().getCodeProductDao();
            //省
            for (CodeProduct unit : province) {
                List<CodeProduct> list = codeProductDao.queryBuilder().where(CodeProductDao.Properties.CParent.eq(unit.getTId())).build().list();
                cityData.put(unit.getTId(), list);
            }
            return cityData;
        }

        private HashMap<String, List<CodeProduct>> buildThirdData(HashMap<String, List<CodeProduct>> cityData) {
            HashMap<String, List<CodeProduct>> countryDate = new HashMap<>();
            CodeProductDao codeProductDao = DBExternalController.getDaoSession().getCodeProductDao();
            for (String key : cityData.keySet()) {
                for (CodeProduct city : cityData.get(key)) {
                    List<CodeProduct> list = codeProductDao.queryBuilder().where(CodeProductDao.Properties.CParent.eq(city.getTId())).build().list();
                    if (list == null ||list.size() ==0) {
                        list = new ArrayList<>();
                        CodeProduct entity = new CodeProduct();
                        entity.setCName("");
                        list.add(entity);
                    }
                    countryDate.put(city.getTId(), list);
                }
            }
            return countryDate;
        }


        public PickerProductKindDialog create() {
            final PickerProductKindDialog dialog = new PickerProductKindDialog(context, params.shadow ? R.style.Theme_Light_NoTitle_Dialog : R.style.Theme_Light_NoTitle_NoShadow_Dialog);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_picker_three, null);
            view.findViewById(R.id.tv_first).setVisibility(View.GONE);
            view.findViewById(R.id.tv_second).setVisibility(View.GONE);
            view.findViewById(R.id.tv_third).setVisibility(View.GONE);

            //数据库中读取数据
            final LoopView loopProvince = (LoopView) view.findViewById(R.id.loop1);
            loopProvince.setArrayList(getList(params.firstData));
            loopProvince.setNotLoop();
            loopProvince.setCurrentItem(0);//湖南省

            final LoopView loopCity = (LoopView) view.findViewById(R.id.loop2);
            CodeProductDao codeProductDao = DBExternalController.getDaoSession().getCodeProductDao();

            List<CodeProduct> cityList = codeProductDao.queryBuilder().
                    where(CodeProductDao.Properties.CParent.eq(params.firstData.get(0).getTId())).build().list();
            List<String> cityListString = getList(cityList);
            loopCity.setArrayList(cityListString);
            loopCity.setNotLoop();
            loopCity.setCurrentItem(1);

            final LoopView loopCountry = (LoopView) view.findViewById(R.id.loop3);
            //县
            List<CodeProduct> countryList =codeProductDao.queryBuilder().
                    where(CodeProductDao.Properties.CParent.eq(cityList.get(1).getTId())).build().list();
            loopCountry.setArrayList(getList(countryList));
            loopCountry.setNotLoop();
            loopCountry.setCurrentItem(0);


            final LoopListener provinceListener = new LoopListener() {
                @Override
                public void onItemSelect(int item) {
                    String tid = params.firstData.get(item).getTId();
                    List<String> list = getList(params.secondData.get(tid));
                    loopCity.setArrayList(list);
                }
            };
            final LoopListener cityListener = new LoopListener() {
                @Override
                public void onItemSelect(int item) {
                    //首先获取选中省的index
                    String provinceTid = params.firstData.get(loopProvince.getCurrentItem()).getTId();
                    String cityTid = params.secondData.get(provinceTid).get(item).getTId();
                    List<String> list = getList(params.thirdData.get(cityTid));
                    loopCountry.setArrayList(list);
                }
            };
            new Thread(){
                @Override
                public void run() {
                    while (params.thirdData == null) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    loopProvince.setListener(provinceListener);
                    loopCity.setListener(cityListener);
                }
            }.start();


            ((TextView) view.findViewById(R.id.tv_title)).setText(params.title);
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

            params.loop1 = loopProvince;
            params.loop2 = loopCity;
            params.loop3 = loopCountry;
            dialog.setParams(params);
            return dialog;
        }

        private List<String> getList(List<CodeProduct> source) {
            if (source == null) return new ArrayList<>();
            List<String> result = new ArrayList<>();
            for (CodeProduct unit : source) {
                result.add(unit.getCName());
            }
            return result;
        }
    }
}

package com.mingnong.xizangphone.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.Unit;
import com.mingnong.xizangphone.dao.external.DBExternalController;
//import com.mingnong.xizangphone.dao.external.UnitDao;
import com.mingnong.xizangphone.view.datapicker.LoopListener;
import com.mingnong.xizangphone.view.datapicker.LoopView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wyw on 2016/11/2.
 */

public class PickerRegionDialog extends Dialog {
    private Params params;

    public PickerRegionDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    private void setParams(PickerRegionDialog.Params params) {
        this.params = params;
    }

    public interface OnDateSelectedListener {
        void onDateSelected(String[] dates);
    }

    /**
     * 是否是省内 有bug 先选省外 再省内 省不对
     * @param isInner
     */
    public void show(boolean isInner) {
        super.show();
        if (isInner) {
            params.province.setVisibility(View.GONE);
        } else {
            params.province.setVisibility(View.VISIBLE);
        }
    }

    private static final class Params {
        private boolean shadow = true;
        private boolean canCancel = true;
        private String title = "请选择地区";
        private LoopView province, city, country;
        private List<Unit> provinceData;
        private HashMap<String, List<Unit>> cityData, countryData;
        private OnDateSelectedListener callback;
    }

    public static class Builder {
        private final Context context;
        private final PickerRegionDialog.Params params;

        public Builder(Context context) {
            this.context = context;
            params = new PickerRegionDialog.Params();
        }

        public Builder setTitle(String title) {
            params.title = title;
            return this;
        }

        /**
         * 获取当前选择的日期
         *
         * @return int[]数组形式返回。例[1990,6,15]
         */
        private final String[] getCurrDateValues() {
            String currYear = params.province.getCurrentItemValue();
            String currMonth = params.city.getCurrentItemValue();
            String currDay = params.country.getCurrentItemValue();
            return new String[]{currYear, currMonth, currDay};
        }

        public Builder setOnDateSelectedListener(OnDateSelectedListener onDateSelectedListener) {
            params.callback = onDateSelectedListener;
            return this;
        }


//        public Builder buildData() {
//            params.provinceData = buildProvinceData();
//            new Thread(){
//                @Override
//                public void run() {
//                    params.cityData = buildCityData(params.provinceData);
//                    params.countryData = buildCountryData(params.cityData);
//                }
//            }.start();
//            return this;
//        }

        /**
         * 省外 到达地 没有湖南省
         * @return
         */
//        public Builder buildDataOutter() {
//            params.provinceData = buildProvinceDataOutter();
//            new Thread(){
//                @Override
//                public void run() {
//                    params.cityData = buildCityData(params.provinceData);
//                    params.countryData = buildCountryData(params.cityData);
//                }
//            }.start();
//            return this;
//        }

//        private List<Unit> buildProvinceData() {
//            //获取数据库,读取数据
//            UnitDao unitDao = DBExternalController.getDaoSession().getUnitDao();
//            //获取省的数据
//            return unitDao.queryBuilder().where(UnitDao.Properties.UParent.eq("1")).build().list();
//        }
//        private List<Unit> buildProvinceDataOutter() {
//            //获取数据库,读取数据
//            UnitDao unitDao = DBExternalController.getDaoSession().getUnitDao();
//            //获取省的数据
//            return unitDao.queryBuilder().where(UnitDao.Properties.UParent.eq("1"),UnitDao.Properties.TId.notEq("394")).build().list();
//        }

//        private HashMap<String, List<Unit>> buildCityData(List<Unit> province) {
//            HashMap<String, List<Unit>> cityData = new HashMap<>();
//            UnitDao unitDao = DBExternalController.getDaoSession().getUnitDao();
//            //省
//            for (Unit unit : province) {
//                List<Unit> list = unitDao.queryBuilder().where(UnitDao.Properties.UParent.eq(unit.getTId())).build().list();
//                cityData.put(unit.getTId(), list);
//            }
//            return cityData;
//        }
//
//        private HashMap<String, List<Unit>> buildCountryData(HashMap<String, List<Unit>> cityData) {
//            HashMap<String, List<Unit>> countryDate = new HashMap<>();
//            UnitDao unitDao = DBExternalController.getDaoSession().getUnitDao();
//            for (String key : cityData.keySet()) {
//                for (Unit city : cityData.get(key)) {
//                    List<Unit> list = unitDao.queryBuilder().where(UnitDao.Properties.UParent.eq(city.getTId())).build().list();
//                    if (list == null || list.size() == 0) {
//                        list = new ArrayList<>();
//                        Unit unit = new Unit();
//                        unit.setUName("无");
//                        list.add(unit);
//                    }
//                    countryDate.put(city.getTId(), list);
//                }
//            }
//            return countryDate;
//        }


        public PickerRegionDialog create() {
            final PickerRegionDialog dialog = new PickerRegionDialog(context, params.shadow ? R.style.Theme_Light_NoTitle_Dialog : R.style.Theme_Light_NoTitle_NoShadow_Dialog);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_picker_three, null);
            view.findViewById(R.id.tv_first).setVisibility(View.GONE);
            view.findViewById(R.id.tv_second).setVisibility(View.GONE);
            view.findViewById(R.id.tv_third).setVisibility(View.GONE);

            //数据库中读取数据
            final LoopView loopProvince = (LoopView) view.findViewById(R.id.loop1);
            loopProvince.setArrayList(getList(params.provinceData));
            loopProvince.setNotLoop();
            loopProvince.setCurrentItem(1);//湖南省

            final LoopView loopCity = (LoopView) view.findViewById(R.id.loop2);
            //市
            //获取相应的市级数据
//            UnitDao unitDao = DBExternalController.getDaoSession().getUnitDao();
//
//            List<Unit> cityList = unitDao.queryBuilder().
//                    where(UnitDao.Properties.UParent.eq(params.provinceData.get(1).getTId())).build().list();
//            List<String> cityListString = getList(cityList);
//            loopCity.setArrayList(cityListString);
//            loopCity.setNotLoop();
//            loopCity.setCurrentItem(1);

            final LoopView loopCountry = (LoopView) view.findViewById(R.id.loop3);
            //县
//            List<Unit> countryList =unitDao.queryBuilder().
//                    where(UnitDao.Properties.UParent.eq(cityList.get(1).getTId())).build().list();
//            List<String> countryListString = getList(countryList);
//            loopCountry.setArrayList(countryListString);
//            loopCountry.setNotLoop();
//            loopCountry.setCurrentItem(1);


            final LoopListener provinceListener = new LoopListener() {
                @Override
                public void onItemSelect(int item) {
                    String tid = params.provinceData.get(item).getTId();
                    List<String> list = getList(params.cityData.get(tid));
                    loopCity.setArrayList(list);
                }
            };
            final LoopListener cityListener = new LoopListener() {
                @Override
                public void onItemSelect(int item) {
                    //首先获取选中省的index 当loopview隐藏时获取到的是中间的数据
                    String provinceTid;
                    if (loopProvince.getVisibility() == View.VISIBLE) {
                        provinceTid = params.provinceData.get(loopProvince.getCurrentItem()).getTId();
                    } else {
                        provinceTid = params.provinceData.get(1).getTId();
                    }
                    Log.e("Builder", loopProvince.getCurrentItem() + "   " + provinceTid);
                    String cityTid = params.cityData.get(provinceTid).get(item).getTId();
                    List<String> list = getList(params.countryData.get(cityTid));
                    loopCountry.setArrayList(list);
                }
            };
            new Thread(){
                @Override
                public void run() {
                    while (params.countryData == null || params.cityData == null) {
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

            params.province = loopProvince;
            params.city = loopCity;
            params.country = loopCountry;
            dialog.setParams(params);
            return dialog;
        }

        private List<String> getList(List<Unit> source) {
            if (source == null) return new ArrayList<>();
            List<String> result = new ArrayList<>();
            for (Unit unit : source) {
                result.add(unit.getUName());
            }
            return result;
        }
    }
}

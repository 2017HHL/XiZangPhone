// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class QueryDetilAnimalBActivity$$ViewBinder<T extends QueryDetilAnimalBActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755547, "field 'btBack'");
    target.btBack = finder.castView(view, 2131755547, "field 'btBack'");
    view = finder.findRequiredView(source, 2131755482, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131755482, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131755548, "field 'btAdd'");
    target.btAdd = finder.castView(view, 2131755548, "field 'btAdd'");
    view = finder.findRequiredView(source, 2131755546, "field 'appBar'");
    target.appBar = finder.castView(view, 2131755546, "field 'appBar'");
    view = finder.findRequiredView(source, 2131755371, "field 'etJianyizhengBianhao'");
    target.etJianyizhengBianhao = finder.castView(view, 2131755371, "field 'etJianyizhengBianhao'");
    view = finder.findRequiredView(source, 2131755372, "field 'etHuozhuName'");
    target.etHuozhuName = finder.castView(view, 2131755372, "field 'etHuozhuName'");
    view = finder.findRequiredView(source, 2131755373, "field 'etHuozhuPhone'");
    target.etHuozhuPhone = finder.castView(view, 2131755373, "field 'etHuozhuPhone'");
    view = finder.findRequiredView(source, 2131755374, "field 'textView2'");
    target.textView2 = finder.castView(view, 2131755374, "field 'textView2'");
    view = finder.findRequiredView(source, 2131755343, "field 'etAnimalType'");
    target.etAnimalType = finder.castView(view, 2131755343, "field 'etAnimalType'");
    view = finder.findRequiredView(source, 2131755375, "field 'etAnimalLeixing'");
    target.etAnimalLeixing = finder.castView(view, 2131755375, "field 'etAnimalLeixing'");
    view = finder.findRequiredView(source, 2131755344, "field 'etAnimalDanwei'");
    target.etAnimalDanwei = finder.castView(view, 2131755344, "field 'etAnimalDanwei'");
    view = finder.findRequiredView(source, 2131755347, "field 'etAnimalNumber'");
    target.etAnimalNumber = finder.castView(view, 2131755347, "field 'etAnimalNumber'");
    view = finder.findRequiredView(source, 2131755346, "field 'etAnimalYongtu'");
    target.etAnimalYongtu = finder.castView(view, 2131755346, "field 'etAnimalYongtu'");
    view = finder.findRequiredView(source, 2131755348, "field 'etQiyunType'");
    target.etQiyunType = finder.castView(view, 2131755348, "field 'etQiyunType'");
    view = finder.findRequiredView(source, 2131755350, "field 'etQiyunShi'");
    target.etQiyunShi = finder.castView(view, 2131755350, "field 'etQiyunShi'");
    view = finder.findRequiredView(source, 2131755351, "field 'etQiyunXian'");
    target.etQiyunXian = finder.castView(view, 2131755351, "field 'etQiyunXian'");
    view = finder.findRequiredView(source, 2131755376, "field 'etStartVillage'");
    target.etStartVillage = finder.castView(view, 2131755376, "field 'etStartVillage'");
    view = finder.findRequiredView(source, 2131755353, "field 'etStartOther'");
    target.etStartOther = finder.castView(view, 2131755353, "field 'etStartOther'");
    view = finder.findRequiredView(source, 2131755356, "field 'etDaodaType'");
    target.etDaodaType = finder.castView(view, 2131755356, "field 'etDaodaType'");
    view = finder.findRequiredView(source, 2131755358, "field 'etDaodaShi'");
    target.etDaodaShi = finder.castView(view, 2131755358, "field 'etDaodaShi'");
    view = finder.findRequiredView(source, 2131755359, "field 'etDaodaXian'");
    target.etDaodaXian = finder.castView(view, 2131755359, "field 'etDaodaXian'");
    view = finder.findRequiredView(source, 2131755355, "field 'etEndVillage'");
    target.etEndVillage = finder.castView(view, 2131755355, "field 'etEndVillage'");
    view = finder.findRequiredView(source, 2131755377, "field 'etEndOther'");
    target.etEndOther = finder.castView(view, 2131755377, "field 'etEndOther'");
    view = finder.findRequiredView(source, 2131755183, "field 'tvErbiao'");
    target.tvErbiao = finder.castView(view, 2131755183, "field 'tvErbiao'");
    view = finder.findRequiredView(source, 2131755378, "field 'etSignatureChecked'");
    target.etSignatureChecked = finder.castView(view, 2131755378, "field 'etSignatureChecked'");
    view = finder.findRequiredView(source, 2131755370, "field 'tvProveTime'");
    target.tvProveTime = finder.castView(view, 2131755370, "field 'tvProveTime'");
    view = finder.findRequiredView(source, 2131755234, "field 'btPrint'");
    target.btPrint = finder.castView(view, 2131755234, "field 'btPrint'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends QueryDetilAnimalBActivity> implements Unbinder {
    private T target;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.btBack = null;
      target.tvTitle = null;
      target.btAdd = null;
      target.appBar = null;
      target.etJianyizhengBianhao = null;
      target.etHuozhuName = null;
      target.etHuozhuPhone = null;
      target.textView2 = null;
      target.etAnimalType = null;
      target.etAnimalLeixing = null;
      target.etAnimalDanwei = null;
      target.etAnimalNumber = null;
      target.etAnimalYongtu = null;
      target.etQiyunType = null;
      target.etQiyunShi = null;
      target.etQiyunXian = null;
      target.etStartVillage = null;
      target.etStartOther = null;
      target.etDaodaType = null;
      target.etDaodaShi = null;
      target.etDaodaXian = null;
      target.etEndVillage = null;
      target.etEndOther = null;
      target.tvErbiao = null;
      target.etSignatureChecked = null;
      target.tvProveTime = null;
      target.btPrint = null;
    }
  }
}

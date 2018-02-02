// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ProductPrintAActivity$$ViewBinder<T extends ProductPrintAActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755215, "field 'etNo'");
    target.etNo = finder.castView(view, 2131755215, "field 'etNo'");
    view = finder.findRequiredView(source, 2131755225, "field 'tvUserName'");
    target.tvUserName = finder.castView(view, 2131755225, "field 'tvUserName'");
    view = finder.findRequiredView(source, 2131755226, "field 'tvUserPhone'");
    target.tvUserPhone = finder.castView(view, 2131755226, "field 'tvUserPhone'");
    view = finder.findRequiredView(source, 2131755322, "field 'tvProductType'");
    target.tvProductType = finder.castView(view, 2131755322, "field 'tvProductType'");
    view = finder.findRequiredView(source, 2131755227, "field 'tvNumber'");
    target.tvNumber = finder.castView(view, 2131755227, "field 'tvNumber'");
    view = finder.findRequiredView(source, 2131755323, "field 'etProductionUnit'");
    target.etProductionUnit = finder.castView(view, 2131755323, "field 'etProductionUnit'");
    view = finder.findRequiredView(source, 2131755160, "field 'tvStartPlace'");
    target.tvStartPlace = finder.castView(view, 2131755160, "field 'tvStartPlace'");
    view = finder.findRequiredView(source, 2131755166, "field 'tvEndPlace'");
    target.tvEndPlace = finder.castView(view, 2131755166, "field 'tvEndPlace'");
    view = finder.findRequiredView(source, 2131755174, "field 'etCarrierName'");
    target.etCarrierName = finder.castView(view, 2131755174, "field 'etCarrierName'");
    view = finder.findRequiredView(source, 2131755175, "field 'etCarrierPhone'");
    target.etCarrierPhone = finder.castView(view, 2131755175, "field 'etCarrierPhone'");
    view = finder.findRequiredView(source, 2131755228, "field 'tvMethod'");
    target.tvMethod = finder.castView(view, 2131755228, "field 'tvMethod'");
    view = finder.findRequiredView(source, 2131755176, "field 'etUtilNumber'");
    target.etUtilNumber = finder.castView(view, 2131755176, "field 'etUtilNumber'");
    view = finder.findRequiredView(source, 2131755178, "field 'etSterilize'");
    target.etSterilize = finder.castView(view, 2131755178, "field 'etSterilize'");
    view = finder.findRequiredView(source, 2131755229, "field 'spinnerEffectArriveTime'");
    target.spinnerEffectArriveTime = finder.castView(view, 2131755229, "field 'spinnerEffectArriveTime'");
    view = finder.findRequiredView(source, 2131755230, "field 'tvQianfaTime'");
    target.tvQianfaTime = finder.castView(view, 2131755230, "field 'tvQianfaTime'");
    view = finder.findRequiredView(source, 2131755324, "field 'etJianduPhone'");
    target.etJianduPhone = finder.castView(view, 2131755324, "field 'etJianduPhone'");
    view = finder.findRequiredView(source, 2131755233, "field 'etRemark'");
    target.etRemark = finder.castView(view, 2131755233, "field 'etRemark'");
    view = finder.findRequiredView(source, 2131755234, "field 'btPrint'");
    target.btPrint = finder.castView(view, 2131755234, "field 'btPrint'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ProductPrintAActivity> implements Unbinder {
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
      target.etNo = null;
      target.tvUserName = null;
      target.tvUserPhone = null;
      target.tvProductType = null;
      target.tvNumber = null;
      target.etProductionUnit = null;
      target.tvStartPlace = null;
      target.tvEndPlace = null;
      target.etCarrierName = null;
      target.etCarrierPhone = null;
      target.tvMethod = null;
      target.etUtilNumber = null;
      target.etSterilize = null;
      target.spinnerEffectArriveTime = null;
      target.tvQianfaTime = null;
      target.etJianduPhone = null;
      target.etRemark = null;
      target.btPrint = null;
    }
  }
}

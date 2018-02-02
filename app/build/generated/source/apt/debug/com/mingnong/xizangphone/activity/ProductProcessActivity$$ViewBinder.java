// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ProductProcessActivity$$ViewBinder<T extends ProductProcessActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755236, "field 'tvNo'");
    target.tvNo = finder.castView(view, 2131755236, "field 'tvNo'");
    view = finder.findRequiredView(source, 2131755333, "field 'tvName'");
    target.tvName = finder.castView(view, 2131755333, "field 'tvName'");
    view = finder.findRequiredView(source, 2131755334, "field 'tvPhone'");
    target.tvPhone = finder.castView(view, 2131755334, "field 'tvPhone'");
    view = finder.findRequiredView(source, 2131755322, "field 'tvProductType'");
    target.tvProductType = finder.castView(view, 2131755322, "field 'tvProductType'");
    view = finder.findRequiredView(source, 2131755227, "field 'tvNumber'");
    target.tvNumber = finder.castView(view, 2131755227, "field 'tvNumber'");
    view = finder.findRequiredView(source, 2131755335, "field 'edtProductionUnitName'");
    target.edtProductionUnitName = finder.castView(view, 2131755335, "field 'edtProductionUnitName'");
    view = finder.findRequiredView(source, 2131755336, "field 'spinProductionUnitName'");
    target.spinProductionUnitName = finder.castView(view, 2131755336, "field 'spinProductionUnitName'");
    view = finder.findRequiredView(source, 2131755160, "field 'tvStartPlace'");
    target.tvStartPlace = finder.castView(view, 2131755160, "field 'tvStartPlace'");
    view = finder.findRequiredView(source, 2131755166, "field 'tvEndPlace'");
    target.tvEndPlace = finder.castView(view, 2131755166, "field 'tvEndPlace'");
    view = finder.findRequiredView(source, 2131755174, "field 'tvCarrierName'");
    target.tvCarrierName = finder.castView(view, 2131755174, "field 'tvCarrierName'");
    view = finder.findRequiredView(source, 2131755175, "field 'tvCarrierPhone'");
    target.tvCarrierPhone = finder.castView(view, 2131755175, "field 'tvCarrierPhone'");
    view = finder.findRequiredView(source, 2131755228, "field 'tvMethod'");
    target.tvMethod = finder.castView(view, 2131755228, "field 'tvMethod'");
    view = finder.findRequiredView(source, 2131755241, "field 'tvUtilNumber'");
    target.tvUtilNumber = finder.castView(view, 2131755241, "field 'tvUtilNumber'");
    view = finder.findRequiredView(source, 2131755242, "field 'tvSterilize'");
    target.tvSterilize = finder.castView(view, 2131755242, "field 'tvSterilize'");
    view = finder.findRequiredView(source, 2131755177, "field 'tvApplyTime'");
    target.tvApplyTime = finder.castView(view, 2131755177, "field 'tvApplyTime'");
    view = finder.findRequiredView(source, 2131755244, "field 'rbAccept'");
    target.rbAccept = finder.castView(view, 2131755244, "field 'rbAccept'");
    view = finder.findRequiredView(source, 2131755245, "field 'rbNoAccept'");
    target.rbNoAccept = finder.castView(view, 2131755245, "field 'rbNoAccept'");
    view = finder.findRequiredView(source, 2131755243, "field 'rg'");
    target.rg = finder.castView(view, 2131755243, "field 'rg'");
    view = finder.findRequiredView(source, 2131755246, "field 'linGroup'");
    target.linGroup = finder.castView(view, 2131755246, "field 'linGroup'");
    view = finder.findRequiredView(source, 2131755247, "field 'etGuanfangName'");
    target.etGuanfangName = finder.castView(view, 2131755247, "field 'etGuanfangName'");
    view = finder.findRequiredView(source, 2131755248, "field 'etGuanfangPhone'");
    target.etGuanfangPhone = finder.castView(view, 2131755248, "field 'etGuanfangPhone'");
    view = finder.findRequiredView(source, 2131755233, "field 'etRemark'");
    target.etRemark = finder.castView(view, 2131755233, "field 'etRemark'");
    view = finder.findRequiredView(source, 2131755185, "field 'btSave'");
    target.btSave = finder.castView(view, 2131755185, "field 'btSave'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ProductProcessActivity> implements Unbinder {
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
      target.tvNo = null;
      target.tvName = null;
      target.tvPhone = null;
      target.tvProductType = null;
      target.tvNumber = null;
      target.edtProductionUnitName = null;
      target.spinProductionUnitName = null;
      target.tvStartPlace = null;
      target.tvEndPlace = null;
      target.tvCarrierName = null;
      target.tvCarrierPhone = null;
      target.tvMethod = null;
      target.tvUtilNumber = null;
      target.tvSterilize = null;
      target.tvApplyTime = null;
      target.rbAccept = null;
      target.rbNoAccept = null;
      target.rg = null;
      target.linGroup = null;
      target.etGuanfangName = null;
      target.etGuanfangPhone = null;
      target.etRemark = null;
      target.btSave = null;
    }
  }
}

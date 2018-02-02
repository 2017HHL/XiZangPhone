// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ProductPrintBActivity$$ViewBinder<T extends ProductPrintBActivity> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131755325, "field 'tvProductPlace'");
    target.tvProductPlace = finder.castView(view, 2131755325, "field 'tvProductPlace'");
    view = finder.findRequiredView(source, 2131755166, "field 'tvEndPlace'");
    target.tvEndPlace = finder.castView(view, 2131755166, "field 'tvEndPlace'");
    view = finder.findRequiredView(source, 2131755326, "field 'etFlagJianyi'");
    target.etFlagJianyi = finder.castView(view, 2131755326, "field 'etFlagJianyi'");
    view = finder.findRequiredView(source, 2131755327, "field 'tvTransport3'");
    target.tvTransport3 = finder.castView(view, 2131755327, "field 'tvTransport3'");
    view = finder.findRequiredView(source, 2131755328, "field 'tvVehicleNo4'");
    target.tvVehicleNo4 = finder.castView(view, 2131755328, "field 'tvVehicleNo4'");
    view = finder.findRequiredView(source, 2131755329, "field 'tvDeliveryBefore4'");
    target.tvDeliveryBefore4 = finder.castView(view, 2131755329, "field 'tvDeliveryBefore4'");
    view = finder.findRequiredView(source, 2131755230, "field 'tvQianfaTime'");
    target.tvQianfaTime = finder.castView(view, 2131755230, "field 'tvQianfaTime'");
    view = finder.findRequiredView(source, 2131755330, "field 'tvqzi3'");
    target.tvqzi3 = finder.castView(view, 2131755330, "field 'tvqzi3'");
    view = finder.findRequiredView(source, 2131755233, "field 'etRemark'");
    target.etRemark = finder.castView(view, 2131755233, "field 'etRemark'");
    view = finder.findRequiredView(source, 2131755331, "field 'tvnumber4'");
    target.tvnumber4 = finder.castView(view, 2131755331, "field 'tvnumber4'");
    view = finder.findRequiredView(source, 2131755234, "field 'btPrint'");
    target.btPrint = finder.castView(view, 2131755234, "field 'btPrint'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ProductPrintBActivity> implements Unbinder {
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
      target.tvProductPlace = null;
      target.tvEndPlace = null;
      target.etFlagJianyi = null;
      target.tvTransport3 = null;
      target.tvVehicleNo4 = null;
      target.tvDeliveryBefore4 = null;
      target.tvQianfaTime = null;
      target.tvqzi3 = null;
      target.etRemark = null;
      target.tvnumber4 = null;
      target.btPrint = null;
    }
  }
}

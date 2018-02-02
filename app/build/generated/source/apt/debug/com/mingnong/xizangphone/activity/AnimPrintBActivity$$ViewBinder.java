// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class AnimPrintBActivity$$ViewBinder<T extends AnimPrintBActivity> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131755149, "field 'tvAnimType'");
    target.tvAnimType = finder.castView(view, 2131755149, "field 'tvAnimType'");
    view = finder.findRequiredView(source, 2131755158, "field 'tvUseage'");
    target.tvUseage = finder.castView(view, 2131755158, "field 'tvUseage'");
    view = finder.findRequiredView(source, 2131755227, "field 'tvNumber'");
    target.tvNumber = finder.castView(view, 2131755227, "field 'tvNumber'");
    view = finder.findRequiredView(source, 2131755160, "field 'tvStartPlace'");
    target.tvStartPlace = finder.castView(view, 2131755160, "field 'tvStartPlace'");
    view = finder.findRequiredView(source, 2131755162, "field 'tvStartPlaceType'");
    target.tvStartPlaceType = finder.castView(view, 2131755162, "field 'tvStartPlaceType'");
    view = finder.findRequiredView(source, 2131755164, "field 'etStartPlaceXiang'");
    target.etStartPlaceXiang = finder.castView(view, 2131755164, "field 'etStartPlaceXiang'");
    view = finder.findRequiredView(source, 2131755165, "field 'etStartPlaceTuzaichang'");
    target.etStartPlaceTuzaichang = finder.castView(view, 2131755165, "field 'etStartPlaceTuzaichang'");
    view = finder.findRequiredView(source, 2131755200, "field 'tvStartPlaceCountry'");
    target.tvStartPlaceCountry = finder.castView(view, 2131755200, "field 'tvStartPlaceCountry'");
    view = finder.findRequiredView(source, 2131755166, "field 'tvEndPlace'");
    target.tvEndPlace = finder.castView(view, 2131755166, "field 'tvEndPlace'");
    view = finder.findRequiredView(source, 2131755168, "field 'tvEndPlaceType'");
    target.tvEndPlaceType = finder.castView(view, 2131755168, "field 'tvEndPlaceType'");
    view = finder.findRequiredView(source, 2131755170, "field 'etEndPlaceXiang'");
    target.etEndPlaceXiang = finder.castView(view, 2131755170, "field 'etEndPlaceXiang'");
    view = finder.findRequiredView(source, 2131755171, "field 'etEndPlaceTuzaichang'");
    target.etEndPlaceTuzaichang = finder.castView(view, 2131755171, "field 'etEndPlaceTuzaichang'");
    view = finder.findRequiredView(source, 2131755204, "field 'tvEndPlaceCountry'");
    target.tvEndPlaceCountry = finder.castView(view, 2131755204, "field 'tvEndPlaceCountry'");
    view = finder.findRequiredView(source, 2131755230, "field 'tvQianfaTime'");
    target.tvQianfaTime = finder.castView(view, 2131755230, "field 'tvQianfaTime'");
    view = finder.findRequiredView(source, 2131755214, "field 'etErbiao'");
    target.etErbiao = finder.castView(view, 2131755214, "field 'etErbiao'");
    view = finder.findRequiredView(source, 2131755231, "field 'tvGuanfangName'");
    target.tvGuanfangName = finder.castView(view, 2131755231, "field 'tvGuanfangName'");
    view = finder.findRequiredView(source, 2131755232, "field 'tvGuanfangPhone'");
    target.tvGuanfangPhone = finder.castView(view, 2131755232, "field 'tvGuanfangPhone'");
    view = finder.findRequiredView(source, 2131755233, "field 'etRemark'");
    target.etRemark = finder.castView(view, 2131755233, "field 'etRemark'");
    view = finder.findRequiredView(source, 2131755234, "field 'btPrint'");
    target.btPrint = finder.castView(view, 2131755234, "field 'btPrint'");
    view = finder.findRequiredView(source, 2131755213, "field 'linErbiao'");
    target.linErbiao = finder.castView(view, 2131755213, "field 'linErbiao'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends AnimPrintBActivity> implements Unbinder {
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
      target.tvAnimType = null;
      target.tvUseage = null;
      target.tvNumber = null;
      target.tvStartPlace = null;
      target.tvStartPlaceType = null;
      target.etStartPlaceXiang = null;
      target.etStartPlaceTuzaichang = null;
      target.tvStartPlaceCountry = null;
      target.tvEndPlace = null;
      target.tvEndPlaceType = null;
      target.etEndPlaceXiang = null;
      target.etEndPlaceTuzaichang = null;
      target.tvEndPlaceCountry = null;
      target.tvQianfaTime = null;
      target.etErbiao = null;
      target.tvGuanfangName = null;
      target.tvGuanfangPhone = null;
      target.etRemark = null;
      target.btPrint = null;
      target.linErbiao = null;
    }
  }
}

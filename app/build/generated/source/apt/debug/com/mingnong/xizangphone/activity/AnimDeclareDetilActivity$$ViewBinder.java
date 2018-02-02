// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class AnimDeclareDetilActivity$$ViewBinder<T extends AnimDeclareDetilActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755215, "field 'etNo'");
    target.etNo = finder.castView(view, 2131755215, "field 'etNo'");
    view = finder.findRequiredView(source, 2131755216, "field 'etType'");
    target.etType = finder.castView(view, 2131755216, "field 'etType'");
    view = finder.findRequiredView(source, 2131755146, "field 'etUserName'");
    target.etUserName = finder.castView(view, 2131755146, "field 'etUserName'");
    view = finder.findRequiredView(source, 2131755148, "field 'etUserPhone'");
    target.etUserPhone = finder.castView(view, 2131755148, "field 'etUserPhone'");
    view = finder.findRequiredView(source, 2131755192, "field 'etAnimType'");
    target.etAnimType = finder.castView(view, 2131755192, "field 'etAnimType'");
    view = finder.findRequiredView(source, 2131755151, "field 'etNumber'");
    target.etNumber = finder.castView(view, 2131755151, "field 'etNumber'");
    view = finder.findRequiredView(source, 2131755197, "field 'etSource'");
    target.etSource = finder.castView(view, 2131755197, "field 'etSource'");
    view = finder.findRequiredView(source, 2131755208, "field 'etStartPlaceTime'");
    target.etStartPlaceTime = finder.castView(view, 2131755208, "field 'etStartPlaceTime'");
    view = finder.findRequiredView(source, 2131755218, "field 'etStartPlace'");
    target.etStartPlace = finder.castView(view, 2131755218, "field 'etStartPlace'");
    view = finder.findRequiredView(source, 2131755219, "field 'etEndPlace'");
    target.etEndPlace = finder.castView(view, 2131755219, "field 'etEndPlace'");
    view = finder.findRequiredView(source, 2131755174, "field 'etCarrierName'");
    target.etCarrierName = finder.castView(view, 2131755174, "field 'etCarrierName'");
    view = finder.findRequiredView(source, 2131755175, "field 'etCarrierPhone'");
    target.etCarrierPhone = finder.castView(view, 2131755175, "field 'etCarrierPhone'");
    view = finder.findRequiredView(source, 2131755220, "field 'etMethod'");
    target.etMethod = finder.castView(view, 2131755220, "field 'etMethod'");
    view = finder.findRequiredView(source, 2131755176, "field 'etUtilNumber'");
    target.etUtilNumber = finder.castView(view, 2131755176, "field 'etUtilNumber'");
    view = finder.findRequiredView(source, 2131755211, "field 'etApplyTime'");
    target.etApplyTime = finder.castView(view, 2131755211, "field 'etApplyTime'");
    view = finder.findRequiredView(source, 2131755178, "field 'etSterilize'");
    target.etSterilize = finder.castView(view, 2131755178, "field 'etSterilize'");
    view = finder.findRequiredView(source, 2131755217, "field 'etUsage'");
    target.etUsage = finder.castView(view, 2131755217, "field 'etUsage'");
    view = finder.findRequiredView(source, 2131755162, "field 'tvStartPlaceType'");
    target.tvStartPlaceType = finder.castView(view, 2131755162, "field 'tvStartPlaceType'");
    view = finder.findRequiredView(source, 2131755164, "field 'etStartPlaceXiang'");
    target.etStartPlaceXiang = finder.castView(view, 2131755164, "field 'etStartPlaceXiang'");
    view = finder.findRequiredView(source, 2131755165, "field 'etStartPlaceTuzaichang'");
    target.etStartPlaceTuzaichang = finder.castView(view, 2131755165, "field 'etStartPlaceTuzaichang'");
    view = finder.findRequiredView(source, 2131755200, "field 'tvStartPlaceCountry'");
    target.tvStartPlaceCountry = finder.castView(view, 2131755200, "field 'tvStartPlaceCountry'");
    view = finder.findRequiredView(source, 2131755168, "field 'tvEndPlaceType'");
    target.tvEndPlaceType = finder.castView(view, 2131755168, "field 'tvEndPlaceType'");
    view = finder.findRequiredView(source, 2131755170, "field 'etEndPlaceXiang'");
    target.etEndPlaceXiang = finder.castView(view, 2131755170, "field 'etEndPlaceXiang'");
    view = finder.findRequiredView(source, 2131755171, "field 'etEndPlaceTuzaichang'");
    target.etEndPlaceTuzaichang = finder.castView(view, 2131755171, "field 'etEndPlaceTuzaichang'");
    view = finder.findRequiredView(source, 2131755204, "field 'tvEndPlaceCountry'");
    target.tvEndPlaceCountry = finder.castView(view, 2131755204, "field 'tvEndPlaceCountry'");
    view = finder.findRequiredView(source, 2131755214, "field 'etErbiao'");
    target.etErbiao = finder.castView(view, 2131755214, "field 'etErbiao'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends AnimDeclareDetilActivity> implements Unbinder {
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
      target.etType = null;
      target.etUserName = null;
      target.etUserPhone = null;
      target.etAnimType = null;
      target.etNumber = null;
      target.etSource = null;
      target.etStartPlaceTime = null;
      target.etStartPlace = null;
      target.etEndPlace = null;
      target.etCarrierName = null;
      target.etCarrierPhone = null;
      target.etMethod = null;
      target.etUtilNumber = null;
      target.etApplyTime = null;
      target.etSterilize = null;
      target.etUsage = null;
      target.tvStartPlaceType = null;
      target.etStartPlaceXiang = null;
      target.etStartPlaceTuzaichang = null;
      target.tvStartPlaceCountry = null;
      target.tvEndPlaceType = null;
      target.etEndPlaceXiang = null;
      target.etEndPlaceTuzaichang = null;
      target.tvEndPlaceCountry = null;
      target.etErbiao = null;
    }
  }
}

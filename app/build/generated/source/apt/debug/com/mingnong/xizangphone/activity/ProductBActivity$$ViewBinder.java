// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ProductBActivity$$ViewBinder<T extends ProductBActivity> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131755401, "field 'etQuarantineNo'");
    target.etQuarantineNo = finder.castView(view, 2131755401, "field 'etQuarantineNo'");
    view = finder.findRequiredView(source, 2131755146, "field 'etUserName'");
    target.etUserName = finder.castView(view, 2131755146, "field 'etUserName'");
    view = finder.findRequiredView(source, 2131755374, "field 'textView2'");
    target.textView2 = finder.castView(view, 2131755374, "field 'textView2'");
    view = finder.findRequiredView(source, 2131755402, "field 'etProductName'");
    target.etProductName = finder.castView(view, 2131755402, "field 'etProductName'");
    view = finder.findRequiredView(source, 2131755411, "field 'etAnimCount'");
    target.etAnimCount = finder.castView(view, 2131755411, "field 'etAnimCount'");
    view = finder.findRequiredView(source, 2131755633, "field 'spProductDanwei'");
    target.spProductDanwei = finder.castView(view, 2131755633, "field 'spProductDanwei'");
    view = finder.findRequiredView(source, 2131755412, "field 'etDizhi'");
    target.etDizhi = finder.castView(view, 2131755412, "field 'etDizhi'");
    view = finder.findRequiredView(source, 2131755218, "field 'etStartPlace'");
    target.etStartPlace = finder.castView(view, 2131755218, "field 'etStartPlace'");
    view = finder.findRequiredView(source, 2131755413, "field 'etProductArea'");
    target.etProductArea = finder.castView(view, 2131755413, "field 'etProductArea'");
    view = finder.findRequiredView(source, 2131755219, "field 'etEndPlace'");
    target.etEndPlace = finder.castView(view, 2131755219, "field 'etEndPlace'");
    view = finder.findRequiredView(source, 2131755414, "field 'etQuarantineFlagNo'");
    target.etQuarantineFlagNo = finder.castView(view, 2131755414, "field 'etQuarantineFlagNo'");
    view = finder.findRequiredView(source, 2131755233, "field 'etRemark'");
    target.etRemark = finder.castView(view, 2131755233, "field 'etRemark'");
    view = finder.findRequiredView(source, 2131755378, "field 'etSignatureChecked'");
    target.etSignatureChecked = finder.castView(view, 2131755378, "field 'etSignatureChecked'");
    view = finder.findRequiredView(source, 2131755370, "field 'tvProveTime'");
    target.tvProveTime = finder.castView(view, 2131755370, "field 'tvProveTime'");
    view = finder.findRequiredView(source, 2131755410, "field 'btBaocun'");
    target.btBaocun = finder.castView(view, 2131755410, "field 'btBaocun'");
    view = finder.findRequiredView(source, 2131755515, "field 'btnSearch'");
    target.btnSearch = finder.castView(view, 2131755515, "field 'btnSearch'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ProductBActivity> implements Unbinder {
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
      target.etQuarantineNo = null;
      target.etUserName = null;
      target.textView2 = null;
      target.etProductName = null;
      target.etAnimCount = null;
      target.spProductDanwei = null;
      target.etDizhi = null;
      target.etStartPlace = null;
      target.etProductArea = null;
      target.etEndPlace = null;
      target.etQuarantineFlagNo = null;
      target.etRemark = null;
      target.etSignatureChecked = null;
      target.tvProveTime = null;
      target.btBaocun = null;
      target.btnSearch = null;
    }
  }
}

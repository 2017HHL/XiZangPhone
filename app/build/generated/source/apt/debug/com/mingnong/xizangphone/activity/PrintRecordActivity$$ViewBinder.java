// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class PrintRecordActivity$$ViewBinder<T extends PrintRecordActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755223, "field 'recyclerview'");
    target.recyclerview = finder.castView(view, 2131755223, "field 'recyclerview'");
    view = finder.findRequiredView(source, 2131755316, "field 'fab'");
    target.fab = finder.castView(view, 2131755316, "field 'fab'");
    view = finder.findRequiredView(source, 2131755317, "field 'overlay'");
    target.overlay = finder.castView(view, 2131755317, "field 'overlay'");
    view = finder.findRequiredView(source, 2131755485, "field 'spinnerStartYear'");
    target.spinnerStartYear = finder.castView(view, 2131755485, "field 'spinnerStartYear'");
    view = finder.findRequiredView(source, 2131755486, "field 'spinnerStartMonth'");
    target.spinnerStartMonth = finder.castView(view, 2131755486, "field 'spinnerStartMonth'");
    view = finder.findRequiredView(source, 2131755487, "field 'spinnerStartDay'");
    target.spinnerStartDay = finder.castView(view, 2131755487, "field 'spinnerStartDay'");
    view = finder.findRequiredView(source, 2131755489, "field 'spinnerEndYear'");
    target.spinnerEndYear = finder.castView(view, 2131755489, "field 'spinnerEndYear'");
    view = finder.findRequiredView(source, 2131755490, "field 'spinnerEndMonth'");
    target.spinnerEndMonth = finder.castView(view, 2131755490, "field 'spinnerEndMonth'");
    view = finder.findRequiredView(source, 2131755491, "field 'spinnerEndDay'");
    target.spinnerEndDay = finder.castView(view, 2131755491, "field 'spinnerEndDay'");
    view = finder.findRequiredView(source, 2131755661, "field 'spinnerContent'");
    target.spinnerContent = finder.castView(view, 2131755661, "field 'spinnerContent'");
    view = finder.findRequiredView(source, 2131755662, "field 'etSearch'");
    target.etSearch = finder.castView(view, 2131755662, "field 'etSearch'");
    view = finder.findRequiredView(source, 2131755660, "field 'fabSheet'");
    target.fabSheet = finder.castView(view, 2131755660, "field 'fabSheet'");
    view = finder.findRequiredView(source, 2131755464, "field 'btSearch'");
    target.btSearch = finder.castView(view, 2131755464, "field 'btSearch'");
    view = finder.findRequiredView(source, 2131755663, "field 'btClear'");
    target.btClear = finder.castView(view, 2131755663, "field 'btClear'");
    view = finder.findRequiredView(source, 2131755222, "field 'swipeLayout'");
    target.swipeLayout = finder.castView(view, 2131755222, "field 'swipeLayout'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends PrintRecordActivity> implements Unbinder {
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
      target.recyclerview = null;
      target.fab = null;
      target.overlay = null;
      target.spinnerStartYear = null;
      target.spinnerStartMonth = null;
      target.spinnerStartDay = null;
      target.spinnerEndYear = null;
      target.spinnerEndMonth = null;
      target.spinnerEndDay = null;
      target.spinnerContent = null;
      target.etSearch = null;
      target.fabSheet = null;
      target.btSearch = null;
      target.btClear = null;
      target.swipeLayout = null;
    }
  }
}

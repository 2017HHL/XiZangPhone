// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class QueryFragment$$ViewBinder<T extends QueryFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755223, "field 'recyclerview'");
    target.recyclerview = finder.castView(view, 2131755223, "field 'recyclerview'");
    view = finder.findRequiredView(source, 2131755222, "field 'swipeLayout'");
    target.swipeLayout = finder.castView(view, 2131755222, "field 'swipeLayout'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends QueryFragment> implements Unbinder {
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
      target.swipeLayout = null;
    }
  }
}

// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class LocalAnimFragment$$ViewBinder<T extends LocalAnimFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755223, "field 'recyclerview'");
    target.recyclerview = finder.castView(view, 2131755223, "field 'recyclerview'");
    view = finder.findRequiredView(source, 2131755222, "field 'swipeLayout'");
    target.swipeLayout = finder.castView(view, 2131755222, "field 'swipeLayout'");
    view = finder.findRequiredView(source, 2131755659, "field 'btRetry'");
    target.btRetry = finder.castView(view, 2131755659, "field 'btRetry'");
    view = finder.findRequiredView(source, 2131755658, "field 'rlEmpty'");
    target.rlEmpty = finder.castView(view, 2131755658, "field 'rlEmpty'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends LocalAnimFragment> implements Unbinder {
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
      target.btRetry = null;
      target.rlEmpty = null;
    }
  }
}
// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MoreFragment$$ViewBinder<T extends MoreFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755597, "field 'btUpdate'");
    target.btUpdate = finder.castView(view, 2131755597, "field 'btUpdate'");
    view = finder.findRequiredView(source, 2131755598, "field 'btAboutUs'");
    target.btAboutUs = finder.castView(view, 2131755598, "field 'btAboutUs'");
    view = finder.findRequiredView(source, 2131755599, "field 'btExit'");
    target.btExit = finder.castView(view, 2131755599, "field 'btExit'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends MoreFragment> implements Unbinder {
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
      target.btUpdate = null;
      target.btAboutUs = null;
      target.btExit = null;
    }
  }
}

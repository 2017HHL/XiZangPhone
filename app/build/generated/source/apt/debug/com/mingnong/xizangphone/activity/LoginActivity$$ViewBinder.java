// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class LoginActivity$$ViewBinder<T extends LoginActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131755306, "field 'etUserName'");
    target.etUserName = finder.castView(view, 2131755306, "field 'etUserName'");
    view = finder.findRequiredView(source, 2131755307, "field 'etPwd'");
    target.etPwd = finder.castView(view, 2131755307, "field 'etPwd'");
    view = finder.findRequiredView(source, 2131755308, "field 'btLogin'");
    target.btLogin = finder.castView(view, 2131755308, "field 'btLogin'");
    view = finder.findRequiredView(source, 2131755143, "field 'tvVersion'");
    target.tvVersion = finder.castView(view, 2131755143, "field 'tvVersion'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends LoginActivity> implements Unbinder {
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
      target.etUserName = null;
      target.etPwd = null;
      target.btLogin = null;
      target.tvVersion = null;
    }
  }
}

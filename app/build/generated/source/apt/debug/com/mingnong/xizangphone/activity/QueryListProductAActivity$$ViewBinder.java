// Generated code from Butter Knife. Do not modify!
package com.mingnong.xizangphone.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class QueryListProductAActivity$$ViewBinder<T extends QueryListProductAActivity> implements ViewBinder<T> {
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
    view = finder.findRequiredView(source, 2131755281, "field 'mRecyclerView'");
    target.mRecyclerView = finder.castView(view, 2131755281, "field 'mRecyclerView'");
    view = finder.findRequiredView(source, 2131755280, "field 'springView'");
    target.springView = finder.castView(view, 2131755280, "field 'springView'");
    view = finder.findRequiredView(source, 2131755282, "field 'viewEmpty'");
    target.viewEmpty = finder.castView(view, 2131755282, "field 'viewEmpty'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends QueryListProductAActivity> implements Unbinder {
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
      target.mRecyclerView = null;
      target.springView = null;
      target.viewEmpty = null;
    }
  }
}

package com.mingnong.xizangphone.interfac;


import com.mingnong.xizangphone.dao.AnimalApplyBean;

import java.util.List;

/**
 * Created by wyw on 2016/11/9.
 */

public interface IQuarantineAnimFragment extends IMVPFragment {
    void addList(List<AnimalApplyBean> list);

    void loadComplete();

    void setList(List<AnimalApplyBean> list);
}

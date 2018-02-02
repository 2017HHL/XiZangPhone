package com.mingnong.xizangphone.presenter;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.bean.ProductAUploadBean;
import com.mingnong.xizangphone.bean.ProductBUploadBean;
import com.mingnong.xizangphone.dao.external.PrintDB;
import com.mingnong.xizangphone.dao.external.UseidDB;
import com.mingnong.xizangphone.interfac.IProductBActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.DoOnSubscriber;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;
import com.mingnong.xizangphone.utils.NetWorkUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
public class ProductBActivityPresenter extends BaseActivityPresenter<IProductBActivity> {
    public ProductBActivityPresenter(IProductBActivity view) {
        super(view);
    }

    public void upLoad(ProductBUploadBean data) {
        List<String>userIsList = UseidDB.getInstance(MyApplication.getContext()).query();
        String userId=null;
        if (userIsList!=null){
            userId = userIsList.get(0);
        }else {
            userId = getUserId();
        }
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            addSubscribe(NetClient.upload(userId, "PDB", new Gson().toJson(data))
                    .doOnSubscribe(new DoOnSubscriber(getView()))
                    .map(baseMsgBean -> {
                        if (baseMsgBean.getErrorCode() != 0) {
                            throw new IllegalArgumentException(baseMsgBean.getErrorMsg());
                        }
                        return baseMsgBean.getData().getResult();
                    }).subscribe(errorCode -> {
                        Toast.makeText(MyApplication.getContext(), "上传完成", Toast.LENGTH_SHORT).show();
                        getView().upLoadSucceed();
                    }, new ExceptionImp(), () -> {
                        Log.e("HarmlessApplyActivityPr", "complete" + getView().toString());
                    }));
        } else {//在没有网络的时候，把要上传的数据库存储的到数据库中，当有网络的时候在服务中上传
            Toast.makeText(MyApplication.getContext(), "当前无网络状态，数据已加入离线上传队列", Toast.LENGTH_SHORT).show();
            PrintDB.getInstance(MyApplication.getContext()).insert(userId, "PDB", new Gson().toJson(data));
            getView().upLoadSucceed();
        }
    }

    public void getJianyiZhenghao() {
        addSubscribe(NetClient.getJianyiZhenghao(getUserId(), "PDB")
                .map(baseMsgBean -> {
                    BaseMsgBean.Data data = new StatusException(baseMsgBean).getObjectData(BaseMsgBean.Data.class);
                    return data;
                })
                .subscribe(dataListBean -> getView().zhenghao(dataListBean)
                        , new ExceptionImp(getView()), new CompleteImp(getView()))
        );
    }
}

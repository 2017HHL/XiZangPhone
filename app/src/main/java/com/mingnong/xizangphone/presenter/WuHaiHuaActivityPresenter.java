package com.mingnong.xizangphone.presenter;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.bean.PublicInformation;
import com.mingnong.xizangphone.interfac.IWuHaiHuaActivity;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.service.UploadPictureService;
import com.mingnong.xizangphone.utils.PhotoUtil;
import com.mingnong.xizangphone.utils.PhotoUtils;

import java.io.File;

import static com.mingnong.xizangphone.MyApplication.getContext;

/**
 * Created by song on 2017/6/12.
 */

public class WuHaiHuaActivityPresenter extends BaseActivityPresenter<IWuHaiHuaActivity> {
    public WuHaiHuaActivityPresenter(IWuHaiHuaActivity view) {
        super(view);
    }


    public void getInfo(PublicInformation bean, String uuid) {
        Gson gson = new Gson();
        String json = gson.toJson(bean);
        addSubscribe(NetClient.deadShenbao(getUser().getUSERID(), "WHHCL", json)
                .map(date -> {
                    if (date.getErrorCode() != 0) {
                        throw new IllegalArgumentException(date.getErrorMsg());
                    } else {
                        for (File file : PhotoUtils.getWuHaiHuaDir().listFiles()) {
                            if (file.getName().contains(uuid)) {
                                //上传
                                Intent intent = new Intent(MyApplication.getContext(), UploadPictureService.class);
                                intent.setAction(UploadPictureService.ADD_TASK);
                                intent.putExtra("localName", file.getName());
                                intent.putExtra("address", PhotoUtils.getWuHaiHuaDir().getAbsolutePath());
                                intent.putExtra("uuid", uuid);
                                MyApplication.getContext().startService(intent);
                            }
                        }

                    }
                    return date.getErrorMsg();
                })
                .subscribe(errorCode -> {
                            Log.e("HarmlessApplyActivityPr", "item success" + errorCode);
                        }, new ExceptionImp(getView()),
                        () -> {
                            Toast.makeText(getContext(), "上传完成", Toast.LENGTH_SHORT).show();
                            getView().isFinish();
                        })

        );
    }

}

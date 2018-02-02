package com.mingnong.xizangphone.service;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.User;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.utils.SPUtils;
import com.mingnong.xizangphone.utils.SoundPoolUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class DemoIntentService extends GTIntentService {

    private static final String TAG = "GetuiSdkDemo";

    /**
     * 为了传数据变化.观察透
     */
    private static int cnt;

    public DemoIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
        Log.d(TAG, "onReceiveServicePid -> " + pid);
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();

        // 第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
        Log.d(TAG, "call sendFeedbackMessage = " + (result ? "success" : "failed"));

        Log.d(TAG, "onReceiveMessageData -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nmessageid = " + messageid + "\npkg = " + pkg
                + "\ncid = " + cid);

        if (payload == null) {
            Log.e(TAG, "receiver payload = null");
        } else {
            String str = new String(payload);
            Log.e(TAG, "onReceiveMessageData  "+ str);
            System.out.println("+++++++++++++"+str);
            receiveData(str);
        }
    }

    @Override
    public void onReceiveClientId(final Context context, final String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
//        TestUtils.writeFile(context, "走到这里了， clientid:=  " + clientid);
        new Thread() {
            @Override
            public void run() {
                long userId = ((User) SPUtils.getInstance().getObjectData(Contance.USER_OBJECT)).getUSERID();
//                String useId = context.getSharedPreferences("date", Context.MODE_PRIVATE).getString("userid", "");
                String id = "";
                MultipartBody.Builder multyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart("UserID", String.valueOf(userId))
                        .addFormDataPart("ClientID", clientid);
                while (TextUtils.isEmpty(id)) {
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.e(TAG, message);
                        }
                    });
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client = new OkHttpClient.Builder()
                            .addNetworkInterceptor(new StethoInterceptor())
                            .addInterceptor(loggingInterceptor)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            //设置错误重连
                            .retryOnConnectionFailure(true)
                            .build();
                    try {

                        Response response = client.newCall(new Request.Builder().url(NetClient.URL_DOMAIN + "UploadClientID.ashx" ).post(multyBuilder.build()).build()).execute();
                        id = response.body().string();

                        Log.e(TAG, id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//                Log.e("PushDemoReceiver", id+"");
            }
        }.start();
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
        Log.d(TAG, "onReceiveOnlineState -> " + (online ? "online" : "offline"));
    }

    //    onReceiveOnlineState cid 离线上线通知 <br>
    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
        Log.e(TAG, "onReceiveCommandResult -> " + cmdMessage);
        int action = cmdMessage.getAction();

        if (action == PushConsts.SET_TAG_RESULT) {
            setTagResult((SetTagCmdMessage) cmdMessage);
        } else if ((action == PushConsts.THIRDPART_FEEDBACK)) {
            feedbackResult((FeedbackCmdMessage) cmdMessage);
        }
    }

    private void setTagResult(SetTagCmdMessage setTagCmdMsg) {
        String sn = setTagCmdMsg.getSn();
        String code = setTagCmdMsg.getCode();

        String text = "设置标签失败, 未知异常";
        switch (Integer.valueOf(code)) {
            case PushConsts.SETTAG_SUCCESS:
                text = "设置标签成功";
                break;

            case PushConsts.SETTAG_ERROR_COUNT:
                text = "设置标签失败, tag数量过大, 最大不能超过200个";
                break;

            case PushConsts.SETTAG_ERROR_FREQUENCY:
                text = "设置标签失败, 频率过快, 两次间隔应大于1s且一天只能成功调用一次";
                break;

            case PushConsts.SETTAG_ERROR_REPEAT:
                text = "设置标签失败, 标签重复";
                break;

            case PushConsts.SETTAG_ERROR_UNBIND:
                text = "设置标签失败, 服务未初始化成功";
                break;

            case PushConsts.SETTAG_ERROR_EXCEPTION:
                text = "设置标签失败, 未知异常";
                break;

            case PushConsts.SETTAG_ERROR_NULL:
                text = "设置标签失败, tag 为空";
                break;

            case PushConsts.SETTAG_NOTONLINE:
                text = "还未登陆成功";
                break;

            case PushConsts.SETTAG_IN_BLACKLIST:
                text = "该应用已经在黑名单中,请联系售后支持!";
                break;

            case PushConsts.SETTAG_NUM_EXCEED:
                text = "已存 tag 超过限制";
                break;

            default:
                break;
        }

        Log.d(TAG, "settag result sn = " + sn + ", code = " + code + ", text = " + text);
    }

    private void feedbackResult(FeedbackCmdMessage feedbackCmdMsg) {
        String appid = feedbackCmdMsg.getAppid();
        String taskid = feedbackCmdMsg.getTaskId();
        String actionid = feedbackCmdMsg.getActionId();
        String result = feedbackCmdMsg.getResult();
        long timestamp = feedbackCmdMsg.getTimeStamp();
        String cid = feedbackCmdMsg.getClientId();
        receiveData(result);
        Log.d(TAG, "onReceiveCommandResult -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nactionid = " + actionid + "\nresult = " + result
                + "\ncid = " + cid + "\ntimestamp = " + timestamp);
    }

    private void receiveData(String result) {
        SoundPoolUtils.getInstance(getApplicationContext()).playSound();
        // 测试消息为了观察数据变化
        cnt++;
        Log.e("GetuiSdkDemo", "receiver payload : " + result);
        try {
            JSONObject object = new JSONObject(result);
            String fileName = object.getString("fileName");
            //标题
            String Ititle = object.getString("title");
            String url = object.getString("url");
            //// TODO: 2017/6/30 数据插入数据库
//                String title = object.getString("title");
//                String content = object.getString("content");
            String[] fileNames = fileName.split(",");
            String[] urls = url.split(",");
            for (int i = 0; i < fileNames.length; i++) {
                Intent intent = new Intent(DownloadService.ADD_TASK);
                intent.putExtra("url", urls[i]);
//                new SimpleDateFormat("yyyy年MM月dd日 ", Locale.CHINA).format(new Date())
                intent.putExtra("fileName",Ititle+ fileNames[i]);
                intent = createExplicitFromImplicitIntent(this, intent);
                startService(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        // Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }
    public static void createNotification(Context context, Intent intents, String content, String title) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.icon_home_nor);
        PendingIntent intent = PendingIntent.getActivity(context, 0, intents, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(intent);
        NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(1, builder.build());
    }

    public static Intent makeIntentStack(Context context, Class acitivity) {
        return new Intent(context, acitivity);
    }
}

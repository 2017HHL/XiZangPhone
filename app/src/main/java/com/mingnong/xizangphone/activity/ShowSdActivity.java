package com.mingnong.xizangphone.activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.adapter.FileShowAdapter;
import com.mingnong.xizangphone.dao.LocalGreenDao;
import com.mingnong.xizangphone.dao.XiaoXiDaoBean;
import com.mingnong.xizangphone.interfac.IMVPList;
import com.mingnong.xizangphone.interfac.IShowSdActivity;
import com.mingnong.xizangphone.presenter.ShowSdActivityP;
import com.mingnong.xizangphone.utils.OtherUtil;
import com.mingnong.xizangphone.utils.RecyclerItemClickSupport;
import com.mingnong.xizangphone.view.springview.container.RotationFooter;
import com.mingnong.xizangphone.view.springview.container.RotationHeader;
import com.mingnong.xizangphone.view.springview.widget.SpringView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.mingnong.xizangphone.MyApplication.getContext;

public class ShowSdActivity extends MVPActivity<ShowSdActivityP> implements IShowSdActivity, SpringView.OnFreshListener, IMVPList {
    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.springView)
    SpringView springView;
    @BindView(R.id.view_empty)
    RelativeLayout rlEmpty;
    private FileShowAdapter adapter;

// {"errorCode" : 0,"errorMsg" : "success","dataList" :[{"TID":"5","FMPARENT":"39","FMNAME":"产品A","FMORDER":"1","IMG":"icon/cpsb.png","TNAME":"","TYPE":"0","M1":"1"},{"TID":"6","FMPARENT":"39","FMNAME":"产品B","FMORDER":"2","IMG":"icon/dwsb.png","TNAME":"","TYPE":"0","M1":"2"},{"TID":"7","FMPARENT":"39","FMNAME":"动物A","FMORDER":"3","IMG":"icon/jycz.png","TNAME":"","TYPE":"0","M1":"3"},{"TID":"8","FMPARENT":"39","FMNAME":"动物B","FMORDER":"4","IMG":"icon/jycz.png","TNAME":"","TYPE":"0","M1":"4"},{"TID":"9","FMPARENT":"39","FMNAME":"无害化处理","FMORDER":"5","IMG":"icon/jycz.png","TNAME":"","TYPE":"0","M1":"4"},{"TID":"10","FMPARENT":"39","FMNAME":"通知公告","FMORDER":"6","IMG":"icon/jycz.png","TNAME":"","TYPE":"0","M1":"4"}]}
    private OkHttpClient mClient=new OkHttpClient();
    private HashMap<String, Call> downCalls;//用来存放各个下载的请求
    private NotificationManager myManager=null;
    private Bitmap LargeBitmap=null;
    private Notification myNotification;
    private static final int NOTIFICATION_ID_1=1;
    private String MyUrl;
    ArrayList<XiaoXiDaoBean> datas1 = new ArrayList<>();
    ArrayList<String> datas2 = new ArrayList<>();
    ArrayList<String> datas3 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sd);
        ButterKnife.bind(this);
    }

    @Override
    protected ShowSdActivityP createPresenter() {
        return new ShowSdActivityP(this);
    }

    @Override
    public void bindData() {
        setTitle("通知公告");
        getPresenter().ChanDiJianYi5();
        mRecyclerView.setHasFixedSize(true);
        springView.setType(SpringView.Type.FOLLOW);
        springView.setGive(SpringView.Give.BOTH);
        springView.setHeader(new RotationHeader(getContext()));   //参数为：logo图片资源，是否显示文字
        springView.setFooter(new RotationFooter(getContext()));
        springView.setListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        btBack.setOnClickListener(v -> finish());
        adapter = new FileShowAdapter(this, datas1);
        mRecyclerView.setAdapter(adapter);
//        List<ShenShiXianBean>list1= LocalGreenDao.getInstance().queryShenShiXian();
//        System.out.println("++++++++++"+list1.get(0).getUname());
//        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//            File downloadDir = new File(Environment.getExternalStorageDirectory(), "西藏Download");
//            if (!downloadDir.exists()) downloadDir.mkdirs();
//            for (File file : downloadDir.listFiles()) {
//                String fileName = file.getName();
//                FileBean bean;
//                if (fileName.contains(".")) {
//                    bean = new FileBean(fileName.substring(0, fileName.lastIndexOf(".")),
//                            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).format(file.lastModified()),
//                            getType(fileName.substring(fileName.lastIndexOf(".") + 1)),
//                            file.getAbsolutePath());
//                } else {
//                    bean = new FileBean(fileName, new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.CHINA).format(file.lastModified()),
//                            "无类型", file.getAbsolutePath());
//                }
//                list.add(bean);
//            }
//            Collections.reverse(list);
//            if (list.size() == 0) rlEmpty.setVisibility(View.VISIBLE);
//        }
    }
    public String getType(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "txt":
                return "文本文档";
            case "doc":
            case "docx":
                return "word文档";
            case "jpg":
            case "png":
            case "bmp":
                return "图片";
            case "xls":
            case "xlsx":
                return "excel文档";
            default:
                return type;
        }
    }

    @Override
    public void bindListener() {
        rlEmpty.setOnClickListener(v -> manualRefresh());
        RecyclerItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
               String data=LocalGreenDao.getInstance().queryXiaoxi().get(position).getUrlList();
                String data2=LocalGreenDao.getInstance().queryXiaoxi().get(position).getCidTongZhiName();
                if (data.equals("")){
                    Toast.makeText(ShowSdActivity.this, "没有文件....", Toast.LENGTH_SHORT).show();
                }
                else {
                    String[] list = data.split(",");
                    if (list.length > 1) {
                        for (int i = 0; i < list.length; i++){
                            MyUrl = list[i];
                        new MyThread().start();
                        }
                        String[] list2 = data2.split(",");
                        gengxin(list2);

                    } else {
                        MyUrl = list[0];
                        new MyThread().start();
                        try {
                            File file = new File(Environment.getExternalStorageDirectory(), "西藏Download");
                            if (file.exists()) OtherUtil.openFile(file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
//                new MyThread().start();
//                text();

            }
        });
    }
    private void gengxin(String[] list) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ShowSdActivity.this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("请选择");
        //    设置一个下拉的列表选择项
        builder.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    File file = new File(Environment.getExternalStorageDirectory(), "西藏Download");
                    if (file.exists()) OtherUtil.openFile(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.show();
    }
    /**
     * 手动刷新
     */
    public void manualRefresh() {
        rlEmpty.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                springView.callFresh();
//                getPresenter().getProductAData(value, startStr, endStr);
            }
        }, 500);
    }

    @Override
    public void onError() {
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void refreshNone() {
        adapter.clear();
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onRefresh() {
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void onLoadmore() {
        springView.onFinishFreshAndLoad();
        if (adapter.getDates().size() > 0) {
            getPresenter().ChanDiJianYi55(adapter.getDates().get(adapter.getDates().size()-1).getTid());
        }

    }

    @Override
    public void addListData() {
        List<XiaoXiDaoBean> listxiaoxi= LocalGreenDao.getInstance().queryXiaoxi();
        for (int i=0;i<listxiaoxi.size();i++){
            datas1.add(listxiaoxi.get(i));
        }
        Collections.reverse(datas1);
        if (datas1.size() == 0) rlEmpty.setVisibility(View.VISIBLE);
        adapter.setmDatas(datas1);
    }
    @Override
    public void setData(List<XiaoXiDaoBean> mylist) {
        adapter.addAll(mylist);
    }
    private class  MyThread extends Thread{
        @Override
        public void run() {
            Request request = new Request.Builder()
                    //确定下载的范围,添加此头,则服务器就可以跳过已经下载好的部分
                    .addHeader("RANGE", "bytes=")
                    .url(MyUrl)
                    .build();
            Call call = mClient.newCall(request);
//            downCalls.put("https://ss2.baidu.com/73Z1bjeh1BF3odCf/it/u=2991169923,1001222125&fm=202", call);//把这个添加到call里,方便取消
            Response response = null;
            try {
                response = call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            File file = new File(Environment.getExternalStorageDirectory(), "西藏Download");
            InputStream is = null;
            FileOutputStream fileOutputStream = null;
            try {
                is = response.body().byteStream();
                try {
                    fileOutputStream = new FileOutputStream(file, true);

                    byte[] buffer = new byte[2048];//缓冲数组2kB
                    int len;
                    while ((len = is.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    fileOutputStream.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                //关闭IO流
                IOUtil.closeAll(is, fileOutputStream);
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void text(){
        //创建大图标的Bitmap  
        LargeBitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        //1.从系统服务中获得通知管理器  
        myManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//3.定义一个PendingIntent，点击Notification后启动一个Activity  
        PendingIntent pi=PendingIntent.getActivity(
                ShowSdActivity.this,
                100,
                new Intent(ShowSdActivity.this,ShowSdActivity.class),
                PendingIntent.FLAG_CANCEL_CURRENT
        );
        //2.通过Notification.Builder来创建通知  
        Notification.Builder myBuilder=new Notification.Builder(ShowSdActivity.this);
        myBuilder.setContentTitle("QQ")
                .setContentText("这是内容")
                .setSubText("这是补充小行内容")
                .setTicker("您收到新的消息")
                //设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示  
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(LargeBitmap)
                //设置默认声音和震动  
                .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)//点击后取消  
                .setWhen(System.currentTimeMillis())//设置通知时间  
                .setPriority(Notification.PRIORITY_HIGH)//高优先级  
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                //android5.0加入了一种新的模式Notification的显示等级，共有三种：  
                //VISIBILITY_PUBLIC  只有在没有锁屏时会显示通知  
                //VISIBILITY_PRIVATE 任何情况都会显示通知  
                //VISIBILITY_SECRET  在安全锁和没有锁屏的情况下显示通知  
                .setContentIntent(pi);//3.关联PendingIntent  
        myNotification=myBuilder.build();
        //4.通过通知管理器来发起通知，ID区分通知  
        myManager.notify(NOTIFICATION_ID_1,myNotification);
    }

}


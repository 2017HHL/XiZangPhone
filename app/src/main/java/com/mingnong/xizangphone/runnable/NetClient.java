package com.mingnong.xizangphone.runnable;


import android.text.TextUtils;
import android.util.Log;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.activity.LoginActivity;
import com.mingnong.xizangphone.bean.AnimListBean;
import com.mingnong.xizangphone.bean.BaseMsg;
import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.bean.DanWeiBean;
import com.mingnong.xizangphone.bean.DongwuBean;
import com.mingnong.xizangphone.bean.HomeBean;
import com.mingnong.xizangphone.bean.LoginBean;
import com.mingnong.xizangphone.bean.PrintRecordListBean;
import com.mingnong.xizangphone.bean.ProductListBean;
import com.mingnong.xizangphone.bean.PublicInformation;
import com.mingnong.xizangphone.bean.QueryAnimABean;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.bean.QueryListChangDI;
import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.bean.QueryProductBBean;
import com.mingnong.xizangphone.bean.QueryTuZaiBean;
import com.mingnong.xizangphone.bean.QueryWHHBean;
import com.mingnong.xizangphone.bean.ShenShiBean;
import com.mingnong.xizangphone.bean.SupervisionBean;
import com.mingnong.xizangphone.bean.TuzaimingcBean;
import com.mingnong.xizangphone.bean.UserBean;
import com.mingnong.xizangphone.bean.WuHaIHuaAddBean;
import com.mingnong.xizangphone.bean.WuHaiHuaUpLocaBaen;
import com.mingnong.xizangphone.bean.XiaoXiBean;
import com.mingnong.xizangphone.dao.CacheTable;
import com.mingnong.xizangphone.dao.User;
import com.mingnong.xizangphone.dao.local.CacheTableDao;
import com.mingnong.xizangphone.dao.local.DBInnerController;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.NetWorkUtils;
import com.mingnong.xizangphone.utils.SPUtils;

import org.greenrobot.greendao.query.Query;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wyw on 2016/6/25.
 */
public class NetClient {

    public static final String BASE_URL = "http://220.182.3.2:8888/";
    public static final String BASE_URL2 = "http://192.168.0.221:8886/XiZangAPP/HtmlAshx/";
    //    public static final String PIC_URL = BASE_URL+"XZJYZMobileWebservice/icon/";
    public static final String PIC_URL = BASE_URL + "XZJYZMobileWebservice/";
    //http://192.168.0.5:53870/HtmlAshx/Login.ashx
    public static final String Test = "http://192.168.0.55/XZAPP/HtmlAshx/";
    public static final String DOMAIN = BASE_URL + "XZJYZMobileWebservice/HtmlAshx/";

    public static final String URL_DOMAIN = BASE_URL2;
    private static final String TAG = NetClient.class.getSimpleName();
    public static final int DEFAULT_DIR_CACHE = 1024 * 1024 * 10;
    private static NetClient mInstance;
    private Retrofit mRetrofit;
    private File httpCacheDirectory; //缓存文件夹

    private static RequestService requestService;

    /**
     * 通过这个方法来调用网络请求的接口
     *
     * @return
     */
    public static RequestService getRequest() {
        return getInstance().requestService;
    }

    private synchronized static NetClient getInstance() {
        if (mInstance == null) {
            mInstance = new NetClient();
        }
        return mInstance;
    }

    private NetClient() {
        //初始化缓存
        httpCacheDirectory = new File(FileUtil.getInstance().getCacheFile(), "cacheData");
//        httpCacheDirectory = new File (MyApplication.getContext().getCacheDir(),"cacheData");
        //设置cookie  compile 'com.squareup.okhttp3:okhttp-urlconnection:3.2.0'
        Cache cache = new Cache(httpCacheDirectory, DEFAULT_DIR_CACHE);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder()
                //设置超时
                //设置错误重连
                .retryOnConnectionFailure(true)
//                .addInterceptor(new CacheInterceptor())
//                .addNetworkInterceptor(new CacheInterceptor())
                .addNetworkInterceptor(new StethoInterceptor())
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .cache(cache);

//        if (BuildConfig.DEBUG) {
        //日志拦截
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e(TAG, message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(loggingInterceptor);
//        }
//        okHttpBuilder.interceptors().add(new ParamterInterceptor());
        //配置retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(URL_DOMAIN)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //注意顺序
                .addConverterFactory(NobodyConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build();
        requestService = mRetrofit.create(RequestService.class);
    }

    public class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            CacheTableDao dao = DBInnerController.getDaoSession().getCacheTableDao();
            Request request = chain.request();
            String type = "";
            try {
                FormBody body = ((FormBody) request.body());
                for (int i = 0; i < body.size(); i++) {
                    if ("tableValues".equals(body.encodedName(i))) {
                        //如果是tableValues属性 那么就可以得到 数据库中CacheTable中的type
                        type = body.value(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
                //没有网络直接从数据库读取
                String userId = String.valueOf(((User) SPUtils.getInstance().getObjectData(Contance.USER_OBJECT)).getUSERID());
                Response.Builder builder = new Response.Builder()
                        .addHeader("Cache-Control", "private")
                        .addHeader("Content-Type", "text/plain;charset=utf-8")
                        .addHeader("Content-Encoding", "gzip")
                        .addHeader("Vary", "Accept-Encoding")
                        .addHeader("Server", "Mircrosoft-IIS/7.5")
                        .addHeader("X-AspNet-Version", "4.0.30319")
                        .addHeader("X-Powered-By", "ASP.NET")
                        .addHeader("Date", "Fri,17 Feb 2017 09:30:50 GMT")
                        .addHeader("Content-Length", "655")
                        .code(200);
                String json;
                if (TextUtils.isEmpty(userId) || "-1".equals(userId)) {
                    json = getErrorBaseMsg("没有存储的用户");
                } else {
                    //从数据库读取json数据
                    List<CacheTable> list = dao.queryBuilder().where(CacheTableDao.Properties.Type.eq(type),
                            CacheTableDao.Properties.UserId.eq(userId)).build().list();
                    if (list != null && list.size() > 0) {
                        json = list.get(0).getValue();
                    } else {
                        json = getErrorBaseMsg("没有数据备份");
                    }
                }
                ResponseBody body = RealResponseBody.create(MediaType.parse("text/plain;charset=utf-8"), json);
                builder.body(body).protocol(Protocol.HTTP_1_1);
                builder.request(new Request.Builder()
                        .method("POST", new FormBody.Builder().add("UserAccount", "").build())
                        .url(URL_DOMAIN)
                        .build());
                return builder.build();
            } else {
                Response response = chain.proceed(request);
                if (TextUtils.isEmpty(type)) return response;
                String userId = "";
                String json = "";
                if (response != null && response.body().contentLength() != 0) {
                    //成功访问服务器
                    BufferedSource source = response.body().source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer = source.buffer();
                    Charset charset = Charset.forName("UTF-8");
                    MediaType contentType = response.body().contentType();
                    if (contentType != null) {
                        try {
                            charset = contentType.charset(charset);
                        } catch (UnsupportedCharsetException ex) {
                            ex.printStackTrace();
                            return response;
                        }
                    }
                    if (!isPlaintext(buffer)) {
                        return response;
                    }
                    if (response.body().contentLength() != 0) {
                        json = buffer.clone().readString(charset);
                    }
                    //根据code保证插入数据的合理性
                    int code = 0;
                    try {
                        code = new JSONObject(json).getInt("errorCode");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return response;
                    }
                    if (code != 0) {
                        return response;
                    }
                    if (type.contains(LoginActivity.class.getSimpleName()))
                        userId = String.valueOf(new Gson().fromJson(json, LoginBean.class).getData().getUSERID());
                    else
                        userId = String.valueOf(((User) SPUtils.getInstance().getObjectData(Contance.USER_OBJECT)).getUSERID());
                    CacheTable bean = new CacheTable();
                    bean.setId(null).setUserId(userId).setType(type).setValue(json);
                    Query<CacheTable> build = dao.queryBuilder().where(CacheTableDao.Properties.Type.eq(type),
                            CacheTableDao.Properties.UserId.eq(userId)).build();
                    List<CacheTable> list = build.list();
                    if (list != null && list.size() > 0) {
                        list.get(0).setValue(json);
                        dao.update(list.get(0));
                    } else {
                        dao.insertOrReplace(bean);
                    }
                    return response;
                }
                return response;
            }
        }
    }

    static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    private static final String getErrorBaseMsg(String errorMsg) {
        BaseMsg baseMsg = new BaseMsg();
        baseMsg.setErrorCode(300);
        baseMsg.setErrorMsg(errorMsg);
        return new Gson().toJson(baseMsg);
    }

    //这是设置在多长时间范围内获取缓存里面
    public static final CacheControl FORCE_CACHE1 = new CacheControl.Builder()
            .onlyIfCached()
            .maxStale(7, TimeUnit.SECONDS)//这里是7s，CacheControl.FORCE_CACHE--是int型最大值
            .build();

    public interface RequestService {
//        @FormUrlEncoded
//        @POST("GetVersion.ashx")
//        Observable<BaseMsgBean> checkApkVersion(@Field("tableValues") String tableValues,
//                                                @Field("version") String apkVersion);


//        @FormUrlEncoded
//        @POST("GetDBVersion.ashx")
//        Observable<BaseMsgBean> checkDbVersion(@Field("tableValues") String tableValues,
//                                               @Field("version") String apkVersion);

        @FormUrlEncoded
        @POST("GetDBVersion.ashx")
        Observable<BaseMsgBean> checkDbVersion(@Field("version") String apkVersion);


        @FormUrlEncoded
        @POST("GetPatch.ashx")
        Observable<BaseMsgBean> checkPatchVersion(@Field("tableValues") String tableValues,
                                                  @Field("Version") String apatchVersion);

        /**
         * 登录接口
         *
         * @param userName
         * @param pwd
         * @return
         */
        @FormUrlEncoded
        @POST("Login.ashx")
        Observable<UserBean> login1(@Field("uAccount") String userName,
                                    @Field("pwd") String pwd);


        /**
         * 上传
         */
        @FormUrlEncoded
        @POST("UploadFourJson.ashx")
        Observable<BaseMsgBean> upload(@Field("fsuserid") String id,
                                       @Field("TableName") String tableName,
                                       @Field("json") String json);

        /**
         * 更新版本
         */
        @FormUrlEncoded
        @POST("GetVersion.ashx")
        Observable<BaseMsgBean> checkApkVersions(@Field("version") String version);


        /**
         * 检疫证号
         */
        @FormUrlEncoded
        @POST("GetNumberPQ.ashx")
        Observable<BaseMsgBean> jianyiZhenghao(@Field("fsuserid") String id,
                                               @Field("TableName") String tableName);


        /**
         * 权限接口
         *
         * @param rid 当前的用户的角色ID
         * @param uid 当前的用户ID
         * @return
         */
        @FormUrlEncoded
        @POST("GetAPP_Menu_Pop.ashx")
        Observable<HomeBean> getPermissionList(@Field("rid") String rid,
                                               @Field("uid") String uid);

        /**
         * 产品A查询的实体类
         * fsuserid请求用户的ID
         * TableName表名称
         * WhereStr查询条件
         */
        @FormUrlEncoded
        @POST("GetEntitityJsonWhere.ashx")
        Observable<QueryProductABean> getProductAData(@Field("Fsuserid") String id,
                                                      @Field("TableName") String tableName,
                                                      @Field("TId") String tid,
                                                      @Field("Name") String name,
                                                      @Field("Value") String value,
                                                      @Field("Sdate") String sdate,
                                                      @Field("Jdate") String jdate);

        /**
         * 产品B查询的实体类
         * fsuserid请求用户的ID
         * TableName表名称
         * WhereStr查询条件
         */
        @FormUrlEncoded
        @POST("GetEntitityJsonWhere.ashx")
        Observable<QueryProductBBean> getProductBData(@Field("Fsuserid") String id,
                                                      @Field("TableName") String tableName,
                                                      @Field("TId") String tid,
                                                      @Field("Name") String name,
                                                      @Field("Value") String value,
                                                      @Field("Sdate") String sdate,
                                                      @Field("Jdate") String jdate);

        /**
         * 动物A查询的实体类
         * fsuserid请求用户的ID
         * TableName表名称
         * WhereStr查询条件
         */
        @FormUrlEncoded
        @POST("GetEntitityJsonWhere.ashx")
        Observable<QueryAnimABean> queryAnimaA(@Field("Fsuserid") String id,
                                               @Field("TableName") String tableName,
                                               @Field("TId") String tid,
                                               @Field("Name") String name,
                                               @Field("Value") String value,
                                               @Field("Sdate") String sdate,
                                               @Field("Jdate") String jdate);

        /**
         * 动物B查询的实体类
         * fsuserid请求用户的ID
         * TableName表名称
         * WhereStr查询条件
         */
        @FormUrlEncoded
        @POST("GetEntitityJsonWhere.ashx")
        Observable<QueryAnimBBean> queryAnimaB(@Field("Fsuserid") String id,
                                               @Field("TableName") String tableName,
                                               @Field("TId") String tid,
                                               @Field("Name") String name,
                                               @Field("Value") String value,
                                               @Field("Sdate") String sdate,
                                               @Field("Jdate") String jdate);

        /**
         * 无害化查询的实体类
         * fsuserid请求用户的ID
         * TableName表名称
         * WhereStr查询条件
         */
        @FormUrlEncoded
        @POST("GetEntitityJsonWhere.ashx")
        Observable<QueryWHHBean> queryWhh(@Field("Fsuserid") String id,
                                          @Field("TableName") String tableName,
                                          @Field("TId") String tid,
                                          @Field("Name") String name,
                                          @Field("Value") String value,
                                          @Field("Sdate") String sdate,
                                          @Field("Jdate") String jdate);


        /**
         * 获取主页列表
         *
         * @param userName
         * @param pwd
         * @return
         */
        @FormUrlEncoded
        @POST("GetAPP_Menu_Pop.ashx")
        Observable<HomeBean> getHomeList(@Field("tableValues") String tableValues,
                                         @Field("uid") String userName,
                                         @Field("rid") String pwd);
        @FormUrlEncoded
        @POST("GetAnimalJson.ashx")
        Observable<DongwuBean> Chandijianyi(@Field("ashxType") String ashxType);
        @FormUrlEncoded
        @POST("GetCode.ashx")
        Observable<DanWeiBean> Chandijianyi2(@Field("FieldType") String FieldType);
        @FormUrlEncoded
        @POST("GetUnit2.ashx")
        Observable<ShenShiBean> Chandijianyi4(@Field("UnitUserId") String UnitUserId);
        //通知公告
        @FormUrlEncoded
        @POST("GetNotice.ashx")
        Observable<XiaoXiBean> Chandijianyi5(@Field("fsuserid") String fsuserid,
                                             @Field("TableName") String TableName,
                                             @Field("tId") String tId);
        @FormUrlEncoded
        @POST("GetSlaAccredit.ashx")
        Observable<TuzaimingcBean> Chandijianyi3(@Field("fsuserid") String fsuserid,
                                                 @Field("TableName") String TableName
        );
        /**
         * 获取查询列表
         *
         * @param userName
         * @param pwd
         * @return
         */
        @FormUrlEncoded
        @POST("GetAPP_Menu_PopS.ashx")
        Observable<HomeBean> getQueryList(@Field("tableValues") String tableValues,
                                          @Field("uid") String userName,
                                          @Field("rid") String pwd);

        /**
         * @param userId
         * @param ZzType DWSBD
         * @param fstId  服务器主键
         * @param count  需要多少数据
         * @return
         */
        @FormUrlEncoded
        @POST("GetJsonList.ashx")
        Observable<AnimListBean> getAnimList(@Field("tableValues") String tableValues,
                                             @Field("USERID") String userId,
                                             @Field("ZzType") String ZzType,
                                             @Field("FStId") String fstId,
                                             @Field("Count") int count);

        /**
         * @param userId
         * @param ZzType DWSBD
         * @param fstId  服务器主键
         * @param count  需要多少数据
         * @return
         */
        @FormUrlEncoded
        @POST("GetJsonList.ashx")
        Observable<ProductListBean> getProductList(@Field("tableValues") String tableValues,
                                                   @Field("USERID") String userId,
                                                   @Field("ZzType") String ZzType,
                                                   @Field("FStId") String fstId,
                                                   @Field("Count") int count);

        /**
         * 获取服务器时间
         *
         * @return
         */
        @GET("GetServerDatetime.ashx")
        Observable<BaseMsgBean> getTime();

        /**
         * 根据经纬度得到附近的动物监督所 以及 id
         *
         * @return
         */
        @FormUrlEncoded
        @POST("GetVeterinaryJG.ashx")
        Observable<SupervisionBean> getSupervision(@Field("fLongitude") String longitude,
                                                   @Field("fLatitude") String latitude);

        /**
         * 动物 产品 证书上传
         * DWSBD anim
         * CPSBD product
         *
         * @return
         */
        @FormUrlEncoded
        @POST("UploadJonInfo.ashx")
        Observable<BaseMsg> uploadAnimAndProduct(@Field("JsonInfo") String JsonInfo,
                                                 @Field("UserID") String UserID,
                                                 @Field("ZzType") String ZzType);


        /**
         * 动物 产品 证书上传
         * DWSBD anim
         * CPSBD product
         *
         * @return
         */
        @FormUrlEncoded
        @POST("UpdateJsonInfo.ashx")
        Observable<BaseMsg> updateAnimAndProduct(@Field("JsonInfo") String JsonInfo,
                                                 @Field("UserID") String UserID,
                                                 @Field("ZzType") String ZzType);

        /**
         * 验证打印机的机器号
         *
         * @param MachineNumber 用户对话框输入的id  序列号
         * @param SerialNumber  查找的机器码id
         * @return
         */
        @FormUrlEncoded
        @POST("GetMachineNumber.ashx")
        Observable<BaseMsg> printCheck(@Field("Json_UserID") String UserID,
                                       @Field("MachineNumber") String MachineNumber,
                                       @Field("SerialNumber") String SerialNumber);

        /**
         * 处理 动物AB  产品AB
         * Contance 里面 PDA PDB ...
         *
         * @param Json_Image 湖南的是null
         * @return
         */
        @FormUrlEncoded
        @POST("HandlerUpLoad.ashx")
        Observable<BaseMsg> processAnimAndProduct(@Field("Json_TabName") String Json_TabName,
                                                  @Field("Json_Data") String Json_Data,
                                                  @Field("Json_Image") String Json_Image,
                                                  @Field("Json_UserID") String UserID);

        @FormUrlEncoded
        @POST("ErrorMessage.ashx")
        Observable<BaseMsg> uploadBugFile(@Field("versioninfo") String versioninfo,
                                          @Field("mobileInfo") String mobileInfo,
                                          @Field("errorinfo") String errorinfo,
                                          @Field("UserID") String UserID);

        /**
         * @param uid       用户id
         * @param startDate 开始时间
         * @param endDate   结束时间
         * @param type      类型
         * @param txt       搜索内容
         * @param table     四证类型
         * @param FStId     主id
         * @return
         */
        @FormUrlEncoded
        @POST("GetSZKZJL.ashx")
        Observable<PrintRecordListBean> search(@Field("uid") int uid,
                                               @Field("kdate") String startDate,
                                               @Field("jdate") String endDate,
                                               @Field("type") String type,
                                               @Field("txt") String txt,
                                               @Field("table") String table,
                                               @Field("FStId") String FStId);


        //无害化死亡申报最初赋值
        @FormUrlEncoded
        @POST("UploadFourJson.ashx")
        Observable<WuHaiHuaUpLocaBaen> deadShenbao(@Field("fsuserid") int id,
                                                   @Field("TableName") String type,
                                                   @Field("json") String json);
        @FormUrlEncoded
        @POST("UploadFourJson.ashx")
        Observable<WuHaiHuaUpLocaBaen> myupload(@Field("fsuserid") String id,
                                                   @Field("TableName") String type,
                                                   @Field("json") String json);
//        @FormUrlEncoded
//        @POST("UploadWHHImages.ashx")
//        Observable<BaseMsgBean> uploadData(@Field("json") String json,
//                                           @Field("type") String type,
//                                           @Field("uid") int uid,
//                                           @Field("myguid") String myguid);
        @FormUrlEncoded
        @POST("GetEntitityJsonWhere.ashx")
        Observable<QueryTuZaiBean> getTuZaiData(@Field("Fsuserid") String id,
                                                @Field("TableName") String tableName,
                                                @Field("TId") String tid,
                                                @Field("Name") String name,
                                                @Field("Value") String value,
                                                @Field("Sdate") String sdate,
                                                @Field("Jdate") String jdate);

        @FormUrlEncoded
        @POST("GetEntitityJsonWhere.ashx")
        Observable<QueryListChangDI> getQChangDi(@Field("Fsuserid") String id,
                                                 @Field("TableName") String tableName,
                                                 @Field("TId") String tid,
                                                 @Field("Name") String name,
                                                 @Field("Value") String value,
                                                 @Field("Sdate") String sdate,
                                                 @Field("Jdate") String jdate);
        @FormUrlEncoded
        @POST("UploadWHHImages.ashx")
        Observable<PublicInformation> uploadQinchuDeathApply(
                @Field("BaseImages") String name,
                @Field("imageName") String uuid);

        @FormUrlEncoded
        @POST("GetSla_AccreditList.ashx")
        Observable<WuHaIHuaAddBean> getAddData(
                @Field("fsuserid") int name);


    }

    //获取服务器的时间
    public static Observable<BaseMsgBean> getDate() {
        return getRequest().getTime()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //用户登录
    public static Observable<UserBean> login1(String userName, String pwd) {
        return getRequest().login1(userName, pwd)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //上传
    public static Observable<BaseMsgBean> upload(String id, String tableName, String json) {
        return getRequest().upload(id, tableName, json)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //动物A查询
    public static Observable<QueryAnimABean> getAnimAListData(String id, String tableName, String tid, String name, String value,
                                                              String sdate, String jdate) {
        return getRequest().queryAnimaA(id, tableName, tid, name, value, sdate, jdate)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //动物B查询
    public static Observable<QueryAnimBBean> getAnimBListData(String id, String tableName, String tid, String name, String value,
                                                              String sdate, String jdate) {
        return getRequest().queryAnimaB(id, tableName, tid, name, value, sdate, jdate)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //无害化查询
    public static Observable<QueryWHHBean> getWhhData(String id, String tableName, String tid, String name, String value,
                                                      String sdate, String jdate) {
        return getRequest().queryWhh(id, tableName, tid, name, value, sdate, jdate)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 产品A 查询
     *
     * @param id
     * @param type
     * @param fStId
     * @param name
     * @param value
     * @param sdate
     * @param jdate
     * @return
     */
    public static Observable<QueryProductABean> getProductAListData(String id, String type, String fStId, String name, String value,
                                                                    String sdate, String jdate) {
        return getRequest().getProductAData(id, type, fStId, name, value, sdate, jdate)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 产品B 查询
     *
     * @param id
     * @param type
     * @param fStId
     * @param name
     * @param value
     * @param sdate
     * @param jdate
     * @return
     */
    public static Observable<QueryProductBBean> getProductBListData(String id, String type, String fStId, String name, String value,
                                                                    String sdate, String jdate) {
        return getRequest().getProductBData(id, type, fStId, name, value, sdate, jdate)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<WuHaIHuaAddBean> getAddData(int id) {
        return getRequest().getAddData(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //检疫证号
    public static Observable<BaseMsgBean> getJianyiZhenghao(String id, String tableName) {
        return getRequest().jianyiZhenghao(id, tableName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //获取界面的列表
    public static Observable<HomeBean> getPermissionList(String uid, String rid) {
        return getRequest().getPermissionList(uid, rid).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //初值
    public static Observable<WuHaiHuaUpLocaBaen> deadShenbao(int id, String type, String json) {
        return getRequest().deadShenbao(id, type, json)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }


    //上传
    public static Observable<PublicInformation> uploadQinchuDeathApply(String name, String uuid) {
        return getRequest().uploadQinchuDeathApply(name, uuid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    //屠宰检疫查询
    public static  Observable<QueryTuZaiBean> getTuZaiData(String id, String tableName, String tid, String name, String value,
                                                           String sdate, String jdate){
        return getRequest().getTuZaiData(id,tableName,tid,name,value,sdate,jdate)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    //场地检疫申报单查询
    public static Observable<QueryListChangDI> getListChangDi(String id, String tableName, String tid, String name, String value,
                                                              String sdate, String jdate){
        return getRequest().getQChangDi(id,tableName,tid,name,value,sdate,jdate)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    }

package bw.com.work14.util;

import android.os.Handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpUtil {
    Handler handler = new Handler();
    private static OkhttpUtil instant;
    private final OkHttpClient okHttpClient;

    public OkhttpUtil() {
        okHttpClient = new OkHttpClient
                .Builder()
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    public static OkhttpUtil getInstant() {
        if (instant==null){
            synchronized (OkhttpUtil.class){
                if (instant == null){
                    instant = new OkhttpUtil();
                }
            }
        }
        return instant;
    }
    public void post(String api, HashMap<String,String> params, final OkhttpCallBack callback){
      /*  FormBody.Builder formbody = new FormBody.Builder();
        for (Map.Entry<String, String> p : params.entrySet()) {
            formbody.add(p.getKey(),p.getValue());

        }
        FormBody build = formbody.build();*/
       /* StringBuilder p = new StringBuilder();
        if (params!=null&&params.size()>0) {
            for (Map.Entry<String, String> map : params.entrySet()) {

                p.append(map.getKey()).append("=");
            }
        }*/
        Request request = new Request.Builder()
                .url(api)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, IOException e) {
               if (callback!= null){
                   handler.post(new Runnable() {
                       @Override
                       public void run() {
                           callback.onFile("请求失败");
                       }
                   });
               }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                if (callback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(string);
                        }
                    });
                }
            }
        });
    }
}

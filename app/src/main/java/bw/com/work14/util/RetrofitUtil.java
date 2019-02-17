package bw.com.work14.util;

import bw.com.work14.api.ProduckApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static RetrofitUtil intanct;
    private final Retrofit retrofit;

    public RetrofitUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(ProduckApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public UserServicer setRetrofit(){
        return retrofit.create(UserServicer.class);
    }
    public static RetrofitUtil getIntanct() {
        if (intanct == null){
            synchronized (RetrofitUtil.class){
                if (intanct == null){
                    intanct = new RetrofitUtil();
                }
            }
        }
        return intanct;
    }
}

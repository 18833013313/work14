package bw.com.work14.util;

import java.util.HashMap;

import bw.com.work14.entity.ProduckBean;
import bw.com.work14.entity.ProduckXQBean;
import bw.com.work14.entity.SerchBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface UserServicer {
    //商品列表
    @GET
    Call<ProduckBean> Get(@Url String url, @QueryMap HashMap<String,String> map);
    //搜索展示
    @GET
    Call<SerchBean> GetSearch(@Url String url, @QueryMap HashMap<String,String> map);
    
    @GET
    Call<ProduckXQBean> GetXQ(@Url String url, @QueryMap HashMap<String,String> map);
}

package bw.com.work14.model;

import java.util.HashMap;

import bw.com.work14.api.ProduckApi;
import bw.com.work14.contract.ProduckContract;
import bw.com.work14.entity.ProduckBean;
import bw.com.work14.entity.ProduckXQBean;
import bw.com.work14.entity.SerchBean;
import bw.com.work14.request.RequestCallBack;
import bw.com.work14.util.OkhttpCallBack;
import bw.com.work14.util.OkhttpUtil;
import bw.com.work14.util.RetrofitUtil;
import bw.com.work14.util.UserServicer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProduckModel implements ProduckContract.IContent {

    @Override
    public void getList(HashMap<String, String> map, final RequestCallBack requestCallBack) {
        UserServicer userServicer = RetrofitUtil.getIntanct().setRetrofit();
        Call<ProduckBean> list = userServicer.Get(ProduckApi.RxxpApi, map);
        list.enqueue(new Callback<ProduckBean>() {
            @Override
            public void onResponse(Call<ProduckBean> call, Response<ProduckBean> response) {
                ProduckBean body = response.body();
                requestCallBack.onSuccess(body);
            }

            @Override
            public void onFailure(Call<ProduckBean> call, Throwable t) {

            }
        });
    }
    @Override
    public void getSerchList(HashMap<String, String> params, final RequestCallBack requestCallBack) {
        UserServicer userServicer = RetrofitUtil.getIntanct().setRetrofit();
        Call<SerchBean> serchBeanCall = userServicer.GetSearch(ProduckApi.SearchApi, params);
        serchBeanCall.enqueue(new Callback<SerchBean>() {
            @Override
            public void onResponse(Call<SerchBean> call, Response<SerchBean> response) {
                SerchBean body = response.body();
                requestCallBack.onSearChsuccess(body);
            }

            @Override
            public void onFailure(Call<SerchBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void getXQList(HashMap<String, String> params, final RequestCallBack requestCallBack) {
        UserServicer userServicer = RetrofitUtil.getIntanct().setRetrofit();
        Call<ProduckXQBean> produckXQBeanCall = userServicer.GetXQ(ProduckApi.RxxpmApi, params);

        produckXQBeanCall.enqueue(new Callback<ProduckXQBean>() {
            @Override
            public void onResponse(Call<ProduckXQBean> call, Response<ProduckXQBean> response) {
                ProduckXQBean body = response.body();
                requestCallBack.onSuccessXQ(body);
            }

            @Override
            public void onFailure(Call<ProduckXQBean> call, Throwable t) {

            }
        });
    }


}

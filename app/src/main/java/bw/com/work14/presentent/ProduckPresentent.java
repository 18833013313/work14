package bw.com.work14.presentent;

import com.google.gson.Gson;

import java.util.HashMap;

import bw.com.work14.contract.ProduckContract;
import bw.com.work14.entity.ProduckBean;
import bw.com.work14.entity.ProduckXQBean;
import bw.com.work14.entity.SerchBean;
import bw.com.work14.model.ProduckModel;
import bw.com.work14.request.RequestCallBack;

public class ProduckPresentent extends ProduckContract.IProcentent {
    private ProduckModel produckModel;
    private ProduckContract.IProduckView produckView;

    public ProduckPresentent(ProduckContract.IProduckView produckView) {
        this.produckModel = new ProduckModel();
        this.produckView = produckView;
    }


    @Override
    public void getList(HashMap<String, String> params) {
        produckModel.getList(params, new RequestCallBack() {
            @Override
            public void onFile(String msg) {

            }

            @Override
            public void onSuccess(ProduckBean produckBean) {
                if (produckView!=null){
                    produckView.ProduckSuccess(produckBean);
                }
            }

            @Override
            public void onSearChsuccess(SerchBean serchBean) {

            }

            @Override
            public void onSuccessXQ(ProduckXQBean result) {

            }


        });
    }

    @Override
    public void getXQList(HashMap<String, String> params) {
        produckModel.getXQList(params, new RequestCallBack() {
            @Override
            public void onFile(String msg) {
                produckView.XQFile(msg);
            }

            @Override
            public void onSuccess(ProduckBean produckBean) {

            }

            @Override
            public void onSearChsuccess(SerchBean serchBean) {

            }

            @Override
            public void onSuccessXQ(ProduckXQBean result) {
                if (produckView!=null){
                    produckView.XQSuccess(result);
                }
            }


        });
    }

    @Override
    public void getSerchList(HashMap<String, String> params) {
        produckModel.getSerchList(params, new RequestCallBack() {
            @Override
            public void onFile(String msg) {

            }

            @Override
            public void onSuccess(ProduckBean produckBean) {

            }

            @Override
            public void onSearChsuccess(SerchBean serchBean) {
                if (produckView!=null){
                    produckView.SerachSuccess(serchBean);
                }
            }

            @Override
            public void onSuccessXQ(ProduckXQBean result) {

            }


        });
    }
}

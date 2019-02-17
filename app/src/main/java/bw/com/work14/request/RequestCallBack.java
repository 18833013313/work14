package bw.com.work14.request;

import bw.com.work14.entity.ProduckBean;
import bw.com.work14.entity.ProduckXQBean;
import bw.com.work14.entity.SerchBean;

public interface RequestCallBack {
    void onFile(String msg);
    void onSuccess(ProduckBean produckBean);
    void onSearChsuccess(SerchBean serchBean);
    void onSuccessXQ(ProduckXQBean result);
}

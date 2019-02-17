package bw.com.work14.contract;

import java.util.HashMap;
import java.util.List;

import bw.com.work14.entity.ProduckBean;
import bw.com.work14.entity.ProduckXQBean;
import bw.com.work14.entity.SerchBean;
import bw.com.work14.request.RequestCallBack;

public interface ProduckContract {
    public abstract class IProcentent{
        protected abstract void getList(HashMap<String, String> params);
        protected abstract void getXQList(HashMap<String, String> params);
        protected abstract void getSerchList(HashMap<String, String> params);
    }
    interface IContent{
        void getList(HashMap<String,String> params, RequestCallBack requestCallBack);
        void getXQList(HashMap<String,String> params, RequestCallBack requestCallBack);
        void getSerchList(HashMap<String,String> params, RequestCallBack requestCallBack);
    }
    interface IProduckView{
        void ProduckFile(String msg);
        void ProduckSuccess(ProduckBean produckBean);
        void XQFile(String msg);
        void XQSuccess(ProduckXQBean produckXQBean);
        void SearchFile(String msg);
        void SerachSuccess(SerchBean serchBean);
    }
}

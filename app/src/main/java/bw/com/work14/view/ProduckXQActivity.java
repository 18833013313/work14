package bw.com.work14.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import bw.com.work14.R;
import bw.com.work14.adapter.ProduckXQAdapter;
import bw.com.work14.contract.ProduckContract;
import bw.com.work14.entity.ProduckBean;
import bw.com.work14.entity.ProduckXQBean;
import bw.com.work14.entity.SerchBean;
import bw.com.work14.presentent.ProduckPresentent;

public class ProduckXQActivity extends AppCompatActivity implements ProduckContract.IProduckView {


    private TextView price;
    private XRecyclerView xlv;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produck_xq);
        EventBus.getDefault().register(this);
        name = findViewById(R.id.name);

        price = findViewById(R.id.price);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void RequestId(String s){
   //     Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        HashMap<String,String> params = new HashMap<>();
        params.put("commodityId",s);
        ProduckPresentent produckPresentent = new ProduckPresentent(this);
        produckPresentent.getXQList(params);

    }
    @Override
    public void ProduckFile(String msg) {

    }

    @Override
    public void ProduckSuccess(ProduckBean produckBean) {

    }

    @Override
    public void XQFile(String msg) {


    }

    @Override
    public void XQSuccess(ProduckXQBean produckXQBean) {
 //       Toast.makeText(this,produckXQBean.result.categoryName,Toast.LENGTH_SHORT).show();
        String categoryName = produckXQBean.result.categoryName;

        name.setText(produckXQBean.result.commodityName);
        Toast.makeText(this,name+"",Toast.LENGTH_SHORT).show();
        price.setText(produckXQBean.result.price+"");


    }



    @Override
    public void SearchFile(String msg) {

    }

    @Override
    public void SerachSuccess(SerchBean serchBean) {

    }




}

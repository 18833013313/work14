package bw.com.work14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.common.internal.Objects;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import bw.com.work14.adapter.ProAdapter;
import bw.com.work14.adapter.ProduckAdapter;
import bw.com.work14.adapter.ProduckXQAdapter;
import bw.com.work14.contract.ProduckContract;
import bw.com.work14.entity.ProduckBean;
import bw.com.work14.entity.ProduckXQBean;
import bw.com.work14.entity.SerchBean;
import bw.com.work14.presentent.ProduckPresentent;

public class MainActivity extends AppCompatActivity implements ProduckContract.IProduckView {


    @BindView(R.id.xrlv)  XRecyclerView xrlv;
    private Button search;
    private EditText tiaojian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initData() {
        final ProduckPresentent produckPresentent = new ProduckPresentent(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = tiaojian.getText().toString();
                HashMap<String,String> params = new HashMap<>();
                params.put("keyword",string);
                params.put("page",1+"");
                params.put("count",5+"");
                produckPresentent.getSerchList(params);

            }
        });


     //   params.put("",);

    }



    private void initView() {
        xrlv = findViewById(R.id.xrlv);
        search = findViewById(R.id.souch);
        tiaojian = findViewById(R.id.tiaojian);
        ProduckPresentent produckPresentent = new ProduckPresentent(this);
        HashMap<String,String> params = new HashMap<>();
        produckPresentent.getList(params);
    }

    @Override
    public void ProduckFile(String msg) {

    }

    @Override
    public void ProduckSuccess(ProduckBean produckBean) {

  /*      ProduckAdapter produckAdapter = new ProduckAdapter(this,produckBean.result);
        xrlv.setLayoutManager(new GridLayoutManager(this,2));
        xrlv.setAdapter(produckAdapter);*/
    }

    @Override
    public void XQFile(String msg) {

    }

    @Override
    public void XQSuccess(ProduckXQBean produckXQBean) {

    }



    @Override
    public void SearchFile(String msg) {

    }

    @Override
    public void SerachSuccess(SerchBean serchBean) {
       Toast.makeText(this,serchBean.result.size()+"",Toast.LENGTH_SHORT).show();
        ProAdapter produckAdapter = new ProAdapter(this,serchBean.result);
        xrlv.setLayoutManager(new GridLayoutManager(this,2));
        xrlv.setAdapter(produckAdapter);
    }




}

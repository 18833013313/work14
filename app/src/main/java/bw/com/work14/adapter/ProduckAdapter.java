package bw.com.work14.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import bw.com.work14.R;
import bw.com.work14.entity.ProduckBean;
import bw.com.work14.view.ProduckXQActivity;

public class ProduckAdapter extends XRecyclerView.Adapter<ProduckAdapter.ViewHolder> {
    private Context context;
    private List<ProduckBean.ResultBean> list;

    public ProduckAdapter(Context context, List<ProduckBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.produck_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.price.setText(list.get(i).price+"");
        viewHolder.text.setText(list.get(i).commodityName);
        Glide.with(context).load(list.get(i).masterPic).into(viewHolder.image);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,ProduckXQActivity.class);
                context.startActivity(intent);
                EventBus.getDefault().post(list.get(i).commodityId+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView text;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.image)
        ImageView image;
        public ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this,view)   ;
        }
    }
}

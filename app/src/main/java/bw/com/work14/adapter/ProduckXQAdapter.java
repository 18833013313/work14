package bw.com.work14.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import bw.com.work14.R;
import bw.com.work14.entity.ProduckXQBean;

public class ProduckXQAdapter extends XRecyclerView.Adapter<ProduckXQAdapter.ViewHolder> {
    private Context context;
    private ProduckXQBean.ResultBean list;

    public ProduckXQAdapter(Context context, ProduckXQBean.ResultBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.produckxq_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.categoryName);
        viewHolder.price.setText(list.price+"");
        String[] split = list.picture.split("\\|");
        Glide.with(context).load(split[0]).into(viewHolder.tupian);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends XRecyclerView.ViewHolder {
        TextView price;
        TextView name;
        ImageView tupian;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             price = itemView.findViewById(R.id.price);
             name = itemView.findViewById(R.id.name);
             tupian = itemView.findViewById(R.id.tupian);
        }
    }
}

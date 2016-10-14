package test.zt.com.demomaterialdesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */

public class RVAdapter extends RecyclerView.Adapter {
    private List<String> datas;
    private Context context;

    public RVAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView itemView = new TextView(context);
        itemView.setGravity(Gravity.CENTER);
        itemView.setTextSize(50);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.MATCH_PARENT));
        return new RecyclerView.ViewHolder(itemView) {};
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TextView) holder.itemView).setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public void addAll(List<String> dd)
    {
        datas.addAll(dd);
        notifyDataSetChanged();
    }
}

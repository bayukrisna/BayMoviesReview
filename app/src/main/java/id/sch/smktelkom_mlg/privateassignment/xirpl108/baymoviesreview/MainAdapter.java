package id.sch.smktelkom_mlg.privateassignment.xirpl108.baymoviesreview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Bayu on 5/11/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<MainListItem> mainListItems;
    private Context context;

    public MainAdapter(List<MainListItem> mainListItems, Context context) {
        this.mainListItems = mainListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_item, parent, false);
        return new ViewHolder(v);
    } //menyambungkan ke xmlnya

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MainListItem homeListItem = mainListItems.get(position);// yg homeListItem digunakan untuk .load

        holder.textViewHead.setText(homeListItem.getHead());
        holder.textViewDesc.setText(homeListItem.getDesc());

        Glide
                .with(context)
                .load(homeListItem.getImageUri())
                .into(holder.imageViewOtof);
    }//mau diapakan viewnya

    @Override
    public int getItemCount() {
        return mainListItems.size();
    }//mengambil data, brp banyak data yg akan ditampilkan

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageViewOtof;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageViewOtof = (ImageView) itemView.findViewById(R.id.imageViewOtof);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayout);
        }
    }//inisialisasi
}

package be.trewep.portfolio;

import android.content.Context;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class portfolioAdapter extends RecyclerView.Adapter<portfolioAdapter.portfolioViewHolder> {

    private Context mContext;
    private ArrayList<portfolioItem> mPortfolioList;
    private onItemClickListener mListener;

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }

    public portfolioAdapter(Context context, ArrayList<portfolioItem> portfolioList) {
        mContext = context;
        mPortfolioList = portfolioList;
    }

    @NonNull
    @Override
    public portfolioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.portfolioitem, parent, false);
        return new portfolioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull portfolioViewHolder holder, int position) {
        portfolioItem currentItem = mPortfolioList.get(position);

        String title = currentItem.getTitle();
        String omschrijving = currentItem.getOmschrijving();
        String tag = currentItem.getTag();
        String link = currentItem.getLink();

        holder.mTextViewTitle.setText(title);



    }

    @Override
    public int getItemCount() {
        return mPortfolioList.size();
    }

    public class portfolioViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewTitle;


        public portfolioViewHolder(@NonNull View itemView) {

            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.text_view_title);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {

                        }mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}

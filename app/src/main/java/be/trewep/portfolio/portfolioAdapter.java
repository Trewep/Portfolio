package be.trewep.portfolio;

import android.content.Context;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class portfolioAdapter extends RecyclerView.Adapter<portfolioAdapter.portfolioViewHolder>{
    private Context mContext;
    private ArrayList<portfolioItem> mPortfolioList;
    private onItemClickListener mListener;
    private onItemClickListener mListenerShare;

    public interface onItemClickListener{

        void onItemClick(int position);
    }

    public void setOnClickListener(onItemClickListener listener, onItemClickListener listenerShare){
        mListener = listener;
        mListenerShare = listenerShare;
    }

    public portfolioAdapter(Context context, ArrayList<portfolioItem> portfolioList) {
        mContext = context;
        mPortfolioList = portfolioList;
    }


    @Override
    public portfolioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.portfolioitem, parent, false);
        return new portfolioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(portfolioViewHolder holder, int position) {
        portfolioItem currentItem = mPortfolioList.get(position);

        String title = currentItem.getTitle();
        String omschrijving = currentItem.getOmschrijving();
        String tag = currentItem.getTag();
        String link = currentItem.getLink();

        holder.mTextViewTitle.setText(title);
        holder.mTextViewOmschrijving.setText(omschrijving);
        holder.mTextViewtag.setText(tag);
        holder.mTextViewLink.setText(link);

    }

    @Override
    public int getItemCount() {
        return mPortfolioList.size();
    }

    public class portfolioViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextViewTitle;
        public TextView mTextViewOmschrijving;
        public TextView mTextViewtag;
        public TextView mTextViewLink;
        public Button mButton;

        public portfolioViewHolder(View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.text_view_title);
            mTextViewOmschrijving = itemView.findViewById(R.id.text_view_Omschrijving_detail);
            mTextViewtag = itemView.findViewById(R.id.text_view_tag_detail);
            mTextViewLink = itemView.findViewById(R.id.text_view_link_detail);
            mButton = itemView.findViewById(R.id.share);

            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListenerShare != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListenerShare.onItemClick(position);
                        }
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
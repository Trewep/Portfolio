package be.trewep.portfolio;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class portfoioAdapter  extends RecyclerView.Adapter<portfoioAdapter.portfolioViewHolder> {

    public class portfolioViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextViewTitle

        public portfolioViewHolder(@NonNull View itemView) {

            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.text_view_title);
        }
    }
}

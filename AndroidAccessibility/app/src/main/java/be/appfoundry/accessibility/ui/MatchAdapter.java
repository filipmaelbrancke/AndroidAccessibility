package be.appfoundry.accessibility.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import be.appfoundry.accessibility.R;
import be.appfoundry.accessibility.model.Match;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;


public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private final List<Match> items;
    private final MatchListener listener;

    public MatchAdapter(final List<Match> items, final MatchListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        Match match = items.get(position);
        holder.bind(match, listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.match)
        MatchView matchView;

        public MatchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(@NonNull final Match match, final MatchListener listener) {
            matchView.setMatch(match, listener);
        }
    }
}

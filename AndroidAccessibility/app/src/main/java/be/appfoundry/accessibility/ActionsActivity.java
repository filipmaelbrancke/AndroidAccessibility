package be.appfoundry.accessibility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import be.appfoundry.accessibility.model.Match;
import be.appfoundry.accessibility.model.MatchMaker;
import be.appfoundry.accessibility.ui.MatchAdapter;
import be.appfoundry.accessibility.ui.MatchListener;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionsActivity extends AppCompatActivity {

    @BindView(R.id.match_list)
    RecyclerView recyclerView;
    private MatchAdapter adapter;

    private MatchListener matchListener = new MatchListener() {
        @Override
        public void onMatchClicked(Match match) {
            showToast("match clicked");
        }

        @Override
        public void onMatchComment(Match match) {
            showToast("match reaction");
        }

        @Override
        public void onMatchShare(Match match) {
            showToast("match share");
        }

        @Override
        public void onMatchLiked(Match match) {
            showToast("match like");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        ButterKnife.bind(this);

        adapter = new MatchAdapter(MatchMaker.generateDummyMatches(), matchListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void showToast(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

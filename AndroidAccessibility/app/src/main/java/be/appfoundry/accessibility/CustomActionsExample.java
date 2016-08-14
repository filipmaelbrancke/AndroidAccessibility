package be.appfoundry.accessibility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import be.appfoundry.accessibility.model.Match;
import be.appfoundry.accessibility.model.MatchMaker;
import be.appfoundry.accessibility.ui.MatchListener;
import be.appfoundry.accessibility.ui.MatchView;
import be.appfoundry.accessibility.utils.AccessibilityHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomActionsExample extends AppCompatActivity {

    @BindView(R.id.example_matchview)
    MatchView matchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_actions_example);

        ButterKnife.bind(this);

        Match match = MatchMaker.generateDummyMatch1();
        boolean isAccessibilityEnabled = AccessibilityHelper.newInstance(this).isAccessibilityEnabled();
        matchView.setMatch(match, isAccessibilityEnabled ? accessibilityMatchListener : matchListener);
    }

    private MatchListener matchListener = new MatchListener() {
        @Override
        public void onMatchClicked(Match match) {
            showToast("Go to match detail for " + match.displayTitle());
        }

        @Override
        public void onMatchComment(Match match) {
            showToast("Comment on '" + match.matchRecap() + "'");
        }

        @Override
        public void onMatchShare(Match match) {
            showToast("Share match " + match.displayTitle());
        }

        @Override
        public void onMatchLiked(Match match) {
            showToast("Liked match " + match.displayTitle());
        }
    };

    private MatchListener accessibilityMatchListener = new MatchListener() {
        @Override
        public void onMatchClicked(Match match) {
            showToast("Accessible match detail!");
        }

        @Override
        public void onMatchComment(Match match) {
            showToast("Accessible match comment!");
        }

        @Override
        public void onMatchShare(Match match) {
            showToast("Accessible match share!");
        }

        @Override
        public void onMatchLiked(Match match) {
            showToast("Accessible match like!");
        }
    };

    private void showToast(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

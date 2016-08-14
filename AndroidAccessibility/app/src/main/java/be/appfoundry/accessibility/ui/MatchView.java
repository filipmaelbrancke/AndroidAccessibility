package be.appfoundry.accessibility.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import be.appfoundry.accessibility.R;
import be.appfoundry.accessibility.model.Match;
import be.appfoundry.accessibility.utils.AccessibilityHelper;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;

public class MatchView extends LinearLayout {

    @BindView(R.id.home_team_name)
    TextView homeTeamName;
    @BindView(R.id.home_team_icon)
    ImageView homeTeamIcon;
    @BindView(R.id.away_team_name)
    TextView awayTeamName;
    @BindView(R.id.away_team_icon)
    ImageView awayTeamIcon;
    @BindView(R.id.score)
    TextView score;
    @BindView(R.id.recap)
    TextView description;
    @BindView(R.id.comment_button)
    Button commentButton;
    @BindView(R.id.share_button)
    Button shareButton;
    @BindView(R.id.like_button)
    Button likeButton;

    public MatchView(Context context) {
        super(context);
        init();
    }

    public MatchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MatchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.match_recap, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public  void setMatch(final Match match) {
        setMatch(match, null);
    }

    public void setMatch(final Match match, final MatchListener listener) {
        homeTeamName.setText(match.homeTeam());
        awayTeamName.setText(match.awayTeam());
        score.setText(match.displayScore());
        description.setText(match.matchRecap());

        Picasso.with(getContext()).load(match.homeImageUrl()).into(homeTeamIcon);
        Picasso.with(getContext()).load(match.awayImageUrl()).into(awayTeamIcon);

        ViewCompat.setAccessibilityDelegate(this, new MatchAccessibilityDelegate(match, listener));

        if (listener != null) {
            setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isAccessibilityEnabled = AccessibilityHelper.newInstance(getContext()).isAccessibilityEnabled();
                    if (isAccessibilityEnabled) {
                        showCustomActions(match);
                    } else {
                        listener.onMatchClicked(match);
                    }
                }
            });

            commentButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMatchComment(match);
                }
            });
            shareButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMatchShare(match);
                }
            });
            likeButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMatchLiked(match);
                }
            });
        }
    }

    private void showCustomActions(final Match match) {
        String[] labels = new String[] {"Go to match detail", "Comment", "Share", "Like"};
        DialogInterface.OnClickListener dialogItemClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        };

        new AlertDialog.Builder(getContext())
            .setTitle("Accessibility options")
            .setItems(labels, dialogItemClickListener)
            .create()
            .show();
    }

    public static class MatchAccessibilityDelegate extends AccessibilityDelegateCompat {

        private final Match match;
        private final MatchListener listener;

        public MatchAccessibilityDelegate(final Match match, final MatchListener listener) {
            this.match = match;
            this.listener = listener;
        }

        @Override
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.match_detail_view, "Go to match detail"));
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.comment_button, "Comment"));
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.share_button, "Share"));
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.like_button, "Like"));
        }

        @Override
        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            switch (action) {
                case R.id.match_detail_view:
                    listener.onMatchClicked(match);
                    return true;
                case R.id.comment_button:
                    listener.onMatchComment(match);
                    return true;
                case R.id.share_button:
                    listener.onMatchShare(match);
                    return true;
                case R.id.like_button:
                    listener.onMatchLiked(match);
                    return true;
                default: return super.performAccessibilityAction(host, action, args);
            }

        }
    }
}

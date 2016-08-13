package be.appfoundry.accessibility.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import be.appfoundry.accessibility.R;
import be.appfoundry.accessibility.model.Match;
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

    public void setMatch(final Match match, final MatchListener listener) {
        homeTeamName.setText(match.homeTeam());
        awayTeamName.setText(match.awayTeam());
        score.setText(match.displayScore());
        description.setText(match.matchRecap());

        Picasso.with(getContext()).load(match.homeImageUrl()).into(homeTeamIcon);
        Picasso.with(getContext()).load(match.awayImageUrl()).into(awayTeamIcon);

        if (listener != null) {
            setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMatchClicked(match);
                }
            });
        }
    }
}

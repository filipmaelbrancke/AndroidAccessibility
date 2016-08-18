package be.appfoundry.accessibility.ui;

import be.appfoundry.accessibility.model.Match;

public interface MatchListener {

    void onMatchClicked(Match match);

    void onMatchComment(Match match);

    void onMatchShare(Match match);

    void onMatchLiked(Match match);
}

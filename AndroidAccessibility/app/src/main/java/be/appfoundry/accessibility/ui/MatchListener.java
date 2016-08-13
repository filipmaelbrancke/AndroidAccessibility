package be.appfoundry.accessibility.ui;

import be.appfoundry.accessibility.model.Match;

/**
 * @author Filip Maelbrancke
 */
public interface MatchListener {

    void onMatchClicked(Match match);

    void onMatchReaction(Match match);

    void onMatchShare(Match match);

    void onMatchLiked(Match match);
}

package be.appfoundry.accessibility.model;

import android.os.Parcelable;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Match implements Parcelable {

    public abstract int id();

    public abstract String homeTeam();

    public abstract String awayTeam();

    public abstract int homeScore();

    public abstract int awayScore();

    public abstract String homeImageUrl();

    public abstract String awayImageUrl();

    public abstract String matchRecap();

    public String displayTitle() {
        return homeTeam() + " - " + awayTeam();
    }

    public String displayScore() {
        return homeScore() + " - " + awayScore();
    }

    @AutoValue.Builder
    public static abstract class Builder {

        public abstract Builder id(int id);

        public abstract Builder homeTeam(String homeTeam);

        public abstract Builder awayTeam(String awayTeam);

        public abstract Builder homeScore(int homeScore);

        public abstract Builder awayScore(int awayScore);

        public abstract Builder homeImageUrl(String imageUrl);

        public abstract Builder awayImageUrl(String imageUrl);

        public abstract Builder matchRecap(String recap);

        public abstract Match build();
    }

    public static Builder builder() {
        return new AutoValue_Match.Builder();
    }
}

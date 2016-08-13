package be.appfoundry.accessibility.model;

import com.google.common.collect.Lists;
import java.util.List;

public class MatchMaker {

    public static List<Match> generateDummyMatches() {
        return Lists.newArrayList(generateDummyMatch1(), generateDummyMatch2(), generateDummyMatch3(), generateDummyMatch4());
    }

    public static Match generateDummyMatch1() {
        final Match dummyMatch = Match.builder()
            .id(123)
            .homeTeam("Real Madrid")
            .awayTeam("Liverpool")
            .homeImageUrl("http://images.vrt.be/orig/contentapi/infostrada/team/4103.png")
            .awayImageUrl("http://images.vrt.be/orig/contentapi/infostrada/team/4075.png")
            .homeScore(2)
            .awayScore(3)
            .matchRecap("Fantastic work by Simon Mignolet keeps the points in Liverpool.")
            .build();
        return dummyMatch;
    }

    public static Match generateDummyMatch2() {
        final Match dummyMatch = Match.builder()
            .id(234)
            .homeTeam("Chelsea")
            .awayTeam("Arsenal")
            .homeImageUrl("http://images.vrt.be/orig/contentapi/infostrada/team/4034.png")
            .awayImageUrl("http://images.vrt.be/orig/contentapi/infostrada/team/4007.png")
            .homeScore(2)
            .awayScore(0)
            .matchRecap("Chelsea wins, thanks to its Belgian players Courtois and Hazard.")
            .build();
        return dummyMatch;
    }

    public static Match generateDummyMatch3() {
        final Match dummyMatch = Match.builder()
            .id(345)
            .homeTeam("Barcelona")
            .awayTeam("Real Madrid")
            .homeImageUrl("http://images.vrt.be/orig/contentapi/infostrada/team/4014.png")
            .awayImageUrl("http://images.vrt.be/orig/contentapi/infostrada/team/4103.png")
            .homeScore(1)
            .awayScore(1)
            .matchRecap("Both teams share the points after an immensely exciting game.")
            .build();
        return dummyMatch;
    }

    public static Match generateDummyMatch4() {
        final Match dummyMatch = Match.builder()
            .id(456)
            .homeTeam("Juventus")
            .awayTeam("Everton")
            .homeImageUrl("http://images.vrt.be/orig/contentapi/infostrada/team/4067.png")
            .awayImageUrl("http://images.vrt.be/orig/contentapi/infostrada/team/4047.png")
            .homeScore(1)
            .awayScore(0)
            .matchRecap("Initially Everton did well, but gave away the advantage after 2 red cards.")
            .build();
        return dummyMatch;
    }

    // real madrid : http://images.vrt.be/orig/contentapi/infostrada/team/4103.png
    // liverpool: http://images.vrt.be/orig/contentapi/infostrada/team/4075.png

    // Everton : http://images.vrt.be/orig/contentapi/infostrada/team/4047.png
    // Arsenal: http://images.vrt.be/orig/contentapi/infostrada/team/4007.png
    // Chelsea : http://images.vrt.be/orig/contentapi/infostrada/team/4034.png
    // Barcelona : http://images.vrt.be/orig/contentapi/infostrada/team/4014.png
    // Real Madrid : http://images.vrt.be/orig/contentapi/infostrada/team/4103.png
    // Juventus : http://images.vrt.be/orig/contentapi/infostrada/team/4067.png

}

package id.ac.ukdw.fti.rpl.kelompokholy.model;

public class Verses {
    private int verseId;
    private String verse;
    private String verseText;
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEventDescribed() {
        return eventDescribed;
    }

    public void setEventDescribed(String eventDescribed) {
        this.eventDescribed = eventDescribed;
    }

    private String eventDescribed;

    public void setVerseId(int verseId) {
       this.verseId = verseId;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public void setVerseText(String verseText) {
        this.verseText = verseText;
    }

    public int getVerseId() {
        return this.verseId;
    }

    public String getVerse() {
        return this.verse;
    }

    public String getVerseText() {
        return this.verseText;
    }
}

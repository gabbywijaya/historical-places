package id.ac.ukdw.fti.rpl.kelompokholy.dao;

import id.ac.ukdw.fti.rpl.kelompokholy.config.Database;
import id.ac.ukdw.fti.rpl.kelompokholy.model.Verses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainDAO extends Database {

    public static MainDAO getInstance() {
        return new MainDAO();
    }

    public ObservableList<Verses> getAllVerses() {
        ObservableList<Verses> verses = FXCollections.observableArrayList();

        try {
            String query = "SELECT verseID, osisRef, verseText, eventsDescribed, places FROM verses ORDER BY verseID ASC";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Verses verse = new Verses();
                verse.setVerseId(result.getInt("verseID"));
                verse.setVerse(result.getString("osisRef"));
                verse.setVerseText(result.getString("verseText"));
                verse.setPlace(result.getString("places"));
                verse.setEventDescribed(result.getString("eventsDescribed"));
                verses.add(verse);
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        return verses;
    }

    public ObservableList<Verses> findVerses(String value) {
        ObservableList<Verses> verses = FXCollections.observableArrayList();

        try {
            String query = "SELECT verseID, osisRef, verseText, eventsDescribed, places FROM verses WHERE places LIKE ? OR eventsDescribed LIKE ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + value + "%");
            statement.setString(2, "%" + value + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Verses verse = new Verses();
                verse.setVerseId(result.getInt("verseID"));
                verse.setVerse(result.getString("osisRef"));
                verse.setVerseText(result.getString("verseText"));
                verse.setPlace(result.getString("places"));
                verse.setEventDescribed(result.getString("eventsDescribed"));
                verses.add(verse);
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        return verses;
    }
}

package id.ac.ukdw.fti.rpl.kelompokholy.dao;


import id.ac.ukdw.fti.rpl.kelompokholy.config.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO extends Database {

    public static LoginDAO getInstance() {
        return new LoginDAO();
    }

    public boolean doLogin(String username, String password) {
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";

            PreparedStatement conn = connection.prepareStatement(query);
            conn.setString(1, username);
            conn.setString(2, password);
            ResultSet result = conn.executeQuery();

            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

module kelompokholy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;

    opens id.ac.ukdw.fti.rpl.kelompokholy to javafx.fxml;
    exports id.ac.ukdw.fti.rpl.kelompokholy;
    opens id.ac.ukdw.fti.rpl.kelompokholy.controller;
    opens id.ac.ukdw.fti.rpl.kelompokholy.dao;
    exports id.ac.ukdw.fti.rpl.kelompokholy.model;
    exports id.ac.ukdw.fti.rpl.kelompokholy.config;

}

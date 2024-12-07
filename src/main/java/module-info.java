module edu.umb.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens edu.umb.javafx to javafx.fxml;
    exports edu.umb.javafx;
}
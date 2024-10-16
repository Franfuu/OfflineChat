module com.github.Franfuu {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.Franfuu.view to javafx.fxml;
    exports com.github.Franfuu.view;
    exports com.github.Franfuu;
    opens com.github.Franfuu to javafx.fxml;

}

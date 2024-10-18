module com.github.Franfuu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    opens com.github.Franfuu.model.entity to java.xml.bind;

    opens com.github.Franfuu.view to javafx.fxml;
    exports com.github.Franfuu.view;
    exports com.github.Franfuu;
    opens com.github.Franfuu to javafx.fxml;

}


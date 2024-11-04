module org.intro.examen {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.intro.prueba to javafx.fxml;
    exports org.intro.prueba;
}
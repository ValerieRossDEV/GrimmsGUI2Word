module valerie.grimms.grimmsgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi.ooxml;


    opens valerie.grimms.grimmsgui to javafx.fxml;
    exports valerie.grimms.grimmsgui;
}
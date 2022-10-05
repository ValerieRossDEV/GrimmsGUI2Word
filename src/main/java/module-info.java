module valerie.grimms.grimmsgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires org.apache.logging.log4j;
    requires java.desktop;


    opens valerie.grimms.grimmsgui to javafx.fxml;
    exports valerie.grimms.grimmsgui;
}
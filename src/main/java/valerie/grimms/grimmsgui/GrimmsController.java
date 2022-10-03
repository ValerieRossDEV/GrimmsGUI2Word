package valerie.grimms.grimmsgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GrimmsController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Nothing");
    }

    protected void insertText() {
        //logic for Wordinsert
    }
    @FXML
    protected void onFrogKingClick() {
        //dynamically inserted by using insertText() method
    }

    @FXML
    protected void onRapunzelClick() {
        //dynamically inserted by using insertText() method
    }

    @FXML
    protected void onHanselAndGretelClick() {
        //dynamically inserted by using insertText() method
    }
}
package valerie.grimms.grimmsgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import org.apache.poi.xwpf.usermodel.*;
import valerie.grimms.grimmsgui.data.HanselAndGretel;
import valerie.grimms.grimmsgui.data.Rapunzel;
import valerie.grimms.grimmsgui.data.TheFrogKing;


import java.io.FileOutputStream;
import java.io.IOException;

public class GrimmsController {
    @FXML
    private Label welcomeText;

    @FXML
    ToggleGroup group1;

    @FXML
    RadioButton frogKing;

    @FXML
    RadioButton rapunzel;

    @FXML
    RadioButton hanselAndGretel;

    static String textSelected = "";

    protected static void insertText() throws IOException {
        XWPFDocument doc = new XWPFDocument();

        XWPFParagraph p1 = doc.createParagraph();
        p1.setAlignment(ParagraphAlignment.CENTER);
        p1.setBorderTop(Borders.DOUBLE);
        p1.setVerticalAlignment(org.apache.poi.xwpf.usermodel.TextAlignment.TOP);

        XWPFRun r1 = p1.createRun();
        r1.setText(textSelected);

        try (FileOutputStream out = new FileOutputStream("FairyTale.docx")) {
            doc.write(out);
        }
    }
    @FXML
    protected void onFrogKingClick() {
        textSelected = TheFrogKing.text;

    }

    @FXML
    protected void onRapunzelClick() {
        textSelected = Rapunzel.text;
    }

    @FXML
    protected void onHanselAndGretelClick() {
        textSelected = HanselAndGretel.text;
    }

    //still need to implement listener for togglegroup & if function in main method
}
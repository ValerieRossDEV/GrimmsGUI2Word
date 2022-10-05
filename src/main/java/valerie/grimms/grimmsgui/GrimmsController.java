package valerie.grimms.grimmsgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import org.apache.poi.xwpf.usermodel.*;
import valerie.grimms.grimmsgui.data.HanselAndGretel;
import valerie.grimms.grimmsgui.data.Rapunzel;
import valerie.grimms.grimmsgui.data.TheFrogKing;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Desktop;

public class GrimmsController {

    //associating fxml elements with tags to be able to work them via java code
    @FXML
    Label labelInstructions;

    @FXML
    ToggleGroup group1;

    @FXML
    RadioButton frogKing;

    @FXML
    RadioButton rapunzel;

    @FXML
    RadioButton hanselAndGretel;

    //instantiating some global static variables
    static String textSelected = "";

    static String userDirectory= "";

    //method for writing text into Word docx document
    protected static void insertText() throws IOException {
        try (XWPFDocument doc = new XWPFDocument()) {

            XWPFParagraph p1 = doc.createParagraph();
            p1.setAlignment(ParagraphAlignment.CENTER);
            p1.setBorderTop(Borders.DOUBLE);
            p1.setVerticalAlignment(TextAlignment.TOP);

            XWPFRun r1 = p1.createRun();
            r1.setText(textSelected);

            try (FileOutputStream out = new FileOutputStream("FairyTale.docx")) {
                doc.write(out);
            }
        }
    }
    // getting the Current Working Directory to be able later to open the word document
    public static void getCurrentWorkingDirectory() {
        userDirectory = System.getProperty("user.dir");

    }
    // opening the generated document with program associated to docx
    protected static void openDocument(){
        getCurrentWorkingDirectory();

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(userDirectory + "\\FairyTale.docx"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //defining radiobutton behavior
    @FXML
    protected void onFrogKingClick() throws Exception {
        textSelected = TheFrogKing.getText();
        insertText();
        labelInstructions.setText("Word Document with Frog King fairy tale text generated.");
        openDocument();
    }

    @FXML
    protected void onRapunzelClick() throws Exception {
        textSelected = Rapunzel.getText();
        insertText();
        labelInstructions.setText("Word Document with Rapunzel fairy tale text generated.");
        openDocument();
    }

    @FXML
    protected void onHanselAndGretelClick() throws Exception {
        textSelected = HanselAndGretel.getText();
        insertText();
        labelInstructions.setText("Word Document with Hansel and Gretel fairy tale text generated.");
        openDocument();
    }
}
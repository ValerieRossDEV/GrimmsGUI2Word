package valerie.grimms.grimmsgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFRun;
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

    static String titleSelected = "";

    static String authorSelected= "";

    //method for writing text into Word docx document
    protected static void insertText() throws IOException {
        try (XWPFDocument doc = new XWPFDocument()) {

            //first paragraph - passing the title of the fairy tale
            XWPFParagraph p1 = doc.createParagraph();
            p1.setAlignment(ParagraphAlignment.CENTER);
            p1.setBorderTop(Borders.DOUBLE);
            p1.setVerticalAlignment(TextAlignment.TOP);


            XWPFRun r1 = p1.createRun();
            r1.setFontSize(16);
            r1.setBold(true);
            r1.setText(titleSelected);

            //second paragraph - passing the author name of the fairy tale
            XWPFParagraph p2 =doc.createParagraph();
            p2.setAlignment(ParagraphAlignment.CENTER);
            p2.setBorderBottom(Borders.DOUBLE_WAVE);
            p2.setVerticalAlignment(TextAlignment.TOP);


            XWPFRun r2 = p2.createRun();
            r2.setText("by " + authorSelected);
            r2.setFontSize(14);
            r2.setBold(true);

            //third paragraph - passing the text of the fairy tale

            XWPFParagraph p3 = doc.createParagraph();
            //p3.setAlignment(ParagraphAlignment.CENTER);
            p3.setBorderBottom(Borders.SINGLE);
            p3.setVerticalAlignment(TextAlignment.CENTER );
            p3.setIndentationFirstLine(3);

            XWPFRun r3 = p3.createRun();
            r3.setText(textSelected);


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
        titleSelected = TheFrogKing.getTitle();
        authorSelected = TheFrogKing.getAuthor();
        textSelected = TheFrogKing.getText();
        insertText();
        labelInstructions.setText("Word Document with Frog King fairy tale text was generated.");
        openDocument();
    }

    @FXML
    protected void onRapunzelClick() throws Exception {
        titleSelected = Rapunzel.getTitle();
        authorSelected = Rapunzel.getAuthor();
        textSelected = Rapunzel.getText();
        insertText();
        labelInstructions.setText("Word Document with Rapunzel fairy tale text was generated.");
        openDocument();
    }

    @FXML
    protected void onHanselAndGretelClick() throws Exception {
        titleSelected = HanselAndGretel.getTitle();
        authorSelected = HanselAndGretel.getAuthor();
        textSelected = HanselAndGretel.getText();
        insertText();
        labelInstructions.setText("Word Document with Hansel and Gretel fairy tale text was generated.");
        openDocument();
    }
}
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    Operace op = new Operace();

    @FXML
    private Label cislickoDec;
    @FXML
    private Label cislickoBin;
    @FXML
    private Label cislickoHex;
    @FXML
    private TextField odpoved1a;
    @FXML
    private TextField odpoved1b;
    @FXML
    private TextField odpoved1c;
    @FXML
    private TextField odpoved2a;
    @FXML
    private TextField odpoved2b;
    @FXML
    private TextField odpoved2c;
    @FXML
    private Button btn;
    @FXML
    private Label bodyLbl;

    public String cislicko1, cislicko2, cislicko3;
    public String odpoved1bin, odpoved1hex, odpoved2dec, odpoved2hex, odpoved3dec, odpoved3bin;

    int body = 0;
    int maxBody = -6;

    @FXML
    void onBtnPressed(ActionEvent event) throws InterruptedException {

        btn.setText("Vyhodnotit");

        if(odpoved1a.getText().equals(odpoved1bin)) body++;
        if(odpoved2a.getText().equals(odpoved1hex)) body++;
        if(odpoved1b.getText().equals(odpoved2dec)) body++;
        if(odpoved2b.getText().equals(odpoved2hex)) body++;
        if(odpoved1c.getText().equals(odpoved3dec)) body++;
        if(odpoved2c.getText().equals(odpoved3bin)) body++;

        odpoved1a.setText("");
        odpoved2a.setText("");
        odpoved1b.setText("");
        odpoved2b.setText("");
        odpoved1c.setText("");
        odpoved2c.setText("");

        cislicko1 = op.generovat(1, 250);
        cislicko2 = op.generovat(1, 250);
        cislicko3 = op.generovat(1, 250);

        odpoved1bin = op.dec2bin(cislicko1);    odpoved1hex = op.dec2hex(cislicko1);
        odpoved2dec = cislicko2;            odpoved2hex = op.dec2hex(cislicko2);
        odpoved3dec = cislicko3;            odpoved3bin = op.dec2bin(cislicko3);

        cislickoDec.setText(cislicko1);
        cislickoBin.setText(op.dec2bin(cislicko2));
        cislickoHex.setText(op.dec2hex(cislicko3));

        System.out.println(cislicko1 + " - " + odpoved1bin + " - " + odpoved1hex);
        System.out.println(op.dec2bin(cislicko2) + " - " + odpoved2dec + " - " + odpoved2hex);
        System.out.println(op.dec2hex(cislicko3) + " - " + odpoved3dec + " - " + odpoved3bin);

        maxBody+=6;

        System.out.println("Body: " + body + "/" + maxBody + "\n");
        bodyLbl.setText("Body: " + body + "/" + maxBody);
    }
}
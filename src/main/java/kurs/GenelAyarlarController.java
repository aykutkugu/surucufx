/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author aykut
 */
public class GenelAyarlarController implements Initializable {

    
    @FXML
    private BorderPane brd_genelAyarlar;
    
    @FXML
    private Label lbl_kurumBilgileri;

    @FXML
    private Label lbl_altProgramlar;

    @FXML
    private Label lbl_mebbis;

    @FXML
    private Label lbl_milliEgitim;    
    

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
    
    
    @FXML
    void altProgramSec(MouseEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/fxml/Ayarlar/AltProgramlar.fxml"));
        brd_genelAyarlar.setCenter(pane);
    }
    
}

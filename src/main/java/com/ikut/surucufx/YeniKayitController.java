/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikut.surucufx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author aykut
 */
public class YeniKayitController implements Initializable {

    @FXML private BorderPane brd_yeniKayit;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            genel();
        } catch (IOException ex) {
            Logger.getLogger(YeniKayitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void evrakKayit() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/YeniKayit/EvrakKayit.fxml"));
        brd_yeniKayit.setCenter(pane);
    }

    @FXML
    void genel() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/YeniKayit/Genel.fxml"));
        brd_yeniKayit.setCenter(pane);
    }
    
}

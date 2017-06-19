/**/
package com.ikut.surucufx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private TabPane tbp_center;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }

    @FXML
    void kursiyerKayitlari(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/KayitGetir.fxml"));
        Stage kursiyerKayitlari = new Stage();
            kursiyerKayitlari.setTitle("Kursiyer Kayıtları");
        Scene scene = new Scene(pane);
            kursiyerKayitlari.setScene(scene);
            kursiyerKayitlari.show();
    }

    @FXML
    void yeniKayit(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/YeniKayit/YeniKayit.fxml"));
        Tab tab = new Tab();
            tab.setText("Yeni Kayıt");
            tab.setContent(pane);
        tbp_center.getTabs().add(tab);
        tbp_center.getSelectionModel().select(tab);
    }

    @FXML
    void genelAyarlar(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/fxml/Ayarlar/GenelAyarlar.fxml"));
        Stage genelAyarlar = new Stage();
            genelAyarlar.setTitle("Genel Ayarlar");
            genelAyarlar.initModality(Modality.APPLICATION_MODAL);
            
        Scene scene = new Scene(pane);
            genelAyarlar.setScene(scene);
            genelAyarlar.show();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikut.surucufx;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import kursiyer.Kursiyer;

/**
 *
 * @author aykut
 */
public class GenelController implements Initializable {

    private final ObservableList<String> belgeTuru = FXCollections
            .observableArrayList("Sertifika", "Ehliyet");

    private final ObservableList<String> yazSinav = FXCollections
            .observableArrayList("e-sınav", "Normal Sınav");

    public ObservableList<String> siniflar = FXCollections.observableArrayList();

    @FXML
    private DatePicker dtp_dogum;

    @FXML
    private TextField txt_adi;
    
    @FXML
    private TextField txt_soyad;

    @FXML
    private TextField txt_tcNo;

    @FXML
    private TextField txt_cep;


    @FXML
    private ChoiceBox<String> cho_murSinifi;

    @FXML
    private ChoiceBox<String> cho_yazSinav;

    @FXML
    private ChoiceBox<String> cho_belgeTuru;

    @FXML
    private ChoiceBox<String> cho_belgeSinifi;

    @FXML
    private DatePicker dtp_belgeTarihi;

    @FXML
    private ComboBox<String> cmb_kursUcreti;

    @FXML
    private TextField txt_belgeSayisi;

    @FXML
    private TextField txt_verYer;

    @FXML
    private Text txt_sinifGosterici;

    @FXML
    private Text txt_adayNo;

    @FXML
    private Label lbl_yas;

    @FXML
    private TitledPane tlp_mevcutBelge;

    @FXML
    private TableView<?> tbv_yazSinav;

    @FXML
    private TableView<?> tbv_dirSinav;

    int sinifIndex = -1;
    int murSinifIndex = -1;

    Kursiyer kursiyer = new Kursiyer();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cho_belgeTuru.setItems(belgeTuru);
        cho_belgeTuru.setValue(belgeTuru.get(1));
        cho_yazSinav.setItems(yazSinav);
        cho_yazSinav.setValue(yazSinav.get(1));
        cho_belgeSinifi.setItems(Sinif.sinif);
        cho_murSinifi.setItems(siniflar());

        converter(dtp_dogum);
        converter(dtp_belgeTarihi);

        cho_belgeSinifi.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                sinifIndex = newValue.intValue();
                System.out.println("Sınıf index => " + sinifIndex);
                txt_sinifGosterici.setText("");
                if (sinifIndex != -1) {
                    if (cho_belgeTuru.getSelectionModel().getSelectedIndex() == 0) {
                        tlp_mevcutBelge.setText("MEVCUT BELGE ->  " + Sinif.sinif.get(sinifIndex) + " SINIFI SERTİFİKA");
                    } else {
                        tlp_mevcutBelge.setText("MEVCUT BELGE -> " + Sinif.sinif.get(sinifIndex) + " SINIFI EHLİYET");
                    }
                    tlp_mevcutBelge.setExpanded(false);
                    kursiyer.mctBelSinifi = cho_belgeSinifi.getItems().get(sinifIndex);
                    txt_sinifGosterici.setText(kursiyer.mctBelSinifi);
                }
            }
        });

        cho_murSinifi.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                murSinifIndex = newValue.intValue();
            }
        });
    }

    @FXML
    void dogumTarihi(ActionEvent event) {
        int yas = (LocalDate.now().getYear()) - (dtp_dogum.getValue().getYear());
        //lbl_yas.setFont(Font.font("Ubuntu", 15)); //font ve boyut ayarı
        int dgunu = dtp_dogum.getValue().getDayOfMonth();
        int dayi = dtp_dogum.getValue().getMonthValue();
        lbl_yas.setText("YAŞ : " + String.valueOf(yas));

        if (sinifIndex != -1) {//mevcut belge sınıfı seçildiyse, belgesi varsa

        } else {//mevcut belge sınıfı seçilmediyse veya yoksa

        }

    }

    private void converter(DatePicker dtp) {
        dtp.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy");

            @Override
            public String toString(LocalDate object) {
                if (object != null) {
                    return dateFormatter.format(object);
                } else {
                    return null;
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
    }

    private ObservableList<String> siniflar() {
        MongoClient client = new MongoClient("localhost", 27017);
        DB db = new DB(client, "surucufx");
        DBCollection coll = db.getCollection("Kurum");
        DBCursor cursor = coll.find();
        while (cursor.hasNext()) {
            String str[] = cursor.next().toString().split(":")[3].substring(2).split("\"");
            siniflar.add(str[0]);
        }
        return siniflar;
    }
    
    private void kaydiTamamla(){
        String adi = txt_adi.getText();
        String soyadi = txt_soyad.getText();
        String tcNo = txt_tcNo.getText();
        String dogumTarihi = dtp_dogum.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String mvctBelgeTarihi = dtp_belgeTarihi.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String cepTelefonu = txt_cep.getText();
        
    }

}

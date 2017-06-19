/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikut.surucufx;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 *
 * @author aykut
 */
public class EvrakKayitController implements Initializable {

    private final ObservableList<String> ozurDurumu = FXCollections
            .observableArrayList(
                    "Özrüm Yoktur",
                    "Ortopedik Özürlü.(Ellerini ve/veya kollarını kullanamıyor)",
                    "Ortopedik Özürlü.(Yürüyemiyor)",
                    "İşitme, Dil veya Konuşma Özürlü",
                    "Görme Özürlü.(Bir gözü görmüyor.)",
                    "Görme Özürlü.(Büyüteç yardımı ile görebiliyor.)",
                    "Süreğen hastalığı var.");

    private final ObservableList<String> ogrBelgeTuru = FXCollections
            .observableArrayList(
                    "II.Kademe Okur Yazarlık Belgesi",
                    "İlkokul Diploma",
                    "İlköğretim Diploma",
                    "İlköğretim Tasdikname",
                    "Açık İlköğretim Öğrenci Belgesi",
                    "Ortaokul Diplama",
                    "Ortaokul Tasdikname",
                    "Lise Diploma",
                    "Lise Tasdikname",
                    "Lise Ögrenci Belgesi",
                    "Üniversite Öğrenci Belgesi",
                    "Üniversite Diploam",
                    "Üniversite Geçici Mezuniyet Belgesi",
                    "Denklik/Öğrenim Belgesinin Noter Tasdikli Türkçe Tercümesi");

    @FXML
    private TextField txt_saglikVerenKurum;

    @FXML
    private TextField txt_saglikSayisi;

    @FXML
    private ChoiceBox<String> cho_ozurDurumu;

    @FXML
    private DatePicker dtp_saglikTarihi;

    @FXML
    private Button btnSaglikGetir;

    @FXML
    private CheckBox chk_tercuman;

    @FXML
    private CheckBox chk_isaretDili;

    @FXML
    private TextField txt_ogrBelgesiVerenKurum;

    @FXML
    private TextField txt_ogrBelgeSayisi;

    @FXML
    private ChoiceBox<String> cho_ogrBelgeTuru;

    @FXML
    private DatePicker dtp_ogrBelgeTarihi;

    @FXML
    private Button btnOgrBelgesiGetir;

    @FXML
    private TextField txt_sabikaKayVerKur;

    @FXML
    private TextField txt_sabikaKaydiSayisi;

    @FXML
    private DatePicker dtp_sabikaTarihi;

    @FXML
    private Button btnSabikaGetir;

    @FXML
    private Label lblCepTelefonu;

    @FXML
    private Label lblAdayNo;

    @FXML
    private Label lblAdiSoyadi;

    @FXML
    private Label lblTcKimlik;

    @FXML
    private Label lblSertifikaSinifi;

    @FXML
    private ImageView imv_imza;

    @FXML
    private Button btnAdayImzaGetir;

    @FXML
    private Button btnSozlesmeBir;

    @FXML
    private Button btnSozlesmeIki;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cho_ozurDurumu.setItems(ozurDurumu);
        cho_ozurDurumu.setValue(ozurDurumu.get(0));
        cho_ogrBelgeTuru.setItems(ogrBelgeTuru);
        cho_ogrBelgeTuru.setValue(ogrBelgeTuru.get(10));
    }

    File ogrenim, saglik, sabika, sozlesme1, sozlesme2, imza;
    List<File> evraklar = FXCollections.observableArrayList(ogrenim, saglik, sabika, sozlesme1, sozlesme2, imza);

    @FXML
    void ogrenimBelgesiGetir(ActionEvent event) {
        choose(ogrenim, "Öğrenim Belgesini Seçiniz");
    }

    @FXML
    void adayImzaGetir(ActionEvent event) {
        choose(imza,"Aday İmza Belgesini Seçiniz");
    }

    @FXML
    void sabikaKaydiGetir(ActionEvent event) {
        choose(sabika,"Sabıka Kayıdı Belgesini Seçiniz");
    }

    @FXML
    void saglikRaporuGetir(ActionEvent event) {
        choose(saglik,"Sağlık Raporu Seçiniz");
    }

    @FXML
    void sozlesme1Getir(ActionEvent event) {
        choose(sozlesme1,"Aday Kayıt Sözleşmesi 1.Sayfayı Seçiniz");
    }

    @FXML
    void sozlesme2Getir(ActionEvent event) {
        choose(sozlesme2,"Aday Kayıt Sözleşmesi 2.Sayfayı Seçiniz");
    }

    private void choose(File file, String title) {//Adaya ait evrakları seçmek için filechooser metodu
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);//parametre olarak gelen başlık
        //adayın tüm belgeleri 500 e 700 olarak boyutlandırılmış jpg dosyası olması beklendiği için standardize edilmiş bir chooser hazırladık
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "*.jpg"));//ne tür dosyaların seçilebileceği
        fileChooser.initialDirectoryProperty().set(new File(System.getProperty("user.home")));//hangi konumda açılacağı
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            //mongoya kayıt edilecek dosya hazırlanıcak ve kayıt için paketlenecek
        } else {
            //eğer seçim yapılmaktan vazgeçildiyse veya seçilmezse yapılacaklar
            System.out.println("Vazgeçildi");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurs;

import com.ikut.surucufx.Sinif;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;

/**
 *
 * @author aykut
 */
public class AltProgramlarController implements Initializable {

    ObservableList<String> tumSiniflar;

    public AltProgramlarController() {
        this.tumSiniflar = Sinif.sinif;
    }

    /////////////////AltProgramlar fxml'e  Ait Olan Nesneler/////
    @FXML
    private Pane pne_altProgramlar;

    @FXML
    private ListView<String> lsv_tumSiniflar;

    @FXML
    private ListView<String> lsv_secilenSiniflar;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_cikar;

    @FXML
    private Button btn_kaydet;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_vazgec;

    @FXML
    private Button btn_tumunuCikart;
    /////////////////////////////////////////////////////////////

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lsv_tumSiniflar.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lsv_secilenSiniflar.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lsv_tumSiniflar.setItems(tumSiniflar);
    }

    @FXML
    void sinifEkle(ActionEvent event) {
        ObservableList<String> eklenenSecimler = lsv_tumSiniflar.getSelectionModel().getSelectedItems();
        lsv_secilenSiniflar.getItems().addAll(eklenenSecimler);
        lsv_tumSiniflar.getItems().removeAll(eklenenSecimler);
    }

    @FXML
    void sinifCikart(ActionEvent event) {
        ObservableList<String> cikarilanSecimler = lsv_secilenSiniflar.getSelectionModel().getSelectedItems();
        lsv_tumSiniflar.getItems().addAll(cikarilanSecimler);
        lsv_secilenSiniflar.getItems().removeAll(cikarilanSecimler);
    }

    @FXML
    void kaydet(ActionEvent event) {
        MongoClient client = new MongoClient("localhost", 27017);
        DB db = new DB(client, "surucufx");
        DBCollection coll = db.getCollection("Kurum");

        for (String item : lsv_secilenSiniflar.getItems()) {
            coll.insert(new BasicDBObject().append("sinif", item));
        }
    }

}

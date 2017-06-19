/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikut.surucufx.evrakKayit;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author aykut
 */
public class OgrenimBelgesi {
    
    private final StringProperty veren = new SimpleStringProperty(this,"veren","");
    private final StringProperty tarihi = new SimpleStringProperty(this,"tarihi","");
    private final StringProperty sayisi = new SimpleStringProperty(this,"sayisi","");
    private final StringProperty turu = new SimpleStringProperty(this,"turu","");    
   
    public StringProperty verenProperty() {
        return veren;
    }
    
    public String getVeren() {
        return veren.get();
    }

    public void setVeren(String veren) {
        this.veren.set(veren);
    }

    public StringProperty tarihiProperty() {
        return tarihi;
    }

    public String getTarihi() {
        return tarihi.get();
    }

    public void setTarihi(String tarihi) {
        this.tarihi.set(tarihi);
    }

    public StringProperty sayisiProperty() {
        return sayisi;
    }

    public String getSayisi() {
        return sayisi.get();
    }

    public void setSayisi(String sayisi) {
        this.sayisi.set(sayisi);
    }

    public StringProperty turuProperty() {
        return turu;
    }

    public String getTuru() {
        return turu.get();
    }

    public void setTuru(String turu) {
        this.turu.set(turu);
    }

}

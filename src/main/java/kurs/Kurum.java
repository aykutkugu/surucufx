/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kurs;

import java.util.List;

/**
 *
 * @author aykut
 */
public class Kurum {
    
    private String adi;
    private String acilis_tarihi;
    private String telefon;
    private String fax;
    private String web_adresi;
    private String email;
    private boolean kurucu_mudur;
    private String kurucu_adSoyad;
    private String kurucu_telefonu;
    private String kurumMuduru_adSoyad;
    private String kurumMuduru_telefounu;
    private String adresi;
    private String adres_kodu;
    private String kurum_kodu;
    
    private String ili;
    private String ilcesi;
    private String ilce_meMuduru_adiSoyadi;
    private String ilce_meSubeMuduru;
    private String ilce_meBolumSefi;
    
    //kurumun verebildiği sertifika programları
    private List<String> alt_programlar;
    
    //kurumun mebbis sistemi kurum yetkilisi
    private String mebbis_yetkili;
    private String mebbis_sifre;

    
    public List<String> getAlt_programlar() {
        return alt_programlar;
    }

    public void setAlt_programlar(List<String> alt_programlar) {
        this.alt_programlar = alt_programlar;
    }
    
    
}

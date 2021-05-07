package com.example.derslistviewornegi;

import java.util.ArrayList;

public class EA_Veritabani {


//BU KOD SADECE ÜRÜNLERİ TUTMAKTADIR. BAŞKA BİR İŞLEVİ YOKTUR



    // static ArrayList<SI_URUN> si_myurunler=new ArrayList<>();      //BURAYI AÇARSAN ALTTAKİNİ KAPARSAN HATA DÜZELİR
    static ArrayList<EA_URUN> ea_myurunler;



    public static ArrayList<EA_URUN> getEa_myurunler() {
        return ea_myurunler;
    }

    public static void setEa_myurunler(ArrayList<EA_URUN> ea_myurunler) {
        EA_Veritabani.ea_myurunler = ea_myurunler;
    }







}



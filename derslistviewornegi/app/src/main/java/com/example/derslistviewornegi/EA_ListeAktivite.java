package com.example.derslistviewornegi;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EA_ListeAktivite extends AppCompatActivity {


    //BU SAYFA LİSTVİEW GÖRÜNTÜLEME SAYFASIDIR. BU KOD DA O SAYFAYI KONTROL ETMEKTEDİR




    ListView ea_listem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_aktivite);

        ea_listem =findViewById(R.id.ea_liste);

        ArrayList<EA_URUN> ea_urunler = EA_Veritabani.ea_myurunler;

        ea_urunler.size();
//        Toast.makeText(SI_ListeAktivite.this, urunler.get(0).getSi_urunismi(), Toast.LENGTH_SHORT).show();


        EA_UrunAdapter EAUrunAdapter= new EA_UrunAdapter(EA_ListeAktivite.this,0,ea_urunler);          //UrunAdapter diye java dosyası açıp oradan get ve set ile adapteri alıyoruz
        EAUrunAdapter.notifyDataSetChanged();                    //notifydatasetchanged bu şekilde kullanılır (adapter değiştiğinde çalıştırılır)

        ea_listem.setAdapter(EAUrunAdapter);




    }










}



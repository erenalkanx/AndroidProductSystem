package com.example.derslistviewornegi;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import java.io.Serializable;

public class EA_URUN implements Serializable {




    //BU KOD EKLENECEK OLAN ÜRÜNLERİN ELEMANLARINI VE CONSTRUCTOR-GET-SET YAPILARINI TUTMAKTADIR




    private String ea_urunismi;
    private String ea_urunAciklama;
    private String ea_urun_miktar;
    private Double ea_fiyat;
    Context ea_context;

    Bitmap ea_image;
    String ea_kategori;
    String ea_platform;


    public void setEa_context(Context ea_context){       //???
        this.ea_context = ea_context;
    }


    //LİSTVİEW DEĞERLERİNİN CONSTRUCTOR YAPISI---BU YAPI BİZİM ÜRÜN EKLEMEMİZİ SAĞLAMAKTADIR
    public EA_URUN(Context ea_context, String si_urunismi, String si_urunAciklama, String ea_urun_miktar, Double ea_fiyat, Bitmap ea_image, String ea_kategori, String ea_platform){    //nesne bu şekilde tanımlanır.      bu yapıya constructor denir.  sağ tıkla direk oluşturulabilir
        this.ea_urunismi=si_urunismi;
        this.ea_urunAciklama=si_urunAciklama;
        this.ea_urun_miktar = ea_urun_miktar;
        this.ea_fiyat = ea_fiyat;//fonksiyondaki fiyat,  yukarıda tanımlanan fiyat değişkeni olsun dedik
        this.ea_image = ea_image;
        this.ea_context = ea_context;
        this.ea_kategori = ea_kategori;
        this.ea_platform = ea_platform;
    }




    //GET SET METODLARI --- BU YAPILAR BİZİM ÜRÜN ÇEKMEMİZE VE ÜRÜN ÇAĞIRMAMIZA OLANAK SAĞLAMAKTADIR
    public String getSi_urunismi(){     //GET DEĞİŞKENİN DEĞERİNİ ALMAYA YARAR
        return ea_urunismi;
    }
    public void setSi_urunismi(String si_urunismi){     //SET DEĞİŞKENİN DEĞERİNİ DEĞİŞTİRMEYE YARAR
        this.ea_urunismi=si_urunismi;
    }


    public Bitmap getEa_image() {
        return ea_image;
    }

    public void setEa_image(Bitmap ea_image) {
        this.ea_image = ea_image;
    }




    public String getEa_kategori() {
        return ea_kategori;
    }

    public void setEa_kategori(String ea_kategori) {
        this.ea_kategori = ea_kategori;
    }


    public String getEa_platform() {
        return ea_platform;
    }

    public void setEa_platform(String ea_platform) {
        this.ea_platform = ea_platform;
    }






    public String getSi_urunAciklama() {
        return ea_urunAciklama;
    }

    public void setSi_urunAciklama(String si_urunAciklama) {
        this.ea_urunAciklama = si_urunAciklama;
    }








    public Double getEa_fiyat(){
        return ea_fiyat;
    }

    public void setEa_fiyat(Double ea_fiyat) {

        if(ea_fiyat <0 ){
            if(ea_context !=null)
                Toast.makeText(ea_context,"ürün fiyatı negatif olamaz",Toast.LENGTH_SHORT).show();
            this.ea_fiyat = 0.0;
        }else
            this.ea_fiyat = ea_fiyat;
    }










    public String getEa_urun_miktar() {
        return ea_urun_miktar;
    }

    public void setEa_urun_miktar(String ea_urun_miktar) {
        this.ea_urun_miktar = ea_urun_miktar;
    }









}

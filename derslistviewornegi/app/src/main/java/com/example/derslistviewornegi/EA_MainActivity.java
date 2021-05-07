package com.example.derslistviewornegi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EA_MainActivity extends AppCompatActivity {


    //ÜRÜN EKLEME VE ÜRÜNLERİ VERİTABANINA GÖNDERME KISMI BU KODDA. AYRICA ÜRÜNLER BİR SONRAKİ SAYFAYA DA BURADAN GÖNDERİLİYOR
    //BİR SONRAKİ SAYFAYI LİSTEAKTİVİTE KODU KONTROL EDİYOR




    EditText ea_isim, ea_aciklama, ea_fiyat;
    Spinner ea_urun_miktar;
    ArrayList<EA_URUN> ea_urunler;      //ea_urunler    ürünleri tutacağımız dizi
    Button ea_liste_btn, ea_foto;        //listviewı gösterme butonu
    ImageView ea_fotoyeri;






    RadioGroup ea_radio;
    RadioButton ea_radio1;
    RadioButton ea_radio2;
    RadioButton ea_radio3;

    String ea_kategori ="";

    CheckBox ea_checkbox1;
    CheckBox ea_checkbox2;
    CheckBox ea_checkbox3;

    String ea_platformlar ="";  //eğer bu değeri boş yapmazsak bu değişkende null değeri olur. ve yazdırırken null yazısı çıkar. ayrıca eğer çağırırken değeri null ise uygulama hata verir


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ea_radio =(RadioGroup)findViewById(R.id.ea_kategorigrp);
        ea_radio1 =(RadioButton) findViewById(R.id.ea_fpsradio);
        ea_radio2 =(RadioButton) findViewById(R.id.ea_openradio);
        ea_radio3 =(RadioButton) findViewById(R.id.ea_rpgradio);






        ea_checkbox1=(CheckBox) findViewById(R.id.ea_check_windows);
        ea_checkbox2=(CheckBox) findViewById(R.id.ea_check_playstation);
        ea_checkbox3=(CheckBox) findViewById(R.id.ea_check_xbox);









        ea_isim =findViewById(R.id.ea_etxt_urun_isim);
        ea_aciklama = findViewById(R.id.ea_etxt_urun_aciklama);
        ea_fiyat =findViewById(R.id.ea_etxt_urun_fiyat);

        ea_urun_miktar =findViewById(R.id.ea_spinner);
        ea_urunler = new ArrayList<>();

        ea_liste_btn =findViewById(R.id.ea_btn_listview);
        ea_foto =findViewById(R.id.ea_btn_foto);
        ea_fotoyeri = findViewById(R.id.ea_iv_fotodan);

        ea_fotoyeri.setImageResource(R.drawable.ea_kutu);      //imageview'a resmi kod olarak vermek gerekiyor. editörden resim verince görmüyor.








        ea_liste_btn.setOnClickListener(new View.OnClickListener() {              //listeyi görüntüle butonuna basıldığında
            @Override       //override'ı buraya kendisi otomatik ekliyor
            public void onClick(View view) {
                Intent si_intent = new Intent(EA_MainActivity.this, EA_ListeAktivite.class);
                //si_intent.putExtra("urunler",ea_urunler);   //ea_urunler listesini urunler adıyla ListeAktivite'ye gönder
                EA_Veritabani.ea_myurunler = ea_urunler;
                startActivity(si_intent);
            }
        });






//SPİNNER YAPISI
        List<String> ea_spinnerElemanlari = new ArrayList();        //spinner  javadaki dropdownlist'dir
        ea_spinnerElemanlari.add("Standart Edition");
        ea_spinnerElemanlari.add("Special Edition");
        ea_spinnerElemanlari.add("Extention Edition");

        ArrayAdapter<String> ea_adapter=new ArrayAdapter(EA_MainActivity.this, android.R.layout.simple_spinner_item,ea_spinnerElemanlari);
        ea_urun_miktar.setAdapter(ea_adapter);  //spinner elemanlarını adapter ile aktarıyoruz




        ea_foto.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);     //kameranın asıl inteni burda
                startActivityForResult(takePictureIntent, 100);





            }
        });
    }



















    Bitmap ea_photo;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {     //bu kısımda çekilen resim alacağız
        super.onActivityResult(requestCode, resultCode, data);

        //if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
        ea_photo = (Bitmap) data.getExtras().get("data");   //çekilen foto bitmap türünde bir değişkende saklanır
        ea_fotoyeri.setImageBitmap(ea_photo);  //çekilen foto fotoyerine aktarılıyor




        // }
    }








    public void ea_urunOlustur(View view){



        int selectedId= ea_radio.getCheckedRadioButtonId();
        switch (selectedId){
            case R.id.ea_fpsradio:
                ea_kategori ="Fps";
                break;
            case R.id.ea_openradio:
                ea_kategori ="Open World";
                break;
            case R.id.ea_rpgradio:
                ea_kategori ="Rpg";
                break;
        }



        if(ea_checkbox1.isChecked()){
            ea_platformlar += "Windows ";
        }
        if(ea_checkbox2.isChecked()){
            ea_platformlar +="Playstation 5 ";
        }
        if(ea_checkbox3.isChecked()){
            ea_platformlar +="Xbox One ";
        }




        //textboxlardan değerleri çekiyoruz
        EA_URUN ea_ur = new EA_URUN(EA_MainActivity.this,     //EA_URUN scriptinde yeni bir ürün oluşturuluyor
                ea_isim.getText().toString(),       //ea_isimi textboxdan al ve ürün nesnesine ilet
                ea_aciklama.getText().toString(),
                ea_urun_miktar.getSelectedItem().toString(),
                Double.parseDouble(ea_fiyat.getText().toString()),   //fiyatı int'e çeviriyoruz
                ea_photo,   //bir de photoyu iletsin
                ea_kategori,
                ea_platformlar
        );

        ea_ur.setEa_fiyat(Double.parseDouble(ea_fiyat.getText().toString()));  //fiyatı set metoduyla ürün nesnesine atıyoruz(aynı zamanda orada kontrolü gerçekleşiyor)
        if (ea_ur.getEa_fiyat() > 0)
            ea_urunler.add(ea_ur);      //ea_urunler'e  textboxdaki değerler ekleniyor

        //ürün eklendikten sonra form elementleri sıfırlansın
        ea_platformlar = "";
        ea_isim.setText(null);
        ea_aciklama.setText(null);
        ea_fiyat.setText(null);
        ea_checkbox1.setSelected(false);
        ea_checkbox2.setSelected(false);
        ea_checkbox3.setSelected(false);
        ea_radio1.setSelected(false);
        ea_radio2.setSelected(false);
        ea_radio3.setSelected(false);


        Toast.makeText(getApplicationContext(), "Ürün Sayısı: " + ea_urunler.size() + " ,Eklenen: " + ea_urunler.get(ea_urunler.size() - 1).getSi_urunismi(),
                Toast.LENGTH_SHORT).show();




    }








}
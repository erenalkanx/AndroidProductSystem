package com.example.derslistviewornegi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class EA_UrunAdapter extends ArrayAdapter<EA_URUN> {     //burada baseadapter de kullanabilirdik




//BU KOD BİZİM ÜRÜN_SATIR LAYOUTUMUZDAKİ VİEWI GETİRMEYE ÇALIŞAN KODDUR. ORADAKİ VİEW, LİSTEAKTİVİTE'YE GİTMEKTEDİR



    Context ea_context;
    public EA_UrunAdapter(@NonNull Context context, int resource, @NonNull List<EA_URUN> objects) {
        super(context, resource, objects);
        this.ea_context =context;

        getItemCount();

    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {  //view getirme fonksiyonu

        LayoutInflater inflater=LayoutInflater.from(ea_context);           //activity liste aktivite layoutundaki listeye urun satir layoutundaki ürün şablonlarını gönderecek
        convertView=inflater.inflate(R.layout.urun_satir,parent,false);

        EA_URUN ea_urun=getItem(position);//buradaki position 0 olursa 0 indexli ürünü yani 1. ürünü verir. position ürün sayısına göre değişmektedir
        ImageView ea_foto= convertView.findViewById(R.id.ea_iv_urun_resim_li);

        TextView ea_isim = convertView.findViewById(R.id.ea_txt_urun_isim_li);
        TextView ea_fiyat = convertView.findViewById(R.id.ea_txt_urun_fiyat_li);
        TextView ea_aciklama = convertView.findViewById(R.id.ea_txt_urun_aciklama_li);
        TextView ea_miktar = convertView.findViewById(R.id.ea_txt_urun_miktar_li);
        Button ea_siparis=convertView.findViewById(R.id.ea_btn_SiparisVer_li);
        TextView ea_kategori = convertView.findViewById(R.id.ea_txt_urun_kategori_li);
        TextView ea_platform = convertView.findViewById(R.id.ea_txt_urun_platform_li);




        ea_kategori.setText(ea_urun.getEa_kategori());
        ea_platform.setText(ea_urun.getEa_platform());

        if(ea_urun.getEa_image()==null)
            ea_foto.setImageResource(R.drawable.ea_kutu);
        else
            ea_foto.setImageBitmap(ea_urun.getEa_image()); //bitmap resmi imageviewa yerleştir

        ea_isim.setText(ea_urun.getSi_urunismi());
        ea_fiyat.setText(String.valueOf(ea_urun.getEa_fiyat())+" TL");
        ea_aciklama.setText(ea_urun.getSi_urunAciklama());
        ea_miktar.setText(ea_urun.getEa_urun_miktar());



        ea_siparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ea_context,"1 Adet "+ea_urun.getSi_urunismi()+" Siparişiniz Alınmıştır",Toast.LENGTH_LONG).show();
            }
        });
        // return super.getView(position, convertView, parent);
        return  convertView;

    }








    public int getItemCount() {
        ArrayList<EA_URUN> urunler = EA_Veritabani.ea_myurunler;
        return urunler.size();
    }






}

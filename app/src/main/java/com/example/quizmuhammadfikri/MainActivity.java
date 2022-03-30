package com.example.quizmuhammadfikri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layouttransaksisatu);
    }

    public void prosesData(View view){
        EditText namaPelanggan, alamatPelanggan, jumlahBarang;
        RadioGroup groupJenisKelamin, groupTipePelanggan, groupNamaBarang;
        RadioButton kelaminSelected, tipeSelected, namaBarangSelected;

        // Edit Text Handle
        namaPelanggan = (EditText) findViewById(R.id.etNama);
        alamatPelanggan = (EditText) findViewById(R.id.etAlamat);
        jumlahBarang = (EditText) findViewById(R.id.jumlahBarang);
        String namaString = namaPelanggan.getText().toString().trim();
        String alamatString = alamatPelanggan.getText().toString().trim();
        Integer jumlahBarangInt = Integer.parseInt(jumlahBarang.getText().toString().trim());


        // Group Handle

        // Jenis Kelamin handle
        groupJenisKelamin = (RadioGroup) findViewById(R.id.groupKelamin);
        int idKelaminSelected = groupJenisKelamin.getCheckedRadioButtonId();
        kelaminSelected = (RadioButton) findViewById(idKelaminSelected);
        String kelaminString = kelaminSelected.getText().toString().trim();

        // Tipe Pelanggan handle
        groupTipePelanggan = (RadioGroup) findViewById(R.id.groupTipePelanggan);
        int idTipePelangganSelected = groupTipePelanggan.getCheckedRadioButtonId();
        tipeSelected = (RadioButton) findViewById(idTipePelangganSelected);
        String tipePelangganString = tipeSelected.getText().toString().trim();

        // Nama Barang handle
        groupNamaBarang = (RadioGroup) findViewById(R.id.groupNamaBarang);
        int idNamaBarangSelected = groupNamaBarang.getCheckedRadioButtonId();
        namaBarangSelected = (RadioButton) findViewById(idNamaBarangSelected);
        String namaBarangString = namaBarangSelected.getText().toString().trim();

        double diskonHarga, diskonMember, totalHarga,jumlahBayar, totalDiskonMember, totalDiskonHarga;
        int hargaBarang;


        // Diskon member berdasarkan jenis member
        switch (tipePelangganString){
            case "Gold":
                diskonMember = 0.2;
                break;
            case "Silver":
                diskonMember = 0.1;
                break;
            case "Biasa":
                diskonMember = 0.05;
                break;
            default:
                diskonMember = 0;
        }

        switch (namaBarangString){
            case "Android":
                hargaBarang = 2000000;
                diskonHarga = 0.10;
                break;
            case "Iphone":
                hargaBarang = 3000000;
                diskonHarga = 0.20;
                break;
            case "Windows Phone":
                hargaBarang = 1000000;
                diskonHarga = 0.30;
                break;
            default:
                hargaBarang = 0;
                diskonHarga = 0;
        }
        totalHarga = hargaBarang * jumlahBarangInt;
        totalDiskonMember = totalHarga * diskonMember;
        totalDiskonHarga = totalHarga * diskonHarga;
        jumlahBayar = totalHarga - totalDiskonMember - totalDiskonHarga;

        Intent intent = new Intent(this, TransaksiDua.class);
        intent.putExtra("tipePelanggan", tipePelangganString );
        intent.putExtra("namaPelanggan", namaString);
        intent.putExtra("jenisKelamin", kelaminString);
        intent.putExtra("alamat", alamatString);
        intent.putExtra("namaBarang", namaBarangString);
        intent.putExtra("jumlahBarang", jumlahBarangInt);
        intent.putExtra("hargaBarang", hargaBarang);
        intent.putExtra("totalHarga", totalHarga);
        intent.putExtra("diskonMember", totalDiskonMember);
        intent.putExtra("diskonHarga", totalDiskonHarga);
        intent.putExtra("jumlahBayar", jumlahBayar);
try {
    startActivity(intent);

}catch (Exception e){

}

    }
}
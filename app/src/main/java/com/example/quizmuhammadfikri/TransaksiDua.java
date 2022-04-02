package com.example.quizmuhammadfikri;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class TransaksiDua extends AppCompatActivity {
    private TextView tipeMember, jenisKelamin, alamatPelanggan, namaBarang, jumlahBarang, hargaBarang, totalHargaTv, discHarga, discMember, jumlahBayar, namaPelanggan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layouttransaksidua);
        namaPelanggan = (TextView) findViewById(R.id.namaPelanggan);
        tipeMember = (TextView) findViewById(R.id.tipeMember);
        jenisKelamin = (TextView) findViewById(R.id.jenisKelamin);
        alamatPelanggan = (TextView) findViewById(R.id.alamatPelanggan);
        namaBarang = (TextView) findViewById(R.id.namaBarang);
        jumlahBarang = (TextView) findViewById(R.id.jumlahBarang);
        hargaBarang = (TextView) findViewById(R.id.hargaBarang);
        totalHargaTv = (TextView) findViewById(R.id.totalHarga);
        discHarga = (TextView) findViewById(R.id.discHarga);
        discMember = (TextView) findViewById(R.id.discMember);
        jumlahBayar = (TextView) findViewById(R.id.jumlahBayar);

        // Format Idr
        DecimalFormat kursRupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursRupiah.setDecimalFormatSymbols(formatRp);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            namaPelanggan.setText("Nama Pelanggan: " +extras.getString("namaPelanggan"));

            tipeMember.setText("Tipe Member: " + extras.getString("tipePelanggan"));

            jenisKelamin.setText("Jenis Kelamin: "  + extras.getString("jenisKelamin"));

            alamatPelanggan.setText("Alamat Pelanggan: " + extras.getString("alamat"));

            namaBarang.setText("Nama Barang: " + extras.getString("namaBarang"));

            jumlahBarang.setText("Jumlah Barang: " + extras.getInt("jumlahBarang"));

            hargaBarang.setText("Harga Barang: " + kursRupiah.format((double) extras.getInt("hargaBarang")));

            totalHargaTv.setText("Total Harga: " + kursRupiah.format(extras.getDouble("totalHarga")));

            discMember.setText("Discount Member: " + kursRupiah.format(extras.getDouble("diskonMember")));

            discHarga.setText("Discount Harga: "+ kursRupiah.format(extras.getDouble("diskonHarga")) );

            jumlahBayar.setText("Jumlah Bayar: " + kursRupiah.format(extras.getDouble("jumlahBayar")));



        }

    }
}

package com.example.cryptoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cryptoapp.Adapter.CryptoWalletAdapter;
import com.example.cryptoapp.Model.CryptoWallet;

import java.util.ArrayList;

public class HomePage_Activity extends AppCompatActivity {

    private CryptoWalletAdapter cryptoWalletAdapter;

    private RecyclerView rv_cryptoActivities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initWidget();

        initUI();
    }

    private void initUI() {

        initRecView();
    }

    private void initRecView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_cryptoActivities.setLayoutManager(linearLayoutManager);

        ArrayList<CryptoWallet> cryptoWalletArrayList = new ArrayList<>();
        ArrayList<Integer> lineData = new ArrayList<>();
        lineData.add(1000);
        lineData.add(1100);
        lineData.add(1200);
        lineData.add(1100);

        ArrayList<Integer> lineData2 = new ArrayList<>();
        lineData2.add(2100);
        lineData2.add(2000);
        lineData2.add(1900);
        lineData2.add(2000);

        ArrayList<Integer> lineData3 = new ArrayList<>();
        lineData3.add(900);
        lineData3.add(1100);
        lineData3.add(1200);
        lineData3.add(1000);
        lineData3.add(1150);

        cryptoWalletArrayList.add(new CryptoWallet("bitcoin", "BTC", 1234.12, 2.13, lineData, 1234.12, 0.12343));
        cryptoWalletArrayList.add(new CryptoWallet("ethereum", "ETH", 2134.21, -1.13, lineData2, 6545.65, 0.01245));
        cryptoWalletArrayList.add(new CryptoWallet("trox", "ROX", 6543.21, 0.73, lineData3, 3123.4, 0.02154));

        cryptoWalletAdapter = new CryptoWalletAdapter(cryptoWalletArrayList);
        rv_cryptoActivities.setAdapter(cryptoWalletAdapter);
    }

    private void initWidget() {

        rv_cryptoActivities = findViewById(R.id.rv_cryptoActivities);
    }
}
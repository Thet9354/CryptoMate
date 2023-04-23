package com.example.cryptoapp.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cryptoapp.Model.CryptoWallet;
import com.example.cryptoapp.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CryptoWalletAdapter extends RecyclerView.Adapter<CryptoWalletAdapter.ViewHolder> {
    ArrayList<CryptoWallet> cryptoWallets;
    DecimalFormat formatter;

    public CryptoWalletAdapter(ArrayList<CryptoWallet> cryptoWallets) {
        this.cryptoWallets = cryptoWallets;
        formatter = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public CryptoWalletAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_wallet, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtView_coinName.setText(cryptoWallets.get(position).getCryptoName());
        holder.txtView_coinHolding.setText("$" + formatter.format(cryptoWallets.get(position).getCryptoPrice()));
        holder.txtView_coinProgress.setText(cryptoWallets.get(position).getChangePercent() + "%");
        holder.txtView_coinPriceBTC.setText(cryptoWallets.get(position).getCryptoSymbol());
        holder.txtView_coinPrice.setText("$" + formatter.format(cryptoWallets.get(position).getPropertyAmount()));
        holder.sl_coin.setData(cryptoWallets.get(position).getLineData());

        if (cryptoWallets.get(position).getChangePercent() > 0) {
            holder.txtView_coinProgress.setTextColor(Color.parseColor("#12c737"));
            holder.sl_coin.setSparkLineColor(Color.parseColor("#12c737"));
        } else if (cryptoWallets.get(position).getChangePercent() < 0) {
            holder.txtView_coinProgress.setTextColor(Color.parseColor("#fc0000"));
            holder.sl_coin.setSparkLineColor(Color.parseColor("#fc0000"));
        } else {
            holder.txtView_coinProgress.setTextColor(Color.parseColor("#ffffff"));
            holder.sl_coin.setSparkLineColor(Color.parseColor("#ffffff"));
        }


        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(cryptoWallets.get(position).getCryptoName(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.imgView_coin);

    }


    @Override
    public int getItemCount() {
        return cryptoWallets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtView_coinName, txtView_coinHolding, txtView_coinProgress, txtView_coinPriceBTC, txtView_coinPrice;
        private RelativeLayout rel_coin;
        private ImageView imgView_coin;
        private com.majorik.sparklinelibrary.SparkLineLayout sl_coin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //TextView
            txtView_coinName = itemView.findViewById(R.id.txtView_coinName);
            txtView_coinHolding = itemView.findViewById(R.id.txtView_coinHolding);
            txtView_coinProgress = itemView.findViewById(R.id.txtView_coinProgress);
            txtView_coinPriceBTC = itemView.findViewById(R.id.txtView_coinPriceBTC);
            txtView_coinPrice = itemView.findViewById(R.id.txtView_coinPrice);

            //RelativeLayout
            rel_coin = itemView.findViewById(R.id.rel_coin);

            //ImageView
            imgView_coin = itemView.findViewById(R.id.imgView_coin);

            //SparkLine
            sl_coin = itemView.findViewById(R.id.sl_coin);

        }
    }
}

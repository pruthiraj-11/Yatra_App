package com.app.yatra_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.app.yatra_app.Models.ItemsModel;
import com.app.yatra_app.databinding.ActivityDetailBinding;
import com.bumptech.glide.Glide;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private ItemsModel itemsModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }

    private void setVariable() {
        itemsModel=(ItemsModel) getIntent().getSerializableExtra("object");
        binding.detailtitletxt.setText(Objects.requireNonNull(itemsModel).getTitle());
        binding.detailscore.setText(""+itemsModel.getScore());
        binding.detaillocation.setText(itemsModel.getLocation());
        binding.bedtxt1.setText(itemsModel.getBed()+" Bed");
        binding.desctxtdetail.setText(itemsModel.getDescription());

        if (itemsModel.isGuide()){
            binding.guidedetailtxt.setText("Guide");
        } else {
            binding.guidedetailtxt.setText("No-Guide");
        }

        if (itemsModel.isWifi()){
            binding.wifidetailtxt.setText("Wifi");
        } else {
            binding.wifidetailtxt.setText("No-Wifi");
        }

        int drawableResourceId=getResources().getIdentifier(itemsModel.getPic(),"drawable",getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(binding.picDetailIMage);

        binding.backdetailbtn.setOnClickListener(view -> {
            finish();
        });
    }
}
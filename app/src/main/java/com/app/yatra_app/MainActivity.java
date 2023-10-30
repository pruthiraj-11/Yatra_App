package com.app.yatra_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.yatra_app.Adapters.CategoryAdapter;
import com.app.yatra_app.Adapters.PopularAdapter;
import com.app.yatra_app.Models.CategoryModel;
import com.app.yatra_app.Models.ItemsModel;
import com.app.yatra_app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView.Adapter adapterPopular,adapterCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<ItemsModel> list=new ArrayList<>();
        list.add(new ItemsModel("Mar caible, avendia lago","Miami Beach","This 2 bed/1 bath home boasts an enormous," +
                "open-living pl accented by striking" +
                "architectural features and high-end finishes." +
                "Feel inspired by open sight lines that" +
                "embrace the outdoors, crowned by stunning" +
                "coffered ceilings.",2,true,4.8,"pic1",true,1000));
        list.add(new ItemsModel("Passo Rolle, TN, ","Hawaii Beach","This 2 bed/1 bath home boasts an enormous," +
                "open-living pl accented by striking" +
                "architectural features and high-end finishes." +
                "Feel inspired by open sight lines that" +
                "embrace the outdoors, crowned by stunning" +
                "coffered ceilings.",3,true,4,"pic2",true,1000));
        list.add(new ItemsModel("Mar caible, avendia lago","Miami Beach","This 2 bed/1 bath home boasts an enormous," +
                "open-living pl accented by striking" +
                "architectural features and high-end finishes." +
                "Feel inspired by open sight lines that" +
                "embrace the outdoors, crowned by stunning" +
                "coffered ceilings.",4,true,4.3,"pic3",true,1000));

        binding.viewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        adapterPopular=new PopularAdapter(list);
        binding.viewPopular.setAdapter(adapterPopular);

        ArrayList<CategoryModel> list1=new ArrayList<>();
        list1.add(new CategoryModel("Beaches","cat1"));
        list1.add(new CategoryModel("Camps","cat2"));
        list1.add(new CategoryModel("Forest","cat3"));
        list1.add(new CategoryModel("Desert","cat4"));
        list1.add(new CategoryModel("Mountain","cat5"));

        binding.viewCate.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        adapterCategory=new CategoryAdapter(list1);
        binding.viewCate.setAdapter(adapterCategory);
    }
}
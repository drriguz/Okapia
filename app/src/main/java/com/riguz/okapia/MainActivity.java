package com.riguz.okapia;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.riguz.okapia.model.SecretItem;
import com.riguz.okapia.ui.ItemAdapter;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        final Resources resources = this.getResources();

        adapter = new ItemAdapter(Arrays.asList(
                new SecretItem("China bank card", "2019/01/02", R.drawable.china_bank),
                new SecretItem("Taobao password", "2019/03/24", R.drawable.protected_x128)),
                resources);
        recyclerView.setAdapter(adapter);
    }
}

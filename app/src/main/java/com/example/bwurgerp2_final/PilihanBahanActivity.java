package com.example.bwurgerp2_final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;

public class PilihanBahanActivity extends AppCompatActivity {

    private Button btRoti;
    private BottomSheetDialog showPilihanRotiActivity;
    private final ArrayList<rotiModel> rotiModelArrayList = new ArrayList<>();
    private final int[] gambarBun = {R.drawable.bun_normal, R.drawable.bun_pretzel, R.drawable.bun_brioche, R.drawable.bun_wheat};
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan);

        btRoti = findViewById(R.id.btRoti);

        showPilihanRotiActivity = new BottomSheetDialog(PilihanBahanActivity.this);
        View viewPilihanRoti = LayoutInflater.from(PilihanBahanActivity.this).inflate(R.layout.bottomsheet_pilihan_roti, null);
        showPilihanRotiActivity.setContentView(viewPilihanRoti);
        btRoti.setBackgroundColor(ContextCompat.getColor(PilihanBahanActivity.this, R.color.btYellow));
        showPilihanRotiActivity.show();

        recyclerView = viewPilihanRoti.findViewById(R.id.rvPilihanRoti);
        setRotiModelArrayList();

        rvRotiAdapter adapter = new rvRotiAdapter(this, rotiModelArrayList);

        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        btRoti.setOnClickListener(view -> showPilihanRotiActivity.show());
    }

    private void setRotiModelArrayList() {
        String namaBun[] = getResources().getStringArray(R.array.namaBun);

        for (int i = 0; i < namaBun.length; i++) {
            rotiModelArrayList.add(new rotiModel(namaBun[i],
                                                 gambarBun[i]));
        }
    }
}

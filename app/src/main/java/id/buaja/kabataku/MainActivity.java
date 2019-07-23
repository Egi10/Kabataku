package id.buaja.kabataku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etAngkaPertama, etAngkaKedua;
    private TextView tvHasil;
    private HasilAdapter hasilAdapter;
    private ArrayList<String> list;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasilAdapter = new HasilAdapter(getBaseContext());
        list = new ArrayList<>();

        //Deklarasi
        etAngkaPertama = findViewById(R.id.et_angka_pertama);
        etAngkaKedua = findViewById(R.id.et_angka_kedua);
        tvHasil = findViewById(R.id.tv_hasil);
        recyclerView = findViewById(R.id.recycler_view);

        Button btnTambah = findViewById(R.id.btn_tambah);
        btnTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_tambah) {
            int angkaPertama = Integer.valueOf(etAngkaPertama.getText().toString());
            int angkaKedua = Integer.valueOf(etAngkaKedua.getText().toString());

            int hasil = angkaPertama + angkaKedua;
            list.add(String.valueOf(hasil));
            hasilAdapter.setList(list);
            recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), 3));
            recyclerView.setAdapter(hasilAdapter);

            tvHasil.setText(String.valueOf(hasil));
        }
    }
}

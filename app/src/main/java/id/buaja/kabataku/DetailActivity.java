package id.buaja.kabataku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.iv_image);
        TextView textView = findViewById(R.id.tv_hasil);

        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        String hasil = intent.getStringExtra("hasil");

        textView.setText(hasil);
        Picasso.get().load(image).into(imageView);
    }
}

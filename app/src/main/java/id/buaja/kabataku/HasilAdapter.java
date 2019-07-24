package id.buaja.kabataku;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HasilAdapter extends RecyclerView.Adapter<HasilAdapter.ViewHolder> {
    private ArrayList<Hasil> list;
    private Context context;

    public HasilAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Hasil> getList() {
        return list;
    }

    public void setList(ArrayList<Hasil> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hasil, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.angkaPertama.setText("Angka Pertama : "+getList().get(position).getAngkaPertama());
        holder.angkaKedua.setText(getList().get(position).getAngkaKedua());
        holder.angkaHasil.setText(getList().get(position).getAngkaHasil());

        Picasso.get().load(getList().get(position).getImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image", getList().get(position).getImage());
                intent.putExtra("hasil", getList().get(position).getAngkaHasil());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView angkaPertama, angkaKedua, angkaHasil;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            angkaPertama = itemView.findViewById(R.id.tv_angka_pertama);
            angkaKedua = itemView.findViewById(R.id.tv_angka_kedua);
            angkaHasil = itemView.findViewById(R.id.tv_hasil);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }
}

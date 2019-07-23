package id.buaja.kabataku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HasilAdapter extends RecyclerView.Adapter<HasilAdapter.ViewHolder> {
    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    private ArrayList<String> list;
    private Context context;

    public HasilAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hasil, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvHasil.setText(getList().get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, getList().get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        int list = 0;
        if (getList().size() > 5) {
            list = 5;
        } else {
            list = getList().size();
        }
        return list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHasil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHasil = itemView.findViewById(R.id.tv_hasil);
        }
    }
}

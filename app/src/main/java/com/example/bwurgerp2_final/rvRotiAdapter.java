    package com.example.bwurgerp2_final;

    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageButton;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.ArrayList;

    public class rvRotiAdapter extends RecyclerView.Adapter<rvRotiAdapter.MyViewHolder> {

        private Context context;
        private ArrayList<rotiModel> rotiModelArrayList;

        public rvRotiAdapter(Context context, ArrayList<rotiModel> rotiModelArrayList) {
                this.context = context;
                this.rotiModelArrayList = rotiModelArrayList;
        }

        @NonNull
        @Override
        public rvRotiAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_roti_rv, parent, false);

            return new rvRotiAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull rvRotiAdapter.MyViewHolder holder, int position) {
                holder.tvRotiPilihan.setText(rotiModelArrayList.get(position).getNama());
                holder.btRotiPilihan.setImageResource(rotiModelArrayList.get(position).getGambar());

                holder.btRotiPilihan.setOnClickListener(v -> {
                    Toast.makeText(context, "Anda memilih " + rotiModelArrayList.get(position).getNama(), Toast.LENGTH_SHORT).show();
                });
        }

        @Override
        public int getItemCount() {
            return rotiModelArrayList.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView btRotiPilihan;
            TextView tvRotiPilihan;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                btRotiPilihan = itemView.findViewById(R.id.btRotiPilihan);
                tvRotiPilihan = itemView.findViewById(R.id.tvNamaBun);
            }
        }
    }

package com.syssolution.ssonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.syssolution.ssonline.PackagesModel;
import com.syssolution.ssonline.R;

public class PackagesAdapter extends RecyclerView.Adapter<PackagesAdapter.ViewHolder> {




    PackagesModel[] packagesModels;
    Context context;

    public PackagesAdapter(PackagesModel[] packagesModels, Context context) {
        this.packagesModels = packagesModels;
        this.context = context;
    }

    @NonNull
    @Override
    public PackagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.packages_design, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull PackagesAdapter.ViewHolder holder, int position) {

        final PackagesModel packagesModel = packagesModels[position];

        holder.Name.setText(packagesModel.getName());
        holder.Speed.setText(packagesModel.getSpeed());
        holder.Charge.setText(packagesModel.getCharge());

    }

    @Override
    public int getItemCount() {

        return packagesModels.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView Name, Charge, Speed;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            Name = itemView.findViewById(R.id.packagesNumber);
            Charge = itemView.findViewById(R.id.packagesCharge);
            Speed = itemView.findViewById(R.id.packagesSpeed);
        }
    }
}

package org.pursuit.implicitintentappfromscratch.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.implicitintentappfromscratch.R;
import org.pursuit.implicitintentappfromscratch.model.Zodiac;
import org.pursuit.implicitintentappfromscratch.view.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {
    private List<Zodiac> zodiacList;

    public ZodiacAdapter(List<Zodiac> zodiacList) {
        this.zodiacList = zodiacList;
    }

    @NonNull
    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zodiac_item_view,parent,false);
        return new ZodiacViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int position) {
        zodiacViewHolder.onBind(zodiacList.get(position));
    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }
}

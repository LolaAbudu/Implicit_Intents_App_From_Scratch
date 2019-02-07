package org.pursuit.implicitintentappfromscratch.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.implicitintentappfromscratch.DisplayActivity;
import org.pursuit.implicitintentappfromscratch.R;
import org.pursuit.implicitintentappfromscratch.model.Zodiac;

import java.util.List;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView numberTextView;

    public static final String NAME = "name";
    public static final String NUMBER = "number";
    public static final String IMAGE = "image";


    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_textView);
        numberTextView = itemView.findViewById(R.id.number_textView);
    }

    public void onBind(final Zodiac zodiac){
        nameTextView.setText(zodiac.getName());
        numberTextView.setText(zodiac.getNumber());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra(NAME, zodiac.getName());
                intent.putExtra(NUMBER, zodiac.getNumber());
                intent.putExtra(IMAGE, zodiac.getImage());
                itemView.getContext().startActivity(intent);
            }
        });


        //Picasso.get().load(zodiac.getImage()).into(imageImageView);
    }
}

package org.pursuit.implicitintentappfromscratch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.implicitintentappfromscratch.view.ZodiacViewHolder;

public class DisplayActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView imageImageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        nameTextView = findViewById(R.id.display_name_textView);
        numberTextView = findViewById(R.id.display_number_textView);
        imageImageView = findViewById(R.id.display_image_imageView);
        button = findViewById(R.id.display_horoscope_button);

        Intent getIntent = getIntent();
        final String name = getIntent.getStringExtra(ZodiacViewHolder.NAME);
        String number = getIntent.getStringExtra(ZodiacViewHolder.NUMBER);
        String image = getIntent.getStringExtra(ZodiacViewHolder.IMAGE);

        nameTextView.setText(name);
        numberTextView.setText(number);
        Picasso.get().load(image).into(imageImageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webpage = "https://www.astrology.com/horoscope/daily/" + name + ".html";
                Uri uri = Uri.parse(webpage);
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(websiteIntent);
            }
        });
    }
}

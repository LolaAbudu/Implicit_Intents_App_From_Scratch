package org.pursuit.implicitintentappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.implicitintentappfromscratch.adapter.ZodiacAdapter;
import org.pursuit.implicitintentappfromscratch.model.Zodiac;
import org.pursuit.implicitintentappfromscratch.model.ZodiacList;
import org.pursuit.implicitintentappfromscratch.network.RetrofitSingleton;
import org.pursuit.implicitintentappfromscratch.network.ZodiacServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        ZodiacServices zodiacServices = retrofit.create(ZodiacServices.class);
        final Call<ZodiacList> zodiacListCall = zodiacServices.getZodiac();
        zodiacListCall.enqueue(new Callback<ZodiacList>() {
            @Override
            public void onResponse(Call<ZodiacList> call, Response<ZodiacList> response) {
                Log.d("zodiac", response.body().getZodiac().get(1).getName());

                List<Zodiac> zodiacList = response.body().getZodiac();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                ZodiacAdapter zodiacAdapter = new ZodiacAdapter(zodiacList);
                recyclerView.setAdapter(zodiacAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onFailure(Call<ZodiacList> call, Throwable t) {
                Log.d("zodiac", t.toString());
            }
        });
    }
}

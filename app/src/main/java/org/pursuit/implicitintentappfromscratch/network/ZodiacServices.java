package org.pursuit.implicitintentappfromscratch.network;

import org.pursuit.implicitintentappfromscratch.model.ZodiacList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZodiacServices {

    @GET("JDVila/storybook/master/zodiac.json")
    Call<ZodiacList> getZodiac();
}

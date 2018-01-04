package murali.myapplication.rest_api_work;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shyleenrodrigues on 1/2/18.
 */

public class APIClient {

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(Context context) {
        retrofit = new Retrofit.Builder().
                baseUrl("https://reqres.in").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        return retrofit;
    }
}
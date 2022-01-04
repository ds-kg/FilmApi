package lbf.com.lesson1;

import android.app.Application;
import lbf.com.lesson1.data.remote.FilmsApi;
import lbf.com.lesson1.data.remote.FilmsApiClient;
import lbf.com.lesson1.data.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmsApi api;
    public static FilmsApiClient client;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmsApi();
        client = new FilmsApiClient();
    }
}

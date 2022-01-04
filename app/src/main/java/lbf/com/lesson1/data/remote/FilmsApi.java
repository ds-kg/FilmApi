package lbf.com.lesson1.data.remote;

import java.util.List;

import lbf.com.lesson1.data.models.Film;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FilmsApi {

    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getFilm(
            @Path("id") String id
    );
}

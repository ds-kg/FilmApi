package lbf.com.lesson1.data.remote;

import java.util.List;

import lbf.com.lesson1.data.models.Film;

public interface FilmsCallback {
    void success(List<Film> films);
    void failure(String msg);
}

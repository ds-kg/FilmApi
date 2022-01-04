package lbf.com.lesson1.ui.films_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lbf.com.lesson1.App;
import lbf.com.lesson1.R;
import lbf.com.lesson1.data.models.Film;
import lbf.com.lesson1.data.remote.FilmsCallback;
import lbf.com.lesson1.databinding.FragmentFilmsBinding;
import retrofit2.http.Path;


public class FilmsFragment extends Fragment implements FilmsCallback{

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
        adapter.setOnClick(film -> {
            Bundle bundle = new Bundle();
            bundle.putString("id", film.getId());
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host);
            navController.navigate(R.id.filmDetailFragment, bundle);
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.filmsRecycler.setAdapter(adapter);
        App.client.getFilms(this);
    }

    @Override
    public void success(List<Film> films) {
        adapter.setFilms(films);

    }

    @Override
    public void failure(String msg) {
        Log.e("TAG", "failure: " + msg);
    }
}
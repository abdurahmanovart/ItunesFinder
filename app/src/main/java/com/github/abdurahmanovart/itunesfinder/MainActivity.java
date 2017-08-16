package com.github.abdurahmanovart.itunesfinder;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.github.abdurahmanovart.itunesfinder.bean.Track;
import com.github.abdurahmanovart.itunesfinder.bean.TracksResponse;
import com.github.abdurahmanovart.itunesfinder.net.ApiClient;
import com.github.abdurahmanovart.itunesfinder.net.TrackService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainFragment.OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        createSearchView();
    }

    private void createSearchView() {
        SearchView SearchView = (SearchView) findViewById(R.id.search);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        SearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getDataFromServer(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    private void getDataFromServer(String query) {
        TrackService service = ApiClient.getClient().create(TrackService.class);
        Call<TracksResponse> responseCall = service.getTracks(query);

        responseCall.enqueue(new Callback<TracksResponse>() {
            @Override
            public void onResponse(@NonNull Call<TracksResponse> call, @NonNull Response<TracksResponse> response) {
                TracksResponse tracksResponse = response.body();
                if (tracksResponse != null)
                    startFragment(tracksResponse);
            }

            @Override
            public void onFailure(@NonNull Call<TracksResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "failure "+t.getMessage());
            }
        });
    }

    private void startFragment(TracksResponse response) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, MainFragment.newInstance(response))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onItemClick(Track track) {
        Toast.makeText(getApplicationContext(), "here we are " + track.getTrackPreviewUrl(), Toast.LENGTH_LONG).show();
    }
}
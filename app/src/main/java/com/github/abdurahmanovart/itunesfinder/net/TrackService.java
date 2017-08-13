package com.github.abdurahmanovart.itunesfinder.net;

import com.github.abdurahmanovart.itunesfinder.bean.TracksResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author Abdurakhmanov on 13.08.17
 */

public interface TrackService {
    @POST("search")
    Call<TracksResponse> getTracks(@Query("term") String keyword);
}

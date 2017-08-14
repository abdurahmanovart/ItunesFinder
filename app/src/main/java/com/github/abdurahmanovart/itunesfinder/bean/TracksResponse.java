package com.github.abdurahmanovart.itunesfinder.bean;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.common.base.Objects;

import java.util.List;

/**
 * @author Abdurakhmanov on 13.08.17
 */

public class TracksResponse {

    private int mTrackCount;

    private List<Track> mTracks;

    public TracksResponse() {
        //Empty constructor needed by Jackson
    }

    @JsonGetter("resultCount")
    public int getTrackCount() {
        return mTrackCount;
    }


    @JsonSetter("resultCount")
    public void setTrackCount(int trackCount) {
        mTrackCount = trackCount;
    }

    @NonNull
    @JsonGetter("results")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Track> getTracks() {
        return mTracks;
    }

    @JsonSetter("results")
    public void setTracks(List<Track> tracks) {
        mTracks = tracks;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TracksResponse that = (TracksResponse) o;
        return mTrackCount == that.mTrackCount &&
                Objects.equal(mTracks, that.mTracks);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mTrackCount, mTracks);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mTrackCount", mTrackCount)
                .add("mTracks", mTracks)
                .toString();
    }
}

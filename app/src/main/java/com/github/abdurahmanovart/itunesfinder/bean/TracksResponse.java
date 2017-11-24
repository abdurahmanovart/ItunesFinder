package com.github.abdurahmanovart.itunesfinder.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Abdurakhmanov on 13.08.17
 */

public class TracksResponse implements Parcelable {

    public static final ClassCreator CREATOR = new ClassCreator();

    private int mTrackCount;

    private List<Track> mTracks;

    public TracksResponse() {
        //Empty constructor needed by Jackson
    }

    protected TracksResponse(Parcel in) {
        mTrackCount = in.readInt();
        mTracks = new ArrayList<>();
        in.readList(mTracks, null);
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
        return MoreObjects.toStringHelper(this)
                .add("mTrackCount", mTrackCount)
                .add("mTracks", mTracks)
                .toString();
    }


    //    @JsonIgnore
//    @Override
//    public String toString() {
//        return Objects.toStringHelper(this)
//                .add("mTrackCount", mTrackCount)
//                .add("mTracks", mTracks)
//                .toString();
//    }

    @JsonIgnore
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mTrackCount);
        dest.writeList(mTracks);
    }

    @JsonIgnore
    @Override
    public int describeContents() {
        return 0;
    }

    public static final class ClassCreator implements Creator<TracksResponse> {

        @Override
        public TracksResponse createFromParcel(Parcel in) {
            return new TracksResponse(in);
        }

        @Override
        public TracksResponse[] newArray(int size) {
            return new TracksResponse[size];
        }

    }
}
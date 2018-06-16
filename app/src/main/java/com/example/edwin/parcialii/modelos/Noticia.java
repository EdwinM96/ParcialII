package com.example.edwin.parcialii.modelos;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
/*import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;*/
import java.io.Serializable;

public class Noticia implements Serializable, Parcelable, Comparable<Noticia>{
    private String _id;

    private String title;

    private String coverImage;

    private String created_date;

    private String description;

    private String body;

    private String game;


    public Noticia(@NonNull String id, String title, String coverImage, String created_date, String description, String body, String game) {
        _id = id;
        this.title = title;
        this.coverImage = coverImage;
        this.created_date = created_date;
        this.description = description;
        this.body = body;
        this.game = game;
    }

    public Noticia() {
    }

    protected Noticia(Parcel in) {
        _id = in.readString();
        title = in.readString();
        coverImage = in.readString();
        created_date = in.readString();
        description = in.readString();
        body = in.readString();
        game = in.readString();
    }

    public static final Creator<Noticia> CREATOR = new Creator<Noticia>() {
        @Override
        public Noticia createFromParcel(Parcel in) {
            return new Noticia(in);
        }

        @Override
        public Noticia[] newArray(int size) {
            return new Noticia[size];
        }
    };

    @NonNull
    public String get_id() {
        return _id;
    }

    public void set_id(@NonNull String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(title);
        dest.writeString(coverImage);
        dest.writeString(created_date);
        dest.writeString(description);
        dest.writeString(body);
        dest.writeString(game);
    }

    @Override
    public int compareTo(@NonNull Noticia o) {
        return 0;
    }
}

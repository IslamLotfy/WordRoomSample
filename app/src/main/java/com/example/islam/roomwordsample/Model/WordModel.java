package com.example.islam.roomwordsample.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class WordModel {

    @PrimaryKey
    @NonNull
    private String word;

    public WordModel(@NonNull String word){
        this.word=word;
    }

    public String getWord() {
        return word;
    }
}

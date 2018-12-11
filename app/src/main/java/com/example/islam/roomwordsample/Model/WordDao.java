package com.example.islam.roomwordsample.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insertWord(WordModel wordModel);
    @Query("Delete FROM word_table")
    void deleteAll();
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<WordModel>> getAllWords();
}

package com.example.islam.roomwordsample.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<WordModel>> words;
    public WordRepository(Application application){
        WordRoomDatabase wordRoomDatabase=WordRoomDatabase.getInstance(application);
        wordDao=wordRoomDatabase.wordDao();
        words=wordDao.getAllWords();
    }

    public LiveData<List<WordModel>> getWords() {
        return words;
    }
    public void insert (WordModel word) {
        new insertAsyncTask(wordDao).execute(word);
    }
    private static class insertAsyncTask extends AsyncTask<WordModel, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WordModel... params) {
            mAsyncTaskDao.insertWord(params[0]);
            return null;
        }
    }
}

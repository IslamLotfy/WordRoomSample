package com.example.islam.roomwordsample.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.islam.roomwordsample.Model.WordModel;
import com.example.islam.roomwordsample.Model.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    private LiveData<List<WordModel>> words;
    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(this.getApplication());
        words=wordRepository.getWords();
    }
    public LiveData<List<WordModel>> getAllWords() { return words; }

    public void insert(WordModel word) { wordRepository.insert(word); }
}

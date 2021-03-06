package com.nefteavtomatica.wordfreqapp;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;


public class WordsCountTest {
    private WordsCount wordsCount;  

    @Test (expected = NoSuchFileException.class)
    public void setFileThrowsNoSuchFileException() throws Exception {
        wordsCount = new WordsCount();
        wordsCount.setFile("i am not here .txt");      
    }

    @Test (expected = IOException.class)
    public void testParseToListThrowsIOException() throws Exception {
        wordsCount = new WordsCount();
        wordsCount.setFile("kindle.exe");
        wordsCount.countWordsFrequencies();
    }

    @Test
    public void testPrintWordsFreq() throws Exception {
        assertWordsFreqMapNotNull();
        wordsCount.printWordsFrequencies();
    }

    @Test
    public void  assertWordsFreqMapNotNull() throws Exception {
        wordsCount = new WordsCount();
        wordsCount.setFile("words.txt");
        wordsCount.parseToList();
        wordsCount.countWordsFrequencies();
        assertNotNull(wordsCount.wordsFreqMap);       
    }

    @Test
    public void testOfWordsListNotNull() throws Exception {
        List<String> wordsListShouldNotBeNull;
        wordsCount = new WordsCount();
        wordsCount.setFile("words.txt");
        wordsCount.parseToList();
        wordsListShouldNotBeNull = wordsCount.wordsList;
        assertNotNull("wordList should not be null",wordsListShouldNotBeNull);       
    }

    @Test
    public void testFileNotNull() throws Exception {
        WordsCount wordsCount = new WordsCount();
        wordsCount.setFile("words.txt");
        assertNotNull("file should not be null",wordsCount.file); 
    }
}

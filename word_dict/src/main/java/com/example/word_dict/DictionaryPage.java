package com.example.word_dict;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

//FOR MULTIPLE XML FILES IMPORT
public class DictionaryPage {
    public AnchorPane root;
    DictionaryPage() throws IOException{
       root =  FXMLLoader.load(getClass().getResource("DictionaryPage.fxml"));
    }
}

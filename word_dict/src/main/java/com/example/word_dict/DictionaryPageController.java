package com.example.word_dict;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {

    private DictionarySaver db;

    //-----------------------------------------------------FIND WORD----------------------------------------------------
    @FXML
    TextField search;
    @FXML
    public void searchButton(MouseEvent event) throws IOException{
        db = new DictionarySaver();
        //db.serializeHashMap(); // N.E.A.R. First time only !
        db.deserializeHashMap();

        if(search.getText()=="")
        {
            Alert no_input_alert = new Alert(Alert.AlertType.ERROR);
            no_input_alert.setHeaderText("Empty Input");
            no_input_alert.setContentText("Please enter a word first!");
            no_input_alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(search.getText().toLowerCase()))
        {
            Alert available_alert = new Alert(Alert.AlertType.INFORMATION);
            available_alert.setHeaderText("Dictionary");
            available_alert.setContentText(search.getText()+" is AVAILABLE in dictionary !");
            available_alert.showAndWait();
        }
        else
        {
            Alert unavailable_alert = new Alert(Alert.AlertType.INFORMATION);
            unavailable_alert.setHeaderText("Dictionary");
            unavailable_alert.setContentText(search.getText()+" is NOT available in dictionary !");
            unavailable_alert.showAndWait();
        }
    }


    //---------------------------------------INSERT WORD----------------------------------------------------------------
    @FXML
    TextField addWord;
    @FXML
    TextField addMeaning;
    @FXML

    public void addButton(MouseEvent event) throws IOException, ClassNotFoundException{
        db = new DictionarySaver();
        db.deserializeHashMap();

        if(addWord.getText()=="" || addMeaning.getText()=="") {
            Alert no_input_alert = new Alert(Alert.AlertType.ERROR);
            no_input_alert.setHeaderText("Empty Input");
            no_input_alert.setContentText("Please enter a word  and meaning !");
            no_input_alert.showAndWait();
        }
        else if (db.getDictionaryList().containsKey(addWord.getText().toLowerCase())) {
            Alert already_present_alert = new Alert(Alert.AlertType.WARNING);
            already_present_alert.setHeaderText("Already Present!");
            already_present_alert.setContentText("Word is already present in dictionary !");
            already_present_alert.showAndWait();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Success !");
            db.getDictionaryList().put(addWord.getText().toLowerCase(),addMeaning.getText());
            db.serializeHashMap();
            alert.setContentText("New word added successfully !");
            alert.showAndWait();
        }
    }


    //--------------------------------------------FIND MEANING----------------------------------------------------------
    @FXML
    TextField find;
    @FXML
    public void findButton(MouseEvent event) throws IOException{
        db = new DictionarySaver();
        db.deserializeHashMap();

        if(find.getText()=="")
        {
            Alert no_input_alert = new Alert(Alert.AlertType.ERROR);
            no_input_alert.setHeaderText("Empty Input");
            no_input_alert.setContentText("Please enter a word first!");
            no_input_alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(find.getText().toLowerCase()))
        {
            Alert foundalert = new Alert(Alert.AlertType.INFORMATION);
            foundalert.setHeaderText("Meaning");
            foundalert.setContentText(db.getDictionaryList().get(find.getText().toLowerCase()));
            foundalert.showAndWait();
        }
        else{
            Alert not_found = new Alert(Alert.AlertType.WARNING);
            not_found.setHeaderText("Word not Found !");
            not_found.setContentText("Insert word first !");
            not_found.showAndWait();
        }
    }


}

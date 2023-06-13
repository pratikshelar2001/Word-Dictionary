module com.example.word_dict {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.word_dict to javafx.fxml;
    exports com.example.word_dict;
}
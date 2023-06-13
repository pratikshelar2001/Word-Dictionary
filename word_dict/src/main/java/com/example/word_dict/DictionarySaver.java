package com.example.word_dict;

import java.io.*;
import java.util.HashMap;

public class DictionarySaver {

    private HashMap<String,String> dictionaryList;

    DictionarySaver(){
        dictionaryList=new HashMap<String,String>();
    }
    HashMap<String,String> getDictionaryList(){
        return dictionaryList;
    }


    void serializeHashMap(){
        try{
            FileOutputStream fos = new FileOutputStream("dictionaryData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(dictionaryList);
            oos.close();
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void deserializeHashMap(){
        try{
            FileInputStream fos = new FileInputStream("dictionaryData");
            ObjectInputStream ois = new ObjectInputStream(fos);

            dictionaryList = (HashMap<String, String>) ois.readObject();


          //  ois.close();
          //  fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

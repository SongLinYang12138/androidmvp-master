package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by ysl on 2017/9/28.
 */

public class ParseIcon {


    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                readFile();
            }
        }).start();

    }


    public  static void readFile() {

        ArrayList<String> nameArray = new ArrayList<>();
        ArrayList<Integer> codeArray = new ArrayList<>();


        File nameFile = new File("F:" + File.separator + "RN" + File.separator + "iconName.txt");
        File codeFile = new File("F:" + File.separator + "RN" + File.separator + "iconCode.txt");

        try {

            FileReader nameRead = new FileReader(nameFile);
            BufferedReader nameReader = new BufferedReader(nameRead);

            boolean nameStart = nameReader.ready();

            if (nameStart) {
                String buffer = nameReader.readLine();
                String[] nameAttr = buffer.split("fontclass");
                for (int i = 0; i < nameAttr.length; ++i) {
                    String str = nameAttr[i];
                    if (str.contains("#")) {
                        str = str.substring(str.indexOf("#"), str.indexOf("<"));
                        nameArray.add(str);
                    }
                }
            }
            nameRead.close();
            nameReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileReader codeRead = new FileReader(codeFile);
            BufferedReader codeReader = new BufferedReader(codeRead);

            String codes = null;
            if (codeReader.ready()) {

                codes = codeReader.readLine();
                String[] codeArr = codes.split("amp");
                for (int i = 0; i < codeArr.length; ++i) {
                    String str = codeArr[i];
                    if (str.contains("#")) {
                        str = str.substring(str.indexOf("x", str.indexOf(";")));
                        codeArray.add(Integer.parseInt(str, 16));
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        File file = new File("F:" + File.separator + "RN" + File.separator + "myJson.Json");

        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < nameArray.size(); ++i) {
                writer.write(nameArray.get(i) + ": " + codeArray.get(i));
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

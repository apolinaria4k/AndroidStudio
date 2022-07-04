package com.example.project36;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    private final List<Valute> valute = new ArrayList<>();
    private final double coef = 0.1f;
    String tagName, textCharCode, textName;
    int textNumCode;
    double textValue;
    Adapter adapter;
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView)findViewById(R.id.listView);
        adapter = new Adapter(this,valute, coef);
        listView.setAdapter(adapter);
        try {
            XmlPullParser xpp = prepareXpp();

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {
//                    case XmlPullParser.START_DOCUMENT:
//                        break;
                    // начало тэга
                    case XmlPullParser.START_TAG:{
                        // сохраняем xpp.getName() в tagName
                        tagName = xpp.getName();
                        break;
                    }

                        // конец тэга
                    case XmlPullParser.END_TAG:{
                        //для сравнения строк можно использовать следующую конструкцию
                        //if( tagName.equals("Name") )
                        if(xpp.getName().equals("Valute")){
                                valute.add(new Valute(textNumCode, textCharCode,
                                        textName, textValue));

                        }
                        // если xpp.getName() - «Valute», значит, закончился фрагмент xml
                        //с информацией об очередной валюте, создаем объект класса testValute,
                        //передаем ему в конструкторе параметры  textNumCode,  textCharCode,
                        // textName, textValute и добавляем этот объект в список
                        break;
                    }

                    // содержимое тэга
                    case XmlPullParser.TEXT:{
                        //для сравнения строк можно использовать следующую конструкцию
                        //if( tagName.equals("Name") )
                        switch (tagName){
                            case "NumCode":{
                                textNumCode = Integer.valueOf(xpp.getText());
                                break;
                            }
                            case "CharCode":{
                                textCharCode = xpp.getText();
                                break;
                            }
                            case "Name":{
                                textName = xpp.getText();
                                break;
                            }
                            case "Value":{
                                textValue = Double.valueOf(xpp.getText().replace(',','.'));
                            }
                            default:
                                break;
                        }
                        // если tagName-”NumCode”, сохраняем xpp.getText() в переменной textNumCode
                        // если tagName-”CharCode”, сохраняем xpp.getText() в переменной textCharCode
                        // если tagName-”Name”, сохраняем xpp.getText() в переменной textName
                        // если tagName-”Valute”, сохраняем xpp.getText() в переменной textValute
                        // т. к. при указании курса валюты используется запятая, а для числового //значения в качестве десятичного разделителя требуется точка, то при //преобразовании значения курса в число требуется заменить запятую на точку
//Float.valueOf(xpp.getText().replace(',','.'));

                        break;
                    }
                    default:
                        break;
                }
                // следующий элемент
                xpp.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        XmlPullParser prepareXpp() {
        return getResources().getXml(R.xml.data);
    }
}

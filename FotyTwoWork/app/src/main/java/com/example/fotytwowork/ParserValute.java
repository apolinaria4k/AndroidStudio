package com.example.fotytwowork;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ParserValute {
    String xmlString;
    List<Valute> valute;
    private final double coef = 0.1f;
    String tagName, textCharCode, textName;
    int textNumCode;
    double textValue;
    public ParserValute(String _xmlString, List<Valute> _valute){
        xmlString = _xmlString;
        valute = _valute;

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
    XmlPullParser prepareXpp() throws XmlPullParserException {
        // получаем фабрику
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        // включаем поддержку namespace (по умолчанию выключена)
        factory.setNamespaceAware(true);
        // создаем парсер для уже полученной ранее строки xmlString с содержимым файла
        XmlPullParser xpp = factory.newPullParser();
        // даем парсеру на вход Reader
        xpp.setInput(new StringReader(xmlString));
        return xpp;
    }

}

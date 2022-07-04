package com.example.project36;


public class Valute {
    int valuteNumCode;
    String valuteCharCode,
            valuteName;
    double valuteValue;

    public Valute(int _valuteNumCode, String _valuteCharCode,
                  String _valuteName, double _valuteValue){
        valuteNumCode = _valuteNumCode;
        valuteCharCode = _valuteCharCode;
        valuteName = _valuteName;
        valuteValue = _valuteValue;
    }

    public int getValuteNumCode() {
        return valuteNumCode;
    }

    public void setValuteNumCode(int valuteNumCode) {
        this.valuteNumCode = valuteNumCode;
    }

    public String getValuteCharCode() {
        return valuteCharCode;
    }

    public void setValuteCharCode(String valuteCharCode) {
        this.valuteCharCode = valuteCharCode;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    public double getValuteValue() {
        return valuteValue;
    }

    public void setValuteValue(double valuteValue) {
        this.valuteValue = valuteValue;
    }
}

package com.example.project39;

public class MyBank {
    String adr, start, fin;
    int[] t;
    public MyBank(String _adr, String _start, String _fin, int[] _t){
        adr = _adr;
        start = _start;
        fin = _fin;
        t = _t;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public int getT() {
        return t[0];
    }

    public void setT(int[] t) {
        this.t = t;
    }
}

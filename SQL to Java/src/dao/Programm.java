package dao;

import bussinesObjects.Vertragspartner;

public class Programm {

    public static void main(String[] args) throws ClassNotFoundException{

        WareDao wareDao = new WareDao();
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        Vertragspartner vertragspartner = vertragspartnerDao.read("123");
        System.out.println(vertragspartner.getNachname());

    }

}

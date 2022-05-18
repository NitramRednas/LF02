package dao;

import bussinesObjects.Ware;
import bussinesObjects.Vertragspartner;

public class Programm {

    public static void main(String[] args) throws ClassNotFoundException{

        WareDao wareDao = new WareDao();
        Ware ware = wareDao.read("1");
        System.out.println(ware.getBeschreibung());

        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        Vertragspartner vertragspartner = vertragspartnerDao.read("123");
        System.out.println(vertragspartner.getNachname());

    }

}

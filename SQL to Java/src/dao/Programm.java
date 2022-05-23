package dao;

import bussinesObjects.Ware;
import bussinesObjects.Vertragspartner;

import java.util.ArrayList;

public class Programm {

    public static void main(String[] args) throws ClassNotFoundException{

      //WareDao wareDao = new WareDao();
      //ArrayList<Ware> wareArrayList = new ArrayList<>();
      //wareArrayList = wareDao.read();
      //System.out.println(wareArrayList);

      VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
      ArrayList<Vertragspartner> vertragspartnerArrayList = new ArrayList<>();

      vertragspartnerArrayList = vertragspartnerDao.read();
      System.out.println(vertragspartnerArrayList);

      vertragspartnerDao.delete("5555");


    }

}

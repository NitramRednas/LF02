package dao;

import bussinesObjects.Adresse;
import bussinesObjects.Ware;
import bussinesObjects.Vertragspartner;

import java.sql.SQLException;
import java.util.ArrayList;

public class Programm {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

      //WareDao wareDao = new WareDao();
      //ArrayList<Ware> wareArrayList = new ArrayList<>();
      //wareArrayList = wareDao.read();
      //System.out.println(wareArrayList);

      VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
      ArrayList<Vertragspartner> vertragspartnerArrayList = new ArrayList<>();

      //vertragspartnerDao.delete("1111");

      Vertragspartner vertragspartner = new Vertragspartner("Heinz","Koch");
      vertragspartner.setAusweisNr("2899");
        Adresse adresse = new Adresse("Radweg","12","2859","Karstadt");
      vertragspartner.setAdresse(adresse);
      vertragspartnerDao.insert(vertragspartner);

      Vertragspartner vertragspartner1 = new Vertragspartner("Lena", "Laurasen");
      vertragspartner1.setAusweisNr("3366");
      Adresse adresse1 = new Adresse("Natur","1","4141","Hügel");
      vertragspartner1.setAdresse(adresse1);
      vertragspartnerDao.insert(vertragspartner1);

      vertragspartnerArrayList = vertragspartnerDao.read();
      System.out.println(vertragspartnerArrayList);
    }

}

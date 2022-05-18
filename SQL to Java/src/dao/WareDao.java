package dao;

public class WareDao {

    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTIONSTRING = "jdbc:sqlite:SQL to Java/src/data/Kaufvertrag.db";

    public WareDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);

    }

}

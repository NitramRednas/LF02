public class KeineKraftException extends Exception{

    private String aktion;
    private String name;

    public KeineKraftException(String aktion, String name){

        this.aktion = aktion;
        this.name = name;
    }

    public String getMessage(){
        return name + "\that für diese Aktion keine Kraft:\t" + aktion;
    }

}

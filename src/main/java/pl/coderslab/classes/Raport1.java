package pl.coderslab.classes;



public class Raport1 {

    private String Imie_i_Nazwisko;
    private int Roboczogodziny;

    public Raport1(String Imie_i_Nazwisko, int Roboczogodziny) {
        Imie_i_Nazwisko = Imie_i_Nazwisko;
        Roboczogodziny = Roboczogodziny;
    }

    public Raport1() {
    }

    public String getImie_i_Nazwisko() {
        return Imie_i_Nazwisko;
    }

    public void setImie_i_Nazwisko(String imie_i_Nazwisko) {
        Imie_i_Nazwisko = Imie_i_Nazwisko;
    }

    public int getRoboczogodziny() {
        return Roboczogodziny;
    }

    public void setRoboczogodziny(int Roboczogodziny) {
        Roboczogodziny = Roboczogodziny;
    }
}

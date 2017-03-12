package agendatelefonica;

import java.io.Serializable;

public class NrTel implements Serializable {

    String numarTel;

    //tratarea exceptiilor care pot sa apara la introducerea unui numar de telefon.
    public static void exceptiiNumar(String numar) {

        if (!numar.startsWith("02") && !numar.startsWith("07")) {
            throw new NumberFormatException("Numarul de telefon trebuie sa inceapa cu 02 sau 07 !!!");
        }
        if (!numar.matches("[0-9]+")) {
            throw new NuEsteNumarException("Numarul trebuie sa contina numai cifre !");
        }
        if (numar.length() == 0) {
            throw new NumarLipsaException("Numarul de telefon nu poate sa lipseasca !!!");
        }
        if (numar.length() < 10 || numar.length() > 10) {
            throw new DimensiuneNepotrivitaException("Numarul trebuie sa contina 10 cifre !!!");
        }
    }

    //constructor cu parametrii.
    public NrTel(String nr) {

        exceptiiNumar(nr);
        numarTel = nr;
    }

    //getter numar.
    public String getNr() {
        return numarTel;
    }

    //setter numar.
    public void setNr(String nr) {

        exceptiiNumar(nr);
        numarTel = nr;
    }

    //rescriere toString.
    @Override
    public String toString() {
        return numarTel;
    }

}

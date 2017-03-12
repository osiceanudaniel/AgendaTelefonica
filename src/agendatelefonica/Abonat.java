package agendatelefonica;

import java.io.Serializable;
import java.util.Calendar;

public class Abonat implements Serializable {
    
    String nume;
    String prenume;
    String CNP;
    NrTel nr;
    
    //tratarea exceptiilor care pot sa apara la introducerea unui abonat.
    public static void exceptiiTot(String num, String pren, String cnp) {
        
        if (num == null || num.length() == 0) {
            throw new IllegalArgumentException("Numele nu poate sa lipseasca !!!");
        }
        if (pren == null || pren.length() == 0) {
            throw new IllegalArgumentException("Prenumele nu poate sa lipseasca !!!");
        }
        if (!num.toUpperCase().matches("[A-Z][a-zA-Z]*")) {
            throw new NuPareNumeException("Nu pare sa fie un nume valid !!!");
        }
        if (!pren.toUpperCase().matches("[A-Z][a-zA-Z]*")) {
            throw new NuPareNumeException("Nu pare sa fie un prenume valid !!!");
        }
        exceptiiCNP(cnp);
    }
    
    //constructor cu parametrii.
    public Abonat(String nume, String prenume, String CNP, NrTel nr) {
        
        exceptiiTot(nume, prenume, CNP);
        this.nume = nume.substring(0, 1).toUpperCase() + nume.substring(1).toLowerCase();
        this.prenume = prenume.substring(0, 1).toUpperCase() + prenume.substring(1).toLowerCase();
        this.CNP = CNP;
        this.nr = nr;
    }
    
    
    //getter CNP.
    public String getCNP() {
        return CNP;
    }
    
    //getter numar telefon.
    public NrTel getNr() {
        return nr;
    }
    
    //getter nume.
    public String getNume() {
        return nume;
    }
    
    //getter prenume.
    public String getPrenume() {
        return prenume;
    }
    
    //tratarea exceptiilor care pot aparea la introducerea unui CNP.
    public static void exceptiiCNP(String cnp) {
        if (cnp == null || cnp.length() == 0) {
            throw new IllegalArgumentException("CNP-ul nu poate sa lipseasca !!!");
        }
        if (cnp.length() < 13 || cnp.length() > 13) {
            throw new DimensiuneNepotrivitaException("CNP-ul trebuie sa contina 13 caracatere !!!");
        }
        if (!cnp.startsWith("1") && !cnp.startsWith("2")) {
            throw new IncepeCuCNPException("CNP-ul trebuie sa inceapa cu 1 sau 2 !!!");
        }
        if (!cnp.matches("[0-9]+")) {
            throw new NuEsteNumarException("CNP-ul trebuie sa contina numai cifre !");
        }
        //verificare daca abonatul are peste 18 ani si sub 100 ani.
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int x = (year - 18) % 1900;
        int y = (year - 100) % 1900;
        if(Integer.parseInt(cnp.substring(1, 3)) > x || Integer.parseInt(cnp.substring(1, 3)) < y) {
            throw new CNPException("CNP-ul introdus apartine unei persoane minore sau unei persoane decedate !!!");
        }
        //validare numar luni din an CNP.
        if(Integer.parseInt(cnp.substring(3, 5)) > 12) {
            throw new CNPException("Luna nu poate sa fie < 0 sau mai mare ca 12 !!!");
        }
        //validare numar zile din luna CNP.
        if(Integer.parseInt(cnp.substring(5, 7)) > 31) {
            throw new CNPException("O luna nu poate sa aiba mai mult de 31 de zile !!!");
        }
    }
    
    //setter CNP.
    public void setCNP(String CNP) {
        
        exceptiiCNP(CNP);
        this.CNP = CNP;
    }
    
    //setter numar.
    public void setNr(NrTel nr) {
        this.nr = nr;
    }
    
    //tratarea exceptiilor ce pot aparea la introducerea unui nume sau prenume.
    public static void exceptiiNume(String num) {
        if (num == null || num.length() == 0) {
            throw new IllegalArgumentException("Numele nu poate sa lipseasca !!!");
        }
        if (!num.toUpperCase().matches("[A-Z][a-zA-Z]*")) {
            throw new NuPareNumeException("Nu pare sa fie un nume valid !!!");
        }
    }
    
    //setter nume.
    public void setNume(String nume) {
        
        exceptiiNume(nume);
        this.nume = nume.substring(0, 1).toUpperCase() + nume.substring(1).toLowerCase();
    }
    
    //setter prenume.
    public void setPrenume(String prenume) {
        
        exceptiiNume(prenume);
        this.prenume = prenume.substring(0, 1).toUpperCase() + prenume.substring(1).toLowerCase();
    }
    
    //rescriere toString.
    @Override
    public String toString() {
        return nume + "     |" + prenume + "        |"+ CNP + "        |" + nr;
    }
    
}

package agendatelefonica;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;

public class CarteDeTelefon extends AbstractListModel implements Serializable {

    static ArrayList<Abonat> carte = new ArrayList<>();

    //cautare.
    public static void cauta(String s) {
        int x = 0;
        Cautare c = new Cautare();
        Abonat a;
        for (int i = 0; i < carte.size(); i++) {
            if (s.toUpperCase().equals(((Abonat) carte.get(i)).getNume().toUpperCase())
                    || s.toUpperCase().equals(((Abonat) carte.get(i)).getPrenume().toUpperCase())
                    || s.toUpperCase().equals(((Abonat) carte.get(i)).getNume().toUpperCase() + " " + ((Abonat) carte.get(i)).getPrenume().toUpperCase())
                    || s.equals(((Abonat) carte.get(i)).getCNP()) || s.equals(String.valueOf(((Abonat) carte.get(i)).getNr()))) {
                a = (Abonat) carte.get(i);
                c.adauga(a);
                x++;
            }
        }
        if (x == 0) {
            throw new PersoanaNegasitaException("Persoana cautata nu exista in agenda !!!");
        }

    }

    //sortare abonati in ordine alfabetica dupa nume.
    public static void sortareNumeCrescator() {
        CarteDeTelefon c = new CarteDeTelefon();

        if (carte.isEmpty()) {
            throw new AgendaGoalaException("Agenda este goala si nu am ce sorta !!!");
        }
        for (int i = 0; i < carte.size(); i++) {
            Collections.sort(carte, new Comparator<Abonat>() {
                @Override
                public int compare(Abonat abonat1, Abonat abonat2) {
                    return abonat1.getNume().compareTo(abonat2.getNume());
                }
            });
        }

    }

    //sortare abonati de la Z-A dupa nume.
    public static void sortareNumeDescrescator() {

        if (carte.isEmpty()) {
            throw new AgendaGoalaException("Agenda este goala si nu am ce sorta !!!");
        }
        for (int i = 0; i < carte.size(); i++) {
            Collections.sort(carte, new Comparator<Abonat>() {
                @Override
                public int compare(Abonat abonat1, Abonat abonat2) {
                    return -abonat1.getNume().compareTo(abonat2.getNume());
                }
            });
        }
    }

    //sortare abonati in ordine alfabetica dupa prenume.
    public static void sortarePrenumeCrescator() {

        if (carte.isEmpty()) {
            throw new AgendaGoalaException("Agenda este goala si nu am ce sorta !!!");
        }
        for (int i = 0; i < carte.size(); i++) {
            Collections.sort(carte, new Comparator<Abonat>() {
                @Override
                public int compare(Abonat abonat1, Abonat abonat2) {
                    return abonat1.getPrenume().compareTo(abonat2.getPrenume());
                }
            });
        }
    }

    //sortare abonati de la Z-A dupa prenume.
    public static void sortarePrenumeDescrescator() {

        if (carte.isEmpty()) {
            throw new AgendaGoalaException("Agenda este goala si nu am ce sorta !!!");
        }
        for (int i = 0; i < carte.size(); i++) {
            Collections.sort(carte, new Comparator<Abonat>() {
                @Override
                public int compare(Abonat abonat1, Abonat abonat2) {
                    return -abonat1.getPrenume().compareTo(abonat2.getPrenume());
                }
            });
        }
    }

    //sortare abonati, de la cel mai batran, la cel mai tanar.
    public static void sortareCNPVarstaMm() {

        if (carte.isEmpty()) {
            throw new AgendaGoalaException("Agenda este goala si nu am ce sorta !!!");
        }
        for (int i = 0; i < carte.size(); i++) {
            Collections.sort(carte, new Comparator<Abonat>() {
                @Override
                public int compare(Abonat abonat1, Abonat abonat2) {
                    int a = Integer.parseInt(abonat1.getCNP().substring(1, 3));
                    int b = Integer.parseInt(abonat2.getCNP().substring(1, 3));

                    if (a > b) {
                        return 1;
                    } else if (a < b) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
    }

    //sortare, abonati de la cel mai tanar, la cel mai batran.
    public static void sortareCNPVarstamM() {

        if (carte.isEmpty()) {
            throw new AgendaGoalaException("Agenda este goala si nu am ce sorta !!!");
        }
        for (int i = 0; i < carte.size(); i++) {
            Collections.sort(carte, new Comparator<Abonat>() {
                @Override
                public int compare(Abonat abonat1, Abonat abonat2) {
                    int a = Integer.parseInt(abonat1.getCNP().substring(1, 3));
                    int b = Integer.parseInt(abonat2.getCNP().substring(1, 3));

                    if (a < b) {
                        return 1;
                    } else if (a > b) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
    }

    //sortare abonati. Sunt afisati mai intai cei cu numere de fix.
    public static void sortareNrFix() {

        if (carte.isEmpty()) {
            throw new AgendaGoalaException("Agenda este goala si nu am ce sorta !!!");
        }
        for (int i = 0; i < carte.size(); i++) {
            Collections.sort(carte, new Comparator<Abonat>() {
                @Override
                public int compare(Abonat abonat1, Abonat abonat2) {
                    int a = Integer.parseInt(abonat1.nr.getNr().substring(1, 2));
                    int b = Integer.parseInt(abonat2.nr.getNr().substring(1, 2));

                    if (a > b) {
                        return 1;
                    } else if (a < b) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
    }

    //sortare abonati. Sunt afisati mai intai cei cu numere de mobil.
    public static void sortareNrMobil() {

        if (carte.isEmpty()) {
            throw new AgendaGoalaException("Agenda este goala si nu am ce sorta !!!");
        }
        for (int i = 0; i < carte.size(); i++) {
            Collections.sort(carte, new Comparator<Abonat>() {
                @Override
                public int compare(Abonat abonat1, Abonat abonat2) {
                    int a = Integer.parseInt(abonat1.nr.getNr().substring(1, 2));
                    int b = Integer.parseInt(abonat2.nr.getNr().substring(1, 2));

                    if (a < b) {
                        return 1;
                    } else if (a > b) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
    }

    //modificare abonat de la un anumit index.
    public void modificare(int i, String nume, String prenume, String CNP, NrTel numar) {
        if (i >= 0 && i <= carte.size()) {
            carte.get(i).setNume(nume);
            carte.get(i).setPrenume(prenume);
            carte.get(i).setCNP(CNP);
            carte.get(i).setNr(numar);
        }
        fireContentsChanged(this, -1, -1);
    }

    //adaugare abonat nou.
    public void adauga(Abonat a) {
        String num = a.getNume();
        String pren = a.getPrenume();
        String cnp = a.getCNP();
        String numar = String.valueOf(a.getNr());
        NrTel.exceptiiNumar(numar);
        Abonat.exceptiiTot(num, pren, cnp);
        carte.add(a);
        fireContentsChanged(this, -1, -1);
    }

    //stergere abonat de pe o anumita pozitie.
    public void stergere(int i) {
        if (i >= 0 && i <= carte.size()) {
            carte.remove(i);
            fireContentsChanged(this, -1, -1);
        }
    }

    //salvarea in fisier.
    public void save(String locatie) {

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(locatie));
            for (Abonat c : carte) {
                os.writeObject(c);
            }
            os.close();

        } catch (IOException ex) {
            Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //deschiderea din fisier.
    public void open(String locatie) {
        try {
          
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(locatie));
           try{ 
            while(true) {
                Abonat a = (Abonat) oi.readObject();      
                carte.add(a);
                fireContentsChanged(this, -1 , -1);

            }
           } catch(EOFException e) {
              
           }
            oi.close();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CarteDeTelefon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getSize() {
        return carte.size();
    }

    @Override
    public Object getElementAt(int index) {
        return carte.get(index);
    }
}

package agendatelefonica;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

//clasa realizata pentru jlist-ul din cautare.
public class Cautare extends AbstractListModel {
    
    static ArrayList<Abonat> caut = new ArrayList<>();

    public void adauga(Abonat a) {
        caut.add(a);
        fireContentsChanged(this, 0, getSize());
    }
    
    public void refresh() {
        fireContentsChanged(this, 0, getSize());
    }
    
    @Override
    public int getSize() {
        return caut.size();
    }

    @Override
    public Object getElementAt(int index) {
        return caut.get(index);
    }
    
}

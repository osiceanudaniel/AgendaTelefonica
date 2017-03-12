package agendatelefonica;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Gui extends javax.swing.JFrame {
    
    //Codul de inregistrare.
    private final int COD = 1995;  
    
    //Contorul cu ajutorul caruia realizez parcurgerea listei de poze pentru reclame.
    int cont = 0;            
    
    //Timer pentru reclame.
    static Timer tm;  
    
    //Timer pentru auto-save.
    static Timer timer_save;   
    
    int inregistrat = 0;
    
    //Imaginile pentru reclame
    URL unu = getClass().getResource("reclama1.JPG");
    URL doi = getClass().getResource("reclama2.JPG");
    URL trei = getClass().getResource("reclama3.JPG");
    URL[] listaReclame = {unu, doi, trei};
    
    CarteDeTelefon car = new CarteDeTelefon();
    Cautare c = new Cautare();
    
    //Cursoarele pentru save si auto-save.
    Cursor cursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
    Cursor cursor2 = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

    public Gui() {
        initComponents();
        
        //Setare iconita aplicatie.
        setIconBara();
        
        popupModifica.setText("Modifica");
        popupSterge.setText("Sterge");

        lista.setModel(car);
        
        //Validari pentru lista. Unele butoane nu vor fi disponibile.
        validareLista();

        //Codul timer-ului pentru reclame.
        tm = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setReclame();
                cont++;
                if (cont >= listaReclame.length) {
                    cont = 0;
                }
            }
        });
        tm.start();
        
        //Cod timer pentru auto-save.
        timer_save = new Timer(300000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.save(locatie);
                setCursor(cursor);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    setCursor(cursor2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        MenuItemSave.setEnabled(false);
        MenuItemOpen.setEnabled(false);
        MenuItemInregistrare.setEnabled(true);
        MenuItemInregistrare.setToolTipText("Activare Open & Save");
        MenuItemAdauga.setToolTipText("Adaugare de noi abonati");
        MenuItemCauta.setToolTipText("Cautare abonati dupa diferite criterii");
        ButonAdauga.setToolTipText("Adaugare de noi abonati");
        ButonCauta.setToolTipText("Cautare abonati dupa diferite criterii");
        ButonSortare.setToolTipText("Sortare abonati dupa diferite criterii");

        this.setDefaultCloseOperation(Gui.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                iesire();
            }

        });
    }

    public void validareLista() {
        if (CarteDeTelefon.carte.isEmpty()) {
            ButonCauta.setEnabled(false);
            ButonModifica.setEnabled(false);
            ButonSterge.setEnabled(false);
            ButonSortare.setEnabled(false);
            MenuItemCauta.setEnabled(false);
            MenuItemModifica.setEnabled(false);
            MenuItemSave.setEnabled(false);
            MenuItemSterge.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        AboutDialogBox = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextPaneAbout = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        ButonAboutClose = new javax.swing.JButton();
        AdaugaDialogBox = new javax.swing.JDialog();
        labelAdaugareAbonat = new javax.swing.JLabel();
        labelNumeAdauga = new javax.swing.JLabel();
        labelPrenumeAdauga = new javax.swing.JLabel();
        labelCNPAdauga = new javax.swing.JLabel();
        labelNumarAdauga = new javax.swing.JLabel();
        textFieldNume = new javax.swing.JTextField();
        textFieldPrenume = new javax.swing.JTextField();
        textFieldCNP = new javax.swing.JTextField();
        textFieldNumar = new javax.swing.JTextField();
        butonOKAdauga = new javax.swing.JButton();
        ButonCancelAdauga = new javax.swing.JButton();
        ModificaDialogBox = new javax.swing.JDialog();
        labelModificare = new javax.swing.JLabel();
        labelNumeModificare = new javax.swing.JLabel();
        labelPrenumeModificare = new javax.swing.JLabel();
        labelCNPModificare = new javax.swing.JLabel();
        labelNumarModificare = new javax.swing.JLabel();
        textFieldNumeModificare = new javax.swing.JTextField();
        textFieldPrenumeModificare = new javax.swing.JTextField();
        textFieldCNPModificare = new javax.swing.JTextField();
        textFieldNumarModificare = new javax.swing.JTextField();
        butonOKModificare = new javax.swing.JButton();
        butonCancelModificare = new javax.swing.JButton();
        popupLista = new javax.swing.JPopupMenu();
        popupModifica = new javax.swing.JMenuItem();
        popupSterge = new javax.swing.JMenuItem();
        CautaDialogBox = new javax.swing.JDialog();
        labelCautareText = new javax.swing.JLabel();
        labelCautare = new javax.swing.JLabel();
        textFieldCautare = new javax.swing.JTextField();
        butonOKCautare = new javax.swing.JButton();
        butonCancelCautare = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaCautare = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPaneInfo = new javax.swing.JTextPane();
        fileChooser = new javax.swing.JFileChooser();
        fileChooser2 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        panelButoane = new javax.swing.JPanel();
        ButonAdauga = new javax.swing.JButton();
        ButonCauta = new javax.swing.JButton();
        ButonModifica = new javax.swing.JButton();
        ButonSterge = new javax.swing.JButton();
        ButonSortare = new javax.swing.JComboBox<>();
        ButonIesire = new javax.swing.JButton();
        panelReclame = new javax.swing.JPanel();
        labelReclame = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuItemOpen = new javax.swing.JMenuItem();
        MenuItemSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuItemExit = new javax.swing.JMenuItem();
        MenuAbonati = new javax.swing.JMenu();
        MenuItemAdauga = new javax.swing.JMenuItem();
        MenuItemCauta = new javax.swing.JMenuItem();
        MenuItemModifica = new javax.swing.JMenuItem();
        MenuItemSterge = new javax.swing.JMenuItem();
        MenuHelp = new javax.swing.JMenu();
        MenuItemInregistrare = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenuItemAbout = new javax.swing.JMenuItem();

        AboutDialogBox.setName("About"); // NOI18N
        AboutDialogBox.setType(java.awt.Window.Type.POPUP);

        TextPaneAbout.setEditable(false);
        TextPaneAbout.setText("Agenda Telefonica Varianta 1.0\n\nAceasta este o agenda telefonica ce permite lucrul cu obiecte de tip Abonat.\nFacilitati :\n-Adaugare de abonati;\n-Sortare abonati dupa diverse criterii;\n-Cautare abonati dupa diverse criterii;\n-Stergere abonati;\n-Modificare abonati;\n-Deschidere si Salvare de fisiere ce contin obiecte de tip Abonat;\nAplicatia contine si reclame.Acestea pot fi dezactivate dupa ce a fost introdus un cod de inregistrare. Deasemenea, optiunile de Open si Save vor fi activate in urma inregistrarii.\n\nAplicatie realizata de : Osiceanu Daniel Nicolae\n© OSICEANU DANIEL NICOLAE ALL RIGHTS RESERVED");
        TextPaneAbout.setFocusable(false);
        jScrollPane2.setViewportView(TextPaneAbout);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/asfsa_190x190.png"))); // NOI18N

        ButonAboutClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButonAboutClose.setText("Close");
        ButonAboutClose.setSelected(true);
        ButonAboutClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonAboutCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AboutDialogBoxLayout = new javax.swing.GroupLayout(AboutDialogBox.getContentPane());
        AboutDialogBox.getContentPane().setLayout(AboutDialogBoxLayout);
        AboutDialogBoxLayout.setHorizontalGroup(
            AboutDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutDialogBoxLayout.createSequentialGroup()
                .addGroup(AboutDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AboutDialogBoxLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AboutDialogBoxLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(AboutDialogBoxLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(ButonAboutClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AboutDialogBoxLayout.setVerticalGroup(
            AboutDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AboutDialogBoxLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(ButonAboutClose)
                .addContainerGap())
        );

        AdaugaDialogBox.setModal(true);
        AdaugaDialogBox.setResizable(false);
        AdaugaDialogBox.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                AdaugaDialogBoxWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                AdaugaDialogBoxWindowClosing(evt);
            }
        });
        AdaugaDialogBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdaugaDialogBoxKeyPressed(evt);
            }
        });

        labelAdaugareAbonat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelAdaugareAbonat.setText("Adauga abonat");

        labelNumeAdauga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumeAdauga.setText("Nume :");

        labelPrenumeAdauga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPrenumeAdauga.setText("Prenume :");

        labelCNPAdauga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCNPAdauga.setText("CNP :");

        labelNumarAdauga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumarAdauga.setText("Numar :");

        textFieldNumar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldNumarKeyPressed(evt);
            }
        });

        butonOKAdauga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        butonOKAdauga.setText("OK");
        butonOKAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonOKAdaugaActionPerformed(evt);
            }
        });

        ButonCancelAdauga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ButonCancelAdauga.setText("Cancel");
        ButonCancelAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonCancelAdaugaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdaugaDialogBoxLayout = new javax.swing.GroupLayout(AdaugaDialogBox.getContentPane());
        AdaugaDialogBox.getContentPane().setLayout(AdaugaDialogBoxLayout);
        AdaugaDialogBoxLayout.setHorizontalGroup(
            AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdaugaDialogBoxLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdaugaDialogBoxLayout.createSequentialGroup()
                        .addComponent(labelCNPAdauga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addComponent(labelPrenumeAdauga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AdaugaDialogBoxLayout.createSequentialGroup()
                        .addComponent(labelNumarAdauga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addComponent(labelNumeAdauga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldPrenume, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(textFieldNume)
                    .addComponent(textFieldCNP)
                    .addComponent(textFieldNumar))
                .addGap(58, 58, 58))
            .addGroup(AdaugaDialogBoxLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(labelAdaugareAbonat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdaugaDialogBoxLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(butonOKAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(ButonCancelAdauga)
                .addGap(91, 91, 91))
        );
        AdaugaDialogBoxLayout.setVerticalGroup(
            AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdaugaDialogBoxLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelAdaugareAbonat)
                .addGap(34, 34, 34)
                .addGroup(AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumeAdauga)
                    .addComponent(textFieldNume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrenumeAdauga)
                    .addComponent(textFieldPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCNPAdauga)
                    .addComponent(textFieldCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumarAdauga)
                    .addComponent(textFieldNumar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(AdaugaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonOKAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButonCancelAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        ModificaDialogBox.setModal(true);
        ModificaDialogBox.setResizable(false);
        ModificaDialogBox.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                ModificaDialogBoxWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                ModificaDialogBoxWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ModificaDialogBoxWindowClosing(evt);
            }
        });

        labelModificare.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelModificare.setText("Modificare abonat");

        labelNumeModificare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumeModificare.setText("Nume :");

        labelPrenumeModificare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPrenumeModificare.setText("Prenume :");

        labelCNPModificare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCNPModificare.setText("CNP :");

        labelNumarModificare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumarModificare.setText("Numar :");

        textFieldNumarModificare.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldNumarModificareKeyPressed(evt);
            }
        });

        butonOKModificare.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        butonOKModificare.setText("OK");
        butonOKModificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonOKModificareActionPerformed(evt);
            }
        });

        butonCancelModificare.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        butonCancelModificare.setText("Cancel");
        butonCancelModificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonCancelModificareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModificaDialogBoxLayout = new javax.swing.GroupLayout(ModificaDialogBox.getContentPane());
        ModificaDialogBox.getContentPane().setLayout(ModificaDialogBoxLayout);
        ModificaDialogBoxLayout.setHorizontalGroup(
            ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificaDialogBoxLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModificaDialogBoxLayout.createSequentialGroup()
                        .addComponent(labelCNPModificare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addComponent(labelPrenumeModificare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ModificaDialogBoxLayout.createSequentialGroup()
                        .addComponent(labelNumarModificare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addComponent(labelNumeModificare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldPrenumeModificare, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(textFieldNumeModificare)
                    .addComponent(textFieldCNPModificare)
                    .addComponent(textFieldNumarModificare))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ModificaDialogBoxLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(butonOKModificare, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(butonCancelModificare)
                .addGap(91, 91, 91))
            .addGroup(ModificaDialogBoxLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(labelModificare)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ModificaDialogBoxLayout.setVerticalGroup(
            ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModificaDialogBoxLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelModificare)
                .addGap(34, 34, 34)
                .addGroup(ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumeModificare)
                    .addComponent(textFieldNumeModificare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrenumeModificare)
                    .addComponent(textFieldPrenumeModificare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCNPModificare)
                    .addComponent(textFieldCNPModificare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumarModificare)
                    .addComponent(textFieldNumarModificare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(ModificaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonOKModificare, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonCancelModificare, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        popupLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        popupLista.setPreferredSize(new java.awt.Dimension(160, 60));

        popupModifica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        popupModifica.setText("jMenuItem1");
        popupModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupModificaActionPerformed(evt);
            }
        });
        popupLista.add(popupModifica);

        popupSterge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        popupSterge.setText("jMenuItem1");
        popupSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupStergeActionPerformed(evt);
            }
        });
        popupLista.add(popupSterge);

        CautaDialogBox.setModal(true);
        CautaDialogBox.setResizable(false);
        CautaDialogBox.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                CautaDialogBoxWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                CautaDialogBoxWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                CautaDialogBoxWindowClosing(evt);
            }
        });

        labelCautareText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCautareText.setText("Cautare Abonati");

        labelCautare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCautare.setText("Cauta :");

        textFieldCautare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textFieldCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCautareActionPerformed(evt);
            }
        });
        textFieldCautare.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldCautareKeyPressed(evt);
            }
        });

        butonOKCautare.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        butonOKCautare.setText("OK");
        butonOKCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonOKCautareActionPerformed(evt);
            }
        });

        butonCancelCautare.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        butonCancelCautare.setText("Cancel");
        butonCancelCautare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonCancelCautareActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listaCautare);

        textPaneInfo.setEditable(false);
        textPaneInfo.setText("Abonatii pot fi cautati utilizand casuta de cautare de mai jos.\nPuteti sa introduceti :\n-Numele;\n-Prenumele;\n-Numele + Prenumele;\n-CNP-ul;\n-Numarul de telefon;\nToate persoanele care indeplinesc conditia de cautare vor fi afisate in lista alaturata.");
        jScrollPane4.setViewportView(textPaneInfo);

        javax.swing.GroupLayout CautaDialogBoxLayout = new javax.swing.GroupLayout(CautaDialogBox.getContentPane());
        CautaDialogBox.getContentPane().setLayout(CautaDialogBoxLayout);
        CautaDialogBoxLayout.setHorizontalGroup(
            CautaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CautaDialogBoxLayout.createSequentialGroup()
                .addGroup(CautaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CautaDialogBoxLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(CautaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CautaDialogBoxLayout.createSequentialGroup()
                                .addComponent(labelCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textFieldCautare))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CautaDialogBoxLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(labelCautareText))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CautaDialogBoxLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(butonOKCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(butonCancelCautare)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        CautaDialogBoxLayout.setVerticalGroup(
            CautaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CautaDialogBoxLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(CautaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CautaDialogBoxLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(CautaDialogBoxLayout.createSequentialGroup()
                        .addComponent(labelCautareText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CautaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCautare)
                            .addComponent(textFieldCautare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CautaDialogBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butonOKCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butonCancelCautare, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );

        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        fileChooser2.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileChooser2.setApproveButtonText("Save");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Telefonica");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lista.setComponentPopupMenu(popupLista);
        jScrollPane1.setViewportView(lista);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 301;
        gridBagConstraints.ipady = 283;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 42, 25);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        panelButoane.setLayout(new java.awt.GridBagLayout());

        ButonAdauga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButonAdauga.setText("Adauga");
        ButonAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonAdaugaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 47;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(21, 5, 0, 0);
        panelButoane.add(ButonAdauga, gridBagConstraints);

        ButonCauta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButonCauta.setText("Cauta");
        ButonCauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonCautaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 57;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(24, 5, 0, 0);
        panelButoane.add(ButonCauta, gridBagConstraints);

        ButonModifica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButonModifica.setText("Modifica");
        ButonModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonModificaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(24, 5, 0, 0);
        panelButoane.add(ButonModifica, gridBagConstraints);

        ButonSterge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButonSterge.setText("Sterge");
        ButonSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonStergeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(24, 5, 0, 0);
        panelButoane.add(ButonSterge, gridBagConstraints);

        ButonSortare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButonSortare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sortare", "Nume [A-Z]", "Nume [Z-A]", "Prenume [A-Z]", "Prenume [Z-A]", "Numar Fix", "Numar Mobil", "CNP [M-m]", "CNP [m-M]" }));
        ButonSortare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonSortareActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(24, 5, 0, 0);
        panelButoane.add(ButonSortare, gridBagConstraints);

        ButonIesire.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButonIesire.setText("Iesire");
        ButonIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButonIesireActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(40, 5, 11, 0);
        panelButoane.add(ButonIesire, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(7, 17, 14, 29);
        getContentPane().add(panelButoane, gridBagConstraints);

        panelReclame.setVerifyInputWhenFocusTarget(false);
        panelReclame.setLayout(new java.awt.GridBagLayout());
        panelReclame.add(labelReclame, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 9, 0);
        getContentPane().add(panelReclame, gridBagConstraints);

        MenuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MenuFile.setText("File");
        MenuFile.setToolTipText("");

        MenuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/OpenFileIcon.png"))); // NOI18N
        MenuItemOpen.setText("Open");
        MenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemOpenActionPerformed(evt);
            }
        });
        MenuFile.add(MenuItemOpen);

        MenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/SaveIcon.png"))); // NOI18N
        MenuItemSave.setText("Save");
        MenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSaveActionPerformed(evt);
            }
        });
        MenuFile.add(MenuItemSave);
        MenuFile.add(jSeparator1);

        MenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        MenuItemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/ExitIcon.png"))); // NOI18N
        MenuItemExit.setText("Exit");
        MenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemExitActionPerformed(evt);
            }
        });
        MenuFile.add(MenuItemExit);

        MenuBar.add(MenuFile);

        MenuAbonati.setText("Abonati");

        MenuItemAdauga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/AdaugaIcon.png"))); // NOI18N
        MenuItemAdauga.setText("Adauga");
        MenuItemAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAdaugaActionPerformed(evt);
            }
        });
        MenuAbonati.add(MenuItemAdauga);

        MenuItemCauta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemCauta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/SearchIcon.png"))); // NOI18N
        MenuItemCauta.setText("Cauta");
        MenuItemCauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCautaActionPerformed(evt);
            }
        });
        MenuAbonati.add(MenuItemCauta);

        MenuItemModifica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/ModifyIcon.png"))); // NOI18N
        MenuItemModifica.setText("Modifica");
        MenuItemModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemModificaActionPerformed(evt);
            }
        });
        MenuAbonati.add(MenuItemModifica);

        MenuItemSterge.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        MenuItemSterge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/DeleteIcon.png"))); // NOI18N
        MenuItemSterge.setText("Sterge");
        MenuItemSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemStergeActionPerformed(evt);
            }
        });
        MenuAbonati.add(MenuItemSterge);

        MenuBar.add(MenuAbonati);

        MenuHelp.setText("Help");

        MenuItemInregistrare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/RegisterIcon.png"))); // NOI18N
        MenuItemInregistrare.setText("Inregistrare");
        MenuItemInregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemInregistrareActionPerformed(evt);
            }
        });
        MenuHelp.add(MenuItemInregistrare);
        MenuHelp.add(jSeparator2);

        MenuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agendatelefonica/AboutIcon.png"))); // NOI18N
        MenuItemAbout.setText("About");
        MenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAboutActionPerformed(evt);
            }
        });
        MenuHelp.add(MenuItemAbout);

        MenuBar.add(MenuHelp);

        setJMenuBar(MenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Locaia in care o sa fie salvat fisierul.
    String locatie = null;
    
    //Variabila folosita pentru a initializa timer-ul pentru auto-save o singura data.
    int x = 0;
    
    private void MenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSaveActionPerformed
                
        //Am setat filtre doar pentru fisier de tip .txt si .bin.        
        fileChooser2.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Extensie txt", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Extensie bin", "bin");
        fileChooser2.addChoosableFileFilter(filter);
        fileChooser2.addChoosableFileFilter(filter2);
        fileChooser2.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        fileChooser2.setDialogTitle("Specifica fisierul unde vrei sa salvezi inregistrarile");
        if(locatie == null)
            fileChooser2.showSaveDialog(null);
        
            try {
            File f = fileChooser2.getSelectedFile();
            locatie = f.getAbsolutePath();
            if(locatie.endsWith(".txt") || locatie.endsWith(".bin")) {
                 car.save(locatie);
            }
            else {
                car.save(locatie + ".txt");
            }
            setCursor(cursor);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    setCursor(cursor2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(x == 0) {
                if(locatie != null) {
                        timer_save.start();
                        x = 1;
                    }
            }
            } catch(NullPointerException e) {
                return;
            }
           
    }//GEN-LAST:event_MenuItemSaveActionPerformed

    private void MenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAboutActionPerformed
        AboutDialogBox.setModal(true);
        AboutDialogBox.setTitle("About");
        AboutDialogBox.setResizable(false);
        AboutDialogBox.pack();
        AboutDialogBox.setLocationRelativeTo(null);
        AboutDialogBox.setVisible(true);
    }//GEN-LAST:event_MenuItemAboutActionPerformed

    private void MenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemExitActionPerformed
        int alegere = JOptionPane.showConfirmDialog(null, "Esti sigur ca vrei sa iesi din aplicatie ?", "EXIT",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (alegere == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_MenuItemExitActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void ButonSortareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonSortareActionPerformed
        int i = ButonSortare.getSelectedIndex();
        switch (i) {
            case 1:
                CarteDeTelefon.sortareNumeCrescator();
                lista.repaint();
                break;
            case 2:
                CarteDeTelefon.sortareNumeDescrescator();
                lista.repaint();
                break;
            case 3:
                CarteDeTelefon.sortarePrenumeCrescator();
                lista.repaint();
                break;
            case 4:
                CarteDeTelefon.sortarePrenumeDescrescator();
                lista.repaint();
                break;
            case 5:
                CarteDeTelefon.sortareNrFix();
                lista.repaint();
                break;
            case 6:
                CarteDeTelefon.sortareNrMobil();
                lista.repaint();
                break;
            case 7:
                CarteDeTelefon.sortareCNPVarstaMm();
                lista.repaint();
                break;
            case 8:
                CarteDeTelefon.sortareCNPVarstamM();
                lista.repaint();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_ButonSortareActionPerformed

    private void ButonIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonIesireActionPerformed
        iesire();
    }//GEN-LAST:event_ButonIesireActionPerformed

    private void ButonAboutCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonAboutCloseActionPerformed
        AboutDialogBox.dispose();
    }//GEN-LAST:event_ButonAboutCloseActionPerformed

    private void MenuItemInregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemInregistrareActionPerformed

        String cod = JOptionPane.showInputDialog(null, "Introdu codul de 4 cifre de inregistrare !", "Inregistrare",
                JOptionPane.INFORMATION_MESSAGE);

        try {

            if (Integer.parseInt(cod) == COD) {
                inregistrat = 1;
                if(CarteDeTelefon.carte.isEmpty()) {
                    MenuItemSave.setEnabled(false);
                }
                else {
                    MenuItemSave.setEnabled(true);
                }
                MenuItemOpen.setEnabled(true);
                MenuItemInregistrare.setEnabled(false);
                this.remove(panelReclame);
                this.pack();
                JOptionPane.showMessageDialog(null, "Felicitari, ai activat toate functiile din program !",
                        "Activat", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Codul introdus nu este valid !",
                        "Eroare autentificare", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | IllegalArgumentException e) {
        }
    }//GEN-LAST:event_MenuItemInregistrareActionPerformed

    private void ButonAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonAdaugaActionPerformed
        adaugareAction();
 
    }//GEN-LAST:event_ButonAdaugaActionPerformed

    private void MenuItemAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAdaugaActionPerformed
        adaugareAction();
    }//GEN-LAST:event_MenuItemAdaugaActionPerformed

    private void ButonCancelAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonCancelAdaugaActionPerformed
        int alegere = JOptionPane.showConfirmDialog(null, "Abonatul nu va fi salvat. Esti sigur ca vrei sa iesi ?", "EXIT",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (alegere == JOptionPane.YES_OPTION) {
            textFieldCNP.setText("");
            textFieldNumar.setText("");
            textFieldNume.setText("");
            textFieldPrenume.setText("");
            AdaugaDialogBox.dispose();
        }
    }//GEN-LAST:event_ButonCancelAdaugaActionPerformed

    private void butonOKAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonOKAdaugaActionPerformed
        
        //Toate spatiile goale din campurile pentru nume, prenume si CNP o sa dispara.
        String nume = textFieldNume.getText().replaceAll("\\s+", "");
        String prenume = textFieldPrenume.getText().replaceAll("\\s+", "");
        String CNP = textFieldCNP.getText().replaceAll("\\s+", "");
        NrTel numar = null;
        int conditie = 0;
        try {
            numar = new NrTel(textFieldNumar.getText().replaceAll("\\s+", ""));
            conditie = 0;
        } catch (NumarLipsaException | NumberFormatException | DimensiuneNepotrivitaException | NuEsteNumarException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "EROARE", JOptionPane.ERROR_MESSAGE);
            conditie = 1;
        }
        if (conditie == 0) {
            try {
                Abonat a = new Abonat(nume, prenume, CNP, numar);
                car.adauga(a);
                ButonCauta.setEnabled(true);
                ButonModifica.setEnabled(true);
                ButonSterge.setEnabled(true);
                ButonSortare.setEnabled(true);
                MenuItemCauta.setEnabled(true);
                MenuItemModifica.setEnabled(true);
                textFieldCNP.setText("");
                textFieldNumar.setText("");
                textFieldNume.setText("");
                textFieldPrenume.setText("");

                AdaugaDialogBox.dispose();
            } catch (IllegalArgumentException | NuPareNumeException | DimensiuneNepotrivitaException | IncepeCuCNPException | CNPException | NuEsteNumarException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "EROARE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_butonOKAdaugaActionPerformed

    private void AdaugaDialogBoxWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_AdaugaDialogBoxWindowClosing
        JOptionPane.showMessageDialog(null, "Toate datele vor fi pierdute !");

        textFieldCNP.setText("");
        textFieldNumar.setText("");
        textFieldNume.setText("");
        textFieldPrenume.setText("");

    }//GEN-LAST:event_AdaugaDialogBoxWindowClosing

    private void AdaugaDialogBoxWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_AdaugaDialogBoxWindowClosed

    }//GEN-LAST:event_AdaugaDialogBoxWindowClosed

    private void butonOKModificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonOKModificareActionPerformed
        int i = lista.getSelectedIndex();
        NrTel numar = null;
        try {
            numar = new NrTel(textFieldNumarModificare.getText());
        } catch (NumberFormatException | NumarLipsaException | DimensiuneNepotrivitaException | NuEsteNumarException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "EROARE", JOptionPane.ERROR_MESSAGE);
        }

        try {
            car.modificare(i, textFieldNumeModificare.getText(), textFieldPrenumeModificare.getText(),
                    textFieldCNPModificare.getText(), numar);
            ModificaDialogBox.dispose();
        } catch (IllegalArgumentException | NuPareNumeException | DimensiuneNepotrivitaException | IncepeCuCNPException | CNPException | NuEsteNumarException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "EROARE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butonOKModificareActionPerformed

    private void butonCancelModificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonCancelModificareActionPerformed
        int alegere = JOptionPane.showConfirmDialog(null, "Modificarile facute nu vor fi salvate. Esti sigur ca vrei sa iesi ?", "EXIT",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (alegere == JOptionPane.YES_OPTION) {
            ModificaDialogBox.dispose();
        }    }//GEN-LAST:event_butonCancelModificareActionPerformed

    private void ModificaDialogBoxWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ModificaDialogBoxWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModificaDialogBoxWindowClosed

    private void ModificaDialogBoxWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ModificaDialogBoxWindowClosing
        JOptionPane.showMessageDialog(null, "Modificarile facute nu vor fi salvate !", 
                "WARNING", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_ModificaDialogBoxWindowClosing

    private void ButonModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonModificaActionPerformed
        modificareAction();
    }//GEN-LAST:event_ButonModificaActionPerformed

    private void MenuItemModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemModificaActionPerformed
        modificareAction();
    }//GEN-LAST:event_MenuItemModificaActionPerformed

    private void ModificaDialogBoxWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ModificaDialogBoxWindowActivated
        int i = lista.getSelectedIndex();
        if (i >= 0) {
            Abonat a = (Abonat) car.getElementAt(i);
            textFieldNumeModificare.setText(a.getNume());
            textFieldPrenumeModificare.setText(a.getPrenume());
            textFieldCNPModificare.setText(a.getCNP());
            textFieldNumarModificare.setText(String.valueOf(a.getNr()));
        }
    }//GEN-LAST:event_ModificaDialogBoxWindowActivated

    private void popupModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupModificaActionPerformed
        modificareAction();
    }//GEN-LAST:event_popupModificaActionPerformed

    private void ButonStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonStergeActionPerformed
        actiuneStergere();
    }//GEN-LAST:event_ButonStergeActionPerformed

    private void MenuItemStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemStergeActionPerformed
        actiuneStergere();
    }//GEN-LAST:event_MenuItemStergeActionPerformed

    private void popupStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupStergeActionPerformed
        actiuneStergere();
    }//GEN-LAST:event_popupStergeActionPerformed

    private void butonOKCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonOKCautareActionPerformed
        if(!Cautare.caut.isEmpty()) {
            Cautare.caut.clear();
            listaCautare.removeAll();
            listaCautare.repaint();
        }    
        String text = textFieldCautare.getText();

        try {
            CarteDeTelefon.cauta(text);
            c.refresh();
            
            listaCautare.setModel(c);
         
        } catch (PersoanaNegasitaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_butonOKCautareActionPerformed

    private void butonCancelCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonCancelCautareActionPerformed
        Cautare.caut.clear();
        listaCautare.removeAll();
        CautaDialogBox.dispose();
    }//GEN-LAST:event_butonCancelCautareActionPerformed

    private void CautaDialogBoxWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_CautaDialogBoxWindowActivated
        textFieldCautare.setText("");
    }//GEN-LAST:event_CautaDialogBoxWindowActivated

    private void CautaDialogBoxWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_CautaDialogBoxWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_CautaDialogBoxWindowClosed

    private void CautaDialogBoxWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_CautaDialogBoxWindowClosing
        Cautare.caut.clear();
        listaCautare.removeAll();
    }//GEN-LAST:event_CautaDialogBoxWindowClosing

    private void ButonCautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonCautaActionPerformed
        CautaDialogBox.setModal(true);
        CautaDialogBox.setTitle("Cautare");
        CautaDialogBox.setResizable(false);
        CautaDialogBox.pack();
        CautaDialogBox.setLocationRelativeTo(null);
        CautaDialogBox.setVisible(true);
    }//GEN-LAST:event_ButonCautaActionPerformed

    private void textFieldCautareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCautareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCautareActionPerformed

    private void MenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemOpenActionPerformed
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Extensie txt", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Extensie bin", "bin");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.addChoosableFileFilter(filter2);
        fileChooser.showOpenDialog(null);
        try {
            File f = fileChooser.getSelectedFile();
            String loc = f.getAbsolutePath();
            car.open(loc);
        } catch(NullPointerException e) {
            
        }
    
        lista.setModel(car);
        if(CarteDeTelefon.carte.size() > 0) {
            ButonCauta.setEnabled(true);
            ButonModifica.setEnabled(true);
            ButonSterge.setEnabled(true);
            ButonSortare.setEnabled(true);
            MenuItemCauta.setEnabled(true);
            MenuItemModifica.setEnabled(true);
            MenuItemSave.setEnabled(true);
            MenuItemSterge.setEnabled(true);
        }
        lista.repaint();
    }//GEN-LAST:event_MenuItemOpenActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
         
    }//GEN-LAST:event_fileChooserActionPerformed

    private void MenuItemCautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCautaActionPerformed
        CautaDialogBox.setModal(true);
        CautaDialogBox.setTitle("Cautare");
        CautaDialogBox.setResizable(false);
        CautaDialogBox.pack();
        CautaDialogBox.setLocationRelativeTo(null);
        CautaDialogBox.setVisible(true);
    }//GEN-LAST:event_MenuItemCautaActionPerformed

    private void AdaugaDialogBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdaugaDialogBoxKeyPressed

    }//GEN-LAST:event_AdaugaDialogBoxKeyPressed

    private void textFieldNumarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNumarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butonOKAdauga.doClick();
        }
    }//GEN-LAST:event_textFieldNumarKeyPressed

    private void textFieldNumarModificareKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNumarModificareKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butonOKModificare.doClick();
        }
    }//GEN-LAST:event_textFieldNumarModificareKeyPressed

    private void textFieldCautareKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldCautareKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            butonOKCautare.doClick();
        }    }//GEN-LAST:event_textFieldCautareKeyPressed

    public void actiuneStergere() {
        int i = lista.getSelectedIndex();
        if (i >= 0) {
            int alegere = JOptionPane.showConfirmDialog(null, "Abonatul selectat va fi sters. Esti sigur ca vrei sa continui ?",
                    "Stergere", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (alegere == JOptionPane.YES_OPTION) {
                car.stergere(i);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nu ai selectat nici un abonat !", 
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        validareLista();
    }

    //codul de confirmare iesire din formular.
    public void iesire() {
        int alegere = JOptionPane.showConfirmDialog(null, "Esti sigur ca vrei sa iesi din aplicatie ?", "EXIT",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (alegere == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void adaugareAction() {
        AdaugaDialogBox.setModal(true);
        AdaugaDialogBox.setTitle("Adaugare");
        AdaugaDialogBox.setResizable(false);
        AdaugaDialogBox.pack();
        AdaugaDialogBox.setLocationRelativeTo(null);
        AdaugaDialogBox.setVisible(true);
        if(CarteDeTelefon.carte.size() > 0) {
            MenuItemSterge.setEnabled(true);
            if(inregistrat == 1) {
                MenuItemSave.setEnabled(true);
            }
        }
    }

    public void modificareAction() {

        if (lista.getSelectedIndex() >= 0) {
            ModificaDialogBox.setModal(true);
            ModificaDialogBox.setTitle("Modificare");
            ModificaDialogBox.setResizable(false);
            ModificaDialogBox.pack();
            ModificaDialogBox.setLocationRelativeTo(null);
            ModificaDialogBox.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Nu ai selectat nici un abonat !",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setReclame() {
        ImageIcon i = new ImageIcon(listaReclame[cont]);
        labelReclame.setIcon(i);

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    Thread.sleep(4000);
                } catch (Exception e) {
                    return;
                }

                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AboutDialogBox;
    private javax.swing.JDialog AdaugaDialogBox;
    private javax.swing.JButton ButonAboutClose;
    private javax.swing.JButton ButonAdauga;
    private javax.swing.JButton ButonCancelAdauga;
    private javax.swing.JButton ButonCauta;
    private javax.swing.JButton ButonIesire;
    private javax.swing.JButton ButonModifica;
    private javax.swing.JComboBox<String> ButonSortare;
    private javax.swing.JButton ButonSterge;
    private javax.swing.JDialog CautaDialogBox;
    private javax.swing.JMenu MenuAbonati;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenu MenuHelp;
    private javax.swing.JMenuItem MenuItemAbout;
    private javax.swing.JMenuItem MenuItemAdauga;
    private javax.swing.JMenuItem MenuItemCauta;
    private javax.swing.JMenuItem MenuItemExit;
    private javax.swing.JMenuItem MenuItemInregistrare;
    private javax.swing.JMenuItem MenuItemModifica;
    private javax.swing.JMenuItem MenuItemOpen;
    private javax.swing.JMenuItem MenuItemSave;
    private javax.swing.JMenuItem MenuItemSterge;
    private javax.swing.JDialog ModificaDialogBox;
    private javax.swing.JTextPane TextPaneAbout;
    private javax.swing.JButton butonCancelCautare;
    private javax.swing.JButton butonCancelModificare;
    private javax.swing.JButton butonOKAdauga;
    private javax.swing.JButton butonOKCautare;
    private javax.swing.JButton butonOKModificare;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JFileChooser fileChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel labelAdaugareAbonat;
    private javax.swing.JLabel labelCNPAdauga;
    private javax.swing.JLabel labelCNPModificare;
    private javax.swing.JLabel labelCautare;
    private javax.swing.JLabel labelCautareText;
    private javax.swing.JLabel labelModificare;
    private javax.swing.JLabel labelNumarAdauga;
    private javax.swing.JLabel labelNumarModificare;
    private javax.swing.JLabel labelNumeAdauga;
    private javax.swing.JLabel labelNumeModificare;
    private javax.swing.JLabel labelPrenumeAdauga;
    private javax.swing.JLabel labelPrenumeModificare;
    private javax.swing.JLabel labelReclame;
    private javax.swing.JList<String> lista;
    private javax.swing.JList<String> listaCautare;
    private javax.swing.JPanel panelButoane;
    private javax.swing.JPanel panelReclame;
    private javax.swing.JPopupMenu popupLista;
    private javax.swing.JMenuItem popupModifica;
    private javax.swing.JMenuItem popupSterge;
    private javax.swing.JTextField textFieldCNP;
    private javax.swing.JTextField textFieldCNPModificare;
    private javax.swing.JTextField textFieldCautare;
    private javax.swing.JTextField textFieldNumar;
    private javax.swing.JTextField textFieldNumarModificare;
    private javax.swing.JTextField textFieldNume;
    private javax.swing.JTextField textFieldNumeModificare;
    private javax.swing.JTextField textFieldPrenume;
    private javax.swing.JTextField textFieldPrenumeModificare;
    private javax.swing.JTextPane textPaneInfo;
    // End of variables declaration//GEN-END:variables

    private void setIconBara() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("agenda.png")));
    }

}

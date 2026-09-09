package fibonacci;
/* FibonacciGUI.java
   Benutzeroberfl�che zum Testen der rekursiven und der iterativen Funktion
   zum Berechnen der Fibonacci-Zahlen.
   HINWEIS: Bitte die GUI-Programmierung NICHT (oder nur sehr vorsichtig)
            ver�ndern!
   Autor:   Ansorge
   Version: 1.0
   Datum:   15.11.01
*/

import java.awt.*;
import java.awt.event.*;

public class FibonacciGUI extends Frame {

  Fibonacci fibo = new Fibonacci();
  // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  //  Anfang der GUI-Programmierung
  // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  // Anfang Variablen
  Label lb1 = new Label ();
  TextField eingabe = new TextField (5);
  TextArea ausgabe = new TextArea ("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  Button start = new Button ();
  Button loesche = new Button ();
  CheckboxGroup auswahl = new CheckboxGroup ();
  Checkbox rekursion = new Checkbox ();
  Checkbox iteration = new Checkbox ();
  // Ende Variablen
  
  public FibonacciGUI (String Title) {
    // Frame-Initialisierung
    super (Title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing (WindowEvent evt) {System.exit(0);}});
    setSize(200, 450);
    setResizable(false);
    setLayout(new FlowLayout());
    
    // Anfang Komponenten
    rekursion.setLabel("Rekursion");
    rekursion.setCheckboxGroup(auswahl);
    add (rekursion);

    iteration.setLabel("Iteration");
    iteration.setCheckboxGroup(auswahl);
    add (iteration);

    lb1.setText("Monate: ");
    add (lb1);
    add (eingabe);

    ausgabe.setText("");
    ausgabe.setColumns(20);
    ausgabe.setRows(20);
    ausgabe.setEditable(false);
    add (ausgabe);

    start.setLabel("START");
    add (start);
    start.addActionListener (new ActionListener () { 
      public void actionPerformed (ActionEvent evt) { 
        startActionPerformed (evt);}});

    loesche.setLabel("RESET");
    add (loesche);
    loesche.addActionListener (new ActionListener () { 
      public void actionPerformed (ActionEvent evt) { 
        loescheActionPerformed (evt);}});

    // Ende Komponenten
  }//Konstruktor
  
  // Anfang Ereignisprozeduren
  public void loescheActionPerformed (ActionEvent evt) {
    eingabe.setText("");
    ausgabe.setText("");
  }
  public void startActionPerformed (ActionEvent evt) {
    int bisMonat;
    long paarzahl;
    bisMonat = Integer.valueOf(eingabe.getText()).intValue();
    ausgabe.append(" Monate\tPaare\n");
    for(int i=0;i<=bisMonat;i++){
      if(iteration.getState())
        paarzahl = fibo.fiboIterativ(i);
      else
        paarzahl = fibo.fiboRekursiv(i);
      ausgabe.append("    "+i+"\t"+paarzahl+"\n");
    }//for
  } //startActionPerformed

  // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  //  Ende der GUI-Programmierung
  // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

  public static void main (String args[]) {
    new FibonacciGUI("Fibonacci").setVisible(true);
  }//main
}//FibonacciGUI


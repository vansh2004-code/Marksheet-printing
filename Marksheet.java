import java.awt.*;
import java.awt.event.*;

public class Marksheet extends Frame implements ActionListener {

    Label lJava, lPython, lDWM, lSE, lTotal, lObtain, lPercent, lGrade;
    TextField tJava, tPython, tDWM, tSE, tTotal, tObtain, tPercent, tGrade;
    Button bCalc;

    Marksheet() {
        setTitle("Marksheet");
        setLayout(null);

        lJava = new Label("Java");
        lPython = new Label("Python");
        lDWM = new Label("DWM");
        lSE = new Label("SE");
        lTotal = new Label("Total Marks");
        lObtain = new Label("Obtained Marks");
        lPercent = new Label("Percentage");
        lGrade = new Label("Grade");
        
        tJava = new TextField();
        tPython = new TextField();
        tDWM = new TextField();
        tSE = new TextField();
        tTotal = new TextField("400");
        tObtain = new TextField();
        tPercent = new TextField();
        tGrade = new TextField();
        tTotal.setEnabled((false));
        
        bCalc = new Button("Calculate");

        lJava.setBounds(40, 60, 80, 25);
        tJava.setBounds(130, 60, 80, 25);

        lPython.setBounds(220, 60, 80, 25);
        tPython.setBounds(300, 60, 80, 25);

        lDWM.setBounds(40, 100, 80, 25);
        tDWM.setBounds(130, 100, 80, 25);

        lSE.setBounds(220, 100, 80, 25);
        tSE.setBounds(300, 100, 80, 25);

        lTotal.setBounds(40, 150, 100, 25);
        tTotal.setBounds(170, 150, 100, 25);

        lObtain.setBounds(40, 190, 120, 25);
        tObtain.setBounds(170, 190, 100, 25);

        lPercent.setBounds(40, 230, 100, 25);
        tPercent.setBounds(170, 230, 100, 25);

        lGrade.setBounds(40, 270, 100, 25);
        tGrade.setBounds(170, 270, 100, 25);

        bCalc.setBounds(150, 310, 100, 30);

        add(lJava); add(tJava);
        add(lPython); add(tPython);
        add(lDWM); add(tDWM);
        add(lSE); add(tSE);
        add(lTotal); add(tTotal);
        add(lObtain); add(tObtain);
        add(lPercent); add(tPercent);
        add(lGrade); add(tGrade);
        add(bCalc);

        bCalc.addActionListener(this);

        setSize(430, 380);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Calculate":

                int java = Integer.parseInt(tJava.getText());
                int python = Integer.parseInt(tPython.getText());
                int dwm = Integer.parseInt(tDWM.getText());
                int se = Integer.parseInt(tSE.getText());

                int total = 400;
                int obtained = java + python + dwm + se;
                double percent = (obtained * 100.0) / total;

                tTotal.setText(String.valueOf(total));
                tObtain.setText(String.valueOf(obtained));
                tPercent.setText(String.format("%.2f", percent));

                int gradeKey = (int) percent / 10;

                switch (gradeKey) {
                    case 10:
                    case 9:
                    case 8:
                        tGrade.setText("A");
                        break;
                    case 7:
                    case 6:
                        tGrade.setText("B");
                        break;
                    case 5:
                        tGrade.setText("C");
                        break;
                    default:
                        tGrade.setText("Fail");
                }
                break;
        }
    }

    public static void main(String[] args) {
        new Marksheet();
    }
}

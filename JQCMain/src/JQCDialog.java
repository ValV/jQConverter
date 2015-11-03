import sun.awt.X11.Screen;

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Enumeration;

import static java.lang.Integer.*;

public class JQCDialog extends JDialog {
    private JPanel contentPane;
    private JButton btnConvert;
    private JButton btnQuit;
    private JTextField txtfConvertFrom;
    private JTextField txtfConvertTo;
    private JSplitPane splpFromTo;
    private JPanel pnlFrom;
    private JPanel pnlTo;
    private JLabel lblConvertFrom;
    private JLabel lblConvertTo;
    private JRadioButton rbtnBitFrom;
    private JRadioButton rbtnKBitFrom;
    private JRadioButton rbtnMBitFrom;
    private JRadioButton rbtnByteFrom;
    private JRadioButton rbtnKByteFrom;
    private JRadioButton rbtnBitTo;
    private JRadioButton rbtnKBitTo;
    private JRadioButton rbtnMBitTo;
    private JRadioButton rbtnByteTo;
    private JRadioButton rbtnKByteTo;
    private ButtonGroup btngrpTo;
    private ButtonGroup btngrpFrom;

    public JQCDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnConvert);
        setTitle("JQConverter"); // <-- Custom

        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onConvert();
            }
        });

        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        });

// call onQuit() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onQuit();
            }
        });

// call onQuit() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onConvert() {
// add your code here
        /* Custom --> */
        Integer value = parseInt(txtfConvertFrom.getText());
        QConverter qconv = new QConverter();

        int counter = 0;
        for (Enumeration<AbstractButton> e = btngrpFrom.getElements(); e.hasMoreElements();) {
            if (e.nextElement().isSelected()) break;
            counter ++;
        }

        switch (counter) {
            case 0: qconv.fromBit(Integer.parseInt(txtfConvertFrom.getText())); break;
            case 1: qconv.fromKBit(Integer.parseInt(txtfConvertFrom.getText())); break;
            case 2: qconv.fromMBit(Integer.parseInt(txtfConvertFrom.getText())); break;
            case 3: qconv.fromByte(Integer.parseInt(txtfConvertFrom.getText())); break;
            case 4: qconv.fromKByte(Integer.parseInt(txtfConvertFrom.getText())); break;
            default: break;
        }

        counter = 0;
        for (Enumeration<AbstractButton> e = btngrpTo.getElements(); e.hasMoreElements();) {
            if (e.nextElement().isSelected()) break;
            counter ++;
        }

        DecimalFormat outFormat = new DecimalFormat("0.########");
        switch (counter) {
            case 0: txtfConvertTo.setText(outFormat.format(qconv.toBit())); break;
            case 1: txtfConvertTo.setText(outFormat.format(qconv.toKBit())); break;
            case 2: txtfConvertTo.setText(outFormat.format(qconv.toMBit())); break;
            case 3: txtfConvertTo.setText(outFormat.format(qconv.toByte())); break;
            case 4: txtfConvertTo.setText(outFormat.format(qconv.toKByte())); break;
            default: break;
        }
        /* <-- Custom */
    }

    private void onQuit() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        JQCDialog dialog = new JQCDialog();
        dialog.pack();
        dialog.setLocationRelativeTo(null); // <-- Custom
        dialog.setVisible(true);
        System.exit(0);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    static boolean czy = false;
    public static void main(String[] args) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) size.getWidth();
        int height = (int) size.getHeight();

        JFrame obj = new JFrame();
        obj.setBounds(width / 3, height / 3, 900, 700);
        obj.setTitle("Weight Converter");
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        obj.add(panel);

        panel.setBackground(Color.gray);

        JTextField textField = getjTextField(obj);
        panel.add(textField);

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem cut = new JMenuItem("Cut");
        popupMenu.add(cut);
        JMenuItem copy = new JMenuItem("Copy");
        popupMenu.add(copy);
        JMenuItem paste = new JMenuItem("Paste");
        popupMenu.add(paste);
        JMenuItem selectAll = new JMenuItem("SelectAll");
        popupMenu.add(selectAll);

        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3){
                    popupMenu.show(textField, e.getX(), e.getY());
                }
            }
        });

        cut.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    textField.cut();
                }
            }
        });

        copy.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    textField.copy();
                }
            }
        });

        paste.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    textField.setText("");
                    textField.setForeground(Color.black);
                    textField.paste();
                }
            }
        });

        selectAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    textField.selectAll();
                }
            }
        });

        JLabel SelectWeight = new JLabel("Select the unit in which the weight is given");
        SelectWeight.setBounds(180, 70, 550, 40);
        SelectWeight.setForeground(Color.black);
        SelectWeight.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(SelectWeight);

        Font fontWeight = new Font("Arial", Font.BOLD, 20);

        int x = 160;
        JRadioButton kg = new JRadioButton("kg");
        kg.setSelected(true);
        kg.setBounds(x,125, 60, 30);
        kg.setForeground(Color.black);
        kg.setFont(fontWeight);
        kg.setOpaque(false);
        kg.setFocusable(false);
        panel.add(kg);

        JRadioButton dag = new JRadioButton("dag");
        dag.setBounds(x+100,125, 60, 30);
        dag.setForeground(Color.black);
        dag.setFont(fontWeight);
        dag.setOpaque(false);
        dag.setFocusable(false);
        panel.add(dag);

        JRadioButton g = new JRadioButton("g");
        g.setBounds(x+200,125, 60, 30);
        g.setForeground(Color.black);
        g.setFont(fontWeight);
        g.setOpaque(false);
        g.setFocusable(false);
        panel.add(g);

        JRadioButton lb = new JRadioButton("lb");
        lb.setBounds(x+300,125, 60, 30);
        lb.setForeground(Color.black);
        lb.setFont(fontWeight);
        lb.setOpaque(false);
        lb.setFocusable(false);
        panel.add(lb);

        JRadioButton oz = new JRadioButton("oz");
        oz.setBounds(x+400,125, 60, 30);
        oz.setForeground(Color.black);
        oz.setFont(fontWeight);
        oz.setOpaque(false);
        oz.setFocusable(false);
        panel.add(oz);

        JRadioButton st = new JRadioButton("st");
        st.setBounds(x+500,125, 60, 30);
        st.setForeground(Color.black);
        st.setFont(fontWeight);
        st.setOpaque(false);
        st.setFocusable(false);
        panel.add(st);

        ButtonGroup group = new ButtonGroup();
        group.add(kg);
        group.add(dag);
        group.add(g);
        group.add(lb);
        group.add(oz);
        group.add(st);

        Font font = new Font("Arial", Font.BOLD, 20);

        JButton convert = new JButton("Convert");
        convert.setBounds(360, 190, 125, 75);
        convert.setFont(font);
        convert.setForeground(Color.black);
        convert.setBackground(Color.lightGray);
        convert.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
        panel.add(convert);

        x = 185;
        int y = 300;
        JTextField toKG = new JTextField();
        toKG.setFont(font);
        toKG.setBounds(x, y, 240, 100);
        toKG.setForeground(Color.black);
        toKG.setBackground(Color.lightGray);
        toKG.setBorder(BorderFactory.createLineBorder(Color.gray));
        toKG.setHorizontalAlignment(SwingConstants.CENTER);
        toKG.setEditable(false);
        toKG.setFocusable(false);
        toKG.setVisible(false);
        panel.add(toKG);

        JTextField toDAG = new JTextField();
        toDAG.setFont(font);
        toDAG.setBounds(x, y+100, 240, 100);
        toDAG.setForeground(Color.black);
        toDAG.setBackground(Color.lightGray);
        toDAG.setBorder(BorderFactory.createLineBorder(Color.gray));
        toDAG.setHorizontalAlignment(SwingConstants.CENTER);
        toDAG.setEditable(false);
        toDAG.setFocusable(false);
        toDAG.setVisible(false);
        panel.add(toDAG);

        JTextField toG = new JTextField();
        toG.setFont(font);
        toG.setBounds(x, y+200, 240, 100);
        toG.setForeground(Color.black);
        toG.setBackground(Color.lightGray);
        toG.setBorder(BorderFactory.createLineBorder(Color.gray));
        toG.setHorizontalAlignment(SwingConstants.CENTER);
        toG.setEditable(false);
        toG.setFocusable(false);
        toG.setVisible(false);
        panel.add(toG);

        JTextField toLB = new JTextField();
        toLB.setFont(font);
        toLB.setBounds(x+240, y, 240, 100);
        toLB.setForeground(Color.black);
        toLB.setBackground(Color.lightGray);
        toLB.setBorder(BorderFactory.createLineBorder(Color.gray));
        toLB.setHorizontalAlignment(SwingConstants.CENTER);
        toLB.setEditable(false);
        toLB.setFocusable(false);
        toLB.setVisible(false);
        panel.add(toLB);

        JTextField toOZ = new JTextField();
        toOZ.setFont(font);
        toOZ.setBounds(x+240, y+100, 240, 100);
        toOZ.setForeground(Color.black);
        toOZ.setBackground(Color.lightGray);
        toOZ.setBorder(BorderFactory.createLineBorder(Color.gray));
        toOZ.setHorizontalAlignment(SwingConstants.CENTER);
        toOZ.setEditable(false);
        toOZ.setFocusable(false);
        toOZ.setVisible(false);
        panel.add(toOZ);

        JTextField toST = new JTextField();
        toST.setFont(font);
        toST.setBounds(x+240, y+200, 240, 100);
        toST.setForeground(Color.black);
        toST.setBackground(Color.lightGray);
        toST.setBorder(BorderFactory.createLineBorder(Color.gray));
        toST.setHorizontalAlignment(SwingConstants.CENTER);
        toST.setEditable(false);
        toST.setFocusable(false);
        toST.setVisible(false);
        panel.add(toST);

        convert.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    String input = textField.getText();
                    double result, outcome;

                    toKG.setVisible(true);
                    toDAG.setVisible(true);
                    toG.setVisible(true);
                    toLB.setVisible(true);
                    toOZ.setVisible(true);
                    toST.setVisible(true);

                    try{
                        input = input.replace(',', '.');
                        result = Double.parseDouble(input);
                    }
                    catch (Exception e1){
                        result = 0;
                    }

                    if (kg.isSelected()){
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toKG.setText(outcome + " kg");
                        outcome = Math.round(result*2.2046*10000.0000)/10000.0000;
                        toLB.setText(outcome + " lb");
                        outcome = Math.round(result*35.274*10000.0000)/10000.0000;
                        toOZ.setText(outcome + " oz");
                        outcome = Math.round(result*0.15747*10000.0000)/10000.0000;
                        toST.setText(outcome + " st");
                        result *= 100;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toDAG.setText(outcome+" dag");
                        result *= 10;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toG.setText(outcome + " g");
                    }
                    else if(dag.isSelected()){
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toDAG.setText(outcome + " dag");
                        result/=100;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toKG.setText(outcome + " kg");
                        outcome = Math.round(result*2.2046*10000.0000)/10000.0000;
                        toLB.setText(outcome + " lb");
                        outcome = Math.round(result*35.274*10000.0000)/10000.0000;
                        toOZ.setText(outcome + " oz");
                        outcome = Math.round(result*0.15747*10000.0000)/10000.0000;
                        toST.setText(outcome + " st");
                        result*=1000;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toG.setText(outcome + " g");
                    }
                    else if(g.isSelected()){
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toG.setText(outcome + " g");
                        result/=1000;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toKG.setText(outcome + " kg");
                        outcome = Math.round(result*2.2046*10000.0000)/10000.0000;
                        toLB.setText(outcome + " lb");
                        outcome = Math.round(result*35.274*10000.0000)/10000.0000;
                        toOZ.setText(outcome + " oz");
                        outcome = Math.round(result*0.15747*10000.0000)/10000.0000;
                        toST.setText(outcome + " st");
                        result*=100;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toDAG.setText(outcome + " dag");
                    }
                    else if(lb.isSelected()){
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toLB.setText(outcome + " lb");
                        result *= 0.4535923;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toKG.setText(outcome + " kg");
                        outcome = Math.round(result*35.274*10000.0000)/10000.0000;
                        toOZ.setText(outcome + " oz");
                        outcome = Math.round(result*0.15747*10000.0000)/10000.0000;
                        toST.setText(outcome + " st");
                        result *= 100;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toDAG.setText(outcome+" dag");
                        result *= 10;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toG.setText(outcome + " g");
                    }
                    else if(oz.isSelected()){
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toOZ.setText(outcome + " oz");
                        result*=0.02834952;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toKG.setText(outcome + " kg");
                        outcome = Math.round(result*2.2046*10000.0000)/10000.0000;
                        toLB.setText(outcome + " lb");
                        outcome = Math.round(result*0.15747*10000.0000)/10000.0000;
                        toST.setText(outcome + " st");
                        result *= 100;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toDAG.setText(outcome+" dag");
                        result *= 10;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toG.setText(outcome + " g");
                    }
                    else{
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toST.setText(outcome + " st");
                        result*=6.350293;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toKG.setText(outcome + " kg");
                        outcome = Math.round(result*2.2046*10000.0000)/10000.0000;
                        toLB.setText(outcome + " lb");
                        outcome = Math.round(result*35.274*10000.0000)/10000.0000;
                        toOZ.setText(outcome + " oz");
                        result *= 100;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toDAG.setText(outcome+" dag");
                        result *= 10;
                        outcome = Math.round(result*10000.0000)/10000.0000;
                        toG.setText(outcome + " g");
                    }
                }
            }
        });

        obj.setVisible(true);
    }

    private static JTextField getjTextField(JFrame obj) {
        JTextField textField = new JTextField();
        textField.setBounds(obj.getWidth()/4, 25, 400, 30);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2) );
        textField.setFont(new Font("Arial", Font.PLAIN, 22));
        textField.setText("Type here");

        textField.setForeground(Color.gray);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!czy) {
                    textField.setText("");
                    czy = true;
                    textField.setForeground(Color.black);
                }
            }
        });
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1 && !czy){
                    textField.setText("");
                    czy = true;
                    textField.setForeground(Color.black);
                }
            }
        });
        return textField;
    }
}
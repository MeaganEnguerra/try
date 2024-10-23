package com.mycompany.mcdollibee;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class McDollibee extends JFrame implements ActionListener  {

    private JLabel hdrWelcome, lblBurger, lblBurgerNum, lblFries, lblFriesNum, lblSoda, lblSodaNum, lblBurgerCount, lblFriesCount, lblSodaCount ;
    private JButton btnAddBurger, btnLessBurger, btnAddFries, btnLessFries, btnAddSoda, btnLessSoda,btnReviewOrder, btnResetOrder;
    private JTextField smmryOrder;
    private JComboBox cbBurger, cbFries,cbSoda;
    private JTextArea txtOrders;
    private int burgerNum = 0;
    private int friesNum = 0;
    private int sodaNum = 0;
    String[] sizes = {"REGULAR", "LARGE", "EXTRA LARGE"};
    Color yellow = new Color(231, 143, 129);
    Color orange = new Color (255, 207, 179);

    McDollibee() {
        setTitle("McDollibee App");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        hdrWelcome = new JLabel("Welcome to McDollibee!", SwingConstants.CENTER);
        hdrWelcome.setBounds(500, 20, 300, 100);
        add(hdrWelcome);
        
        lblBurger = new JLabel ("BURGER:");
        lblBurger.setBounds(100,140,80,50);
        add(lblBurger);

        btnAddBurger = new JButton("+");
        btnAddBurger.setBounds(450, 140, 100, 40);
        btnAddBurger.setBackground(orange);
        add(btnAddBurger);

        btnLessBurger = new JButton ("-");
        btnLessBurger.setBounds(700, 140, 100, 40);
        btnLessBurger.setBackground(orange);
        add(btnLessBurger);
        
        lblBurgerNum = new JLabel("0");
        lblBurgerNum.setBounds(250, 140,80,30);
        add(lblBurgerNum);
        
        cbBurger = new JComboBox <>(sizes);
        cbBurger.setBounds(950, 140, 200,40);
        cbBurger.setBackground(orange);
        add(cbBurger);
        
        lblFries = new JLabel ("FRIES:");
        lblFries.setBounds(100, 200, 80, 50);
        add(lblFries);
        
        lblFriesNum = new JLabel ("0");
        lblFriesNum.setBounds(250, 200, 80,50);
        add(lblFriesNum);                
                
        btnAddFries = new JButton ("+");
        btnAddFries.setBounds(450, 200,100,40);
        btnAddFries.setBackground(orange);
        add(btnAddFries);
        
        btnLessFries = new JButton ("-");
        btnLessFries.setBounds(700, 200, 100,40);
        btnLessFries.setBackground(orange);
        add(btnLessFries);
        
        cbFries = new JComboBox <> (sizes);
        cbFries.setBounds(950, 200, 200,40);
        cbFries.setBackground(orange);
        add(cbFries);
        
        lblSoda = new JLabel ("SODA:");
        lblSoda.setBounds(100, 260, 80, 50);
        add(lblSoda);
        
        lblSodaNum = new JLabel ("0");
        lblSodaNum.setBounds(250, 260, 80,50);
        add(lblSodaNum);
        
        btnAddSoda = new JButton ("+");
        btnAddSoda.setBounds(450, 260, 100,40);
        btnAddSoda.setBackground(orange);
        add(btnAddSoda);
        
        btnLessSoda = new JButton ("-");
        btnLessSoda.setBounds(700, 260, 100,40);
        btnLessSoda.setBackground(orange);
        add(btnLessSoda);
        
        cbSoda = new JComboBox<> (sizes);
        cbSoda.setBounds(950, 260, 200, 40);
        cbSoda.setBackground(orange);
        add(cbSoda);
        
        btnReviewOrder = new JButton ("TOTAL ORDER: ");
        btnReviewOrder.setBounds(150, 450, 250, 50);
        btnReviewOrder.setBackground(yellow);
        add(btnReviewOrder);
        
        btnResetOrder = new JButton("CLEAR ORDER");
        btnResetOrder.setBounds (150,550,250,50);
        btnResetOrder.setBackground(yellow);
        add(btnResetOrder);
        
        txtOrders = new JTextArea ();
        txtOrders.setBounds(450, 400, 800, 250);
        txtOrders.setEditable(false);
        add(txtOrders);
        
        btnAddBurger.addActionListener(this);
        btnLessBurger.addActionListener(this);
        btnAddFries.addActionListener(this);
        btnLessFries.addActionListener(this);
        btnAddSoda.addActionListener(this);
        btnLessSoda.addActionListener(this);
        btnReviewOrder.addActionListener(this);
        btnResetOrder.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddBurger){
            burgerNum++;
            lblBurgerNum.setText(String.valueOf(burgerNum));
        }else if (e.getSource() == btnLessBurger){
            if (burgerNum> 0){
            burgerNum--;
            lblBurgerNum.setText(String.valueOf(burgerNum));
            }
        }else if (e.getSource() == btnAddFries){
            friesNum++;
            lblFriesNum.setText(String.valueOf(friesNum));
        }else if (e.getSource() == btnLessFries){
            if (friesNum> 0){
            friesNum--;
            lblFriesNum.setText(String.valueOf(friesNum));
            }
            }else if (e.getSource() == btnAddSoda){
            sodaNum++;
            lblSodaNum.setText(String.valueOf(sodaNum));
            
        }else if (e.getSource() == btnLessSoda){
            if (sodaNum> 0){
            sodaNum--;
            lblSodaNum.setText(String.valueOf(sodaNum));
            }
        }else if (e.getSource() == btnReviewOrder){
            double totalCost = 0.0;
            totalCost+=calculateCost(burgerNum, (String)cbBurger.getSelectedItem());
            totalCost+=calculateCost(friesNum, (String)cbFries.getSelectedItem());
            totalCost+=calculateCost(sodaNum, (String)cbSoda.getSelectedItem());
            
            txtOrders.setText("Burger ("+cbBurger.getSelectedItem()+"): "+burgerNum+"\n"+
                               "Fries ("+cbFries.getSelectedItem()+"): "+friesNum+"\n"+
                                "Soda ("+cbSoda.getSelectedItem()+"): "+sodaNum+"\n"+
                                 "Total Cost: $" + totalCost+ "");
                    
        } else if (e.getSource() == btnResetOrder){
            burgerNum = 0;
            lblBurgerNum.setText(String.valueOf(burgerNum));
            friesNum = 0;
            lblFriesNum.setText(String.valueOf(friesNum));
            sodaNum= 0;
            lblSodaNum.setText(String.valueOf(sodaNum));
            
            txtOrders.setText("");
            
            cbBurger.setSelectedIndex(0);
            cbFries.setSelectedIndex(0);
            cbSoda.setSelectedIndex(0);
        }
        }
    
    private double calculateCost (int count, String size){
        double price = 0.0;
        switch (size) {
            case "REGULAR" -> price = 5.00;
            case "LARGE" -> price = 7.50;
            case "EXTRA LARGE" -> price = 10.00;
        } return count*price;
    }
    }

    
    

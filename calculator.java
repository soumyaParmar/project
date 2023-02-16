/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton numB[] = new JButton[9];
    JButton funB[] = new JButton[11];
    JButton add, sub, mul , dev, fact, sqr;
    JButton dec, equ, del, clr, neg;
    JPanel panel;
    Font myFont = new Font("TimesRoman",Font.BOLD,30);
    double num1 = 0,num2 = 0, result = 0;
    char operator;
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        textfield = new JTextField();
        textfield.setBounds(50,25,400,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        dev = new JButton("/");
        fact = new JButton("!");
        sqr = new JButton("sqr");
        dec = new JButton(".");
        equ = new JButton("=");
        del = new JButton("del");
        clr = new JButton("clr");
        neg = new JButton("(-)");
        
        funB[0] = add;
        funB[1] = sub;
        funB[2] = mul;
        funB[3] = dev;
        funB[4] = fact;
        funB[5] = sqr;
        funB[6] = dec;
        funB[7] = equ;
        funB[8] = del;
        funB[9] = clr;
        funB[10] = neg;
        
        for(int i=0;i<9;i++){
            funB[i].addActionListener(this);
            funB[i].setFont(myFont);
            funB[i].setFocusable(false);
        }
        for(int i=0;i<11;i++){
            numB[i] = new JButton(String.valueOf(i));
            numB[i].addActionListener(this);
            numB[i].setFont(myFont);
            numB[i].setFocusable(false);
         }
        
        neg.setBounds(50,430,70,50);
        del.setBounds(150,430,70,50);
        clr.setBounds(250,430,70,50);
        dec.setBounds(350,430,70,50);
        
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayouts(new GridLayout(4,4,10,10));
        
        panel.add(numB[1]);
        panel.add(numB[2]);
        panel.add(numB[3]);
        panel.add(add);
        panel.add(numB[4]);
        panel.add(numB[5]);
        panel.add(numB[6]);
        panel.add(sub);
        panel.add(numB[7]);
        panel.add(numB[8]);
        panel.add(numB[9]);
        panel.add(mul);
        panel.add(sqr);
        panel.add(numB[0]);
        panel.add(fact);
        panel.add(equ);
        
        frame.add(panel);
        frame.add(neg);
        frame.add(del);
        frame.add(clr);
        frame.add(textfield);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    public double factorial(double n){
        if(n<1) return 1;
        return n * factorial(n-1);
    }
    
     @Override   
    public void actionPerform(ActionEvent e){
        for(int i=0;i<11;i++){
            if(e.getSource()==numB[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
                
            }
        }
            if(e.getSource()== dec){
                textfield.setText(textfield.getText().concat("."));
            }
            if(e.getSource()==fact){
                textfield.setText(textfield.getText().concat("!"));
                operator = '!';
                
            }
            if(e.getSource()== sqr){
                textfield.setText(textfield.getText().concat(" square"));
                operator = '^';
            }
            if(e.getSource()== add){
                textfield.setText(textfield.getText());
                operator = '+';
                textfield.setText("");
            }
            if(e.getSource()== sub){
                textfield.setText(textfield.getText());
                operator = '-';
                textfield.setText("");
            }
            if(e.getSource()== mul){
                textfield.setText(textfield.getText());
                operator = '*';
                textfield.setText("");
            }
            if(e.getSource()== dev){
                textfield.setText(textfield.getText());
                operator = '/';
                textfield.setText("");
            }
            if(e.getSource()== equ){
               num2 = Double.parseDouble(textfield.getText());
               
               switch(operator){
                   case'+': 
                       result = num1+num2;
                       break;
                   case'-':
                       result = num1-num2;
                       break;
                   case'*':
                       result = num1*num2;
                       break;
                   case'/':
                       result = num1/num2;
                       break;
                   case'!':
                       result = factorial(num1);
                       break;
                   case'^':
                       result = num1*num1;
                       break;
               }
               textfield.setText(String.valueOf(result));
               num1 = result;
            }
            if(e.getSource()==clr){
                textfield.setText("");
            }
            if(e.getSource()==del){
                String s = textfield.getText();
                textfield.setText("");
                for(int i=0;i<s.length()-1;i++){
                    textfield.setText(textfield.getText()+s.charAt(i));
                }
            }
            if(e.getSource()==neg){
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            }
        }
    }



 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.exameniimaquinaria;

/**
 *
 * @author LuisaFernanda
 */
public class main {
    static conexionDB connMongo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        connMongo = new conexionDB();
        connMongo.setBD();
        
        
        Maquinaria exito = new Maquinaria();
        exito.setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoia;
import java.util.*;
/**
 *
 * @author luiz.ferreira
 */
public class TrabalhoIA {
    
    public static void main(String[] args) {
        
    Scanner ler = new Scanner(System.in); //para ler dados do teclado
    Central central  = new Central();
    
    int investimento = 20000;
    
    
    central.investir(investimento);
    central.interacaoInicial();
    central.vender();
    central.interagir();
    
    
   
}
    
}

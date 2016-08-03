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
    //Central central  = new Central();
    //int investimento = 20000;
    //central.investir(investimento);
    //central.interacaoInicial();
    //central.vender();
    //central.interagir();
    
        Central2 central = new Central2();
        Central3 central3 = new Central3();
        
        System.out.println("Informe a quantidade de Jogadores: ");
        int n_players = ler.nextInt();
        double investimento = 20000;
        //Array para armazenar as empresas
        ArrayList<Empresa> empresas = new ArrayList();
        //Uma empresa qualquer
        Empresa uma_empresa = new Empresa();
        Manual manual = new Manual();
        //Criando o numero de jogadores
        for(int i=0; i < n_players; i++){
            Empresa aux = new Empresa();
            empresas.add(aux);
        }
         //Atribuindo o investimento inicial
        for(int i=0; i<n_players; i++){
            uma_empresa = (Empresa) empresas.get(i);
            uma_empresa.saldo = investimento;
            
        }
        
        System.out.println("----------------------------");
        System.out.println("Quem irá tomar as descisões?");
        System.out.println("1 - Eu mesmo");
        System.out.println("2 - Alg. Genético");
        System.out.println("3 - Alg. Simulated Annealing");
        System.out.println("Digite a opções: ");
        int opcao = ler.nextInt();
        
        switch(opcao){
            case 1:   
                central.interacaoInicial(empresas, n_players);
                manual.interacaoManual(empresas, n_players);
                
            case 2:
                central.vender(empresas, n_players);
                central.interagir(empresas, n_players);
                
            case 3:
                central3.interacaoInicial(empresas, n_players);
                central3.interagir(empresas, n_players);
           }
        
        
        
        
        
        
    
    
   
}
    
}

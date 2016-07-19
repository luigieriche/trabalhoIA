/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoia;

import java.util.*;

/**
 *
 * @author Anderson
 */
public class Manual {
    
    int rodadas = 10;
    
    Central2 central = new Central2();
    Scanner scanner = new Scanner(System.in); 
    
    public void interacaoManual(ArrayList empresas, int n_players){
        
        Empresa uma_empresa;
      
        for(int i=0; i<rodadas; i++){
            //Realizo a venda
            central.vender(empresas, n_players);
         
            //Atualizando o  Saldo
           for(int a=0; a < n_players; a++){
            uma_empresa = (Empresa) empresas.get(a);
            uma_empresa.saldo += (uma_empresa.qtd_vendida * uma_empresa.vlr_prod) - (uma_empresa.vlr_marke + uma_empresa.gastos_fixos + uma_empresa.vlr_insumos);
            }
            
            //Imprimindo a Rodada
            System.out.println("  ");
            System.out.println("Rodada: " + i);
            System.out.println("*****************************************");
            for(int x=0; x < n_players; x++){
            uma_empresa = (Empresa) empresas.get(x);
            System.out.println("Empresa " + x);
            System.out.println("Valor do Produto: " + uma_empresa.vlr_prod);
            System.out.println("Quantidade Produzida: " + uma_empresa.qtd_prod);
            System.out.println("Quantidade vendida: " + uma_empresa.qtd_vendida);
            System.out.println("Quantidade Saldo: " + uma_empresa.saldo);
            System.out.println(" ");
            }
            System.out.println("*****************************************");
            //Hora de realizar as mudancas
            System.out.println(" ");
            System.out.println("Hora de Tomar a Descicão!");
            System.out.println("Informe as mudanças: ");
            for (int j=0; j < n_players; j++){
            uma_empresa = (Empresa) empresas.get(j);
            System.out.println("Empresa " + j);
            System.out.println("Informe a Localização: ");
            uma_empresa.localizacao = scanner.next();  
        
            switch (uma_empresa.localizacao){
            case "A":
                uma_empresa.gastos_fixos = 3000;
                uma_empresa.bonus = 0.07;
                break;
            case "B":
                uma_empresa.gastos_fixos = 2500;
                uma_empresa.bonus = 0.04;
                break;
            case "C":
                uma_empresa.gastos_fixos = 2000;
                uma_empresa.bonus = 0.03;
                break;
            default:
                uma_empresa.gastos_fixos = 4000;
                uma_empresa.bonus = 0.01;
                break;
            }
            System.out.println("Qual a quantidade desejada de produção: ");
            int y = scanner.nextInt();
            uma_empresa.qtd_prod = y;
            
            uma_empresa.vlr_insumos = uma_empresa.qtd_prod * 1.70;
            
            System.out.println("Qual o valor de investimentos em publicidade:");
            double d = scanner.nextDouble();
            uma_empresa.vlr_marke = d;
            
            System.out.println("Qual será a porcentagem de lucro?");
            double h = scanner.nextDouble();
            uma_empresa.porcentagem_lucro = h;
            uma_empresa.custo_prod = 1.70 + (uma_empresa.vlr_marke/uma_empresa.qtd_prod) + (uma_empresa.gastos_fixos/uma_empresa.qtd_prod);
            uma_empresa.vlr_prod = (((uma_empresa.custo_prod/100)* uma_empresa.porcentagem_lucro) + uma_empresa.custo_prod);
            System.out.println("Valor apropriado para o produto: " + uma_empresa.vlr_prod);
            System.out.println(" ");
            
            }
            
        }
        
    }
    
}

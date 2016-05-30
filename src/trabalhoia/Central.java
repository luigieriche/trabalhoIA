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
public class Central {
    
    
    public void rank(int vlr_prod1, int vlr_marke1, int vlr_prod2, int vlr_marke2){
    int n_rodadas = 5;
    int rodada = 1;
    int[] demanda = {100,200,300,400,500,600,700,800,900,1000};
    double venda1, venda2, marke1, marke2, rank1, rank2;
    int demandado;
    //Array contendo as possiveis porcentagem de quem tem o menor valor de venda
    double[] porcentagem_venda = {0.40,0.41,0.42,0.43,0.44,0.45,0.46,0.47,0.48,0.49,
                                 0.50,0.51,0.52,0.53,0.54,0.55,0.56,0.57,0.58,0.59,
                                 0.60};
     Random n = new Random();
     int a = n.nextInt(21);
     //Array contendo as possiveis porcentagem de quem tem mais investimento em Marketing
     double[] porcentagem_marketing = {0.17,0.18,0.19,0.20,0.21,0.22,0.23,0.24,0.25};
     Random m = new Random();
     int b = m.nextInt(9);
    //Do total de 100% vendido, vamos atribuir 70% aos valores do produto e
    // 30% aos investimentos em Marketing
    //Analisando o Valor do Produto, quem tem valor menor, recebe mais porcentagem da venda
    //Geramos uma porcentagem aleatorio entre 0.40% a 0.60% para o que tem menor valor
       
    if(vlr_prod1 < vlr_prod2){      
        venda1 = porcentagem_venda[a];
        venda2 = 0.70 - venda1; //Pega o que foi atribuido para a venda1 e diminui dos 70% totais e atribui o restante a venda2
    }else{
        if(vlr_prod1 > vlr_prod2){
            venda2 = porcentagem_venda[a];
            venda1 = 0.70 - venda2;            
        }else{ //sao iguais
            venda1 = 0.35;
            venda2 = 0.35;
        }
    }
    //Analisando o valor investido em marketing, geramos aleatoriamente uma porcentagem entre 17% a 25% para quem tem mais 
    //investimento em marketing
    if(vlr_marke1 < vlr_marke2){
        marke1 = porcentagem_marketing[b];
        marke2 = 0.30 - marke1 ;
    }else{
        if(vlr_marke1 > vlr_marke2){
            marke2 = porcentagem_marketing[b];
            marke1 = 0.30 - marke2;

        }else{
            marke1 = 0.15;
            marke2 = 0.15;
        }
    }
    //Somando as porcentagem de venda
    rank1 = venda1 + marke1;
    rank2 = venda2 + marke2;
    
    //Gerando a quantidade da demanda
    Random gerador = new Random();
    int c = gerador.nextInt(10);//Numero aleatorio entre 0-9
    demandado = demanda[c];
    
    //Gerando a quantidade que cada empresa vendeu
    int vlr_demanda1 = (int) rank1 * demandado;
    int vlr_demanda2 = (int) rank2 * demandado;
    
    //imprimir os valores da rodada
    System.out.println("Final da Rodada: " + rodada);
    System.out.println("Empresa 1 Vendeu: " + vlr_demanda1 + " produtos");
    System.out.println("Empresa 2 Vendeu: " + vlr_demanda2 + " produtos");
    
    //Como passar o valor vendido para as empresas?
    //chamar alguma funcao da empresa e passar como parametro?
    //Passar em alguma variavel da empresa? 
    
    Empresa empresa1 = new Empresa();
    empresa1.Demanda(vlr_demanda1);
    
    Empresa empresa2 = new Empresa();
    empresa2.Demanda(vlr_demanda2);
  
   
    
 }
    
     
}

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
    int rodadas = 5; //Como iniciar as rodadas?
    int[] demanda = {100,200,300,400,500,600,700,800,900,1000};
    double venda1, venda2, marke1, marke2, rank1, rank2;
    int demandado;
    //Do total de 100% vendido, vamos atribuir 70% aos valores do produto e
    // 30% aos investimentos em Marketing
    //Analisando o Valor do Produto, quem tem valor menor, recebe mais porcentagem da venda
    if(vlr_prod1 < vlr_prod2){
        venda1 = 0.40;
        venda2 = 0.30;
    }else{
        if(vlr_prod1 > vlr_prod2){
            venda1 = 0.30;
            venda2 = 0.40;
        }else{ //sao iguais
            venda1 = 0.35;
            venda2 = 0.35;
        }
    }
    //Analisando o valor investido em marketing
    if(vlr_marke1 < vlr_marke2){
        marke1 = 0.20;
        marke2 = 0.10;
    }else{
        if(vlr_marke1 > vlr_marke2){
            marke1 = 0.10;
            marke2 = 0.20;
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
    int n = gerador.nextInt(10);//Numero aleatorio entre 0-9
    demandado = demanda[n];
    
    //Gerando a quantidade que cada empresa vendeu
    int vlr_demanda1 = (int) rank1 * demandado;
    int vlr_demanda2 = (int) rank2 * demandado;
    }
    
    //Como passar o valor vendido para as empresas?
    //chamar alguma funcao da empresa e passar como parametro?
    //Passar em alguma variavel da empresa?
    
}

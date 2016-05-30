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
public class Empresa {
    
 long vlr_invest;  //(Valor Inicial do Investimento)
 String produto;  //(qual o produto a ser produzido)
 long vlr_prod;  //(qual o valor do produto)
 long vlr_insumos;  //(os valores dos insumos)
 long vlr_marke;  //(os valores gastos com propagandas)
 long gastos_fixos;  //(os valores gastos fixos como aguá, funcionários, luz…)
 int qtd_prod; //(quantidade produzida)

public void Demanda(int vlr_demanda){

//Analizar se o valor da demanda foi maior do que a oferta ou menor
// e tomar as decisões
//Se Demanda maior que oferta, entao, deve produzir mais
//Podemos usar o algoritmo genetico aqui e na Empresa2 usar uma outra tecnica, para ver a diferenca
if(vlr_demanda > qtd_prod){
    //Como vendeu tudo que produziu, pegamos o total produzido e multiplicamos pelo valor do produto
    long receita_bruta = qtd_prod * vlr_prod;
    long despesas = gastos_fixos + vlr_insumos + vlr_marke ;  
    long receita_liquida = receita_bruta - despesas;
    //Atualizando o valor do investimento com o lucro obtido
    vlr_invest =+ receita_liquida; 
    //Decidir o quanto a mais produzir
    long diferenca = vlr_demanda - qtd_prod;
    long dobro = diferenca * 2;
    if(dobro > qtd_prod){
        //produzir 100% a mais
        vlr_insumos = vlr_insumos * 2;
        qtd_prod = qtd_prod * 2;
    }else{
        //produzir somente 50% a mais
        vlr_insumos = vlr_insumos + (vlr_insumos / 2);
        qtd_prod = qtd_prod + (qtd_prod / 2);
    }
   //Imprimir os valores da rodada
    System.out.println("Empresa 1 - Valores");
    System.out.println("Valor do Investimento: " + vlr_invest);
    System.out.println("Valor dos Insumos: " + vlr_insumos);
    System.out.println("Quantidade Produzida: " + qtd_prod);
    System.out.println("Preco do Produto: " + vlr_prod);

}else{
    //Como produzimos mais que vendemos, pegamos entao o que vendemos e multiplicamos pelo valor do produto    
    long receita_bruta = vlr_demanda * vlr_prod;
    long despesas = gastos_fixos + vlr_insumos + vlr_marke ;  
    long receita_liquida = receita_bruta - despesas;
    //Atualizando o valor do investimento com o lucro obtido
    vlr_invest =+ receita_liquida; 
    //Decidir o que fazer para melhorar a venda

    
}

}

    
}

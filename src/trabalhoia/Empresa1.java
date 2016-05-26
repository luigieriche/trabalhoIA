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
public class Empresa1 {
    
 int vlr_invest;  //(Valor Inicial do Investimento)
 String produto;  //(qual o produto a ser produzido)
 int vlr_prod;  //(qual o valor do produto)
 int vlr_insumos;  //(os valores dos insumos)
 int vlr_marke;  //(os valores gastos com propagandas)
 int gastos_fixos;  //(os valores gastos fixos como aguá, funcionários, luz…)
 int qtd_prod; //(quantidade produzida)

public void Demanda(int vlr_demanda){

//Analizar se o valor da demanda foi maior do que a oferta ou menor
// e tomar as decisões
//Se Demanda maior que oferta, entao, deve produzir mais
//Podemos usar o algoritmo genetico aqui e na Empresa2 usar uma outra tecnica, para ver a diferenca
if(vlr_demanda > qtd_prod){
    //Como vendeu tudo que produziu, pegamos o total produzido e multiplicamos pelo valor do produto
    int receita_bruta = qtd_prod * vlr_prod;
    int despesas = gastos_fixos + vlr_insumos + vlr_marke ;  
    int receita_liquida = receita_bruta - despesas;
    //Atualizando o valor do investimento com o lucro obtido
    vlr_invest =+ receita_liquida; 
    //Decidir o quanto a mais produzir


}else{
    //Como produzimos mais que vendemos, pegamos entao o que vendemos e multiplicamos pelo valor do produto    
    int receita_bruta = vlr_demanda * vlr_prod;
    int despesas = gastos_fixos + vlr_insumos + vlr_marke ;  
    int receita_liquida = receita_bruta - despesas;
    //Atualizando o valor do investimento com o lucro obtido
    vlr_invest =+ receita_liquida; 
    //Decidir o que fazer para melhorar a venda

    
}

}

    
}

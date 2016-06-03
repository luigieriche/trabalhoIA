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
    
    String nome; 
    double saldo;    
    double vlr_prod;      
    double vlr_insumos;   
    double vlr_marke;     
    double gastos_fixos; 
    int qtd_prod;      
 
public void Demanda(int vlr_demanda){

//Analizar se o valor da demanda foi maior do que a oferta ou menor
// e tomar as decisões
//Se Demanda maior que oferta, entao, deve produzir mais
//Podemos usar o algoritmo genetico aqui e na Empresa2 usar uma outra tecnica, para ver a diferenca
if(vlr_demanda > qtd_prod){
    //Como vendeu tudo que produziu, pegamos o total produzido e multiplicamos pelo valor do produto
    double receita_bruta = qtd_prod * vlr_prod;
    double despesas = gastos_fixos + vlr_insumos + vlr_marke ;  
    double receita_liquida = receita_bruta - despesas;
    //Atualizando o valor do investimento com o lucro obtido
    saldo =+ receita_liquida; 
    //Decidir o quanto a mais produzir
    long diferenca = vlr_demanda - qtd_prod;
    long dobro = qtd_prod * 2;
    if(diferenca > dobro){
        //produzir 100% a mais
        vlr_insumos = vlr_insumos * 2;
        qtd_prod = qtd_prod * 2;
    }else{
        //produzir somente 50% a mais
        vlr_insumos = vlr_insumos + (vlr_insumos / 2);
        qtd_prod = qtd_prod + (qtd_prod / 2);
    }
   //Imprimir os valores da rodada
    System.out.println("Empresa X - Valores");
    System.out.println("Valor do Investimento: " + saldo);
    System.out.println("Valor dos Insumos: " + vlr_insumos);
    System.out.println("Quantidade Produzida: " + qtd_prod);
    System.out.println("Preco do Produto: " + vlr_prod);

}else{
    //Como produzimos mais que vendemos, pegamos entao o que vendemos e multiplicamos pelo valor do produto    
    double receita_bruta = vlr_demanda * vlr_prod;
    double despesas = gastos_fixos + vlr_insumos + vlr_marke ;  
    double receita_liquida = receita_bruta - despesas;
    //Atualizando o valor do investimento com o lucro obtido
    saldo =+ receita_liquida; 
    //Decidir o que fazer para melhorar a venda

    
}

}

    
}

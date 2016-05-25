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
    Empresa1 empresa1 = new Empresa1();
    Empresa2 empresa2 = new Empresa2();
    
    int vlr_invest1, vlr_invest2;  //(Valor Inicial do Investimento)
    String produto;  //(qual o produto a ser produzido)
    int vlr_prod1, vlr_prod2;  //(qual o valor do produto)
    int vlr_insumos1, vlr_insumos2;  //(os valores dos insumos)
    int vlr_marke1, vlr_marke2;  //(os valores gastos com propagandas)
    int gastos_fixos1, gastos_fixos2;  //(os valores gastos fixos como aguá, funcionários, luz…)
    int qtd_prod1, qtd_prod2; //(quantidade produzida)    
    
        System.out.println("Duelo de Empresas!\n\n");
        System.out.println("Por Favor, preencha os parametros iniciais");
        System.out.println("Empresa 1");
        System.out.println("Valor do Investimento: ");
        vlr_invest1 = ler.nextInt();
        empresa1.vlr_invest = vlr_invest1; //Ja envio este dado para a variavel da empresa
        System.out.println("Valor do Produto: ");
        vlr_prod1 = ler.nextInt();
        empresa1.vlr_prod = vlr_prod1;
        System.out.println("Valor dos Insumos: ");
        vlr_insumos1 = ler.nextInt();
        empresa1.vlr_insumos = vlr_insumos1;
        System.out.println("Valor do Marketing: ");
        vlr_marke1 = ler.nextInt();
        empresa1.vlr_marke = vlr_marke1;
        System.out.println("Valor dos Gastos Fixos: ");
        gastos_fixos1 = ler.nextInt();
        empresa1.gastos_fixos = gastos_fixos1;
        System.out.println("Quantidade Produzida: ");
        qtd_prod1 = ler.nextInt();
        empresa1.qtd_prod = qtd_prod1;
        
    //Parametros para a empresa 2    
        System.out.println("\nEmpresa 2");
        System.out.println("Valor do Investimento: ");
        vlr_invest2 = ler.nextInt();
        empresa2.vlr_invest = vlr_invest2; 
        System.out.println("Valor do Produto: ");
        vlr_prod2 = ler.nextInt();
        empresa2.vlr_prod = vlr_prod2;
        System.out.println("Valor dos Insumos: ");
        vlr_insumos2 = ler.nextInt();
        empresa2.vlr_insumos = vlr_insumos2;
        System.out.println("Valor do Marketing: ");
        vlr_marke2 = ler.nextInt();
        empresa2.vlr_marke = vlr_marke2;
        System.out.println("Valor dos Gastos Fixos: ");
        gastos_fixos2 = ler.nextInt();
        empresa2.gastos_fixos = gastos_fixos2;
        System.out.println("Quantidade Produzida: ");
        qtd_prod2 = ler.nextInt();
        empresa2.qtd_prod = qtd_prod2;
        
     //Enviar os dados da producao e preco do produto para o algoritmo central
     
     
    }
    
}

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
public class Central2 {
    
// Define número de Gerações
    int geracoes = 10;
    
    // Verifica qual o número da rodada
    int rodada = 0;
    
    // Valor das demandas para o número de geracoes
    int[] demanda = {500,650,800,1000,1200,1100,1400,1500,1500,1700,1800,1900,2000};
    
    // Porcentagem das possíveis vendas, varia de 40% a 60% para o produto com menor preço
    double[] porcentagem_venda = {0.40,0.41,0.42,0.43,0.44,0.45,0.46,0.47,0.48,0.49,
                        0.50,0.51,0.52,0.53,0.54,0.55,0.56,0.57,0.58,0.59,
                        0.60};
    
    // Porcentagem das possíveis vendas, varia de 15% a 25% para o produto com melhor marketing
    double[] porcentagem_marketing = {0.15, 0.16,0.17,0.18,0.19,0.20,0.21,0.22,0.23,0.24,0.25}; 
    
    Empresa uma_empresa = new Empresa();
    
    Scanner scanner = new Scanner(System.in); 
    
   //Interecao Inicial------------------------------------------------------------------------------------------------------- 
    public void interacaoInicial(ArrayList empresas, int n_players){
        int j;
        double d;
        
       
        //Gerando os parametros de cada empresa
        for (int i=0; i < n_players; i++){
        uma_empresa = (Empresa) empresas.get(i);
        System.out.println("Empresa " + i);
        System.out.println("Valor do Investimento: " + uma_empresa.saldo);
        System.out.println("Escolher Localização: A (Melhor Localização, B (Localização Mediana) e C (Pior Localização))");
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
        j = scanner.nextInt();
        uma_empresa.qtd_prod = j;
        
        uma_empresa.vlr_insumos = uma_empresa.qtd_prod * 1.70;
        System.out.println("O valor dos insumos são calculados com base na quantidade de produtos, total: " + uma_empresa.vlr_insumos);
        
        System.out.println("Qual o valor de investimentos em publicidade:");
        d = scanner.nextDouble();
        uma_empresa.vlr_marke = d;
        
        System.out.println("Qual será a porcentagem de lucro?");
        d = scanner.nextDouble();
        uma_empresa.porcentagem_lucro = d;
        uma_empresa.custo_prod = 1.70 + (uma_empresa.vlr_marke/uma_empresa.qtd_prod) + (uma_empresa.gastos_fixos/uma_empresa.qtd_prod);
        uma_empresa.vlr_prod = (((uma_empresa.custo_prod/100)* uma_empresa.porcentagem_lucro) + uma_empresa.custo_prod);
        System.out.println("Valor apropriado para o produto: " + uma_empresa.vlr_prod);
        System.out.println(" ");
        
        }
      //Imprimindo os parametros iniciais
      System.out.println("+++Parametros Iniciais+++");
      for (int i=0; i < n_players; i++){
          uma_empresa = (Empresa) empresas.get(i);
          System.out.println("Empresa: " + i);
          System.out.println("Localizacao: " + uma_empresa.localizacao);
          System.out.println("Investimento: " + uma_empresa.saldo);
          System.out.println("Producao: " + uma_empresa.qtd_prod);
          System.out.println("Insumos: " + uma_empresa.vlr_insumos);
          System.out.println("Valor Marketing: " + uma_empresa.vlr_marke);
          System.out.println("Valor Produto: " + uma_empresa.vlr_prod);
          System.out.println("Lucro: " + uma_empresa.porcentagem_lucro);
          System.out.println("Gastos Fixos: " + uma_empresa.gastos_fixos);
          System.out.println(" ");   
      }
         
    }
     //VENDER-------------------------------------------------------------------------------------------------------------------
    
    public void vender(ArrayList empresas, int n_players){
     double rest;
     double sobra = 0;

    
     //Somando os bonus de todas as empresas
     for (int i=0; i < n_players; i++){
         uma_empresa = (Empresa) empresas.get(i);
         sobra += uma_empresa.bonus; 
     }
     
     //O resto sera dividido entre os jogadores 
     rest = (0.15 - sobra)/n_players;
     
     //Atualizando a demanda
     for (int i=0; i < n_players; i++){
         uma_empresa = (Empresa) empresas.get(i);
         uma_empresa.demanda = uma_empresa.bonus + rest;
     }
    
     Random n = new Random();
     int porcentagem = n.nextInt(21);
     
     //Achar a empresa com MENOR valor de PRODUTO
     Empresa menor = (Empresa) empresas.get(0);
     for (int i=0; i < n_players; i++){
         uma_empresa = (Empresa) empresas.get(i);
         if(uma_empresa.vlr_prod <= menor.vlr_prod){
             menor = uma_empresa;
         }
     }
     menor.demanda += porcentagem_venda[porcentagem];
     
     //Dividir o Restante da Demanda com os demais jogadores
     double rest_demanda = (0.6 - porcentagem_venda[porcentagem]) / (n_players - 1);
     
     for(int i=0; i < n_players; i++){
         uma_empresa = (Empresa) empresas.get(i);
         if(uma_empresa != menor){
             uma_empresa.demanda += rest_demanda;
         }
     }
     //Achar a empresa com o MAIOR valor de MARKETING
     int porcentagem2 = n.nextInt(11);
     Empresa maior = (Empresa) empresas.get(0);
     
     for (int i=0; i < n_players; i++){
         if(uma_empresa.vlr_marke <= maior.vlr_marke){
             maior = uma_empresa;
         }
     }
     maior.demanda += porcentagem_marketing[porcentagem2];
     
     //Dividir o Restante da Demanda com os demais jogadores
     double rest_demanda2 = (0.25 - porcentagem_marketing[porcentagem2]) / (n_players - 1);
     
     for(int i=0; i < n_players; i++){
         uma_empresa = (Empresa) empresas.get(i);
         if(uma_empresa != maior){
             uma_empresa.demanda += rest_demanda;
         }
     }
     
     //Calculando o total vendido de cada empresa
     int porcentagem3 = n.nextInt(13);
     
      for(int i=0; i < n_players; i++){
          uma_empresa = (Empresa) empresas.get(i);
          double v1 = uma_empresa.demanda;
          int v2 = demanda[porcentagem3];
          uma_empresa.total = (int) (v1 * v2);
      }
      
      for(int i=0; i < n_players; i++){
          uma_empresa = (Empresa) empresas.get(i);
          if(uma_empresa.total >= uma_empresa.qtd_prod){
              uma_empresa.qtd_vendida = uma_empresa.qtd_prod;
          }else
              uma_empresa.qtd_vendida = uma_empresa.total;
      }
      System.out.println("----------------------------------------------------------------------- ");
      System.out.println("Demanda do Mercado: " + demanda[porcentagem]);
      for(int i=0; i < n_players; i++){
          uma_empresa = (Empresa) empresas.get(i);
          System.out.println("Empresa " + i + " | Porcentagem da Demanda: " + uma_empresa.demanda + " Produtos: "+ uma_empresa.total);
      }
     }
     
   //INTERAGIR-----------------------------------------------------------------------------------------------------------------
    
    public void interagir(ArrayList empresas, int n_players){
       
      
      //Atualizando o  Saldo
      for(int i=0; i < n_players; i++){
          uma_empresa = (Empresa) empresas.get(i);
          uma_empresa.saldo += (uma_empresa.qtd_vendida * uma_empresa.vlr_prod) - (uma_empresa.vlr_marke + uma_empresa.gastos_fixos + uma_empresa.vlr_insumos);
      }
      System.out.println("  ");
      System.out.println("Rodada 0: ");
      System.out.println("*****************************************");
      
      for(int i=0; i < n_players; i++){
          uma_empresa = (Empresa) empresas.get(i);
          System.out.println("Empresa " + i);
          System.out.println("Valor do Produto: " + uma_empresa.vlr_prod);
          System.out.println("Quantidade Produzida: " + uma_empresa.qtd_prod);
          System.out.println("Quantidade vendida: " + uma_empresa.qtd_vendida);
          System.out.println("Quantidade Saldo: " + uma_empresa.saldo);
          System.out.println(" ");
      }
      
      AlgoritmoGenetico um_genetico;
      //Array para armazenar os geneticos 
      ArrayList<AlgoritmoGenetico> geneticos = new ArrayList();
      
      for (int x = 1; x < geracoes; x++){
          for(int i=0; i< n_players; i++){
              AlgoritmoGenetico aux = new AlgoritmoGenetico();
              geneticos.add(aux);
          }
          
          for (int i=0; i < n_players; i++){
               uma_empresa = (Empresa) empresas.get(i);
               um_genetico = (AlgoritmoGenetico) geneticos.get(i);
               
               if(uma_empresa.qtd_vendida < uma_empresa.qtd_prod){
                   uma_empresa = um_genetico.geneneticoCentral(uma_empresa, 0);
               }else
                   uma_empresa = um_genetico.geneneticoCentral(uma_empresa, -1);
            }
          
          this.vender(empresas, n_players);
      
      //Atualizando saldo novamente
        for(int i=0; i < n_players; i++){
           uma_empresa = (Empresa) empresas.get(i);
           uma_empresa.saldo += (uma_empresa.qtd_vendida * uma_empresa.vlr_prod) - (uma_empresa.vlr_marke + uma_empresa.gastos_fixos + uma_empresa.vlr_insumos);
        } 
        //rodadas
        System.out.println("  ");
        System.out.println("Rodada " + x);
        System.out.println("*****************************************");
        for(int i=0; i < n_players; i++){
           uma_empresa = (Empresa) empresas.get(i);
           System.out.println("Empresa " + i);
           System.out.println("Valor do Produto: " + uma_empresa.vlr_prod);
           System.out.println("Quantidade Produzida: " + uma_empresa.qtd_prod);
           System.out.println("Quantidade vendida: " + uma_empresa.qtd_vendida);
           System.out.println("Quantidade Saldo: " + uma_empresa.saldo);
           System.out.println(" ");
          }
        }
          
        }
    }

      
      



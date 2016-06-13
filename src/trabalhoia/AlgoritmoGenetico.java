/*
    *Algorítmo base

    Procedimento AG
        { 
            t = 0;
            inicia_população (P, t)
            avaliação (P, t);
            repita até (t = d)
            { 
                t = t +1;
                seleção_dos_pais (P,t);
                recombinação (P, t);
                mutação (P, t);
                avaliação (P, t);
                sobrevivem (P, t)
            }
    }
 */
package trabalhoia;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author luiz.ferreira
 */
public class AlgoritmoGenetico {
     ArrayList<Empresa> pais = new ArrayList<Empresa>();
     Empresa auxiliar = new Empresa();
     
     int geracoes = 5;

     Empresa geneneticoCentral(Empresa empresa, Integer criterio){
        inicia_populacao(empresa, criterio);
        
        for (int x = 0; x < geracoes; x++){
            popula();
            Random n = new Random();
                int mutacao = n.nextInt(pais.size());
            auxiliar = mutacao(pais.get(mutacao), criterio);
            pais.set(mutacao, auxiliar);
        
            avalicao(criterio);
        }
        
        auxiliar = seleciona_melhor(criterio);
        return auxiliar;
    }
     
    void inicia_populacao(Empresa empresa, Integer criterio){
        pais.add(empresa);
        Empresa auxiliar = new Empresa();
        auxiliar = this.mutacao(empresa, criterio);

        pais.add(auxiliar);
       
    }//Gera por meio da mutação a população inicial
    
    void popula(){
        Empresa empresa1 = new Empresa();
        Empresa empresa2 = new Empresa();
        
        for (int x = 0; x < geracoes; x++){
            empresa1 = pais.get(0);
            empresa2 = pais.get(1);
            pais.add(gerar_cromossomo(empresa1, empresa2));
        }
    }
    
     Empresa gerar_cromossomo(Empresa empresa1, Empresa empresa2){
        Empresa auxiliar = new Empresa();
        Random n = new Random();
        int modifica = n.nextInt(3);
        
        switch (modifica){
          case 0:
              empresa1.vlr_marke = empresa2.vlr_marke;
              break;
          case 1:
              empresa1.porcentagem_lucro = empresa2.porcentagem_lucro;
              break;
          case 2:
              empresa1.qtd_prod = empresa2.qtd_prod;
              break;
        }
        
        empresa1.custo_prod = 1.70 + (empresa1.vlr_marke/empresa1.qtd_prod) + (empresa1.gastos_fixos/empresa1.qtd_prod);
        empresa1.vlr_prod = (((empresa1.custo_prod/100)* empresa1.porcentagem_lucro) + empresa1.custo_prod);
        
        return empresa1;
    }
    
    void avalicao(Integer criterio){
        Empresa melhor1 = new Empresa();
        Empresa melhor2 = new Empresa();
        Empresa auxiliar = new Empresa();
        // Modo Torneio, 2 cromossomos aleatórios.
        
        melhor1 = pais.get(0);
        melhor2 = pais.get(1);
        
        System.out.println(melhor1.vlr_prod);
        System.out.println(melhor2.vlr_prod);
        

       // Significa que deve produzir mais
        if (criterio == 0){
            for (int x = 2; x < pais.size(); x++){
                auxiliar = pais.get(x);
                System.out.println(auxiliar.vlr_prod);
                if ((auxiliar.vlr_prod) > (melhor1.vlr_prod)){
                    melhor2 = melhor1;
                    melhor1 = auxiliar;
                }
                else if ((auxiliar.vlr_prod) > (melhor2.vlr_prod )){
                    melhor2 = auxiliar;
                }
            }
        }
       
        // Selecionar os cromossomos que pretendem vender menos
        else{
             for (int x = 2; x < pais.size(); x++){
                auxiliar = pais.get(x);
                System.out.println(auxiliar.vlr_prod);
                
                if ((auxiliar.vlr_prod ) < (melhor1.vlr_prod)){
                    melhor2 = melhor1;
                    melhor1 = auxiliar;
                }
                else if ((auxiliar.vlr_prod ) < (melhor2.vlr_prod )){
                    melhor2 = auxiliar;
                }
            }
        }
       
        System.out.println(melhor1.vlr_prod);
        System.out.println(melhor2.vlr_prod);
       
        //Limpa o vetor de pais para a próxima interação
        pais.clear();
        
        pais.add(melhor1);
        pais.add(melhor2);
  
    }//calcula a avaliação da população
    
     Empresa seleciona_melhor(Integer criterio){
         Empresa auxiliar = new Empresa();
         
         if (criterio == 0){
              if ((pais.get(0).qtd_prod * pais.get(0).vlr_prod) > (pais.get(1).qtd_prod * pais.get(1).vlr_prod)){
                  auxiliar = pais.get(0);
              }
              else if ((pais.get(0).qtd_prod * pais.get(0).vlr_prod) <= (pais.get(1).qtd_prod * pais.get(1).vlr_prod)){
                  auxiliar = pais.get(1);
              }     
        }
        // Selecionar os cromossomos que pretendem vender menos
        else{    
            if ((pais.get(0).qtd_prod * pais.get(0).vlr_prod)< (pais.get(1).qtd_prod * pais.get(1).vlr_prod)){
                auxiliar = pais.get(0);
            }
            else if ((pais.get(0).qtd_prod * pais.get(0).vlr_prod) >= (pais.get(1).qtd_prod * pais.get(1).vlr_prod)){
                auxiliar = pais.get(1);
            }       
        }
         
         System.out.println("Melhor escolhido: " + auxiliar.qtd_prod);
        
        return auxiliar;
    
    } //função fit que fará a selação dos pais por meio de um modelo de seleção "Roleta", por exemplo
    
    
    // Realiza mutação entre os indivíduos gerados
    Empresa mutacao(Empresa empresa, Integer criterio){
        Random n = new Random();
        int porcentagem_marketing = 0;
        int porcentagem_lucro = 0;
        int porcentagem_producao = 0;
        int porcentagem_vlr_produto = 0;
       
        if (criterio == 0){
            porcentagem_marketing = n.nextInt(5);
            porcentagem_lucro = n.nextInt(5);
            porcentagem_producao = n.nextInt(5);
            porcentagem_vlr_produto = n.nextInt(5);
            
        }
        else {
            porcentagem_marketing = n.nextInt(5) * -1;
            porcentagem_lucro = n.nextInt(5) * -1;
            porcentagem_producao = n.nextInt(5) ;
            porcentagem_vlr_produto = n.nextInt(5) * -1;
        }
        
        empresa.porcentagem_lucro = porcentagem_lucro;
        empresa.vlr_marke = ((empresa.vlr_marke/100)* porcentagem_producao) + empresa.vlr_marke;
        empresa.qtd_prod = ((empresa.qtd_prod/100)* porcentagem_producao) + empresa.qtd_prod;
        
        empresa.custo_prod = 1.70 + (empresa.vlr_marke/empresa.qtd_prod) + (empresa.gastos_fixos/empresa.qtd_prod);
        empresa.vlr_prod = empresa.vlr_prod + ((empresa.vlr_prod/100) * porcentagem_vlr_produto);
        
        return empresa;
    }
   
    void sobrevivem(){} // Seleção dos indivíduos que irão sobreviver para a próxima interação
}

/*
    Algoritmo Base:

    Inicializar u, T0, L0
    k := 0
        Repetir
        Para l = 1 ATÉ Lk
            Gerar w de V(u)
            Se f(w) ≤ f(u), então u := w
            Caso contrário, se random[0, 1) < exp ((f(u) − f(w))/Tk)
                então u := w
        k := k + 1
        Calcular Lk e Tk
    Até "critério de parada"


 */
package trabalhoia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author luiz.ferreira
 */
public class AlgoritmoSimulatedAnnealing {
    
    Empresa auxiliar = new Empresa();
         
    public Empresa inicia(Empresa empresa, int criterio){
        auxiliar = empresa;
        Empresa vizinho = new Empresa();
        double custoAtual, custoVizinho;
        
        //t0: temperatura inicial, lk: número de interações
        int t0 = 10;
        int lk = 20;
        
        //Inicialização das variáveis
        double tk = t0;
        double deltaCusto = 0;

        while (tk > 1 || lk != 0){
                // Para temperatura inicial chegar até zero
                vizinho = gerarVizinho(empresa, criterio);
                
                // Funções para gerar o Custo da escolha atual em auxiliar, e do vizinho gerado
                custoAtual = calculaCusto(auxiliar, empresa, criterio);
                custoVizinho = calculaCusto(vizinho, empresa, criterio);
                
                // Gera diferença dos custos
                deltaCusto = custoAtual - custoVizinho;
                
                if (deltaCusto >= 0)
                    {
                        // Atualiza auxiliar como sendo vizinho, pelo fato de ser uma solução melhor
                        auxiliar = vizinho;
                    }
                else {
                    BigDecimal expoente = new BigDecimal(deltaCusto/tk);
                    
                    if (Math.pow(Math.E, tk) > Math.random())
                        auxiliar = vizinho;
                    }
            //Calcular Tk 
            tk = 0.5 * (tk-1);
            lk--;
        }
        
        return auxiliar;
    }
    
    public Empresa gerarVizinho(Empresa empresa, int criterio){
        Random n = new Random();
        int porcentagem_marketing = 0;
        int porcentagem_lucro = 0;
        int porcentagem_producao = 0;
        int porcentagem_vlr_produto = 0;
       
        switch (criterio) {
            case 0:// Produziu mais do que vendeu & Valor do seu produto é maior 
                porcentagem_marketing = n.nextInt(5);
                porcentagem_producao = n.nextInt(5) * -1;
                porcentagem_vlr_produto = n.nextInt(5) * -1;
                break;
            case 1:// Produziu mais do que vendeu & Valor do seu produto é menor
                porcentagem_marketing = n.nextInt(5);
                porcentagem_producao = n.nextInt(5) * -1;
                porcentagem_vlr_produto = n.nextInt(5);
                break;
            case 2:// Vendeu tudo o que produziu & Valor do seu produto é maior
                porcentagem_producao = n.nextInt(5);
                break;
            case 3:// Vendeu tudo o que produziu & Valor do seu produto é menor
                porcentagem_marketing = n.nextInt(5) * -1;
                porcentagem_producao = n.nextInt(5);
                porcentagem_marketing = n.nextInt(5);
                break;

            default:
                break;
        }
        
        empresa.porcentagem_lucro = porcentagem_lucro;
        empresa.vlr_marke = ((empresa.vlr_marke/100)* porcentagem_producao) + empresa.vlr_marke;
        empresa.qtd_prod = ((empresa.qtd_prod/100)* porcentagem_producao) + empresa.qtd_prod;
        
        empresa.custo_prod = 1.70 + (empresa.vlr_marke/empresa.qtd_prod) + (empresa.gastos_fixos/empresa.qtd_prod);
        empresa.vlr_prod = empresa.vlr_prod + ((empresa.vlr_prod/100) * porcentagem_vlr_produto);
        
        return empresa;
}
    
    public double calculaCusto(Empresa empresa,Empresa auxiliar, int criterio){
        double custo = 0;
        double custoVizinho = 0;
        double custoEmpresa = 0;
        
        // Valor total do que foi produzido.
        custoVizinho = auxiliar.qtd_prod * auxiliar.vlr_prod;
        custoEmpresa = empresa.qtd_prod * empresa.vlr_prod;

            switch (criterio) {
            case 0:// Produziu mais do que vendeu & Valor do seu produto é maior 
                custo = (custo + (auxiliar.vlr_marke - empresa.vlr_marke));
                custo = (custo + custoEmpresa - custoVizinho);
                break;
            case 1:// Produziu mais do que vendeu & Valor do seu produto é menor
                 custo = empresa.qtd_prod * auxiliar.qtd_prod;
                break;
            case 2:// Vendeu tudo o que produziu & Valor do seu produto é maior
                custo = auxiliar.qtd_prod - empresa.qtd_prod;
                break;
            case 3:// Vendeu tudo o que produziu & Valor do seu produto é menor
               custo = (custo + (empresa.vlr_marke - auxiliar.vlr_marke));
               custo = (custo + custoVizinho - custoEmpresa);
                break;

            default:
                break;
        }
        return custo;
    }
    
    
}

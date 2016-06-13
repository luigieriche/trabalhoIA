/*
    Notações Importantes:

    String nome; 
    double saldo;               |  é o saldo inicial e saldo que irá ser atualizado durante a execução do algoritmo
    int qtd_prod;               |  quantidade de produtos 
    double vlr_prod;            |  o valor do produto será uma função definida por: custos + % de lucro (Onde custos estão relacionados aos Insumos, Marketing, e os Gastos fixos)
    double custo_prod;          |  é o custo do produto, por valor unitário.
    double porcentagem_lucro;   
    double lucro;
    int qtd_vendida;
    double vlr_insumos;         |  ou materia prima, será o conjunto de todos os ingredientes para a produção do produto
    double vlr_marke;           |  os valores gastos com propagandas, cartazes, notificações em rádios, etc.
    double gastos_fixos;        |  os valores gastos fixos como aguá, funcionários, luz, etc.
    double bonus;

    gastos_fixos:
    - Selecionando Instalação A: garantirá +5% nas vendas, no entanto o custo fixo será de R$ 3.000,00
    - Selecionando Instalação B: garantirá +3,5% nas vendas, no entanto o custo fixo será de R$ 2.500,00
    - Selecionando Instalação C: garantirá +2% nas vendas, no entanto o custo fixo será de R$ 2.000
    *Os gastos fixos estão relacionados principalmente às questões de localização, quanto mais próximo de um local com maior ganho 
    nas vendas, maior é o valor relacionado a ele. Ambas as empresas podem selecionar o mesmo local.

 */
package trabalhoia;
import java.util.*;
/**
 * @author Anderson
 */
public class Central {
    
    // Definimos Arrays para salvar todos objetos gerados a cada interação
    ArrayList<Empresa> arrayEmpresa1 = new ArrayList<Empresa>();
    ArrayList<Empresa> arrayEmpresa2 = new ArrayList<Empresa>();

    // Objetos que serão manuseados a cada interação
    Empresa empresa1 = new Empresa();
    Empresa empresa2 = new Empresa();
    
    // Define número de Gerações
    int geracoes = 25;
    
    // Verifica qual o número da rodada
    int rodada = 0;
    
    // Valor das demandas para o número de geracoes
    int[] demanda = {1000,1200,1100,1400,1500,1500,1700,1800,1900,2000};
    
    // Porcentagem das possíveis vendas, varia de 40% a 60% para o produto com menor preço
    double[] porcentagem_venda = {0.40,0.41,0.42,0.43,0.44,0.45,0.46,0.47,0.48,0.49,
                        0.50,0.51,0.52,0.53,0.54,0.55,0.56,0.57,0.58,0.59,
                        0.60};
    
    // Porcentagem das possíveis vendas, varia de 15% a 25% para o produto com melhor marketing
    double[] porcentagem_marketing = {0.15, 0.16,0.17,0.18,0.19,0.20,0.21,0.22,0.23,0.24,0.25};
        
    public Central() {
        // Aloca nos arrays a quantidade que existirão de gerações

    }
    
    public void investir(int investimento){
        empresa1.saldo = investimento;
        empresa2.saldo = investimento;
    }
    
    public void interacaoInicial(){
        
        Scanner scanner = new Scanner(System.in);  
        double d = 0;
        int i = 0;
        String localizacao, localizacao2;
        
        System.out.println("Empresa 1");
        System.out.println("Valor do Investimento: " + empresa1.saldo);
        System.out.println("Escolher Localização: A (Melhor Localização, B (Localização Mediana) e C (Pior Localização))");
        System.out.println("Informe a Localização: ");
        localizacao = scanner.nextLine();  
        
        switch (localizacao){
            case "A":
                empresa1.gastos_fixos = 3000;
                empresa1.bonus = 0.07;
                break;
            case "B":
                empresa1.gastos_fixos = 2500;
                empresa1.bonus = 0.04;
                break;
            case "C":
                empresa1.gastos_fixos = 2000;
                empresa1.bonus = 0.03;
                break;
            default:
                empresa1.gastos_fixos = 4000;
                empresa1.bonus = 0.01;
                break;
        }
        
        System.out.println("Qual a quantidade desejada de produção: ");
        i = scanner.nextInt();
        empresa1.qtd_prod = i;
        
        empresa1.vlr_insumos = empresa1.qtd_prod * 1.70;
        System.out.println("O valor dos insumos são calculados com base na quantidade de produtos, total: " + empresa1.vlr_insumos);
        
        System.out.println("Qual o valor de investimentos em publicidade:");
        d = scanner.nextDouble();
        empresa1.vlr_marke = d;
        
        System.out.println("Qual será a porcentagem de lucro?");
        d = scanner.nextDouble();
        empresa1.porcentagem_lucro = d;
        
        empresa1.custo_prod = 1.70 + (empresa1.vlr_marke/empresa1.qtd_prod) + (empresa1.gastos_fixos/empresa1.qtd_prod);
        empresa1.vlr_prod = (((empresa1.custo_prod/100)* empresa1.porcentagem_lucro) + empresa1.custo_prod);
        System.out.println("Valor apropriado para o produto: " + empresa1.vlr_prod);
        
        // Empresa 2
        scanner.next();
        System.out.println("Empresa 2");
        System.out.println("Valor do Investimento: " + empresa2.saldo);
        System.out.println("Escolher Localização: A (Melhor Localização, B (Localização Mediana) e C (Pior Localização))");
        System.out.println("Informe a Localização: ");
        localizacao2 = scanner.nextLine();  
        
        switch (localizacao){
            case "A":
                empresa2.gastos_fixos = 3000;
                empresa2.bonus = 0.07;
                break;
            case "B":
                empresa2.gastos_fixos = 2500;
                empresa2.bonus = 0.04;
                break;
            case "C":
                empresa2.gastos_fixos = 2000;
                empresa2.bonus = 0.03;
                break;
            default:
                empresa2.gastos_fixos = 4000;
                empresa2.bonus = 0.01;
                break;
        }
        
        System.out.println("Qual a quantidade desejada de produção: ");
        i = scanner.nextInt();
        empresa2.qtd_prod = i;
        
        empresa2.vlr_insumos = empresa2.qtd_prod * 1.70;
        System.out.println("O valor dos insumos são calculados com base na quantidade de produtos, total: " + empresa2.vlr_insumos);
        
        System.out.println("Qual o valor de investimentos em publicidade:");
        d = scanner.nextDouble();
        empresa2.vlr_marke = d;
        
        System.out.println("Qual será a porcentagem de lucro?");
        d = scanner.nextDouble();
        empresa2.porcentagem_lucro = d;
        
        empresa2.custo_prod = 1.70 + (empresa2.vlr_marke/empresa2.qtd_prod) + (empresa2.gastos_fixos/empresa2.qtd_prod);
        empresa2.vlr_prod = (((empresa2.custo_prod/100)* empresa2.porcentagem_lucro) + empresa2.custo_prod);
        System.out.println("Valor apropriado para o produto: " + empresa2.vlr_prod);
    }
       
    public void interagir(){
        AlgoritmoGenetico genetico1 = new AlgoritmoGenetico();
        AlgoritmoGenetico genetico2 = new AlgoritmoGenetico();
        
        empresa1.saldo = (empresa1.saldo + (empresa1.qtd_vendida * empresa1.vlr_prod)) - (empresa1.vlr_marke + empresa1.gastos_fixos + empresa1.vlr_insumos);
        empresa2.saldo = (empresa2.saldo + (empresa2.qtd_vendida * empresa2.vlr_prod)) - (empresa2.vlr_marke + empresa2.gastos_fixos + empresa2.vlr_insumos);
        
        arrayEmpresa1.add(empresa1);
        arrayEmpresa2.add(empresa2);
        
        System.out.println("Rodada 0: ");
        System.out.println("Empresa 1");
         System.out.println("Valor do Produto: " + empresa1.vlr_prod);
        System.out.println("Quantidade Produzida: " + empresa1.qtd_prod);
        System.out.println("Quantidade vendida: " + empresa1.qtd_vendida);
        System.out.println("Quantidade Saldo: " + empresa1.saldo);
        System.out.println(" ");
        System.out.println("Empresa 2");
         System.out.println("Valor do Produto: " + empresa2.vlr_prod);
        System.out.println("Quantidade Produzida: " + empresa2.qtd_prod);
        System.out.println("Quantidade vendida: " + empresa2.qtd_vendida);
        System.out.println("Quantidade Saldo: " + empresa2.saldo);
        System.out.println(" ");
        System.out.println(" ");
        
        for (int x = 0; x < geracoes; x++)
        {
             if (empresa1.qtd_vendida < empresa1.qtd_prod){
                 empresa1 = genetico1.geneneticoCentral(empresa1, -1);
             }
             else{
                 empresa1 = genetico1.geneneticoCentral(empresa1, 0);
             }
             
             if (empresa2.qtd_vendida < empresa2.qtd_prod){
                empresa2 = genetico2.geneneticoCentral(empresa2, -1);
             }
             else{
                empresa2 = genetico2.geneneticoCentral(empresa2, 0);
             }
             
            this.vender();
            
            empresa1.saldo = (empresa1.saldo + (empresa1.qtd_vendida * empresa1.vlr_prod)) - (empresa1.vlr_marke + empresa1.gastos_fixos + empresa1.vlr_insumos);
            empresa2.saldo = (empresa2.saldo + (empresa2.qtd_vendida * empresa2.vlr_prod)) - (empresa2.vlr_marke + empresa2.gastos_fixos + empresa2.vlr_insumos);
        
            arrayEmpresa1.add(empresa1);
            arrayEmpresa2.add(empresa2);
            
            System.out.println("Rodada " + x);
            System.out.println("Empresa 1");
            System.out.println("Valor do Produto: " + empresa1.vlr_prod);
            System.out.println("Quantidade Produzida: " + empresa1.qtd_prod);
            System.out.println("Quantidade vendida: " + empresa1.qtd_vendida);
            System.out.println("Quantidade Saldo: " + empresa1.saldo);
            System.out.println(" ");
            System.out.println("Empresa 2");
             System.out.println("Valor do Produto: " + empresa2.vlr_prod);
            System.out.println("Quantidade Produzida: " + empresa2.qtd_prod);
            System.out.println("Quantidade vendida: " + empresa2.qtd_vendida);
            System.out.println("Quantidade Saldo: " + empresa2.saldo);
            System.out.println(" ");
            System.out.println(" ");
        }  
      
    }
    
    public void vender(){      
        double rest = (0.15 - (empresa1.bonus + empresa2.bonus)) / 2;
        double demanda1 = empresa1.bonus + rest;
        double demanda2 = empresa2.bonus + rest;
        int total1 = 0;
        int total2 = 0;
        
        Random n = new Random();
        int porcentagem = n.nextInt(21);
        
        if (empresa1.vlr_prod < empresa2.vlr_prod){
            demanda1 = demanda1 + porcentagem_venda[porcentagem];
            demanda2 = demanda2 + 0.6 - porcentagem_venda[porcentagem];
        }
        else if (empresa1.vlr_prod > empresa2.vlr_prod){
            demanda2 = demanda2 + porcentagem_venda[porcentagem];
            demanda1 = demanda1 + 0.6 - porcentagem_venda[porcentagem];
        }
        else{
            demanda1 =+ 0.3;
            demanda2 =+ 0.3;
        }
        
        System.out.println("Demanda 1:" + demanda1);
        System.out.println("Demanda 2:" + demanda2);
        System.out.println(" ");
      
        
        porcentagem = n.nextInt(11);
        
        if (empresa1.vlr_marke > empresa2.vlr_marke){
            demanda1 = demanda1 + porcentagem_marketing[porcentagem];
            demanda2 = demanda2 + 0.25 - porcentagem_marketing[porcentagem];
        }
        else if (empresa1.vlr_marke < empresa2.vlr_marke){
            demanda2 = demanda2 + porcentagem_marketing[porcentagem];
            demanda1 = demanda1 + 0.25 - porcentagem_marketing[porcentagem];
        }
        else{
            demanda1 = demanda1 + 0.125;
            demanda2 = demanda2 + 0.125;
        }
        
        System.out.println("Demanda 1:" + demanda1);
        System.out.println("Demanda 2:" + demanda2);
        System.out.println(" ");
        
        porcentagem = n.nextInt(10);
               
        total1 = (int) (demanda1 * demanda[porcentagem]);
        total2 = (int) (demanda2 * demanda[porcentagem]);
        
        if (total1 >= empresa1.qtd_prod){
            empresa1.qtd_vendida = empresa1.qtd_prod;
        }
        else{
             empresa1.qtd_vendida = total1;
        }
        
         if (total2 >= empresa2.qtd_prod){
            empresa2.qtd_vendida = empresa2.qtd_prod;
        }
        else{
             empresa2.qtd_vendida = total2;
        }
        
        System.out.println("------------------------------------------------- ");
        System.out.println("Demanda do Mercado: " + demanda[porcentagem]);
        System.out.println("Porcentagem de venda da demanda empresa 1 :" + total1);
        System.out.println("Porcentagem de venda da demanda empresa 2 :" + total2);
        
        
        
    }
}

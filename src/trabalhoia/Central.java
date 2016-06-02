/*
    Notações Importantes:
    long saldo          |  é o saldo inicial e saldo que irá ser atualizado durante a execução do algoritmo
    long vlr_prod       |  o valor do produto será uma função definida por: custos + % de lucro (Onde custos estão relacionados aos Insumos, Marketing, e os Gastos fixos)
    long vlr_insumos    |  ou materia prima, será o conjunto de todos os ingredientes para a produção do produto
    long vlr_marke      |  os valores gastos com propagandas, cartazes, notificações em rádios, etc.
    long gastos_fixos   |  os valores gastos fixos como aguá, funcionários, luz, etc.
    int qtd_prod        |  quantidade de produtos 

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
    Empresa[] arrayEmpresa1;
    Empresa[] arrayEmpresa2;
    
    // Objetos que serão manuseados a cada interação
    Empresa empresa1 = new Empresa();
    Empresa empresa2 = new Empresa();
    
    // Define númer de Gerações
    int geracoes = 10;
        
    public Central() {
        // Aloca nos arrays a quantidade que existirão de gerações
        this.arrayEmpresa1 = new Empresa[geracoes];
        this.arrayEmpresa2 = new Empresa[geracoes];
    }
    
    public void investir(int investimento){
        empresa1.saldo = investimento;
        empresa2.saldo = investimento;
    }
    
    public void interacaoInicial(){
        
        Scanner scanner = new Scanner(System.in);  
        double d = 0;
        int i = 0;
        String localizacao;
        
        System.out.println("Empresa 1");
        System.out.println("Valor do Investimento: " + empresa1.saldo);
        System.out.println("Escolher Localização: A (Melhor Localização, B (Localização Mediana) e C (Pior Localização))");
        System.out.println("Informe a Localização: ");
        localizacao = scanner.nextLine();  
        
        switch (localizacao){
            case "A":
                empresa1.gastos_fixos = 3000;
                break;
            case "B":
                empresa1.gastos_fixos = 2500;
                break;
            case "C":
                empresa1.gastos_fixos = 2000;
                break;
            default:
                empresa1.gastos_fixos = 4000;
                break;
        }
        
        System.out.println("Qual a quantidade desejada de produção: ");
        i = scanner.nextInt();
        empresa1.qtd_prod = i;
        
        empresa1.vlr_insumos = empresa1.qtd_prod * 0.90;
        System.out.println("O valor dos insumos são calculados com base na quantidade de produtos, total: " + empresa1.vlr_insumos);
        
        System.out.println("Qual o valor de investimentos em publicidade:");
        d = scanner.nextDouble();
        empresa1.vlr_marke = d;
        
        System.out.println("Qual será a porcentagem de lucro?");
        d = scanner.nextDouble();
        
        empresa1.vlr_prod = 0.90 + (empresa1.vlr_marke/empresa1.qtd_prod) + (empresa1.gastos_fixos/empresa1.qtd_prod);
        empresa1.vlr_prod = (((empresa1.vlr_prod/100)*d) + empresa1.vlr_prod);
        System.out.println("Valor apropriado para o produto: " + empresa1.vlr_prod);
        
        // Empresa 2
        System.out.println("Empresa 2");
        System.out.println("Valor do Investimento: " + empresa2.saldo);
        System.out.println("Escolher Localização: A (Melhor Localização, B (Localização Mediana) e C (Pior Localização))");
        System.out.println("Informe a Localização: ");
        localizacao = scanner.nextLine();  
        
        switch (localizacao){
            case "A":
                empresa1.gastos_fixos = 3000;
                break;
            case "B":
                empresa1.gastos_fixos = 2500;
                break;
            case "C":
                empresa1.gastos_fixos = 2000;
                break;
            default:
                empresa1.gastos_fixos = 4000;
                break;
        }
        
        System.out.println("Qual a quantidade desejada de produção: ");
        i = scanner.nextInt();
        empresa2.qtd_prod = i;
        
        empresa2.vlr_insumos = empresa2.qtd_prod * 0.90;
        System.out.println("O valor dos insumos são calculados com base na quantidade de produtos, total: " + empresa2.vlr_insumos);
        
        System.out.println("Qual o valor de investimentos em publicidade:");
        d = scanner.nextDouble();
        empresa2.vlr_marke = d;
        
        System.out.println("Qual será a porcentagem de lucro?");
        d = scanner.nextDouble();
        
        empresa2.vlr_prod = 0.90 + (empresa2.vlr_marke/empresa2.qtd_prod) + (empresa2.gastos_fixos/empresa2.qtd_prod);
        empresa2.vlr_prod = (((empresa2.vlr_prod/100)*d) + empresa2.vlr_prod);
        System.out.println("Valor apropriado para o produto: " + empresa2.vlr_prod);
    }
    
    public void interagir(){
        for (int x = 0; x < geracoes; x++)
        {
            // Definirá o valor do "Tiro no Escuro" na primeira Interação
            if (x == 0){
                
            }
            else if (x < geracoes){
            
            }
            else {
            
            }
        
        }  
    }
    
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

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
    Empresa[] arrayEmpresa1;
    Empresa[] arrayEmpresa2;
    
    // Objetos que serão manuseados a cada interação
    Empresa empresa1 = new Empresa();
    Empresa empresa2 = new Empresa();
    
    // Define número de Gerações
    int geracoes = 10;
    
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
                empresa1.bonus = 0.5;
                break;
            case "B":
                empresa1.gastos_fixos = 2500;
                empresa1.bonus = 0.35;
                break;
            case "C":
                empresa1.gastos_fixos = 2000;
                empresa1.bonus = 0.2;
                break;
            default:
                empresa1.gastos_fixos = 4000;
                empresa1.bonus = 0.1;
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
        localizacao = scanner.nextLine();  
        
        switch (localizacao){
            case "A":
                empresa2.gastos_fixos = 3000;
                empresa2.bonus = 0.05;
                break;
            case "B":
                empresa2.gastos_fixos = 2500;
                empresa2.bonus = 0.035;
                break;
            case "C":
                empresa2.gastos_fixos = 2000;
                empresa2.bonus = 0.02;
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
        for (int x = 0; x < geracoes; x++)
        {

        
        }  
    }
    
    public void vender(){      
        double demanda1 = empresa1.bonus;
        double demanda2 = empresa2.bonus;
        int total1 = 0;
        int total2 = 0;
        
        Random n = new Random();
        int porcentagem = n.nextInt(21);
        
        if (empresa1.vlr_prod > empresa2.vlr_prod){
            demanda1 = demanda1 + porcentagem;
            demanda2 = demanda2+ 0.6 - porcentagem_venda[porcentagem];
        }
        else if (empresa1.vlr_prod < empresa2.vlr_prod){
            demanda2 = demanda2 + porcentagem;
            demanda1 = demanda1 + 0.6 - porcentagem_venda[porcentagem];
        }
        else{
            demanda1 = 0.3;
            demanda2 = 0.3;
        }
        
        porcentagem = n.nextInt(11);
        
        if (empresa1.vlr_marke > empresa2.vlr_marke){
            demanda1 = demanda1 + porcentagem;
            demanda2 = demanda2 + 0.25 - porcentagem_venda[porcentagem];
        }
        else if (empresa1.vlr_marke < empresa2.vlr_marke){
            demanda2 = demanda2 + porcentagem;
            demanda1 = demanda1 + 0.25 - porcentagem_venda[porcentagem];
        }
        else{
            demanda1 = demanda1 + 0.125;
            demanda2 = demanda2 + 0.125;
        }
        
        total1 = (int) (demanda1 * demanda[rodada]);
        total2 = (int) (demanda2 * demanda[rodada]);
        
        System.out.println(total1);
        System.out.println(total2);
        
    }
}

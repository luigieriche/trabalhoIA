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

import java.util.ArrayList;

/**
 *
 * @author luiz.ferreira
 */
public class AlgoritmoSimulatedAnnealing {
    
    ArrayList<Empresa> pais = new ArrayList<Empresa>();
    Empresa auxiliar = new Empresa();
     
    int geracoes = 10;
    
    public void inicia(){
        
    }
    
    public void gerarVizinho(){}
    
    public void calculaCusto(){}
    
    
}

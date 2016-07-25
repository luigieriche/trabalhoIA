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
    At´e ‘‘critério de parada’’


 */
package trabalhoia;

/**
 *
 * @author luiz.ferreira
 */
public class AlgoritmoSimulatedAnnealing {
    
    public void inicia(){}
    public void gerarVizinho(){}
    public void calculaCusto(){}
    
    
}

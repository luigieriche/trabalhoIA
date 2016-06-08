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

/**
 *
 * @author luiz.ferreira
 */
public class AgoritmoGenetico {
    
    void inicia_populacao(Empresa empresa){}//Gera por meio da mutação a população inicial
    void avalicao(){}//calcula a avaliação da população
    void seleciona_pais(){} //função fit que fará a selação dos pais por meio de um modelo de seleção "Roleta", por exemplo
    void recombinacao(){} // Aplica técnica de recombinação entre os pais "Cromossomos", por exemplo
    void mutacao(){} // Realiza mutação entre os indivíduos gerados
    void sobrevivem(){} // Seleção dos indivíduos que irão sobreviver para a próxima interação
}

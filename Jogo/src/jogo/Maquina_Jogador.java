
package jogo;
import java.util.Random;//Importar a classe Random

public class Maquina_Jogador {
    public int jogada(){
        Random random = new Random();
        int num_Aleatorio = random.nextInt(3);//Gera número aleatório de 0 a 8
        
        return num_Aleatorio;
    }
}

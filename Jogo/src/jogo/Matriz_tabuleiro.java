
package jogo;

public class Matriz_tabuleiro {
    public int linha;
    public int coluna;
    
    public static void imprimirTabuleiro(char[][]Matriz) {
        for (int i=0; i < Matriz.length; i++) {
            for (int col = 0; col < Matriz[i].length; col++) {
                System.out.print(Matriz[i][col]);
                if(col < Matriz[i].length - 1){
                System.out.print(" | ");
                }
            }
            System.out.println();
            if(i < Matriz.length - 1){
                System.out.println("---------");
            }
        }
    }
    //Método para checar possíveis vitórias
    public static boolean checar_Vencedor(char[][]matriz, char jogador){
        //Testar linhas e colunas
        for(int a=0;a < matriz.length;a++){
            if((matriz[a][0] == jogador && matriz[a][1] == jogador && matriz[a][2] == jogador)||
                (matriz[0][a] == jogador && matriz[1][a] == jogador && matriz[2][a]== jogador)){ 
                return true;
            }
        }//Testando as diagonais
        if((matriz[0][0] == jogador && matriz[1][1] == jogador && matriz[2][2] == jogador)||
           (matriz[0][2] == jogador && matriz[1][1] == jogador && matriz[2][0] == jogador)){
            return true;
        }
        return false;
    }
}

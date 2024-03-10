package jogo;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        char[][] Matriz = new char[3][3]; //Criei uma matriz 3X3
        Maquina_Jogador maquina = new Maquina_Jogador();
        int jogadas_realizadas = 0;
        int limite_jogadas = 9;//Limite de 9 jogadas
        Scanner ler = new Scanner(System.in);
        char simbolo_X = 'X';
        char simbolo_O = 'O';
        
        //Prencher a Matriz com valores vasios
        for(int a= 0;a < Matriz.length;a++){
            for(int b=0; b < Matriz[a].length;b++){
                Matriz[a][b]=' ';
            }
        }
      
        System.out.println("*-*-* J O G O   D A   V E L H A *-*-*\n");
        
        Matriz_tabuleiro.imprimirTabuleiro(Matriz);
        
        //Preencher a matriz usando valores aleatórios usando o método jogada
        while(jogadas_realizadas < limite_jogadas){
            if(jogadas_realizadas % 2 == 0){
                System.out.println("\nJogador 1, selecione entre 0 e 2:");
                System.out.println("Linha: ");
                int linha = ler.nextInt();
                System.out.println("Coluna: ");
                int coluna = ler.nextInt();
                if(0 <= linha && linha <= 2 && 0 <= coluna && coluna <= 2){//Testando as jogadas do jogador 1
                    if(Matriz[linha][coluna] == ' '){
                    Matriz[linha][coluna] = simbolo_X;
                    jogadas_realizadas++;
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
                    Matriz_tabuleiro.imprimirTabuleiro(Matriz);
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
                    if(Matriz_tabuleiro.checar_Vencedor(Matriz, simbolo_X)){
                        System.out.println("Jogador 1 é o vencedor!!!");
                        break;
                    }
                    }else{
                        System.out.println("Essa posição já está ocupada. Tente outra posição!!!\n");  
                    }
                }else{
                    System.out.println("Linha e coluna inválida. Tente novamente!");
                }  
            }else{//Jogada da máquina
                int linha = maquina.jogada();//Gera número aleatório para linha
                int coluna = maquina.jogada();//Gera número aleatório para coluna
                while(Matriz[linha][coluna] != ' '){
                    linha = maquina.jogada();
                    coluna = maquina.jogada();
                }
                System.out.println("\nJogador 2 jogou:\nLinha: "+ linha);
                System.out.println("Coluna: "+ coluna);
                Matriz[linha][coluna] = simbolo_O;
                jogadas_realizadas++;
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
                Matriz_tabuleiro.imprimirTabuleiro(Matriz);
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
                if(Matriz_tabuleiro.checar_Vencedor(Matriz, simbolo_O)){
                    System.out.println("Jogador 2 (Máquina) é o vencedor!!!");
                    break;
                }
            }
            if(jogadas_realizadas == limite_jogadas){
                System.out.println("Empate!!!");
                break;
            }
        } 
    } 
}

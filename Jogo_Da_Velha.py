from random import randint

Matriz = [[' ' for _ in range(3)] for _ in range(3)]
c = pos = num_jogadas = 0
limite_jogadas = 9
simbolo_X = 'X'
simbolo_O = 'O'
linha = coluna = 0

#Criando a função para imprimir o tabuleiro
def imprimir_tabuleiro(Matriz): 
    for linha in Matriz:
        print("|".join(linha))
        print("-"*5)

print("*-*-* J O G O   D A   V E L H A *-*-*")

imprimir_tabuleiro(Matriz)

#Função para checar vitória
def checar_vitoria(Matriz, jogador):
    #Testar linhas e coluna
    for a in range(len(Matriz)):
        if (Matriz[a][0] == jogador and Matriz[a][1] == jogador and Matriz[a][2] == jogador) or \
        (Matriz[0][a] == jogador and Matriz[1][a] == jogador and Matriz[2][a] == jogador):
            return True
        if(Matriz[0][0] == jogador and Matriz[1][1] == jogador and Matriz[2][2] == jogador) or \
           (Matriz[0][2] == jogador and Matriz[1][1] == jogador and Matriz[2][0] == jogador):
            return True
    return False

#Função de jogada da máquina
def jogada_maquina():
    randint(0, 2)

while num_jogadas < limite_jogadas:
    if num_jogadas % 2 == 0:#Jogada jogador
        print("Jogador 1, escolha a linha e a coluna:")
        linha = int(input("Linha (0 a 2): "))
        coluna = int(input("Coluna (0 a 2): "))
        if 0 <= linha and linha <= 2 and 0 <= coluna and coluna <= 2:
            if Matriz[linha][coluna] == ' ':
                Matriz[linha][coluna] = simbolo_X
                print("=="* 20)
                imprimir_tabuleiro(Matriz)
                print("=="* 20)
                num_jogadas+=1
                if checar_vitoria(Matriz, simbolo_X):
                    print("Jogador 1 é o vencedor!!!")
                    break
            else:
                print("Essa posição já está acupada. Tente novamente!")
    else:#Jogada da máquina
        linha, coluna = randint(0, 2), randint(0, 2)
        if Matriz[linha][coluna] == ' ':
            print(f"O jogador 2 (Maquina) escolheu a linha {linha} e a coluna {coluna}")
            Matriz[linha][coluna] = simbolo_O
            print("=="* 20)
            imprimir_tabuleiro(Matriz)
            print("=="* 20)
            num_jogadas+=1
            if checar_vitoria(Matriz, simbolo_O):
                print("Jogador 2 (Maquina) é o vencedor!!!")
                break
        if num_jogadas == limite_jogadas:
            print("Empate!!!")

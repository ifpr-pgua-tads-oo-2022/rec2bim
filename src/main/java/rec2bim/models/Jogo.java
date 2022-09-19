package rec2bim.models;

import java.util.Random;

public class Jogo {
    
    private int tentativas;
    private int sorteado;
    private int max=-1;
    private final Random rnd;
    private boolean inicializado;
    
    public Jogo(){
        rnd = new Random(System.currentTimeMillis());
    }
    /**
     * Seta o valor para o limite máximo do gerador
     * de números aletórios.
     * 
     * @param max limite superior do gerador de números aleatórios.
     */
    public void setMax(int max){
        this.max = max;
    }


    /**
     * Inicializa o estado do jogo, colocando tentativas=0 e 
     * sorteia um novo valor. Deve ser invocado ao iniciar um novo
     * jogo.
     * 
     * @throws NaoIniciadoException o método setMax deve ser invocado antes de iniciar.
     */
    public void iniciar() throws NaoIniciadoException{
        if(max == -1){
            throw new NaoIniciadoException("O valor do máximo não foi iniciado. Invoque setMax para indicar o valor máximo do gerador de números aleatórios.");
        }
        tentativas = 0;
        sorteado = rnd.nextInt(max);
        inicializado = true;
    }

    /**
     * Compara o palpite do usuário recebido por parâmetro
     * com o número sorteado. Se o palpite for igual ao
     * sorteado retorna 0. Se for maior retorna 1, se for menor -1.
     * 
     * @param val int indica o palpite do usuário
     * @return 0 se val==sorteado, 1 se val > sorteado, -1 se val < sorteado
     * 
     * @throws NaoIniciadoExeption o método iniciar deve ser invocado antes da primeira tentativa.
     */
    public int tentar(int val) throws NaoIniciadoException{
        if(!inicializado){
            throw new NaoIniciadoException("O método iniciar deve ser invocado antes de uma tentativa!");
        }
        tentativas += 1;
        if(val == sorteado){
            inicializado = false;
            return 0;
        }else if(val > sorteado){
            return 1;
        }else{
            return -1;
        }
    }
    /**
     * Permite acessar o número de tentativas até o momento
     * @return int tentativas
     */
    public int getTentativas(){
        return tentativas;
    }

}

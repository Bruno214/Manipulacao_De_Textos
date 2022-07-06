import java.util.Random;

public class Texto {
    //Classe texto para modelar um texto, tratar e retirar informações

    protected Frase[] frases;  // vetor de Frases
    public int TAMANHO_MAXIMO = 1000;
    protected String conteudoTexto;
    private int qtdpalavras;



    public Texto(String conteudoTexto) {
        // construtor da classe texto
        this.conteudoTexto = conteudoTexto;
        this.frases = new Frase[TAMANHO_MAXIMO];
        this.qtdpalavras = 0;
        //chamada do metodo de criar as frases
        criarFrase();
    }

    public void criarFrase(){
        // Este metodo pega o texto passado e
        // a cada ponto final cria uma nova frase na posição disponivel no vetor frases
        // A ideia da lógica é que eu leio cada letra do texto ate encontrar um ponto e colocar no vetor

        String var = "";
        int cont = 0;

        for (char letra : this.conteudoTexto.toCharArray()){
            var += letra;

            if(letra == '.'){
                frases[cont] = new Frase(var);
                cont++;
                var = "";
            }
        }
    }

    public void substitui(String palavraVelha, String palavraNova){
        //metodo que faz a troca de palavras no texto
        for (int i = 0; i < frases.length - 1; i++) {
            if (frases[i] != null) {
                frases[i].setConteudoFrase(frases[i].getConteudoFrase().replace(palavraVelha, palavraNova));
            }
        }
    }

    public Texto adicionaFrase(Frase novaFrase){
        // método para adicionar uma nova frase ao vetor frases na posição disponivel
        for (int i = 0; i < frases.length - 1; i++) {
            if (frases[i] == null) {
                frases[i] = novaFrase;
                break;
            }
        }
        return this;
    }

    public void adicionaFrase(String fraseNova){
        // método para adicionar uma nova frase ao vetor frases na posição disponivel so que
        // agora a frase é do tipo String
        for (int i = 0; i < frases.length - 1; i++) {
            if (frases[i] == null) {
                frases[i] = new Frase(fraseNova);
                break;
            }

        }

    }

    public int getQtdpalavras(){
        return this.qtdpalavras;
    }

    public void setQtdpalavras(int valor){
        this.qtdpalavras = valor;
    }

    public int getQuantidadePalavras() {
        //Metodo que conta a quantidade de palavras no Texto
        // a ideia aqui é criar um vetor de palavras no final o for pega somente palavras
        // nao pega possiveis espaços ou algo do tipo
        String var = "";
        int contaPalavra = 0;
        int cont = 0;
        String[] palavras = new String[10000];

        for (int i = 0; i < frases.length - 1; i++) {
            if(frases[i] != null){
                for(char letra : frases[i].getConteudoFrase().toCharArray()){
                    if(Character.isLetter(letra)){
                        var += letra;
                    }else{
                        palavras[cont] = var;
                        cont++;
                        var = "";
                    }
                }
            }else{
                break;
            }
        }
        for (String plv: palavras) {
            if (plv != null && (!plv.equalsIgnoreCase(""))){
                contaPalavra++;
            }
        }
        this.setQtdpalavras(contaPalavra);
    return contaPalavra;
    }


    public int getTempoEstimadoLeitura() {
        // retorna o tempo estimado de leitura do texto sendo 1 minuto a cada 200 palavras
        if (this.qtdpalavras <= 200 )
            return 1;

        return this.qtdpalavras / 200;
        
    }
    public String getFrasesCom(String palavra) {
        // Este metodo retorna todas as frases que tem a palavra passada no paramentro
        // A logica aqui é que ler letra por letra ate que ache algo que nao seje letra como um espaço
        // quando isso ocorre significa que temos uma palavra então se for a palavra procurada
        // concateno na string frase para depois retornar as frases que tem a palavra buscada
        
        String frase = "";
        String var = "";
        String aux = "";

        for (int i = 0; i < frases.length - 1; i++) {
            if (frases[i] != null){
                aux = frases[i].getConteudoFrase();
                for(char letra : aux.toCharArray()){
                    if((!Character.isLetter(letra))){
                        if (var.equalsIgnoreCase(palavra)){
                            frase += aux.trim();
                            var = "";
                            break;
                        }else{
                            var = "";
                        }
                    }else {

                        var += letra;
                    }
                }
            }else {
                break;
            }
        }
        return frase;
    }

    public Frase getFraseAleatoria(){
        // metodo que retorna uma frase aleatoria o vetorAux foi criado para nao acontecer de retornar uma
        // frase null
        Random fraseAleatoria = new Random();
        Frase[] vetorAux = new Frase[1000];
        int cont = 0;

        for (int i = 0; i < frases.length - 1; i++) {
            if(frases[i] != null){
                vetorAux[i] = frases[i];
                cont++;
            }else{
                break;
            }
        }
        return vetorAux[fraseAleatoria.nextInt(cont)];
    }
    
    
    public String toString(){
        // metodo que faz a impressão do Texto
        // Explicando o ponteiro criado foi para que a última frase impressa não quebrasse
        // a linha para não mudar a saída do programa

        String strRetorno = "\n";
        Frase ponteiro = null;

        for (int i = 0; i < frases.length - 1; i++) {
            ponteiro = frases[i + 1];
            if(frases[i] != null){
                strRetorno += frases[i].getConteudoFrase().trim(); // função trim() remove os espaços iniciais e finais
                if(ponteiro != null){
                    strRetorno += "\n";
                }
            }else {
                break;
            }
        }
        return strRetorno;
    }
    
}
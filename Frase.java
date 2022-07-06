public class Frase {
    /*Classe Frase que tem o conteudo das frases
     * */
    private String conteudoFrase;

    public Frase(String conteudoFrase){
        // construtor de Frase
        this.conteudoFrase = conteudoFrase;
    }

    //Criar meus get e set para acessar o conteudo de frase no vetor
    public String getConteudoFrase(){
        return this.conteudoFrase;
    }

    public void setConteudoFrase(String frase){
        this.conteudoFrase = frase;
    }

    public String toString(){
        return this.conteudoFrase.trim(); // trim() tira espações do inicio e no fim na empressão
    }
}

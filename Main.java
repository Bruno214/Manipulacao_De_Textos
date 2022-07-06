/*

Desenvolvedor:  Bruno Da Silva Barcelos
Linkedin: https://www.linkedin.com/in/bruno-silva-27a81a219/
 */

public class Main {
    public static void main(String[] args) {
        Texto teste = new Texto("Diz a sabedoria popular que um homem só tem uma vida completa quando planta " +
                "uma árvore, escreve um livro e tem um filho. Ao meu ver, não se diz isso pensando de forma " +
                "literal, mas sim na importância abstrata destes feitos. Ao plantar uma árvore, demonstramos" +
                " preocupação com o ambiente onde vivemos. Ao ter um filho, amamos ao próximo " +
                "incondicionalmente. Ao escrever um livro, desejamos compartilhar e \"eternizar\" o " +
                "conhecimento adquirido.");


        teste.substitui("popular", "do povo");
        teste.adicionaFrase(new Frase("Claramente conseguimos realizar estes feitos " +
                "abstratos de diferentes maneiras.")).adicionaFrase("O importante é ter consciência da importância destes.");

        System.out.println("Qtd: " + teste.getQuantidadePalavras());
        System.out.println("Tempo: " + teste.getTempoEstimadoLeitura() + " minuto(s)");
        System.out.println("Texto recuperado: " + teste);
        System.out.println("Frases com:\n" + teste.getFrasesCom("livro"));
        System.out.println("Aleatória:\n" + teste.getFraseAleatoria());
    }

}

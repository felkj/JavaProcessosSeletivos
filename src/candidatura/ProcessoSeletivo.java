package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", 
        "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JOEL"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }

    }
    static void imprimirSelecionados(){
    String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JOEL"};
    System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

    for(int indice=0; indice < candidatos.length; indice++){
        System.out.println("O candidato de nº " + (indice+1) + " é " + candidatos[indice]);
    }
    System.out.println("Forma abreviada de interação for each");

    for(String candidato: candidatos){
        entrandoEmContato(candidato);
    }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuaTentando = !atendeu;
            if(continuaTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("CONTATO REALIZADO COM SUCESSO ");
            }
        }while(continuaTentando && tentativasRealizadas< 3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM "+ candidato + " NA " + tentativasRealizadas+ "º TENTATIVA.");
        }else{
            System.out.println("NÃO CONSEGUIMOS CONTATO COM "+ candidato + ", NUMERO MAXIMO DE TENTATIVAS.");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }


    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JOEL"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+ candidato + " Solicitou este valor de salario "+ salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidatro " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }else{
                System.out.println("O candidatro " + candidato + " não foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
        }

        static double valorPretendido(){
            return ThreadLocalRandom.current().nextDouble(1800, 2200);
        }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA CANDIDATO");
        }else if(salarioBase==salarioPretendido){
            System.out.println("LIGAR PARA CANDIDATO COM CONTRAPROPOSTA");
        }else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    
}

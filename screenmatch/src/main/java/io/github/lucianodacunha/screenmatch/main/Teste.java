package io.github.lucianodacunha.screenmatch.main;

import org.springframework.cglib.core.Local;

import java.util.*;
import java.util.stream.Stream;

public class Teste {
    public static void main(String[] args) {

        paraSaberMaisStreams();
    }

    static void paraSaberMaisStream(){
        List<Integer> list = Arrays.asList(1, 3, 4, 5);
        System.out.println(list);

        int value = list.stream()
                .peek(n -> System.out.println("Elem: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Content after map: " + n))
                .reduce(0, Integer::sum);

        System.out.println("Value: " + value);
    }

    static void paraSaberMaisOptimal(){
        Optional<String> nome = getString();
        System.out.println(
                "Valor digitado: " + nome.orElse("Não digitado"));
    }

    static Optional<String> getString(){
        Scanner input = new Scanner(System.in);
        System.out.print("Entre com o seu nome: ");
        String nome = null;
        return Optional.ofNullable(nome);
    }

    static void paraSaberMaisFindAny(){
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i <= 100; i++){
            numeros.add(i);
        }

        for(int i = 0; i < 5; i++) {
            Optional<Integer> numeroQualquer = numeros.parallelStream()
                    .filter(n -> n % 10 == 0)
                    .findAny();
            if (numeroQualquer.isPresent()) {
                System.out.println("Encontrado: " + numeroQualquer.get() + ".");
            } else {
                System.out.println("Nenhum numero encontrado.");
            }
        }
    }

    static void paraSaberMaisStats(){
        Locale.setDefault(Locale.US);
        List<Integer> inteiros = Arrays.asList(1, 3, 4, 5);
        IntSummaryStatistics stat = new IntSummaryStatistics();
        for(int i : inteiros) stat.accept(i);

        System.out.printf("""
                %25s %02d
                %25s %02d
                %25s %02d
                %25s %02d\n""",
                "Quantidade de elementos: ", stat.getCount(),
                "Soma dos elementos: ", stat.getSum(),
                "Menor elemento: ", stat.getMin(),
                "Maior elemento: ", stat.getMax(),
                "Média dos elementos: ",  stat.getAverage());
    }

    static void paraSaberMaisStreams(){
        // loop
        Stream.iterate(0, n -> n  +1)
                .limit(10)
                .forEach(System.out::print);

        System.out.println();

        // achatamento de streams
        List<List<String>> list = List.of(
                List.of("a", "b"),
                List.of("c", "d")
        );

        Stream<String> stream = list.stream()
                .flatMap(Collection::stream);

        stream.forEach(System.out::println);

        // redução
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.stream().reduce(Integer::sum);
        result.ifPresent(System.out::println); //prints 15


    }


}

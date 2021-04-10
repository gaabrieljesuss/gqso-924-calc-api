package br.edu.ifal.gqso;

public class Calculadora {
    public class DivisaoPorZeroException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    public class EntradaInvalidaException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    // Soma dois inteiros.
    public int soma(int a, int b) {
        return a + b;
    }

    public double divide(int dividendo, int divisor) throws DivisaoPorZeroException {
        if (divisor == 0) {
            throw new DivisaoPorZeroException();
        }
        return dividendo / divisor;
    }

    public double fromString(String str) throws DivisaoPorZeroException, EntradaInvalidaException {
        try {
            final Operacao op = encontraOperacao(str);
            switch (op) {
                case SOMA:
                    String[] parcelas = str.split("\\+");
                    int parc1 = Integer.parseInt(parcelas[0]);
                    int parc2 = Integer.parseInt(parcelas[1]);
                    return soma(parc1, parc2);
                case DIVISAO:
                    String[] divs = str.split("\\/");
                    int dividendo = Integer.parseInt(divs[0]);
                    int divisor = Integer.parseInt(divs[1]);
                    return divide(dividendo, divisor);
                default:
            }
        } catch (NumberFormatException e) {
            throw new EntradaInvalidaException();
        }
        return 0;
    }

    private enum Operacao {
        SOMA, SUBTRACAO, DIVISAO, MULTIPLICACAO, DESCONHECIDA;
    }

    private Operacao encontraOperacao(String op) {
        if (op.contains("+")) {
            return Operacao.SOMA;
        }
        if (op.contains("/")) {
            return Operacao.DIVISAO;
        }
        return Operacao.DESCONHECIDA;
    }
}
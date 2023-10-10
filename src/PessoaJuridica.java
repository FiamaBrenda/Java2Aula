public class PessoaJuridica extends Pessoa {
    public String cnpj;
    public float CalcularImposto(float rendimento) {
        /* ate 1500 isento
        de 1,5k a 3,5k - 2%
        acima  3,5k a 6k 3.5%
        acima de 6k - 5%
         */

        if (rendimento <= 3000) {
            return rendimento * .03f;
        } else if (rendimento <= 6000) {
            return rendimento * .05f;

        } else if (rendimento <= 10000) {
            return rendimento * .07f;
        } else {
            return rendimento * .09f;
        }

    }
}

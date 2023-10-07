import java.time.LocalDate;

public class PessoaFisica extends Pessoa{
    public String cpf;
    public LocalDate dtNasc;

    public float CalcularImposto(float rendimento) {
        /* ate 1500 isento
        de 1,5k a 3,5k - 2%
        acima  3,5k a 6k 3.5%
        acima de 6k - 5%
         */

        if (rendimento <= 1500) {
            return 0;
        } else if (rendimento <= 3500) {
            return rendimento * .02f;

        } else if (rendimento <= 3500) {
            return rendimento * .035f;
        } else {
            return rendimento * .05f;
        }

    }
}

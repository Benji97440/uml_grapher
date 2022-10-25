package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SampleTest {

    private final Sample sample = new Sample();

    @Test
    void add_2_and_2_should_return_4() {
        int result = sample.op(Sample.Operation.ADD, 2, 2);

        Assertions.assertThat(result)
            .as("Addition of 2 and 2")
            .isEqualTo(4);
    }
    @Test
    void mult_2_and_2_should_return_4() {
        int result = sample.op(Sample.Operation.MULT, 2, 2);

        Assertions.assertThat(result)
            .as("Multiplication of 2 and 2")
            .isEqualTo(4);
    }
    @Test
    void fact_6() {
        int result = sample.fact(6);

        Assertions.assertThat(result)
            .as("Factorisation of 6")
            .isEqualTo(720);
    }
    @Test
    void sample_fact_nbellowzero_return() {
        var sample = new Sample();

        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> sample.fact(-12))
            .withMessage("N should be positive");
    }
}

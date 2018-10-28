package io.vasiliyplatonov;

import io.vasiliyplatonov.helpers.SetWorker;
import io.vasiliyplatonov.helpers.Universe;
import org.assertj.core.api.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static io.vasiliyplatonov.helpers.Universe.LOW_RUS_LETTERS;

public class SetWorkerTest {

    @Test
    public void isSetIncludedInUniverse() {
        // positive tests
        String set = "фбаыфщоффоы";
        assertThat(SetWorker.isSetIncludedInUniverse(LOW_RUS_LETTERS, set)).isTrue();


        // negative tests
        String setWithNum = "фбаыфщо23ффоы";
        assertThat(SetWorker.isSetIncludedInUniverse(LOW_RUS_LETTERS, setWithNum)).isFalse();

        String setWithLatin = "фбаыфщоdafффоы";
        assertThat(SetWorker.isSetIncludedInUniverse(LOW_RUS_LETTERS, setWithLatin)).isFalse();

        setWithLatin = "fsaassa";
        assertThat(SetWorker.isSetIncludedInUniverse(LOW_RUS_LETTERS, setWithLatin)).isFalse();

        String setWithSpace = "фбаыфщ ффоы";
        assertThat(SetWorker.isSetIncludedInUniverse(LOW_RUS_LETTERS, setWithSpace)).isFalse();
    }

    @Test
    public void getNormalizeSet() {
        String testStr = "adsьвыфол31дф";
        String expected = "ьвыфолдф";

        assertThat(SetWorker.getNormalizeSet(LOW_RUS_LETTERS, testStr)).isEqualTo(expected);
    }

    @Test
    public void getLetterLinkedList() {
        String testStr = "флафылжж";

        assertThat(SetWorker.getLetterLinkedList(testStr))
                .isNotNull()
                .isNotEmpty()
                .containsExactly('ф', 'л', 'а', 'ф', 'ы', 'л', 'ж', 'ж');

        assertThat(SetWorker.getLetterLinkedList("   "))
                .isNotNull()
                .isNotEmpty()
                .containsExactly(' ', ' ', ' ');

        assertThat(SetWorker.getLetterLinkedList(null))
                .isNotNull()
                .isEmpty();



    }

}

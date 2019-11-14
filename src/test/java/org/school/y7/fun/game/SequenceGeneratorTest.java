package org.school.y7.fun.game;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.school.y7.fun.game.rule.NumberRule;

import java.io.IOException;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.school.y7.fun.game.rule.RulesBuilder;
import org.school.y7.fun.game.util.FunGamesUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.school.y7.fun.game.util.FunGamesUtils.BUZZ_TEXT;
import static org.school.y7.fun.game.util.FunGamesUtils.FIZZ_BUZZ_TEXT;
import static org.school.y7.fun.game.util.FunGamesUtils.FIZZ_TEXT;

public class SequenceGeneratorTest {

    private static List<NumberRule<String>> threeAndFiveNumberRules;

    @BeforeClass
    public static void setUp() {

        threeAndFiveNumberRules = new RulesBuilder()
                .withNumberThreeAndFiveRules()
                .getRules();
    }

    @Test
    public void should_generate_Fizz_when_number_is_3() {

        String sequence = getSequenceGenerator(3,3, threeAndFiveNumberRules).generateStageOneSequence();
        assertThat(sequence, CoreMatchers.is(FIZZ_TEXT));
    }

    @Test
    public void should_generate_Buzz_when_message_is_5() {

        String sequence = getSequenceGenerator(5,5, threeAndFiveNumberRules).generateStageOneSequence();
        assertThat(sequence, CoreMatchers.is(BUZZ_TEXT));
    }

    @Test
    public void should_generate_FizzBuzz_when_number_is_15() {

        String sequence = getSequenceGenerator(15,15, threeAndFiveNumberRules).generateStageOneSequence();
        assertThat(sequence, CoreMatchers.is(FunGamesUtils.FIZZ_BUZZ_TEXT));
    }

    @Test
    public void should_generate_numbers_when_numbers_are_7_and_8() {

        String sequence = getSequenceGenerator(7,8, threeAndFiveNumberRules).generateStageOneSequence();
        assertThat(sequence, is("7\n8"));
    }

    @Test
    public void should_generate_NumberFizz_when_numbers_are_8_and_9() {
        
        String sequence = getSequenceGenerator(8,9, threeAndFiveNumberRules).generateStageOneSequence();
        assertThat(sequence, is("8\n" + FIZZ_TEXT));
    }

    @Test
    public void should_generate_NumberFizzNumber_when_number_range_11_to_13() {

        String sequence = getSequenceGenerator(11,13, threeAndFiveNumberRules).generateStageOneSequence();
        assertThat(sequence, is("11\n" + FIZZ_TEXT + "\n13"));
    }

    @Test
    public void should_generate_Fizz_in_stage_2_when_number_is_13() {

        String sequence = getSequenceGenerator(13,13, threeAndFiveNumberRules).generateStageTwoSequence();
        assertThat(sequence, is(FIZZ_TEXT));
    }

    @Test
    public void should_generate_FizzBuzz_in_stage_2_when_number_is_53() {

        String sequence = getSequenceGenerator(53,53, threeAndFiveNumberRules).generateStageTwoSequence();
        assertThat(sequence, is(FIZZ_BUZZ_TEXT));
    }

    @Test
    public void should_generate_fun_sequence_stage_1_when_number_range_1_to_100() throws IOException {

        String str = IOUtils.toString(this.getClass().getResourceAsStream("/sequence.txt"),
                "UTF-8");
        String sequence = getSequenceGenerator(1,100, threeAndFiveNumberRules).generateStageOneSequence();
        assertThat(sequence, is(str));
    }

    @Test
    public void should_generate_fun_sequence_stage_2_when_number_range_1_to_100() throws IOException {

        String str = IOUtils.toString(this.getClass().getResourceAsStream("/stage_two_sequence.txt"),
                "UTF-8");
        String sequence = getSequenceGenerator(1,100, threeAndFiveNumberRules).generateStageTwoSequence();
        assertThat(sequence, is(str));
    }

    private SequenceGenerator getSequenceGenerator(int startId, int endId,
                                                   List<NumberRule<String>> rules) {
        return new SequenceGenerator(startId, endId, rules);
    }
}
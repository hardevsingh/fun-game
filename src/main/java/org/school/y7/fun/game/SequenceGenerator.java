package org.school.y7.fun.game;

import org.school.y7.fun.game.rule.NumberRule;
import org.school.y7.fun.game.rule.NumberRuleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class SequenceGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(SequenceGenerator.class);
    private int startId;
    private int endId;
    private List<NumberRule<String>> rules;

    private static Predicate<NumberRule<String>> isNumberMultiple(int id) {
        return rule -> rule.isNumberMultiple(id);
    }

    private static Predicate<NumberRule<String>> isNumberMultipleOrContains(int id) {
        return rule -> rule.isNumberMultiple(id) || rule.containsNumber(id);
    }

    public SequenceGenerator(int startId, int endId, List<NumberRule<String>> rules) {
        this.startId = startId;
        this.endId = endId;
        this.rules = rules;
    }

    public String generateStageOneSequence() {

        final String sequence = rangeClosed(startId, endId)
                .mapToObj(id -> generateMessage(id, isNumberMultiple(id)))
                .collect(joining(LF));
        LOGGER.info(sequence);
        return sequence;
    }

    public String generateStageTwoSequence() {

        final String sequence = rangeClosed(startId, endId)
                .mapToObj(id -> generateMessage(id, isNumberMultipleOrContains(id)))
                .collect(joining(LF));
        LOGGER.info(sequence);
        return sequence;
    }

    private String generateMessage(int id, Predicate<NumberRule<String>> rule) {

        final String message = rules.stream()
                .filter(rule)
                .map(NumberRuleBase::generateMessage)
                .collect(joining(EMPTY));
        return  isEmpty(message) ? EMPTY + id : message;
    }
}

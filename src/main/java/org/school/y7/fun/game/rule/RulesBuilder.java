package org.school.y7.fun.game.rule;

import java.util.ArrayList;
import java.util.List;

import static org.school.y7.fun.game.util.FunGamesUtils.BUZZ_TEXT;
import static org.school.y7.fun.game.util.FunGamesUtils.FIZZ_TEXT;

public final class RulesBuilder {

    private List<NumberRule<String>> rules;
    private static NumberRule<String> NUMBER_THREE_RULE = new NumberRule<>(3, FIZZ_TEXT);
    private static NumberRule<String> NUMBER_FIVE_RULE = new NumberRule<>(5, BUZZ_TEXT);

    public RulesBuilder () {
        rules = new ArrayList<>();
    }

    public RulesBuilder withNumberThreeRule() {
        rules.add(NUMBER_THREE_RULE);
        return this;
    }

    public RulesBuilder withNumberFiveRule() {
        rules.add(NUMBER_FIVE_RULE);
        return this;
    }

    public RulesBuilder withNumberThreeAndFiveRules() {
        rules.add(NUMBER_THREE_RULE);
        rules.add(NUMBER_FIVE_RULE);
        return this;
    }

    public List<NumberRule<String>> getRules() {
        return rules;
    }
}

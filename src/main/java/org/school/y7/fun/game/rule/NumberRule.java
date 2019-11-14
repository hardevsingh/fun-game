package org.school.y7.fun.game.rule;

public class NumberRule<V> extends NumberRuleBase<V> {

    private V message;

    public NumberRule(int number, V message) {
        super(number);
        this.message = message;
    }

    @Override
    public V getMessage() {
        return message;
    }
}

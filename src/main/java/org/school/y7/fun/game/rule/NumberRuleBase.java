package org.school.y7.fun.game.rule;

public abstract class NumberRuleBase<V> {

    private int id;

    public NumberRuleBase(int id) {
        this.id = id;
    }

    public boolean isNumberMultiple(int id) {
        return id % this.id == 0;
    }

    public boolean containsNumber(int id) {
        return String.valueOf(id).contains(String.valueOf(this.id));
    }

    public V generateMessage() {
        return getMessage();
    }

    public abstract V getMessage();
}

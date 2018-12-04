/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author janne
 */
public class Querybuilder {
    private Matcher matcher;

    public Querybuilder() {
        matcher = new All();
    }
    
    public Matcher build() {
        Matcher builtMatcher = matcher;
        this.matcher = new All();
        return builtMatcher;
    }
    
    Querybuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    Querybuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }

    Querybuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    Querybuilder oneOf(Matcher first, Matcher second) {
        this.matcher = new Or(first, second);
        return this;
    }
}

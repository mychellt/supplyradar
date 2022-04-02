package br.com.supplyradar.domain.visitors;

public interface Visitable<T> {
    public void accept(final Visitor<T, ?> visitor);
}

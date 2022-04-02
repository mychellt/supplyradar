package br.com.supplyradar.domain.visitors;

public interface Visitor<T, R> {
    public R visit(final T obj);
}

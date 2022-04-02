package br.com.supplyradar.core.command;

public interface Command<R> {
    R process(final CommandContext context);
}

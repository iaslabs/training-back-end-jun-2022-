package com.co.ias.market.commons;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}

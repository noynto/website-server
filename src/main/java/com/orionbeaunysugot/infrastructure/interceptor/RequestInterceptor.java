package com.orionbeaunysugot.infrastructure.interceptor;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;

@Filter(Filter.MATCH_ALL_PATTERN)
public class RequestInterceptor implements HttpServerFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        logger.info("IP Address: {}, Path: {}", request.getRemoteAddress().getHostName(), request.getPath());
        return chain.proceed(request);
    }

}

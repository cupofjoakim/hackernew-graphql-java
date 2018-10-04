package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;

import java.util.List;

public class Query {

    private final LinkRepository linkRepository;

    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GraphQLQuery //2
    public List<Link> allLinks(LinkFilter filter,
                               @GraphQLArgument(name = "skip", defaultValue = "0") Number skip, //3
                               @GraphQLArgument(name = "first", defaultValue = "0") Number first) {
        return linkRepository.getAllLinks(filter, skip.intValue(), first.intValue());
    }
}


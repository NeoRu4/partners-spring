package com.delta.partners.graphql.resolver;

import com.delta.partners.domain.entity.Person;
import com.delta.partners.service.PersonService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@GraphQLApi
public class PartnerQueryResolver {

    @Autowired
    private PersonService personService;

    @GraphQLQuery(name="findPersons")
    public Iterable<Person> findPersons() {
        return personService.findAll();
    }

    @GraphQLMutation(name="addPerson")
    public Person addPerson(@GraphQLArgument(name = "person") Person person) {
        return personService.addPerson(person);
    }
}

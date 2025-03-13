package be.pxl.services.federationgateway.scalar;

import com.netflix.graphql.dgs.DgsScalar;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@DgsScalar(name = "DateTime")
public class DateTimeScalar implements Coercing<LocalDateTime, String> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
        if (dataFetcherResult instanceof LocalDateTime) {
            return ((LocalDateTime) dataFetcherResult).format(FORMATTER);
        }
        throw new CoercingSerializeException("Invalid value for LocalDateTime: " + dataFetcherResult);
    }

    @Override
    public LocalDateTime parseValue(Object input) throws CoercingParseValueException {
        if (input instanceof String) {
            return LocalDateTime.parse((String) input, FORMATTER);
        }
        throw new CoercingParseValueException("Invalid value for LocalDateTime: " + input);
    }

    @Override
    public LocalDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
        if (input instanceof String) {
            return LocalDateTime.parse((String) input, FORMATTER);
        }
        throw new CoercingParseLiteralException("Invalid literal for LocalDateTime: " + input);
    }
}

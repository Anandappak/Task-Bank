package com.example.server.xmlEntity;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.OffsetDateTime;

public class OffsetDateTimeAdapter
        extends XmlAdapter<String, OffsetDateTime> {

    @Override
    public OffsetDateTime unmarshal(String value) {
        return OffsetDateTime.parse(value);
    }

    @Override
    public String marshal(OffsetDateTime value) {
        return value.toString();
    }
}

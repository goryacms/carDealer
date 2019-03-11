package com.company.cardealer.datatypes;

import com.google.common.base.Strings;
import com.haulmont.chile.core.annotations.JavaClass;
import com.haulmont.chile.core.datatypes.Datatype;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Pattern;

@JavaClass(String.class)
public class PhoneDataType implements Datatype<String> {

    private final Pattern PHONE_PATTERN = Pattern.compile("^\\+7(\\s?\\d?\\s?){7,14}$");

    @Override
    public String format(@Nullable Object value) {
        if (value == null)
            return "";
        /**
         * TODO: добавить анализ на первый символ: если 8, то заменить на +7
         */
        return (String) value;
    }

    @Override
    public String format(@Nullable Object value, Locale locale) {
        return format(value);
    }

    @Nullable
    @Override
    public String parse(@Nullable String value) throws ParseException {
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }

        if (!PHONE_PATTERN.matcher(value).matches()) {
            throw new ParseException("Invalid phone", 0);
        }

        return value;
    }

    @Nullable
    @Override
    public String parse(@Nullable String value, Locale locale) throws ParseException {
        /**
         * TODO: рефакторить код с учётом локализации
         */
        return parse(value);
    }

}

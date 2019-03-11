package com.company.cardealer.service;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;

import java.math.BigDecimal;

@Source(type = SourceType.APP)
public interface CardealerConfig extends Config {
    @Property("cardealer.tax-rate")
    BigDecimal getTaxRate();
}

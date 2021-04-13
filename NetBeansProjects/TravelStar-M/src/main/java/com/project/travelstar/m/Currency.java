
package com.project.travelstar.m;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Currency implements Serializable
{

    private String code;
    private String symbol;
    private String thousandsSeparator;
    private String decimalSeparator;
    private Boolean symbolOnLeft;
    private Boolean spaceBetweenAmountAndSymbol;
    private Integer roundingCoefficient;
    private Integer decimalDigits;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9217400132397496398L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Currency() {
    }

    /**
     * 
     * @param symbol
     * @param code
     * @param decimalSeparator
     * @param spaceBetweenAmountAndSymbol
     * @param roundingCoefficient
     * @param decimalDigits
     * @param thousandsSeparator
     * @param symbolOnLeft
     */
    public Currency(String code, String symbol, String thousandsSeparator, String decimalSeparator, Boolean symbolOnLeft, Boolean spaceBetweenAmountAndSymbol, Integer roundingCoefficient, Integer decimalDigits) {
        super();
        this.code = code;
        this.symbol = symbol;
        this.thousandsSeparator = thousandsSeparator;
        this.decimalSeparator = decimalSeparator;
        this.symbolOnLeft = symbolOnLeft;
        this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
        this.roundingCoefficient = roundingCoefficient;
        this.decimalDigits = decimalDigits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    public void setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
    }

    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public Boolean getSymbolOnLeft() {
        return symbolOnLeft;
    }

    public void setSymbolOnLeft(Boolean symbolOnLeft) {
        this.symbolOnLeft = symbolOnLeft;
    }

    public Boolean getSpaceBetweenAmountAndSymbol() {
        return spaceBetweenAmountAndSymbol;
    }

    public void setSpaceBetweenAmountAndSymbol(Boolean spaceBetweenAmountAndSymbol) {
        this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
    }

    public Integer getRoundingCoefficient() {
        return roundingCoefficient;
    }

    public void setRoundingCoefficient(Integer roundingCoefficient) {
        this.roundingCoefficient = roundingCoefficient;
    }

    public Integer getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

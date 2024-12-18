package com.EpicSeven.enums;

public enum Attribute {
    FIXEDATTACK("attack", 10, 50),
    PERCENTATTACK("attackPercentage", 10, 50),
    FIXEDDEFENSE("defense", 10, 50),
    PERCENTDEFENSE("defensePercentage", 10, 50),
    FIXEDHEALTH("health", 1000, 5000),
    PERCENTHEALTH("healthPercentage", 10, 50),
    SPEED("speed", 50, 200),
    CRITCHANCE("attack", 1, 50);
    
    private String attributeType;
    private int minValue;
    private int maxValue;
    
    Attribute(String attributeType, int minValue, int maxValue) {
        this.attributeType = attributeType;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    
    public String getAttributeType() {
        return attributeType;
    }
    
    public int getMinValue() {
        return minValue;
    }
    
    public int getMaxValue() {
        return maxValue;
    }
    
    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }
    
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
    
    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }
    
    public boolean isValid(int value) {
        if (value >= minValue && value <= maxValue) {
            return true;
        }
        throw new IllegalArgumentException("Value " + value + " for attribute " + attributeType + " is out of bounds. Valid range: " + minValue + " - " + maxValue);
    }
}
package com.EpicSeven.enums;

public enum Element {
    LIGHT("Luz", "Light"),
    DARKNESS("Trevas", "Darkness"),
    EARTH("Terra", "Earth"),
    ICE("Gelo", "Ice"),
    FIRE("Fogo", "Fire");
    
    private String valuePortuguese;
    private String valueEnglish;
    
    Element(String valuePortuguese, String valueEnglish) {
        this.valuePortuguese = valuePortuguese;
        this.valueEnglish = valueEnglish;
    }
    
    public String getValuePortuguese() {
        return valuePortuguese;
    }
    
    public String getValueEnglish() {
        return valueEnglish;
    }
}


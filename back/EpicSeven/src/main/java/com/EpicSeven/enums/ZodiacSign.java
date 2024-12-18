package com.EpicSeven.enums;

public enum ZodiacSign {
    ARIES("Áries", "Aries"),
    TAURUS("Touro", "Taurus"),
    GEMINI("Gêmeos", "Gemini"),
    CANCER("Câncer", "Cancer"),
    LEO("Leão", "Leo"),
    VIRGO("Virgem", "Virgo"),
    LIBRA("Libra", "Libra"),
    SCORPIO("Escorpião", "Scorpio"),
    SAGITTARIUS("Sagitário", "Sagittarius"),
    CAPRICORN("Capricórnio", "Capricorn"),
    AQUARIUS("Aquário", "Aquarius"),
    PISCES("Peixes", "Pisces");
    
    private String valuePortuguese;
    private String valueEnglish;
    
    ZodiacSign(String valuePortuguese, String valueEnglish) {
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


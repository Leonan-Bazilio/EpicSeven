package com.EpicSeven.enums;

public enum CharacterClass {
    KNIGHT("Cavaleiro", "Knight"),
    WARRIOR("Guerreiro", "Warrior"),
    MAGE("Mago", "Mage"),
    ARCHER("Atirador", "Archer"),
    THIELF("Ladrão", "Thief"),
    SOUL_WEAVER("Tece Almas", "Soul Weaver"),
    NONE("Nenhuma", "None");
    
    private String valuePortuguese;
    private String valueEnglish;
    
    CharacterClass(String valuePortuguese, String valueEnglish) {
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

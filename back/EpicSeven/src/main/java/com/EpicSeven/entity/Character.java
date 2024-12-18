package com.EpicSeven.entity;

import com.EpicSeven.enums.CharacterClass;
import com.EpicSeven.enums.Element;
import com.EpicSeven.enums.ZodiacSign;

import java.time.LocalDate;

public class Character {
    private String nameEn;
    private String namePt;
    private ZodiacSign sign;
    private CharacterClass characterClass;
    private Element element;
    private LocalDate releaseDate;
}

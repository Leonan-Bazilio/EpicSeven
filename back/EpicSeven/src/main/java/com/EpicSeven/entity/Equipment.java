package com.EpicSeven.entity;

import com.EpicSeven.enums.Attribute;

import com.EpicSeven.enums.TypeEquipment;
import jakarta.persistence.*;

@Entity
public class Equipment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private TypeEquipment typeEquipment;
    
    private String nameEquipment;
    private int levelEquipment;
    
    @Enumerated(EnumType.STRING)
    private Attribute typeMainAttribute;
    private int valueMainAttribute;
    
    @Enumerated(EnumType.STRING)
    private Attribute typeSubAttribute1;
    private int valueSubAttribute1;
    
    @Enumerated(EnumType.STRING)
    private Attribute typeSubAttribute2;
    private int valueSubAttribute2;
    
    @Enumerated(EnumType.STRING)
    private Attribute typeSubAttribute3;
    private int valueSubAttribute3;
    
    @Enumerated(EnumType.STRING)
    private Attribute typeSubAttribute4;
    private int valueSubAttribute4;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public TypeEquipment getTypeEquipment() {
        return typeEquipment;
    }
    
    public void setTypeEquipment(TypeEquipment typeEquipment) {
        this.typeEquipment = typeEquipment;
    }
    
    public String getNameEquipment() {
        return nameEquipment;
    }
    
    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }
    
    public int getLevelEquipment() {
        return levelEquipment;
    }
    
    public void setLevelEquipment(int levelEquipment) {
        this.levelEquipment = levelEquipment;
    }
    
    public Attribute getTypeMainAttribute() {
        return typeMainAttribute;
    }
    
    public void setTypeMainAttribute(Attribute typeMainAttribute) {
        this.typeMainAttribute = typeMainAttribute;
    }
    
    public int getValueMainAttribute() {
        return valueMainAttribute;
    }
    
    public void setValueMainAttribute(int valueMainAttribute) {
        this.valueMainAttribute = valueMainAttribute;
    }
    
    public Attribute getTypeSubAttribute1() {
        return typeSubAttribute1;
    }
    
    public void setTypeSubAttribute1(Attribute typeSubAttribute1) {
        this.typeSubAttribute1 = typeSubAttribute1;
    }
    
    public int getValueSubAttribute1() {
        return valueSubAttribute1;
    }
    
    public void setValueSubAttribute1(int valueSubAttribute1) {
        this.valueSubAttribute1 = valueSubAttribute1;
    }
    
    public Attribute getTypeSubAttribute2() {
        return typeSubAttribute2;
    }
    
    public void setTypeSubAttribute2(Attribute typeSubAttribute2) {
        this.typeSubAttribute2 = typeSubAttribute2;
    }
    
    public int getValueSubAttribute2() {
        return valueSubAttribute2;
    }
    
    public void setValueSubAttribute2(int valueSubAttribute2) {
        this.valueSubAttribute2 = valueSubAttribute2;
    }
    
    public Attribute getTypeSubAttribute3() {
        return typeSubAttribute3;
    }
    
    public void setTypeSubAttribute3(Attribute typeSubAttribute3) {
        this.typeSubAttribute3 = typeSubAttribute3;
    }
    
    public int getValueSubAttribute3() {
        return valueSubAttribute3;
    }
    
    public void setValueSubAttribute3(int valueSubAttribute3) {
        this.valueSubAttribute3 = valueSubAttribute3;
    }
    
    public Attribute getTypeSubAttribute4() {
        return typeSubAttribute4;
    }
    
    public void setTypeSubAttribute4(Attribute typeSubAttribute4) {
        this.typeSubAttribute4 = typeSubAttribute4;
    }
    
    public int getValueSubAttribute4() {
        return valueSubAttribute4;
    }
    
    public void setValueSubAttribute4(int valueSubAttribute4) {
        this.valueSubAttribute4 = valueSubAttribute4;
    }
}

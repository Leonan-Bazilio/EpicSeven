package com.EpicSeven.service;

import com.EpicSeven.entity.Equipment;
import com.EpicSeven.enums.Attribute;
import com.EpicSeven.enums.TypeEquipment;
import com.EpicSeven.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EquipmentService {
    
    @Autowired
    private EquipmentRepository equipmentRepository;
    
    public Equipment createEquipment(Equipment equipment) {
        validateEquipment(equipment);
        validateAttributesValues(equipment);
        return equipmentRepository.save(equipment);
    }
    
    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipment not found with ID: " + id));
    }
    

    public Equipment updateEquipment(Long id, Equipment updatedEquipment) {
        Equipment existingEquipment = getEquipmentById(id);
        updatedEquipment.setId(existingEquipment.getId());
        validateEquipment(updatedEquipment);
        validateAttributesValues(updatedEquipment);
        return equipmentRepository.save(updatedEquipment);
    }
    

    public void deleteEquipment(Long id) {
        Equipment equipment = getEquipmentById(id);
        equipmentRepository.delete(equipment);
    }
    

    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }
    
    private void validateEquipment(Equipment equipment) {
        TypeEquipment type = equipment.getTypeEquipment();
        

        Set<Attribute> mainAttributesAllowed;
        Set<Attribute> subAttributesDenied;
        
        switch (type) {
            case ARMOR:
                mainAttributesAllowed = Set.of(Attribute.FIXEDHEALTH);
                subAttributesDenied = Set.of(Attribute.FIXEDATTACK, Attribute.PERCENTATTACK);
                break;
            case WEAPON:
                mainAttributesAllowed = Set.of(Attribute.FIXEDATTACK);
                subAttributesDenied = Set.of(Attribute.FIXEDDEFENSE, Attribute.PERCENTDEFENSE);
                break;
            case BOOTS:
                mainAttributesAllowed = Set.of(
                        Attribute.FIXEDATTACK, Attribute.PERCENTATTACK,
                        Attribute.FIXEDDEFENSE, Attribute.PERCENTDEFENSE,
                        Attribute.SPEED, Attribute.CRITCHANCE
                );
                subAttributesDenied = Set.of();
                break;
            case HELMET:
            case NECKLACE:
            case RING:
                mainAttributesAllowed = Set.of(Attribute.FIXEDHEALTH, Attribute.PERCENTHEALTH);
                subAttributesDenied = Set.of(Attribute.CRITCHANCE);
                break;
            default:
                throw new IllegalArgumentException("Invalid equipment type: " + type);
        }
        
        validateAttributes(equipment, mainAttributesAllowed, subAttributesDenied);
    }
    
    private void validateAttributes(Equipment equipment,
                                    Set<Attribute> mainAttributesAllowed,
                                    Set<Attribute> subAttributesDenied) {
        
        if (!mainAttributesAllowed.contains(equipment.getTypeMainAttribute())) {
            throw new IllegalArgumentException("Invalid main attribute: " +
                    equipment.getTypeMainAttribute() + " for equipment type " +
                    equipment.getTypeEquipment());
        }
        
        Set<Attribute> attributes = new HashSet<>(Set.of(
                equipment.getTypeSubAttribute1(),
                equipment.getTypeSubAttribute2(),
                equipment.getTypeSubAttribute3(),
                equipment.getTypeSubAttribute4()
        ));
        
        for (Attribute subAttribute : attributes) {
            if (subAttributesDenied.contains(subAttribute)) {
                throw new IllegalArgumentException("Invalid subattribute: " + subAttribute +
                        " for equipment type " + equipment.getTypeEquipment());
            }
        }
        
        attributes.add(equipment.getTypeMainAttribute());
        if (attributes.size() <  5) {
            throw new IllegalArgumentException("Attributes cannot be repeated between main and subattributes.");
        }
    }
    
    private void validateAttributesValues(Equipment equipment) {
        equipment.getTypeMainAttribute().isValid(equipment.getValueMainAttribute());
        equipment.getTypeSubAttribute1().isValid(equipment.getValueSubAttribute1());
        equipment.getTypeSubAttribute2().isValid(equipment.getValueSubAttribute2());
        equipment.getTypeSubAttribute3().isValid(equipment.getValueSubAttribute3());
        equipment.getTypeSubAttribute4().isValid(equipment.getValueSubAttribute4());
    }
}
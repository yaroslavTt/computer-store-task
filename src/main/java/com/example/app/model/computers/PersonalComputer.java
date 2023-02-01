package com.example.app.model.computers;

import com.example.app.model.properties.GraphicCard;
import com.example.app.model.properties.PowerSupply;
import jakarta.persistence.*;

@Entity
@Table(name = "personal_computers")
public class PersonalComputer extends Computer{

    @ManyToOne
    @JoinColumn(name = "graphic_card_id", referencedColumnName = "id")
    private GraphicCard graphicCard;

    @ManyToOne
    @JoinColumn(name = "power_supply_id", referencedColumnName = "id")
    private PowerSupply powerSupply;

}

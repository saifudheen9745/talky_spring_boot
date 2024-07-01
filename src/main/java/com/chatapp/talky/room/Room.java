package com.chatapp.talky.room;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table
@Entity
public class Room {

    @Id
    @SequenceGenerator(
        initialValue=1,
        allocationSize=1,
        name="user_id_sequence",
        sequenceName="user_id_sequence"
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator="user_id_sequence"
    )
    private Long id;
        
    @Column(nullable = false)
    private Long memberA;

    @Column(nullable = false)
    private Long memberB;

    public Room() {
    }

    public Room(Long memberA, Long memberB) {
        this.memberA = memberA;
        this.memberB = memberB;
    }

    public Room(Long id, Long memberA, Long memberB) {
        this.id = id;
        this.memberA = memberA;
        this.memberB = memberB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberA() {
        return memberA;
    }

    public void setMemberA(Long memberA) {
        this.memberA = memberA;
    }

    public Long getMemberB() {
        return memberB;
    }

    public void setMemberB(Long memberB) {
        this.memberB = memberB;
    }

    
    
    
}

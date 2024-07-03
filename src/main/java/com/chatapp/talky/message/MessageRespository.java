package com.chatapp.talky.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRespository extends JpaRepository<Message, Long> {
    
    @Query("SELECT m FROM Message m WHERE (m.msgFrom = :userId1 AND m.msgTo = :userId2) OR (m.msgFrom = :userId2 AND m.msgTo = :userId1)")
    List<Message> findMessagesBetweenUsers(@Param("userId1") Long userId1, @Param("userId2") Long userId2);
    
}

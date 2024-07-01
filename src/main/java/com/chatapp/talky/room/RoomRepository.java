package com.chatapp.talky.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    @Query("SELECT r FROM Room r WHERE (r.memberA = :memberA AND r.memberB = :memberB) OR (r.memberA = :memberB AND r.memberB = :memberA)")
    Room findRoomByMembers(@Param("memberA") Long memberA, @Param("memberB") Long memberB);
}

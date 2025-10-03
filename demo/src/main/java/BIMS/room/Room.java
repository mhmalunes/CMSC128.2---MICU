// package BIMS.room;

// import BIMS.floor.Floor;
// import com.fasterxml.jackson.annotation.JsonBackReference;
// import jakarta.persistence.*;

// @Entity
// @Table(name = "room")
// public class Room
// {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer roomId;

//     @ManyToOne
//     @JoinColumn(name = "floor_id", nullable = false)
//     @JsonBackReference
//     private Floor floor;

//     @Column(nullable = false)
//     private Integer roomNumber;

//     @Column(length = 50)
//     private String roomName;

//     public Integer getRoomId() {
//         return roomId;
//     }

//     public Floor getFloor() {
//         return floor;
//     }

//     public Integer getRoomNumber() {
//         return roomNumber;
//     }

//     public String getRoomName() {
//         return roomName;
//     }

//     public void setRoomId(Integer roomId) {
//         this.roomId = roomId;
//     }

//     public void setFloor(Floor floor) {
//         this.floor = floor;
//     }

//     public void setRoomNumber(Integer roomNumber) {
//         this.roomNumber = roomNumber;
//     }

//     public void setRoomName(String roomName) {
//         this.roomName = roomName;
//     }
// }



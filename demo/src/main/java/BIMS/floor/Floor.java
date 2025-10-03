// package BIMS.floor;

// import BIMS.building.Building;
// import BIMS.room.Room;
// import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonManagedReference;
// import jakarta.persistence.*;

// import java.util.List;

// @Entity
// @Table(name = "floor")
// public class Floor
// {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer floorId;

//     @ManyToOne
//     @JoinColumn(name = "building_id", nullable = false)
//     @JsonBackReference
//     private Building building;

//     @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL, orphanRemoval = true)
//     @JsonManagedReference
//     private List<Room> rooms;

//     @Column(nullable = false)
//     private Integer floorNumber;

//     public Integer getFloorId()
//     {
//         return floorId;
//     }

//     public Building getBuilding()
//     {
//         return building;
//     }

//     public List<Room> getRooms()
//     {
//         return rooms;
//     }

//     public Integer getFloorNumber()
//     {
//         return floorNumber;
//     }

//     public void setFloorId(Integer floorId)
//     {
//         this.floorId = floorId;
//     }

//     public void setBuilding(Building building)
//     {
//         this.building = building;
//     }

//     public void setRooms(List<Room> rooms)
//     {
//         this.rooms = rooms;
//     }

//     public void setFloorNumber(Integer floorNumber)
//     {
//         this.floorNumber = floorNumber;
//     }
// }

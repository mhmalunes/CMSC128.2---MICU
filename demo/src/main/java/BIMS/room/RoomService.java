// package BIMS.room;

// import jakarta.transaction.Transactional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class RoomService
// {

//     private final RoomRepository roomRepository;

//     @Autowired
//     public RoomService(RoomRepository roomRepository)
//     {
//         this.roomRepository = roomRepository;
//     }

//     @Transactional
//     public Room createRoom(Room room)
//     {
//         if (room.getFloor() == null || room.getFloor().getFloorId() == null)
//         {
//             throw new IllegalArgumentException("Floor ID must be provided and valid.");
//         }
//         return roomRepository.save(room);
//     }

//     public List<Room> getAllRooms()
//     {
//         return roomRepository.findAll();
//     }

//     @Transactional
//     public Room updateRoom(Integer id, Room roomDetails)
//     {
//         Optional<Room> optionalRoom = roomRepository.findById(id);
//         if (optionalRoom.isEmpty())
//         {
//             return null;
//         }

//         Room existingRoom = optionalRoom.get();
//         existingRoom.setRoomNumber(roomDetails.getRoomNumber());
//         existingRoom.setRoomName(roomDetails.getRoomName());
//         existingRoom.setFloor(roomDetails.getFloor()); // Allow updating the floor association if needed

//         return roomRepository.save(existingRoom);
//     }

//     public boolean deleteRoom(Integer id)
//     {
//         if (!roomRepository.existsById(id))
//         {
//             return false;
//         }
//         roomRepository.deleteById(id);
//         return true;
//     }

//     public Room getRoomById(Integer id)
//     {
//         return roomRepository.findById(id).orElse(null);
//     }

// }


// package BIMS.room;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/rooms")
// public class RoomController
// {

//     private final RoomService roomService;

//     @Autowired
//     public RoomController(RoomService roomService)
//     {
//         this.roomService = roomService;
//     }

//     @PostMapping
//     public ResponseEntity<Room> createRoom(@RequestBody Room room)
//     {
//         Room createdRoom = roomService.createRoom(room);
//         return ResponseEntity.ok(createdRoom);
//     }

//     @GetMapping
//     public ResponseEntity<List<Room>> getAllRooms()
//     {
//         List<Room> rooms = roomService.getAllRooms();
//         return ResponseEntity.ok(rooms);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Room> updateRoom(@PathVariable Integer id, @RequestBody Room room)
//     {
//         Room updatedRoom = roomService.updateRoom(id, room);
//         if (updatedRoom == null) {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.ok(updatedRoom);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteRoom(@PathVariable Integer id)
//     {
//         boolean deleted = roomService.deleteRoom(id);
//         if (!deleted)
//         {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.noContent().build();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Room> getRoomById(@PathVariable Integer id)
//     {
//         Room room = roomService.getRoomById(id);
//         if (room == null)
//         {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.ok(room);
//     }
// }


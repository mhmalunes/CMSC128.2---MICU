// package BIMS.floor;

// import BIMS.building.Building;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/floors")
// public class FloorController {

//     private final FloorService floorService;

//     @Autowired
//     public FloorController(FloorService floorService) {
//         this.floorService = floorService;
//     }

//     @PostMapping
//     public ResponseEntity<Floor> createFloor(@RequestBody Floor floor)
//     {
//         Floor createdFloor = floorService.createFloor(floor);
//         return ResponseEntity.ok(createdFloor);
//     }

//     @GetMapping
//     public ResponseEntity<List<Floor>> getAllFloors()
//     {
//         List<Floor> floors = floorService.getAllFloors();
//         return ResponseEntity.ok(floors);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Floor> updateFloor(@PathVariable Integer id, @RequestBody Floor floor)
//     {
//         Floor updatedFloor = floorService.updateFloor(id, floor);
//         if (updatedFloor == null)
//         {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.ok(updatedFloor);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<?> deleteFloor(@PathVariable Integer id)
//     {
//         boolean deleted = floorService.deleteFloor(id);
//         if (!deleted)
//         {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.noContent().build(); // 204 No Content
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Floor> getFloorById(@PathVariable Integer id)
//     {
//         Floor floor = floorService.getFloorById(id);
//         if (floor == null)
//         {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.ok(floor);
//     }
// }
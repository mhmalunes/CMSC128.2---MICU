
// package BIMS.floor;

// import jakarta.transaction.Transactional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class FloorService {

//     private final FloorRepository floorRepository;

//     @Autowired
//     public FloorService(FloorRepository floorRepository) {
//         this.floorRepository = floorRepository;
//     }

//     @Transactional
//     public Floor createFloor(Floor floor)
//     {
//         if (floor.getBuilding() == null || floor.getBuilding().getBuildingId() == null)
//         {
//             throw new IllegalArgumentException("Building ID does not exists.");
//         }
//         return floorRepository.save(floor);
//     }

//     public List<Floor> getAllFloors() {
//         return floorRepository.findAll();
//     }

//     @Transactional
//     public Floor updateFloor(Integer id, Floor floorDetails)
//     {
//         Optional<Floor> optionalFloor = floorRepository.findById(id);
//         if (optionalFloor.isEmpty())
//         {
//             return null;
//         }

//         Floor existingFloor = optionalFloor.get();
//         existingFloor.setFloorNumber(floorDetails.getFloorNumber());
//         existingFloor.setBuilding(floorDetails.getBuilding()); // Allow updating the building association

//         return floorRepository.save(existingFloor);
//     }

//     @Transactional
//     public boolean deleteFloor(Integer id)
//     {
//         Optional<Floor> floorOptional = floorRepository.findById(id);
//         if (floorOptional.isEmpty())
//         {
//             return false;
//         }

//         floorRepository.delete(floorOptional.get());
//         return true;
//     }

//     public Floor getFloorById(Integer id) {
//         return floorRepository.findById(id).orElse(null);
//     }
// }

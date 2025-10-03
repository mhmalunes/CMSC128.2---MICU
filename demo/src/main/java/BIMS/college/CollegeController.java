// package BIMS.college;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/colleges")
// public class CollegeController
// {

//     private final CollegeService collegeService;

//     @Autowired
//     public CollegeController(CollegeService collegeService)
//     {
//         this.collegeService = collegeService;
//     }

//     @PostMapping
//     public ResponseEntity<College> createCollege(@RequestBody College college)
//     {
//         College createdCollege = collegeService.createCollege(college);
//         return ResponseEntity.ok(createdCollege);
//     }

//     @GetMapping
//     public ResponseEntity<List<College>> getAllColleges()
//     {
//         List<College> colleges = collegeService.getAllColleges();
//         return ResponseEntity.ok(colleges);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<College> updateCollege(@PathVariable Integer id, @RequestBody College college)
//     {
//         College updatedCollege = collegeService.updateCollege(id, college);
//         if (updatedCollege == null)
//         {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.ok(updatedCollege);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<?> deleteCollege(@PathVariable Integer id)
//     {
//         try
//         {
//             boolean deleted = collegeService.deleteCollege(id);
//             if (!deleted)
//             {
//                 return ResponseEntity.notFound().build();
//             }
//             return ResponseEntity.noContent().build();
//         }
//         catch (IllegalStateException e)
//         {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<College> getCollegeById(@PathVariable Integer id)
//     {
//         College college = collegeService.getCollegeById(id);
//         if (college == null)
//         {
//             return ResponseEntity.notFound().build();
//         }
//         return ResponseEntity.ok(college);
//     }
// }


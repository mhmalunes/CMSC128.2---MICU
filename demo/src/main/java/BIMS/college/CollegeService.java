// package BIMS.college;

// import BIMS.building.BuildingRepository;
// import jakarta.transaction.Transactional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class CollegeService {

//     private final CollegeRepository collegeRepository;

//     @Autowired
//     public CollegeService(CollegeRepository collegeRepository)
//     {
//         this.collegeRepository = collegeRepository;
//     }

//     @Transactional
//     public College createCollege(College college)
//     {
//         return collegeRepository.save(college);
//     }

//     public List<College> getAllColleges()
//     {
//         return collegeRepository.findAll();
//     }

//     @Transactional
//     public College updateCollege(Integer id, College collegeDetails)
//     {
//         Optional<College> optionalCollege = collegeRepository.findById(id);
//         if (optionalCollege.isEmpty())
//         {
//             return null;
//         }

//         College existingCollege = optionalCollege.get();
//         existingCollege.setCollegeName(collegeDetails.getCollegeName());

//         return collegeRepository.save(existingCollege);
//     }

//     @Transactional
//     public boolean deleteCollege(Integer id)
//     {
//         Optional<College> optionalCollege = collegeRepository.findById(id);
//         if (optionalCollege.isEmpty())
//         {
//             return false;
//         }

//         College college = optionalCollege.get();

//         if (college.getBuildings() != null && !college.getBuildings().isEmpty())
//         {
//             throw new IllegalStateException("Cannot delete College because it still has buildings assigned.");
//         }

//         collegeRepository.delete(college);
//         return true;
//     }

//     public College getCollegeById(Integer id)
//     {
//         return collegeRepository.findById(id).orElse(null);
//     }
// }


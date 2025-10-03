    // package BIMS.college;

    // import BIMS.building.Building;
    // import com.fasterxml.jackson.annotation.JsonManagedReference;
    // import jakarta.persistence.*;

    // import java.util.List;

    // @Entity
    // @Table(name = "college")
    // public class College
    // {
    //     @Id
    //     @GeneratedValue(strategy = GenerationType.IDENTITY)
    //     private Integer collegeId;

    //     @Column(nullable = false, length = 50)
    //     private String collegeName;

    //     @OneToMany(mappedBy = "college")
    //     @JsonManagedReference
    //     private List<Building> buildings;

    //     public Integer getCollegeId()
    //     {
    //         return collegeId;
    //     }

    //     public String getCollegeName()
    //     {
    //         return collegeName;
    //     }

    //     public List<Building> getBuildings()
    //     {
    //         return buildings;
    //     }

    //     public void setCollegeId(Integer collegeId)
    //     {
    //         this.collegeId = collegeId;
    //     }

    //     public void setCollegeName(String collegeName)
    //     {
    //         this.collegeName = collegeName;
    //     }

    //     public void setBuildings(List<Building> buildings)
    //     {
    //         this.buildings = buildings;
    //     }
    // }


-- Create the College table
CREATE TABLE college (
                         college_id SERIAL PRIMARY KEY,
                         college_name VARCHAR(50) NOT NULL
);

-- Create the Building table
CREATE TABLE building (
                          building_id SERIAL PRIMARY KEY,
                          college_id INTEGER NOT NULL,
                          building_name VARCHAR(50) NOT NULL,
                          number_of_floors INTEGER NOT NULL,
                          building_footprint DOUBLE PRECISION NOT NULL,
                          total_floor_area DOUBLE PRECISION NOT NULL,
                          floor_plans_url VARCHAR(255),
                          CONSTRAINT fk_college FOREIGN KEY (college_id) REFERENCES college(college_id)
);

-- Create the Floor table
CREATE TABLE floor (
                       floor_id SERIAL PRIMARY KEY,
                       building_id INTEGER NOT NULL,
                       floor_number INTEGER NOT NULL,
                       CONSTRAINT fk_building FOREIGN KEY (building_id) REFERENCES building(building_id)
);

-- Create the Room table
CREATE TABLE room (
                      room_id SERIAL PRIMARY KEY,
                      floor_id INTEGER NOT NULL,
                      room_number INTEGER NOT NULL,
                      room_name VARCHAR(50),
                      CONSTRAINT fk_floor FOREIGN KEY (floor_id) REFERENCES floor(floor_id)
);

package com.startbuild.microservice.buildservice.dao;

import com.startbuild.microservice.buildservice.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


// Repository are the DAOs (Data Access Objects), they access the database directly.
@Repository
public class StudentDao implements RowMapper<Student> {
    // RowMapper interface is used to fetch multiple rows and column

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean isTableExist(String tableName){

        String query =
                "select count(*) "
                        + "from information_schema.tables "
                        + "where table_name = ?";
        Integer result = jdbcTemplate.queryForObject(query, Integer.class, tableName); // queryForObject returns query output
        return result == 1 ? true : false;
    }

    public void createTable() {

        if (!isTableExist("student_data")) {
            String query = "CREATE TABLE student_data(id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL, age VARCHAR(3), avg_marks VARCHAR(3))";
            int update = this.jdbcTemplate.update(query); // update return 1 for success and 0 for failure
            if (update==1)
                System.out.println("Table Created");
        }
    }

    public void insertData(Student student) {

        String query = "insert into student_data(name, age, avg_marks) values(?,?,?)";
        int update = jdbcTemplate.update(query,student.getName(), student.getAge(), student.getAvg_marks());
        if (update == 1)
            System.out.println("Data inserted for student : " + student.getName());
    }

    public List<Student> getStudentRecords(){

        String query = "select * from student_data";
        List<Student> studentList = jdbcTemplate.query(query,this);
        return studentList;
    }

    public Student getStudentRecordById(int id){

        String query = "select * from student_data where id = ?";
        Student studentRecord = jdbcTemplate.queryForObject(query,this, id);
        return studentRecord;
    }

    public void deleteStudentRecordById(int id){

        String query = "delete from student_data where id = ?";
        int update = jdbcTemplate.update(query,id);
        if (update==1)
            System.out.println("Record deleted for id : " +id);
    }

    public void updateStudentRecordById(Student student){

        String query = "update student_data set name = ?, age = ?, avg_marks = ? where id = ?";
        int update = jdbcTemplate.update(query, student.getName(), student.getAge(), student.getAvg_marks(), student.getId());
        if (update==1)
            System.out.println("Record updated for id : " +student.getId());
    }

    /**
     * This implemented method of RowMapper interface is being used to fetch student data from table
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setAge(rs.getInt(3));
        student.setAvg_marks(rs.getInt(4));
        return student;
    }
}

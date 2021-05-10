package main.java;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Task2 {

    static final String DB = "jdbc:mysql://localhost:3306/TestTaskStudents";
    static final String USER = "root";
    static final String PASS = "";
    private static final String TABLENAME = "students";
    static final Connection con = Conection();


    public static Connection Conection() {
        try {
            return DriverManager.getConnection(DB, USER, PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void createStudentTable() throws SQLException {
        DatabaseMetaData md = con.getMetaData();
        ResultSet res = md.getTables(null, null, TABLENAME, null);
        while (res.next()) {
            String tableName = res.getString("TABLE_NAME");
            if (tableName != null && tableName.equals(TABLENAME)) {
                return;
            }
        }
        Statement stmt = con.createStatement();
        String sql = "CREATE TABLE " + TABLENAME + " (`id` INTEGER not NULL AUTO_INCREMENT, `first_name` VARCHAR(255), `middle_name` VARCHAR(255), " +
                " `last_name` VARCHAR(255), `birth_date` DATE, `group` VARCHAR(255), PRIMARY KEY (id))";
        stmt.executeUpdate(sql);
    }

    public static boolean addStudent(String fName, String mName, String lName, Date date, String group) throws SQLException {
        String sql = "INSERT INTO " + TABLENAME + " (first_name, middle_name, last_name, birth_date, `group`) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, fName);
        stmt.setString(2, mName);
        stmt.setString(3, lName);
        stmt.setDate(4, date);
        stmt.setString(5, group);
        return stmt.executeUpdate() == 1;
    }

    public static boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM " + TABLENAME + " WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeUpdate() == 1;
    }

    public static List<Student> getStudents() throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM " + TABLENAME;
        ResultSet rs = stmt.executeQuery(sql);

        List<Student> studs = new LinkedList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String fName = rs.getString("first_name");
            String mName = rs.getString("middle_name");
            String lName = rs.getString("last_name");
            String group = rs.getString("group");
            Date date = rs.getDate("birth_date");
            studs.add(new Student(id, fName, mName, lName, date, group));
        }
        return studs;
    }

}

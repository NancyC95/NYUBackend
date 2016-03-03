package record;

import json.get.CourseJson;
import json.get.UserJson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordGetter extends Record {
    public static String getUserModels(String userId) throws SQLException {
        final String sqlString = "SELECT first_name, last_name, age, grade_level, major, school_name " +
                "FROM public.user WHERE user_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, userId);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                UserJson userJson = new UserJson();

                userJson.setFirstName(result.getString(1));
                userJson.setLastName(result.getString(2));
                userJson.setAge(result.getInt(3));
                userJson.setGradeLevel(result.getInt(4));
                userJson.setMajor(result.getString(5));
                userJson.setSchoolName(result.getString(6));

                return userJson.toJson();
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }

    public static String getCourses(String courseId) throws SQLException {
        final String sqlString = "SELECT school_name, subject, course_number, prof_first_name, prof_last_name " +
                "FROM publc.course WHERE course_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sqlString)) {
            preparedStatement.setString(1, courseId);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                CourseJson courseJson = new CourseJson();

                courseJson.setSchoolName(result.getString(1));
                courseJson.setSubject(result.getString(2));
                courseJson.setCourseNum(result.getInt(3));
                courseJson.setProfFirstName(result.getString(4));
                courseJson.setProfLastName(result.getString(5));

                return courseJson.toJson();
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return null;
    }
}
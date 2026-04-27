package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDto {

    public static List<ContactDto> readAll(Connection connection) {
        String query = "SELECT contact_id, first_name, last_name FROM contact";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            List<ContactDto> contactDtos = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("contact_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                ContactDto contactDto = new ContactDto(id, firstName, lastName);
                contactDtos.add(contactDto);
            }
            return contactDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int id;
    private final String firstName;
    private final String lastName;

    public ContactDto(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

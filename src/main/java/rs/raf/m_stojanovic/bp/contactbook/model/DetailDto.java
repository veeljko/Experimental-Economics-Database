package rs.raf.m_stojanovic.bp.contactbook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailDto {

    public static List<DetailDto> readForContact(Connection connection, int contact) {
        String query = "SELECT detail_id, detail_value, cat_name " +
                "FROM detail JOIN category ON detail.cat_id = category.cat_id " +
                "WHERE contact_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, contact);
            List<DetailDto> detailDtos = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("detail_id");
                String value = rs.getString("detail_value");
                String category = rs.getString("cat_name");
                DetailDto detailDto = new DetailDto(contact, id, value, category);
                detailDtos.add(detailDto);
            }
            return detailDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final int contact;
    private final int id;
    private final String value;
    private final String category;

    public DetailDto(int contact, int id, String value, String category) {
        this.contact = contact;
        this.id = id;
        this.value = value;
        this.category = category;
    }

    public int getContact() {
        return contact;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }
}

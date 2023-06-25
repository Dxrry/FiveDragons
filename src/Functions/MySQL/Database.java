/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions.MySQL;

/**
 *
 * @author dxrry
 */
import Functions.Types.History;
import Functions.Types.Menu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {

    private Connection createConnection() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost/warung_teh_yuli";
        String dbUsername = "chickennugget";
        String dbPassword = "chickennuggetpassword";
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error while closing connection: " + e.getMessage());
        }
    }

    private String executeQueryAndReturnString(Connection connection, String sql, Object... params) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString(1);
                }
            }
        }
        return "";
    }

    private int executeQueryAndReturnInt(Connection connection, String sql, Object... params) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
        return 0;
    }

    private byte[] executeQueryAndReturnByteArray(Connection connection, String sql, Object... params) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getBytes(1);
                }
            }
        }
        return new byte[0];
    }

    public String getUserFullname(Integer userId) {
        String sql = "SELECT fullname FROM tbl_user WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnString(connection, sql, userId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public Integer getUserId(String userName) {
        String sql = "SELECT id FROM tbl_user WHERE username = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnInt(connection, sql, userName);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public String getUserPassword(String userName) {
        String sql = "SELECT password FROM tbl_user WHERE username = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnString(connection, sql, userName);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public List<String> getMenuAllCategories() {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT * FROM tbl_categories";
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String categoryId = resultSet.getString("categories_name");
                categories.add(categoryId);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return categories;
    }

    public String getCategoriesName(Integer categoriesID) {
        String sql = "SELECT categories_name FROM tbl_categories WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnString(connection, sql, categoriesID);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public String getHistoryPaymentMethod(Integer orderID) {
        String sql = "SELECT pembayaran FROM tbl_history WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnString(connection, sql, orderID);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public String getHistoryPaymentName(Integer orderID) {
        String sql = "SELECT atas_nama FROM tbl_history WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnString(connection, sql, orderID);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public String getMenuName(Integer menuId) {
        String sql = "SELECT menu_name FROM tbl_menu WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnString(connection, sql, menuId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public String getMenuCategories(Integer menuId) {
        String sql = "SELECT menu_categories FROM tbl_menu WHERE id = ?";
        try (Connection connection = createConnection()) {
            int menuCategories = executeQueryAndReturnInt(connection, sql, menuId);
            return getCategoriesName(menuCategories);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public String getMenuDesc(Integer menuId) {
        String sql = "SELECT menu_description FROM tbl_menu WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnString(connection, sql, menuId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public String getPaymentNumber(String paymentMethod) {
        String sql = "SELECT number FROM tbl_payment WHERE name = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnString(connection, sql, paymentMethod);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }

    public String putOrderHistory(Map<Integer, Integer> checkoutList, String paymentMethod, String paymentName, Integer userId) {
        String sql = "INSERT INTO tbl_history (user_id, menu_selected, pembayaran, atas_nama, status) VALUES (?, ?, ?, ?, 'PENDING')";
        ObjectMapper objectMapper = new ObjectMapper();

        try (Connection connection = createConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                statement.setString(2, objectMapper.writeValueAsString(checkoutList));
                statement.setString(3, paymentMethod);
                statement.setString(4, paymentName);
                statement.executeUpdate();
            }
        } catch (SQLException | JsonProcessingException e) {
            System.err.println(e.getMessage());
        }

        return "";
    }

    public String putNewAccount(String accName, String accUsername, String accPassword, String accNumber, String accEmail) {
        String sql = "INSERT INTO tbl_user (fullname, username, password, email, number) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = createConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, accName);
                statement.setString(2, accUsername);
                statement.setString(3, accPassword);
                statement.setString(4, accEmail);
                statement.setString(5, accNumber);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return "";
    }

    public Integer getMenuPrice(Integer menuId) {
        String sql = "SELECT menu_price FROM tbl_menu WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnInt(connection, sql, menuId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
    
    public byte[] getMenuIcon(Integer menuId) {
        String sql = "SELECT menu_image FROM tbl_menu WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnByteArray(connection, sql, menuId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return new byte[0];
    }

    public byte[] getCheckoutIcon(Integer menuId) {
        String sql = "SELECT menu_image_checkout FROM tbl_menu WHERE id = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnByteArray(connection, sql, menuId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return new byte[0];
    }

    public Integer getMenuCategoriesId(String menuCategories) {
        String sql = "SELECT id FROM tbl_categories WHERE categories_name = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnInt(connection, sql, menuCategories);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public Integer getTotalPages(String menuCategories) {
        String sql = "SELECT COUNT(id) AS total FROM tbl_menu WHERE menu_categories = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnInt(connection, sql, getMenuCategoriesId(menuCategories));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public int[] getMenuIds(String menuCategories) {
        String sql = "SELECT id FROM tbl_menu WHERE menu_categories = ?";
        try (Connection connection = createConnection()) {
            int menuCategoriesId = getMenuCategoriesId(menuCategories);
            List<Integer> menuIdList = new ArrayList<>();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, menuCategoriesId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        menuIdList.add(resultSet.getInt("id"));
                    }
                }
            }
            return menuIdList.stream().mapToInt(Integer::intValue).toArray();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return new int[0];
    }

    public Integer getAllPages(String menuCategories) {
        String sql = "SELECT id FROM tbl_menu WHERE menu_categories = ?";
        try (Connection connection = createConnection()) {
            return executeQueryAndReturnInt(connection, sql, getMenuCategoriesId(menuCategories));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public List<History> getHistoryById(Integer orderID) {
        List<History> historyList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_history WHERE id = ?";
        try (Connection connection = createConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, orderID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Integer historyId = resultSet.getInt("id");
                        String menuSelected = resultSet.getString("menu_selected");
                        String historyStatus = resultSet.getString("status");
                        Integer historyUserID = resultSet.getInt("user_id");
                        String historyDate = resultSet.getString("timestamp");
                        String historyPaymentMethod = resultSet.getString("pembayaran");
                        String historyPaymentName = resultSet.getString("atas_nama");
                        History history = new History(historyId, menuSelected, historyUserID, historyStatus, historyDate, historyPaymentMethod, historyPaymentName);
                        historyList.add(history);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return historyList;
    }

    public List<History> getAllHistory(Integer userId) {
        List<History> historyList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_history WHERE user_id = ? ORDER BY timestamp DESC";
        try (Connection connection = createConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Integer historyId = resultSet.getInt("id");
                        String menuSelected = resultSet.getString("menu_selected");
                        String historyStatus = resultSet.getString("status");
                        Integer historyUserID = resultSet.getInt("user_id");
                        String historyDate = resultSet.getString("timestamp");
                        String historyPaymentMethod = resultSet.getString("pembayaran");
                        String historyPaymentName = resultSet.getString("atas_nama");
                        History history = new History(historyId, menuSelected, historyUserID, historyStatus, historyDate, historyPaymentMethod, historyPaymentName);
                        historyList.add(history);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return historyList;
    }

    public List<Menu> getMenu(String menuCategories, Integer limitSize) {
        List<Menu> menuList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_menu WHERE menu_categories = ? LIMIT ?";
        try (Connection connection = createConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, getMenuCategoriesId(menuCategories));
                statement.setInt(2, limitSize);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Integer menuId = resultSet.getInt("id");
                        String menuName = resultSet.getString("menu_name");
                        String menuDesc = resultSet.getString("menu_description");
                        Integer menuPrice = resultSet.getInt("menu_price");
                        byte[] menuImage = resultSet.getBytes("menu_image");
                        Menu menu = new Menu(menuId, menuName, menuDesc, menuPrice, menuImage);
                        menuList.add(menu);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return menuList;
    }
}

package me.darkeyedragon.magicwands.database;

import me.darkeyedragon.magicwands.wrappers.PlayerWithMana;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;

public class DatabaseController{

    private static String SQL_QUERY;
    /*public static void updateUser(Player player) throws SQLException {
        SQL_QUERY = "INSERT INTO users (uuid, last_seen) VALUES (?, ?) on duplicate key UPDATE last_seen = VALUES(?)";
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)
        ) {
            preparedStatement.setString(1, player.getUniqueId().toString());
            preparedStatement.setLong(2, System.currentTimeMillis());
            preparedStatement.setLong(3, System.currentTimeMillis());
            preparedStatement.executeQuery();
        }
    }

    public static List<Kingdom> fetchKingdoms() throws SQLException {
        SQL_QUERY = "SELECT * FROM kingdom";
        List<Kingdom> kingdoms;
        try (Connection con = DataSource.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SQL_QUERY);
             ResultSet rs = preparedStatement.executeQuery()
        ) {
            kingdoms = new ArrayList<>();
            Kingdom kingdom;
            while (rs.next()) {
                kingdom = new Kingdom();
                kingdom.setName(rs.getString("name"));
                kingdom.setPrefix(rs.getString("prefix"));
                //TODO figure out how to deal with foreign keys
                //kingdom.addMember(rs.getString());
            }
        }
        return kingdoms;
    }

    public static void addKingdomMember(Player player) throws SQLException {
        final String uuid = player.getUniqueId().toString();
        SQL_QUERY = "INSERT IGNORE INTO kingdom_member (uuid) VALUES (?)";
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)) {
            preparedStatement.setString(1, uuid);
            preparedStatement.execute();
        }
    }

    public static void removeFromKingdom(Player player) throws SQLException {
        final String uuid = player.getUniqueId().toString();
        SQL_QUERY = "DELETE FROM kingdom_member WHERE uuid=?";
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)) {
            preparedStatement.setString(1, uuid);
            preparedStatement.execute();
        }
    }*/

    public static void addPlayer (Player player) throws SQLException{
        final String UUID = player.getUniqueId().toString();
        SQL_QUERY = "INSERT INTO users (uuid) VALUES (?) on duplicate key UPDATE last_seen = ?";
        String SQL_QUERY2 = "INSERT IGNORE INTO mana (uuid, max_mana, current_mana) VALUES (?,?,?)";
        try (Connection connection = DataSource.getConnection();
             PreparedStatement insertUsers = connection.prepareStatement(SQL_QUERY);
             PreparedStatement insertMana = connection.prepareStatement(SQL_QUERY2)){
            insertUsers.setString(1, UUID);
            insertUsers.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            insertUsers.execute();

            insertMana.setString(1, UUID);
            insertMana.setInt(2, PlayerWithMana.DEFAULT_MAX_MANA);
            insertMana.setInt(3, PlayerWithMana.DEFAULT_MAX_MANA);
            insertMana.execute();
        }
    }

    public static PlayerWithMana getPlayerData (Player player) throws SQLException{
        final String uuid = player.getUniqueId().toString();
        SQL_QUERY = "SELECT * FROM mana WHERE uuid = ?";
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)){
            preparedStatement.setString(1, uuid);
            ResultSet resultSet = preparedStatement.executeQuery();
            PlayerWithMana playerWithMana = new PlayerWithMana();
            while (resultSet.next()){
                playerWithMana.setPlayer(Bukkit.getPlayer(resultSet.getString("uuid")));
                playerWithMana.setMaxMana(resultSet.getInt("max_mana"));
                playerWithMana.setCurrentMana(resultSet.getInt("current_mana"));
            }
            return playerWithMana;
        }
    }
}
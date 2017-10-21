package mq.xivklott.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.bukkit.entity.Player;

public class SqlConnection {
    private Connection connection;
    private String urlbase;
    private String host;
    private String database;
    private String user;
    private String pass;

    public SqlConnection(String urlbase, String host, String database, String user, String pass) {
        this.urlbase = urlbase;
        this.host = host;
        this.database = database;
        this.user = user;
        this.pass = pass;
    }

    public void connection() {
        if (!isConnected()) {
            try {
                this.connection = java.sql.DriverManager.getConnection(this.urlbase + this.host + "/" + this.database, this.user, this.pass);
                System.out.println("connected ok");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                this.connection.close();
                System.out.println("connected off");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        return this.connection != null;
    }

    public int getBalance(Player player) {
        try {
            PreparedStatement q = this.connection.prepareStatement("SELECT coins FROM joueurs WHERE uuid = ?");
            q.setString(1, player.getUniqueId().toString());

            int balance = 0;
            java.sql.ResultSet rs = q.executeQuery();

            while (rs.next()) {
                balance = rs.getInt("coins");
            }

            q.close();

            return balance;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void addMoney(Player player, int amount) {
        int balance = getBalance(player);
        int newbalance = balance + amount;
        try {
            PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET coins = ? WHERE uuid = ?");
            rs.setInt(1, newbalance);
            rs.setString(2, player.getUniqueId().toString());
            rs.executeUpdate();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeMoney(Player player, int amount) {
        int balance = getBalance(player);
        int newbalance = balance - amount;

        if (newbalance <= 0) {
            return;
        }

        try {
            PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET coins = ? WHERE uuid = ?");
            rs.setInt(1, newbalance);
            rs.setString(2, player.getUniqueId().toString());
            rs.executeUpdate();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean hasPermission(Player player, String permission) {
        try {
            PreparedStatement rs = this.connection.prepareStatement("SELECT permission FROM permissions WHERE uuid = ? and permission = ?");
            rs.setString(1, player.getUniqueId().toString());
            rs.setString(2, permission);
            java.sql.ResultSet resultat = rs.executeQuery();
            if ((resultat.next()) && (permission.equals(resultat.getString("permission")))) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addPermission(Player player, String permission) {
        if (hasPermission(player, permission)) {
            return;
        }
        try {
            PreparedStatement rs = this.connection.prepareStatement("INSERT INTO permissions (uuid, permission) VALUES (?, ?)");
            rs.setString(1, player.getUniqueId().toString());
            rs.setString(2, permission);
            rs.executeUpdate();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePermission(Player player, String permission) {
        if (!hasPermission(player, permission)) {
            return;
        }
        try {
            PreparedStatement rs = this.connection.prepareStatement("DELETE FROM permissions WHERE uuid = ? and permission = ?");
            rs.setString(1, player.getUniqueId().toString());
            rs.setString(2, permission);
            rs.executeUpdate();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
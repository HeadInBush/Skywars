/*     */ package mq.xivklott.main;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class SqlConnection
/*     */ {
/*     */   private Connection connection;
/*     */   private String urlbase;
/*     */   private String host;
/*     */   private String database;
/*     */   private String user;
/*     */   private String pass;
/*     */   
/*     */   public SqlConnection(String urlbase, String host, String database, String user, String pass)
/*     */   {
/*  19 */     this.urlbase = urlbase;
/*  20 */     this.host = host;
/*  21 */     this.database = database;
/*  22 */     this.user = user;
/*  23 */     this.pass = pass;
/*     */   }
/*     */   
/*     */   public void connection() {
/*  27 */     if (!isConnected()) {
/*     */       try {
/*  29 */         this.connection = java.sql.DriverManager.getConnection(this.urlbase + this.host + "/" + this.database, this.user, this.pass);
/*  30 */         System.out.println("connected ok");
/*     */       } catch (SQLException e) {
/*  32 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void disconnect() {
/*  38 */     if (isConnected()) {
/*     */       try {
/*  40 */         this.connection.close();
/*  41 */         System.out.println("connected off");
/*     */       } catch (SQLException e) {
/*  43 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isConnected()
/*     */   {
/*  51 */     return this.connection != null;
/*     */   }
/*     */   
/*     */   public int getBalance(Player player)
/*     */   {
/*     */     try
/*     */     {
/*  58 */       PreparedStatement q = this.connection.prepareStatement("SELECT coins FROM joueurs WHERE uuid = ?");
/*  59 */       q.setString(1, player.getUniqueId().toString());
/*     */       
/*  61 */       int balance = 0;
/*  62 */       java.sql.ResultSet rs = q.executeQuery();
/*     */       
/*  64 */       while (rs.next()) {
/*  65 */         balance = rs.getInt("coins");
/*     */       }
/*     */       
/*  68 */       q.close();
/*     */       
/*  70 */       return balance;
/*     */     }
/*     */     catch (SQLException e) {
/*  73 */       e.printStackTrace();
/*     */     }
/*     */     
/*  76 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void addMoney(Player player, int amount)
/*     */   {
/*  82 */     int balance = getBalance(player);
/*  83 */     int newbalance = balance + amount;
/*     */     try
/*     */     {
/*  86 */       PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET coins = ? WHERE uuid = ?");
/*  87 */       rs.setInt(1, newbalance);
/*  88 */       rs.setString(2, player.getUniqueId().toString());
/*  89 */       rs.executeUpdate();
/*  90 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/*  93 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void removeMoney(Player player, int amount)
/*     */   {
/* 101 */     int balance = getBalance(player);
/* 102 */     int newbalance = balance - amount;
/*     */     
/* 104 */     if (newbalance <= 0) {
/* 105 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 109 */       PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET coins = ? WHERE uuid = ?");
/* 110 */       rs.setInt(1, newbalance);
/* 111 */       rs.setString(2, player.getUniqueId().toString());
/* 112 */       rs.executeUpdate();
/* 113 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 116 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean hasPermission(Player player, String permission)
/*     */   {
/*     */     try
/*     */     {
/* 126 */       PreparedStatement rs = this.connection.prepareStatement("SELECT permission FROM permissions WHERE uuid = ? and permission = ?");
/* 127 */       rs.setString(1, player.getUniqueId().toString());
/* 128 */       rs.setString(2, permission);
/* 129 */       java.sql.ResultSet resultat = rs.executeQuery();
/* 130 */       if ((resultat.next()) && 
/* 131 */         (permission.equals(resultat.getString("permission")))) {
/* 132 */         return true;
/*     */       }
/*     */       
/* 135 */       return false;
/*     */     }
/*     */     catch (SQLException e) {
/* 138 */       e.printStackTrace();
/*     */     }
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   public void addPermission(Player player, String permission) {
/* 144 */     if (hasPermission(player, permission)) {
/* 145 */       return;
/*     */     }
/*     */     try {
/* 148 */       PreparedStatement rs = this.connection.prepareStatement("INSERT INTO permissions (uuid, permission) VALUES (?, ?)");
/* 149 */       rs.setString(1, player.getUniqueId().toString());
/* 150 */       rs.setString(2, permission);
/* 151 */       rs.executeUpdate();
/* 152 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 155 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePermission(Player player, String permission) {
/* 160 */     if (!hasPermission(player, permission)) {
/* 161 */       return;
/*     */     }
/*     */     try {
/* 164 */       PreparedStatement rs = this.connection.prepareStatement("DELETE FROM permissions WHERE uuid = ? and permission = ?");
/* 165 */       rs.setString(1, player.getUniqueId().toString());
/* 166 */       rs.setString(2, permission);
/* 167 */       rs.executeUpdate();
/* 168 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 171 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\main\SqlConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
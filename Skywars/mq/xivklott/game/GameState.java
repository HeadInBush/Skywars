/*    */ package mq.xivklott.game;
/*    */ 
/*    */ public enum GameState
/*    */ {
/*  5 */   LOBBY(true),  PREGAME(false),  GAME(false),  FINISH(false);
/*    */   
/*    */   private boolean canJoin;
/*    */   private static GameState current;
/*    */   
/*    */   private GameState(boolean b)
/*    */   {
/* 12 */     this.canJoin = b;
/*    */   }
/*    */   
/*    */   public boolean canJoin()
/*    */   {
/* 17 */     return this.canJoin;
/*    */   }
/*    */   
/*    */   public static void setState(GameState state) {
/* 21 */     current = state;
/*    */   }
/*    */   
/*    */   public static boolean isState(GameState state) {
/* 25 */     return current == state;
/*    */   }
/*    */   
/*    */   public static GameState getState() {
/* 29 */     return current;
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Downloads\SkyWars (3).jar!\mq\xivklott\game\GameState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
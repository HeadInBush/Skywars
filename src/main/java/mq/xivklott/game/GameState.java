package mq.xivklott.game;

public enum GameState {
    LOBBY(true), PREGAME(false), GAME(false), FINISH(false);

    private boolean canJoin;
    private static GameState current;

    private GameState(boolean b) {
        this.canJoin = b;
    }

    public boolean canJoin() {
        return this.canJoin;
    }

    public static void setState(GameState state) {
        current = state;
    }

    public static boolean isState(GameState state) {
        return current == state;
    }

    public static GameState getState() {
        return current;
    }
}
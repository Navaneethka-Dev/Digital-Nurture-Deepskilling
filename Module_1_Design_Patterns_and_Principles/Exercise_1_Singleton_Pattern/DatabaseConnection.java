public class DatabaseConnection {
    private static volatile DatabaseConnection dbInstance;
    private String connectionStatus;

    private DatabaseConnection() {
        this.connectionStatus = "DISCONNECTED";
    }

    public static DatabaseConnection getInstance() {
        if (dbInstance == null) {
            synchronized (DatabaseConnection.class) {
                if (dbInstance == null) {
                    dbInstance = new DatabaseConnection();
                }
            }
        }
        return dbInstance;
    }

    public void connect() {
        this.connectionStatus = "CONNECTED";
        System.out.println("[DB-INFO] Successfully established connection to the database.");
    }
    
    public String getStatus() {
        return this.connectionStatus;
    }
}

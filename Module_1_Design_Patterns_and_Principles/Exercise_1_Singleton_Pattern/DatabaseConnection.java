/**
 * Singleton class representing a Database Connection.
 * Implements double-checked locking for thread safety.
 */
public class DatabaseConnection {
    // Volatile keyword ensures visibility of changes to variables across threads
    private static volatile DatabaseConnection dbInstance;
    private String connectionStatus;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        this.connectionStatus = "DISCONNECTED";
    }

    /**
     * Retrieves the single instance of DatabaseConnection.
     * @return dbInstance
     */
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

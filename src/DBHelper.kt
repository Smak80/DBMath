import java.sql.Connection
import java.sql.DriverManager

class DBHelper(
    val dbName: String,
    val host: String = "localhost",
    val port: Int = 3306,
    val username: String = "root",
    val password: String = "root"
) {

    val conn: Connection

    init{
        conn = DriverManager.getConnection(
            "jdbc:mysql://$host:$port/$dbName?serverTimezone=UTC",
            username, password
        )
    }

    fun createTables(){
        val statement = conn.createStatement()
        statement.execute("CREATE TABLE IF NOT EXISTS `a` (" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "text VARCHAR(30) NOT NULL, " +
                "PRIMARY KEY(`id`)" +
                ")")
    }
}
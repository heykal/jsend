package work.jeong.murry.jsend;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * TimestampSerializer
 *
 * @author Heykal Abdillah (heykal.abdillah@gmail.com)
 * 
 */

public class TimestampSerializer implements JsonSerializer<Timestamp> {
    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override 
    public JsonElement serialize(Timestamp time, Type type,
        JsonSerializationContext jsonSerializationContext) {
        Instant instant = time.toInstant();
        LocalDateTime ldt = instant.atZone(ZoneId.of("Asia/Jakarta")).toLocalDateTime();
        
        String s = ldt.format(dateFormat);

        return new JsonPrimitive(s);
    }
  }

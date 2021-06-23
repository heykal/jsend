package work.jeong.murry.jsend;

import java.lang.reflect.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * DateSerializer
 *
 * @author Heykal Abdillah (heykal.abdillah@gmail.com)
 * 
 */

public class DateSerializer implements JsonSerializer<Date> {
    @Override 
    public JsonElement serialize(Date date, Type type,
        JsonSerializationContext jsonSerializationContext) {

        LocalDate ld =  date.toLocalDate();
        
        String formattedDate = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

      return new JsonPrimitive(formattedDate);
    }
  }

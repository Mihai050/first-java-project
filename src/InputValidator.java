import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class InputValidator {

    // intelligent
    public boolean isNameCorrect(String name){
        return name.length() > 3;
    }

    public boolean isTypeCorrect(String type){
        String typeUpper = type.toUpperCase();
        return Arrays.stream(TaskTypes.values())
                .anyMatch(taskType -> taskType.name().equals(typeUpper));
    }

    public boolean isDescriptionCorrect(String description){
        return description.length() > 9;
    }

    public boolean isTimeCorrect(String estimatedTime){
        try {
            float time = Float.parseFloat(estimatedTime);
            return time > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDateCorrect(String year, String month, String day){
        int parsedYear;
        int parsedMonth;
        int parsedDay;

        try {
            parsedYear = Integer.parseInt(year);
            parsedMonth = Integer.parseInt(month);
            parsedDay = Integer.parseInt(day);
        } catch (NumberFormatException e) {
            return false;
        }

        if (parsedYear < 2000 || parsedYear > 2080) {
            return false;
        }

        if (parsedMonth < 1 || parsedMonth > 12) {
            return false;
        }

        if (parsedDay < 1 || parsedDay > 31) {
            return false;
        }

        try {
            LocalDate parsedDate = LocalDate.of(parsedYear, parsedMonth, parsedDay);
            LocalDate currentDate = LocalDate.now();
            return !parsedDate.isBefore(currentDate);
        } catch (DateTimeException e) {
            return false;
        }
    }

    public boolean isNumberOnMenu(String number, int min, int max){
        try {
            int parsedNumber = Integer.parseInt(number);
            return parsedNumber >= min && parsedNumber <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumberInteger(String input) {
        if (input != null && !input.isEmpty()) {
            try {
                int number = Integer.parseInt(input);
                return number > 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }


}

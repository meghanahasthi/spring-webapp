package com.example.demo;
 
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class DerivedData {
    private static final Logger logger = Logger.getLogger(DerivedData.class.getName());
 
    public void init() {
        // Initialization logic
    }
 
    public boolean validateOperator(String moduleAttr, String customOperatorValue, String operator) {
        if (logger.isLoggable(Level.INFO)) {
logger.info(String.format("Operator: %s\tAttribute: %s\tCustomOperator Value: %s", operator, moduleAttr, customOperatorValue));
        }
 
        if (!isValid(moduleAttr, customOperatorValue, operator)) return false;
 
        try {
            return switch (operator.toLowerCase()) {
                case "equal" -> moduleAttr.equals(customOperatorValue);
                case "not equal" -> !moduleAttr.equals(customOperatorValue);
                case "greater than" -> compareInts(moduleAttr, customOperatorValue) > 0;
                case "greater than or equal" -> compareInts(moduleAttr, customOperatorValue) >= 0;
                case "less than" -> compareInts(moduleAttr, customOperatorValue) < 0;
                case "less than or equal" -> compareInts(moduleAttr, customOperatorValue) <= 0;
                case "between" -> isBetween(moduleAttr, customOperatorValue);
                case "not between" -> !isBetween(moduleAttr, customOperatorValue);
                case "in" -> inList(moduleAttr, customOperatorValue);
                case "not in" -> !inList(moduleAttr, customOperatorValue);
                case "is null" -> moduleAttr == null;
                case "is not null" -> moduleAttr != null;
                case "starts with" -> moduleAttr.startsWith(customOperatorValue);
                case "does not start with" -> !moduleAttr.startsWith(customOperatorValue);
                case "ends with" -> moduleAttr.endsWith(customOperatorValue);
                case "does not end with" -> !moduleAttr.endsWith(customOperatorValue);
                default -> {
                    if (logger.isLoggable(Level.WARNING)) {
                        logger.log(Level.WARNING,() -> "Unknown operator: " + operator);
                    }
                    yield false;
                }
            };
        } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, () -> "Validation error: " + e.getMessage());
            }
            return false;
        }
    }
 
    private boolean isValid(String a, String b, String c) {
        return a != null && !a.isEmpty() &&
               b != null && !b.isEmpty() &&
               c != null && !c.isEmpty();
    }
 
    private int compareInts(String a, String b) {
        return Integer.parseInt(a) - Integer.parseInt(b);
    }
 
    private boolean isBetween(String attr, String rangeStr) {
        String[] range = rangeStr.split("and");
        int val = Integer.parseInt(attr);
        int low = Integer.parseInt(range[0].trim());
        int high = Integer.parseInt(range[1].trim());
        return val >= low && val <= high;
    }
 
    private boolean inList(String attr, String listStr) {
        for (String val : listStr.split(",")) {
            if (attr.equals(val.trim())) return true;
        }
        return false;
    }
}
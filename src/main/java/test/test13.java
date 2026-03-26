package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author wanghuadong
 * @Date 2025/4/3 9:12
 */
public class test13 {
    public static boolean isValidQuery(String sql) {
        // 定义正则表达式，用于匹配非查询命令
        String regex = "^\\s*(?!(SELECT|WITH).*$)(INSERT|UPDATE|DELETE|CREATE|ALTER|DROP|TRUNCATE|GRANT|REVOKE).*$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sql.trim());
        // 如果匹配到非查询命令，则返回 false
        return !matcher.matches();
    }

    public static void main(String[] args) {
        String validQuery = "SELECT * FROM users";
        String invalidQuery = "INSERT  INTO users (name, age) VALUES ('John', 25)";

        System.out.println("Valid query is valid: " + isValidQuery(validQuery));
        System.out.println("Invalid query is valid: " + isValidQuery(invalidQuery));
    }
}

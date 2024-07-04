package ir.maktab.q01;
import java.util.*;

public class Test {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a word: ");
                String word = scanner.nextLine().trim(); // دریافت کلمه از کاربر و حذف فضای اضافی

                // ایجاد HashMap برای ذخیره جایگشت‌های ممکن
                HashMap<String, Boolean> permutations = new HashMap<>();

                // محاسبه تعداد حروف در کلمه و ذخیره در HashMap
                HashMap<Character, Integer> charCount = new HashMap<>();
                for (char ch : word.toCharArray()) {
                    charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
                }

                // فراخوانی تابع برای تولید جایگشت‌ها
                generatePermutations(word, "", charCount, permutations);

                // چاپ تمامی جایگشت‌ها
                System.out.println("All permutations:");
                for (String perm : permutations.keySet()) {
                    System.out.println(perm);
                }
            }
            static void generatePermutations(String word,
                                             String ans,
                                                HashMap<Character,Integer> charCount,
                                                        HashMap<String,Boolean> permutations) {
                // اگر جایگشت فعلی به طول کلمه رسیده باشد، آن را به HashMap اضافه کنیم
                if (ans.length() == word.length()) {
                    permutations.put(ans, true);
                    return;
                }

                // برای هر حرف موجود در charCount
                for (char ch : charCount.keySet()) {
                    int count = charCount.get(ch);
                    if (count > 0) {
                        // کم کردن یکی از حرف از charCount
                        charCount.put(ch, count - 1);
                        // فراخوانی بازگشتی برای حرف بعدی
                        generatePermutations(word, ans + ch, charCount, permutations);
                        // بازگرداندن تعداد حرف به حالت اولیه برای انجام جایگشت‌های بعدی
                        charCount.put(ch, count);
                    }
                }
            }
        }

